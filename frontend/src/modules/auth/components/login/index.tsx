import { useState } from 'react';
import classNames from 'classnames/bind';
import styles from './styles.module.scss';
const cx = classNames.bind(styles);
import loginLogo from '../../../../assets/images/loginLogo.png';
import loginSlide from '../../../../assets/images/loginSlide.jpg';
import congThongTinSV from '../../../../assets/images/congthongtinsinhvien.png';

export default function Login() {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    // const [errMessage, setErrMessage] = useState('');

    function handleLoginAccount() {}

    return (
        <div className={cx('container')}>
            <div className={`${cx('login-header')} mb-3`}>
                <img src={loginLogo} className={cx('login-university-logo')} />
            </div>
            <div className={`flex flex-nowrap px-5`}>
                <div className={`w-3/4`}>
                    <div className={`px-5`}>
                        <img src={loginSlide} className={`${cx('login-slide-image')}`} />
                    </div>
                </div>
                <div className={`w-1/4 `}>
                    <div className={`px-5 mx-5 ${styles.loginForm}`}>
                        <div className={`flex justify-center mt-5`}>
                            <img src={congThongTinSV} className={`${cx('login-congthongtin-logo')}`} />
                        </div>
                        <h3 className={`${cx('login-title')}`}>ĐĂNG NHẬP HỆ THỐNG</h3>

                        <div className="px-5">
                            <input
                                type="text"
                                id="text"
                                className="bg-gray-50 border border-gray-300
                                outline-none px-5 mb-6
                                text-gray-900 text-sm rounded-md focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
                                placeholder="Nhập mã sinh viên"
                                required
                                value={username}
                                onChange={(e) => setUsername(e.target.value)}
                            />
                            <input
                                type="password"
                                id="password"
                                className="bg-gray-50 border border-gray-300
                                outline-none px-5 mb-6
                                text-gray-900 text-sm rounded-md focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
                                placeholder="Nhập mật khẩu"
                                required
                                value={password}
                                onChange={(e) => setPassword(e.target.value)}
                            />

                            <button
                                onClick={handleLoginAccount}
                                type="submit"
                                className="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm w-full px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800"
                            >
                                Đăng Nhập
                            </button>

                            <div className="mt-3">
                                <span className="text-pink-700 hover:text-pink-800 cursor-pointer text-sm mt-6">
                                    Error messages
                                </span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}
