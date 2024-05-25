const KEY = 'iuh-kt-access-token';

const token = {
    get: () => localStorage.getItem(KEY),
    set: (token: string) => localStorage.setItem(KEY, token),
};

export default token;
