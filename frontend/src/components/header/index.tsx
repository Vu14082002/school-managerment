import classNames from 'classnames/bind';
import { useDispatch } from 'react-redux';
import { Link } from 'react-router-dom';
import axiosClient from '../../api';
import logoIuh from '../../assets/images/header-iuh-logo.png';
import { routes } from '../../configs';
import { logout } from '../../features/auth/authSlice';
import { AUTH_ENDPOINT } from '../../modules/auth/constants';
import { token } from '../../utils';
import styles from './styles.module.scss';

const cx = classNames.bind(styles);

export default function Header() {
    const dispatch = useDispatch();

    const handleLogout = () => {
        token.set('');
        dispatch(logout());
        axiosClient.post(`${AUTH_ENDPOINT}/logout`).then();
    };

    return (
        <div className={`w-full flex justify-center py-2 ${cx('wrapper')}`}>
            <div className="w-[1200px] flex justify-between flex-nowrap">
                <Link to={routes.studentDashboard}>
                    <img src={logoIuh} alt="logo iuh" className={cx('logo-iuh')} />
                </Link>
                <div className="flex items-center gap-5">
                    <Link to={routes.studentDashboard} className="flex items-center gap-1">
                        <i className="ri-home-8-line"></i>
                        <span>Trang chủ</span>
                    </Link>
                    <details className="dropdown">
                        <summary className="flex items-center gap-1">
                            <span className="hover:text-blue-500 cursor-pointer ">Nguyễn Văn A</span>
                            <i className="ri-arrow-down-s-fill"></i>
                        </summary>
                        <ul className="p-2 shadow menu dropdown-content z-[1] bg-base-100 w-52">
                            <li>
                                <Link onClick={handleLogout} to={routes.login}>
                                    <p>Đăng xuất</p>
                                </Link>
                            </li>
                            <li>
                                <a>Item 2</a>
                            </li>
                        </ul>
                    </details>
                </div>
            </div>
        </div>
    );
}
