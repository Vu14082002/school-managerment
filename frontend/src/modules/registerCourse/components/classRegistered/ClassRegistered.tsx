import LocalPrintshopIcon from '@mui/icons-material/LocalPrintshop';
import classNames from 'classnames/bind';
import { useAppSelector } from '../../../../app/hooks';
import { RootState } from '../../../../app/store';
import Table from '../table';
import ClassRegisteredItem from './ClassRegisteredItem';
import styles from './styles.module.scss';

const cx = classNames.bind(styles);

const ClassRegistered = ({ className }: { className?: string }) => {
    const { registeredClasses } = useAppSelector((state: RootState) => state.registeredClasses);

    return (
        <div className={cx(className, 'container')}>
            <Table title="Lớp HP đã đăng ký trong học kỳ này">
                <thead>
                    <tr>
                        <th style={{ width: '72px', paddingInline: '4px' }}>Thao tác</th>
                        <th style={{ width: '37px', paddingInline: '4px' }}>STT</th>
                        <th style={{ width: '115px' }}>Mã lớp HP</th>
                        <th>Tên môn học/HP</th>
                        <th style={{ width: '122px', paddingInline: '4px' }}>Lớp học dự kiến</th>
                        <th style={{ width: '29px', paddingInline: '4px' }}>TC</th>
                        <th style={{ width: '76px', paddingInline: '4px' }}>Nhóm TH</th>
                        <th style={{ width: '73px' }}>Học phí</th>
                        <th style={{ width: '87px', paddingInline: '4px' }}>Hạn nộp</th>
                        <th style={{ width: '38px', paddingInline: '4px' }}>Thu</th>
                        <th style={{ width: '108px' }}>Trạng thái ĐK</th>
                        <th style={{ width: '90px' }}>Ngày ĐK</th>
                        <th style={{ width: '120px', paddingInline: '4px' }}>TT lớp HP</th>
                    </tr>
                </thead>
                <tbody>
                    {registeredClasses.length ? (
                        registeredClasses.map((course, index) => (
                            <ClassRegisteredItem key={course.maLopHocPhan} course={course} index={index} />
                        ))
                    ) : (
                        <tr>
                            <td colSpan={13}>Không tìm thấy lớp HP đã đăng ký</td>
                        </tr>
                    )}
                </tbody>
            </Table>

            <span className={cx('print-btn')}>
                <LocalPrintshopIcon fontSize="small" />
            </span>
        </div>
    );
};

export default ClassRegistered;
