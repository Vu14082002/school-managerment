import styles from './styles.module.scss';
import classNames from 'classnames/bind';
const cx = classNames.bind(styles);
import logoIuh from '../../assets/images/header-iuh-logo.png';
import { Link } from 'react-router-dom';
import { routes } from '../../configs';

export default function Header() {
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
                                <Link to={routes.notFound}>
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
