import classNames from 'classnames/bind';
import { useEffect, useState } from 'react';
import { useAppSelector } from '../../../../app/hooks';
import { RootState } from '../../../../app/store';
import Table from '../table';
import styles from './styles.module.scss';

const cx = classNames.bind(styles);

const ClassRegisterDetail = () => {
    const [active, setActive] = useState<number | undefined>(undefined);
    const { classDetails, classSelected } = useAppSelector((state: RootState) => state.classDetails);
    const { classes } = useAppSelector((state: RootState) => state.classes);
    const showGroupCol = classDetails.some((classDetail) => classDetail.nhomThucHanh);

    const renderButtonViewSchedule = () => {
        return (
            <div className={cx('duplicate-btn-wrap')}>
                <button className={cx('duplicate-btn')}>Xem lịch trùng</button>
            </div>
        );
    };

    const handleClickItem = (group: number | undefined) => group && setActive(group);

    useEffect(() => {
        setActive(undefined);
    }, [classDetails]);

    if (!classes.length || !classSelected) return null;

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
                            <span className={cx('text-blue-bold')}>Sĩ số tối đa: {classSelected.siSoToiDa}</span>
                        </th>
                    </tr>
                </thead>
                <tbody>
                    {classDetails.map((classDetail, index) => (
                        <tr
                            key={index}
                            className={cx('class-detail', {
                                selected: !classDetail.nhomThucHanh,
                                active: active && active === classDetail.nhomThucHanh,
                            })}
                            onClick={() => handleClickItem(classDetail.nhomThucHanh)}
                        >
                            <td>
                                <div className={cx('class-detail__info')}>
                                    <p>
                                        Lịch học: &nbsp;
                                        <strong className={cx('text-blue-bold')}>{classDetail.lichHoc}</strong>
                                    </p>
                                    <p>
                                        Cơ sở: &nbsp;
                                        <strong>{classDetail.cs}</strong>
                                    </p>
                                    {/* <p>
                                        Dãy nhà: &nbsp;
                                        <strong>{classDetail.building}</strong>
                                    </p> */}
                                    <p>
                                        Phòng: &nbsp;
                                        <strong>{classDetail.phongHoc}</strong>
                                    </p>
                                </div>
                            </td>
                            {showGroupCol ? <td>{classDetail.nhomThucHanh}</td> : null}
                            <td>
                                <div className={cx('class-detail__info')}>
                                    <p>
                                        <strong>GV:&nbsp; {classDetail.giangVien}</strong>
                                    </p>
                                    <p>{classDetail.lichHoc}</p>
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
                    <button
                        disabled={showGroupCol && !active}
                        className={cx('register-btn', {
                            disabled: showGroupCol && !active,
                        })}
                    >
                        Đăng ký
                    </button>
                </div>
            ) : null}
        </div>
    );
};

export default ClassRegisterDetail;
