import LocalPrintshopIcon from '@mui/icons-material/LocalPrintshop';
import classNames from 'classnames/bind';
import { IRegisteredClass } from '../../interfaces';
import Table from '../table';
import ClassRegisteredItem from './ClassRegisteredItem';
import styles from './styles.module.scss';

const cx = classNames.bind(styles);

const registerCourses: IRegisteredClass[] = [
    {
        class: 'DHKTPM16A',
        classStatus: 'Đã khóa',
        credit: 3,
        deadline: '20/09/2021',
        fee: 1000000,
        id: '4203003193',
        name: 'Toán ứng dụng Toán ứng dụng',
        registerDate: '19/09/2021',
        status: 'Đăng ký mới',
        payment: false,
        group: 1,
    },
    {
        class: 'DHKTPM16A',
        classStatus: 'Đã khóa',
        credit: 3,
        deadline: '20/09/2021',
        fee: 1000000,
        id: '4203003194',
        name: 'Toán ứng dụng Toán ứng dụng',
        registerDate: '19/09/2021',
        status: 'Đăng ký mới',
        payment: false,
        group: 1,
    },
];

const ClassRegistered = ({ className }: { className?: string }) => {
    return (
        <div className={cx(className, 'container')}>
            <Table title="Lớp HP đã đăng ký trong học kỳ này">
                <thead>
                    <tr>
                        <th style={{ width: '72px', paddingInline: '4px' }}>Thao tác</th>
                        <th style={{ width: '37px', paddingInline: '4px' }}>STT</th>
                        <th style={{ width: '103px' }}>Mã lớp HP</th>
                        <th>Tên môn học/HP</th>
                        <th style={{ width: '122px', paddingInline: '4px' }}>Lớp học dự kiến</th>
                        <th style={{ width: '29px', paddingInline: '4px' }}>TC</th>
                        <th style={{ width: '76px', paddingInline: '4px' }}>Nhóm TH</th>
                        <th style={{ width: '73px' }}>Học phí</th>
                        <th style={{ width: '87px', paddingInline: '4px' }}>Hạn nộp</th>
                        <th style={{ width: '38px', paddingInline: '4px' }}>Thu</th>
                        <th style={{ width: '108px' }}>Trạng thái ĐK</th>
                        <th style={{ width: '83px' }}>Ngày ĐK</th>
                        <th style={{ width: '78px', paddingInline: '4px' }}>TT lớp HP</th>
                    </tr>
                </thead>
                <tbody>
                    {registerCourses.map((course, index) => (
                        <ClassRegisteredItem key={course.id} course={course} index={index} />
                    ))}
                </tbody>
            </Table>

            <span className={cx('print-btn')}>
                <LocalPrintshopIcon fontSize="small" />
            </span>
        </div>
    );
};

export default ClassRegistered;
