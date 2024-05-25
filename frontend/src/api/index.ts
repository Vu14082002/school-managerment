import axios from 'axios';
import { token } from '../utils';

const axiosClient = axios.create();

function refresh() {
    return new Promise((resolve, reject) => {
        axios
            .post(`http://localhost:4002/api/v1/auth/refresh-token`)
            .then((response) => {
                token.set(response.data.data.accessToken);
                return resolve(response.data.data.accessToken);
            })
            .catch((error) => {
                token.set('');
                return reject(error);
            });
    });
}

axiosClient.interceptors.response.use(
    (res) => res,
    async (error) => {
        const prevRequest = error?.config;

        if (error?.response?.status === 401 && !prevRequest?.sent && token.get()) {
            prevRequest.sent = true;

            try {
                const newAccessToken = (await refresh()) as string;
                prevRequest.headers.Authorization = `Bearer ${newAccessToken}`;
                token.set(newAccessToken);
                return axiosClient(prevRequest);
            } catch (error) {
                console.error(error);
            }
        }
        return Promise.reject(error);
    },
);

axiosClient.interceptors.request.use(
    (config) => {
        const access_token = token.get();
        config.headers.Authorization = `Bearer ${access_token}`;
        return config;
    },
    (error) => Promise.reject(error),
);

export default axiosClient;
