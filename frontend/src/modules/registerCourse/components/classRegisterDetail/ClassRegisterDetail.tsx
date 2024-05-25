import { Button, Modal, Stack, Typography } from '@mui/material';
import classNames from 'classnames/bind';
import { useEffect, useState } from 'react';
import { toast } from 'react-toastify';
import { useBoolean } from 'usehooks-ts';
import axiosClient from '../../../../api';
import { useAppDispatch, useAppSelector } from '../../../../app/hooks';
import { RootState } from '../../../../app/store';
import { SUBJECT_ENDPOINT } from '../../constants';
import { setClass, setClassDetails } from '../../features/classDetails/classDetailsSlice';
import { setClasses, setSubject } from '../../features/classes/classesSlice';
import { getRegisteredClasses } from '../../features/registeredClasses/registeredClassesSlice';
import { excludeRegisteredSubject } from '../../features/subjects/subjectsSlice';
import Table from '../table';
import styles from './styles.module.scss';

const cx = classNames.bind(styles);

const ClassRegisterDetail = () => {
    const [active, setActive] = useState<number | undefined>(undefined);
    const { user } = useAppSelector((state: RootState) => state.user);
    const { hocKy, namHoc } = useAppSelector((state: RootState) => state.subjects);
    const {
        classDetails,
        classSelected,
        loading: loadingClasses,
    } = useAppSelector((state: RootState) => state.classDetails);
    const { classes, subject } = useAppSelector((state: RootState) => state.classes);
    const showGroupCol = classDetails.some((classDetail) => classDetail.nhomThucHanh);
    const { value, setFalse, setTrue } = useBoolean(false);
    const [loading, setLoading] = useState(false);
    const dispatch = useAppDispatch();

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

    if (!classes.length || !classSelected || !subject || !user) return null;

    const handleRegister = async () => {
        setLoading(true);

        try {
            const registerPromise = new Promise((resolve, reject) => {
                try {
                    const handle = async () => {
                        const result = await axiosClient.post(`${SUBJECT_ENDPOINT}/DangKyHocPhan`, {
                            maHocPhan: subject.maHocPhan,
                            nhomThucHanh: active,
                            maLopHocPhan: classSelected.maLopHocPhan,
                            mssv: user.mssv,
                        });

                        if (result.data.code !== 200) reject(new Error('Đăng ký thất bại, vui lòng thử lại sau 🤯'));

                        const res = await dispatch(
                            getRegisteredClasses({ data: { hocKy, namHoc, mssv: user.mssv } }),
                        ).unwrap();

                        resolve(res);
                    };

                    handle();
                } catch (error) {
                    reject(error);
                }
            });

            await toast.promise(registerPromise, {
                pending: 'Đang đăng ký học phần...',
                success: 'Đăng ký thành công 🎉',
                error: 'Đăng ký thất bại, vui lòng thử lại sau 🤯',
            });

            setFalse();
            dispatch(excludeRegisteredSubject(subject.maHocPhan));
            dispatch(setClass(null));
            dispatch(setClassDetails([]));
            dispatch(setSubject(undefined));
            dispatch(setClasses([]));
        } catch (error) {
            console.error(error);
        } finally {
            setLoading(false);
        }
    };

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
                    {loadingClasses ||
                        classDetails.map((classDetail, index) => (
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
                    {classDetails.length && !loadingClasses ? null : (
                        <tr className={cx('no-detail')}>
                            <td className="relative" colSpan={showGroupCol ? 3 : 2}>
                                {loadingClasses ? (
                                    <div className="spin-wrapper">
                                        <div className="spin"></div>
                                    </div>
                                ) : (
                                    <span>Chưa có lịch học</span>
                                )}
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
                        onClick={setTrue}
                    >
                        Đăng ký
                    </button>
                </div>
            ) : null}

            <Modal
                open={value}
                onClose={setFalse}
                aria-labelledby="modal-modal-title"
                aria-describedby="modal-modal-description"
            >
                <div className={cx('modal-wrap')}>
                    <Typography id="modal-modal-title" variant="h6" component="h2">
                        Đăng ký học phần
                    </Typography>
                    <Typography id="modal-modal-description" sx={{ mt: 2 }}>
                        Bạn có chắc chắn muốn đăng ký học phần này không?
                    </Typography>

                    <Stack direction="row" sx={{ mt: 2 }} spacing={2} justifyContent="flex-end">
                        <Button disabled={loading} onClick={setFalse}>
                            Huỷ
                        </Button>
                        <Button disabled={loading} onClick={handleRegister} variant="contained">
                            Đăng ký
                        </Button>
                    </Stack>
                </div>
            </Modal>
        </div>
    );
};

export default ClassRegisterDetail;
