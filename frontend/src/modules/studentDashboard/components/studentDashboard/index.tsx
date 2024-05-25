import classNames from 'classnames/bind';
import { Link } from 'react-router-dom';
import { useAppSelector } from '../../../../app/hooks';
import { RootState } from '../../../../app/store';
import calendar from '../../../../assets/images/calendar.png';
import courseRegister from '../../../../assets/images/courseregistration.png';
import payment from '../../../../assets/images/payment.png';
import resultStuding from '../../../../assets/images/result_studing.png';
import money from '../../../../assets/images/tracuucongno.png';
import Header from '../../../../components/header';
import { routes } from '../../../../configs';
import styles from './styles.module.scss';
const cx = classNames.bind(styles);

// TODO: Khoá học, bậc đào tạo, loại hình đào tạo
export default function StudentDashboard() {
    const { user } = useAppSelector((state: RootState) => state.user);

    if (!user) return null;

    return (
        <div className={`${cx('wrapper')}`}>
            <Header />

            <div className="flex justify-center">
                <div className={`w-[1200px] pt-[80px]`}>
                    <div className={`flex flex-nowrap gap-3`}>
                        <div className="w-3/5 rounded-md bg-white p-3">
                            <h4 className="font-bold pb-2 border-b-2">Thông tin sinh viên</h4>
                            <div className="flex flex-nowrap gap-3 mt-3">
                                <div className=" w-1/2">
                                    <div className="flex flex-nowrap gap-2 mb-3">
                                        <p className="text-sm">MSSV: </p>
                                        <p className="text-sm font-semibold">{user.mssv}</p>
                                    </div>
                                    <div className="flex flex-nowrap gap-2 mb-3">
                                        <p className="text-sm">Họ tên: </p>
                                        <p className="text-sm font-semibold">{user.hoTen}</p>
                                    </div>
                                    <div className="flex flex-nowrap gap-2 mb-3">
                                        <p className="text-sm">Giới tính: </p>
                                        <p className="text-sm font-semibold">{user.gioiTinh ? 'Nam' : 'Nữ'}</p>
                                    </div>
                                    <div className="flex flex-nowrap gap-2 mb-3">
                                        <p className="text-sm">Ngày sinh: </p>
                                        <p className="text-sm font-semibold">
                                            {user.ngaySinh.substring(0, 10).split('-').reverse().join('/')}
                                        </p>
                                    </div>
                                    <div className="flex flex-nowrap gap-2 mb-3">
                                        <p className="text-sm">Nơi snh: </p>
                                        <p className="text-sm font-semibold">2018600000</p>
                                    </div>
                                </div>

                                <div className="w-1/2">
                                    <div className="flex flex-nowrap gap-2 mb-3">
                                        <p className="text-sm">Lớp học: </p>
                                        <p className="text-sm font-semibold">{user.lopDanhNghia[0]}</p>
                                    </div>
                                    <div className="flex flex-nowrap gap-2 mb-3">
                                        <p className="text-sm">Khóa học: </p>
                                        <p className="text-sm font-semibold">2020 - 2021</p>
                                    </div>
                                    <div className="flex flex-nowrap gap-2 mb-3">
                                        <p className="text-sm">Bậc đào tạo: </p>
                                        <p className="text-sm font-semibold">Đại học</p>
                                    </div>
                                    <div className="flex flex-nowrap gap-2 mb-3">
                                        <p className="text-sm">Loại hình đào tạo: </p>
                                        <p className="text-sm font-semibold">Chính quy</p>
                                    </div>
                                    <div className="flex flex-nowrap gap-2 mb-3">
                                        <p className="text-sm">Ngành: </p>
                                        <p className="text-sm font-semibold">{user.chuyenNganh[0]}</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div className="w-2/5 flex flex-wrap gap-3 h-1/2">
                            <Link to={''} className="rounded-md p-3 w-full bg-white">
                                <p className="text-xs text-gray-600">Nhắc nhở mới, chưa xem</p>
                                <div className="flex flex-nowrap justify-between items-center">
                                    <h1 className="font-medium text-gray-600">0</h1>
                                    <i
                                        className="ri-notification-3-line text-gray-600"
                                        style={{
                                            fontSize: '1.2rem',
                                            padding: '3px 7px',
                                            borderRadius: '100%',
                                            border: '1px solid #d1d5db',
                                        }}
                                    ></i>
                                </div>
                                <p className="text-xs text-gray-600">Xem chi tiết</p>
                            </Link>
                            <div className="flex flex-nowrap w-full gap-3">
                                <Link to={''} className="rounded-md p-3 w-1/2 bg-sky-400">
                                    <p className="text-xs text-white">Lịch học theo tuần</p>
                                    <div className="flex flex-nowrap justify-between items-center">
                                        <h1 className="font-medium text-white">0</h1>
                                        <i
                                            className="ri-calendar-todo-fill text-white"
                                            style={{
                                                fontSize: '1.2rem',
                                                padding: '3px 7px',
                                                borderRadius: '100%',
                                                border: '1px solid white',
                                            }}
                                        ></i>
                                    </div>
                                    <p className="text-xs text-white">Xem chi tiết</p>
                                </Link>
                                <Link to={''} className="rounded-md p-3 w-1/2 bg-orange-300">
                                    <p className="text-xs text-white">Lịch thi trong tuần</p>
                                    <div className="flex flex-nowrap justify-between items-center">
                                        <h1 className="font-medium text-white">0</h1>
                                        <i
                                            className="ri-calendar-todo-fill text-white"
                                            style={{
                                                fontSize: '1.2rem',
                                                padding: '3px 7px',
                                                borderRadius: '100%',
                                                border: '1px solid white',
                                            }}
                                        ></i>
                                    </div>
                                    <p className="text-xs text-white">Xem chi tiết</p>
                                </Link>
                            </div>
                        </div>
                    </div>

                    <div className="flex flex-nowrap items-center mt-3 gap-5">
                        <Link
                            to={routes.weeklySchedule}
                            className=" bg-white rounded-md py-5 px-5 group hover:text-cyan-500"
                        >
                            <div className="flex justify-center mb-5">
                                <img src={calendar} className="text-center" />
                            </div>
                            <p className="text-sm mt-5 text-center">Lịch theo tuần</p>
                        </Link>

                        <Link to={''} className=" bg-white rounded-md py-5 px-5 hover:text-cyan-500">
                            <div className="flex justify-center mb-5">
                                <img src={resultStuding} className="text-center" />
                            </div>
                            <p className="text-sm mt-5 text-center ">Kết quả học tập</p>
                        </Link>
                        <Link to={routes.registerCourse} className=" bg-white rounded-md py-5 px-5 hover:text-cyan-500">
                            <div className="flex justify-center mb-5">
                                <img src={courseRegister} className="text-center" />
                            </div>
                            <p className="text-sm mt-5 text-center hover:text-cyan-500">Đăng ký học phần</p>
                        </Link>

                        <Link to={''} className=" bg-white rounded-md py-5 px-5 hover:text-cyan-500">
                            <div className="flex justify-center mb-5">
                                <img src={money} className="text-center" />
                            </div>
                            <p className="text-sm mt-5 text-center hover:text-cyan-500">Tra cứu công nợ</p>
                        </Link>

                        <Link to={''} className=" bg-white rounded-md py-5 px-5 hover:text-cyan-500">
                            <div className="flex justify-center mb-5">
                                <img src={payment} className="text-center" />
                            </div>
                            <p className="text-sm mt-5 text-center hover:text-cyan-500">Thanh toán trực tuyến</p>
                        </Link>
                    </div>
                </div>
            </div>
        </div>
    );
}
