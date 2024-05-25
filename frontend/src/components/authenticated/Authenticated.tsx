import { jwtDecode } from 'jwt-decode';
import { ReactNode, useEffect, useState } from 'react';
import { useSelector } from 'react-redux';
import { useNavigate } from 'react-router-dom';
import { useAppDispatch } from '../../app/hooks';
import { RootState } from '../../app/store';
import { getUser } from '../../features/user/userSlice';
import { IJwtPayload } from '../../interfaces';
import { token } from '../../utils';
import Loading from '../loading';

const Authenticated = ({ children }: { children: ReactNode }) => {
    const auth = useSelector((state: RootState) => state.auth);
    const [loading, setLoading] = useState(true);
    const navigate = useNavigate();
    const dispatch = useAppDispatch();

    useEffect(() => {
        const tokenValue = token.get();

        if (!tokenValue) return navigate('/login');

        const getData = async () => {
            const decoded = jwtDecode(tokenValue);

            const mssv = +(decoded as IJwtPayload).username;

            try {
                await dispatch(getUser({ mssv })).unwrap();

                setLoading(false);
            } catch (error) {
                navigate('/login');
            }
        };

        getData();
    }, [auth.username, dispatch, navigate]);

    if (loading) return <Loading />;

    return children;
};

export default Authenticated;
