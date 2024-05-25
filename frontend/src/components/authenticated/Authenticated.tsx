import { ReactNode, useEffect, useState } from 'react';
import { useSelector } from 'react-redux';
import { useNavigate } from 'react-router-dom';
import { RootState } from '../../app/store';
import { token } from '../../utils';
import Loading from '../loading';

const Authenticated = ({ children }: { children: ReactNode }) => {
    const auth = useSelector((state: RootState) => state.auth);
    const [loading, setLoading] = useState(true);
    const navigate = useNavigate();

    useEffect(() => {
        if (!auth.username && !token.get()) navigate('/login');
        else setLoading(false);
    }, [auth.username, navigate]);

    if (loading) return <Loading />;

    return children;
};

export default Authenticated;
