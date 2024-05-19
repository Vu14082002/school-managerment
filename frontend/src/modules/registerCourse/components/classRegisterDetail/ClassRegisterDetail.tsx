import classNames from 'classnames/bind';
import { useState } from 'react';
import { IClassDetail } from '../../interfaces';
import Table from '../table';
import styles from './styles.module.scss';

const cx = classNames.bind(styles);

const classDetails: IClassDetail[] = [
    {
        building: 'H (CS1)',
        date: '03/06/2024 - 08/07/2024',
        id: '1',
        infrastructure: 'Cơ sở 1 (Thành phố Hồ Chí Minh)',
        lecturer: 'TS Đoàn Văn Thắng',
        room: 'H4.2.1',
        schedule: 'TH   - Thứ 2  (Tiết 7  -> 12 )',
    },
    {
        building: 'H (CS1)',
        date: '03/06/2024 - 08/07/2024',
        id: '2',
        infrastructure: 'Cơ sở 1 (Thành phố Hồ Chí Minh)',
        lecturer: 'TS Đoàn Văn Thắng',
        room: 'H4.2.1',
        schedule: 'TH   - Thứ 2  (Tiết 7  -> 12 )',
        group: 1,
    },
    {
        building: 'H (CS1)',
        date: '03/06/2024 - 08/07/2024',
        id: '3',
        infrastructure: 'Cơ sở 1 (Thành phố Hồ Chí Minh)',
        lecturer: 'TS Đoàn Văn Thắng',
        room: 'H4.2.1',
        schedule: 'TH   - Thứ 2  (Tiết 7  -> 12 )',
        group: 2,
    },
    {
        building: 'H (CS1)',
        date: '03/06/2024 - 08/07/2024',
        id: '4',
        infrastructure: 'Cơ sở 1 (Thành phố Hồ Chí Minh)',
        lecturer: 'TS Đoàn Văn Thắng',
        room: 'H4.2.1',
        schedule: 'TH   - Thứ 2  (Tiết 7  -> 12 )',
        group: 2,
    },
];

const ClassRegisterDetail = () => {
    const [active, setActive] = useState<number | undefined>(undefined);
    const showGroupCol = classDetails.some((classDetail) => classDetail.group);

    const renderButtonViewSchedule = () => {
        return (
            <div className={cx('duplicate-btn-wrap')}>
                <button className={cx('duplicate-btn')}>Xem lịch trùng</button>
            </div>
        );
    };

    const handleClickItem = (group: number | undefined) => group && setActive(group);

    return (
        <div>
            <Table title="Chi tiết lớp học phần" detail={renderButtonViewSchedule()}>
                <thead>
                    <tr>
                        <th style={{ width: '290px' }}>
                            Trạng thái: <span className={cx('text-red')}>Chấp nhận mở lớp</span>
                        </th>
                        {showGroupCol ? <th style={{ width: '57px' }}>Nhóm</th> : null}
                        <th>
                            <span className={cx('text-blue-bold')}>Sĩ số tối đa: 66</span>
                        </th>
                    </tr>
                </thead>
                <tbody>
                    {classDetails.map((classDetail) => (
                        <tr
                            key={classDetail.id}
                            className={cx('class-detail', {
                                selected: !classDetail.group,
                                active: active && active === classDetail.group,
                            })}
                            onClick={() => handleClickItem(classDetail.group)}
                        >
                            <td>
                                <div className={cx('class-detail__info')}>
                                    <p>
                                        Lịch học: &nbsp;
                                        <strong className={cx('text-blue-bold')}>{classDetail.schedule}</strong>
                                    </p>
                                    <p>
                                        Cơ sở: &nbsp;
                                        <strong>{classDetail.infrastructure}</strong>
                                    </p>
                                    <p>
                                        Dãy nhà: &nbsp;
                                        <strong>{classDetail.building}</strong>
                                    </p>
                                    <p>
                                        Phòng: &nbsp;
                                        <strong>{classDetail.room}</strong>
                                    </p>
                                </div>
                            </td>
                            {showGroupCol ? <td>{classDetail.group}</td> : null}
                            <td>
                                <div className={cx('class-detail__info')}>
                                    <p>
                                        <strong>GV:&nbsp; {classDetail.lecturer}</strong>
                                    </p>
                                    <p>{classDetail.date}</p>
                                </div>
                            </td>
                        </tr>
                    ))}
                    {classDetails.length ? null : (
                        <tr className={cx('no-detail')}>
                            <td colSpan={2}>
                                <span>Chưa có lịch học</span>
                            </td>
                        </tr>
                    )}
                </tbody>
            </Table>

            {classDetails.length ? (
                <div className={cx('register-btn-wrap')}>
                    <button className={cx('register-btn')}>Đăng ký</button>
                </div>
            ) : null}
        </div>
    );
};

export default ClassRegisterDetail;
