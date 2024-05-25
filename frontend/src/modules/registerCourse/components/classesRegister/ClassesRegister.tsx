import { Checkbox } from '@mui/joy';
import axios from 'axios';
import classNames from 'classnames/bind';
import { ChangeEvent, useEffect, useState } from 'react';
import { useAppDispatch, useAppSelector } from '../../../../app/hooks';
import { RootState } from '../../../../app/store';
import { getClassDetails, setClass } from '../../features/classDetails/classDetailsSlice';
import { getClasses } from '../../features/classes/classesSlice';
import { IClass } from '../../interfaces';
import Table from '../table';
import styles from './styles.module.scss';

const cx = classNames.bind(styles);

const ClassesRegister = () => {
    const [classId, setClassId] = useState<string>('');
    const { classes, subject } = useAppSelector((state: RootState) => state.classes);
    const [showNotOverlap, setShowNotOverlap] = useState<boolean>(false);
    console.log('🚀 ~ ClassesRegister ~ showNotOverlap:', showNotOverlap);
    const dispatch = useAppDispatch();

    useEffect(() => {
        if (!subject) return;

        const source = axios.CancelToken.source();

        const getData = async () => {
            const data: IClass[] = await dispatch(
                getClasses({
                    data: {
                        maHocPhan: subject.maHocPhan,
                    },
                    cancelToken: source.token,
                }),
            ).unwrap();

            const firstClass = data[0];
            setClassId(firstClass.maLopHocPhan);

            dispatch(setClass(firstClass));
            dispatch(
                getClassDetails({
                    data: {
                        maHocPhan: subject.maHocPhan,
                        maLopHocPhan: firstClass.maLopHocPhan,
                    },
                    cancelToken: source.token,
                }),
            );
        };

        getData();

        return () => {
            source.cancel();
        };
    }, [dispatch, subject]);

    if (!classes.length) return null;

    const handleChangeShowNotOverlap = (e: ChangeEvent<HTMLInputElement>) => setShowNotOverlap(e.target.checked);

    const renderClassesNotOverlap = () => {
        return (
            <div className={cx('checkbox-wrap')}>
                <label className={cx('justify-end items-center')}>
                    <Checkbox checked={showNotOverlap} onChange={handleChangeShowNotOverlap} />
                    <span>HIỂN THỊ LỚP học phần KHÔNG TRÙNG LỊCH</span>
                </label>
            </div>
        );
    };

    const handleClickClass = (item: IClass) => {
        if (!subject || item.maLopHocPhan === classId) return;

        setClassId(item.maLopHocPhan);

        dispatch(setClass(item));
        dispatch(
            getClassDetails({
                data: {
                    maHocPhan: subject.maHocPhan,
                    maLopHocPhan: item.maLopHocPhan,
                },
            }),
        );
    };

    return (
        <Table title="Lớp học phần chờ đăng ký" detail={renderClassesNotOverlap()}>
            <thead>
                <tr>
                    <th style={{ width: '45px' }}>STT</th>
                    <th>Thông tin lớp học phần</th>
                    <th style={{ width: '110px' }}>Đã đăng ký</th>
                </tr>
            </thead>
            <tbody>
                {classes.map((item, index) => (
                    <tr
                        onClick={() => handleClickClass(item)}
                        key={item.maLopHocPhan}
                        className={cx('class', {
                            selected: classId === item.maLopHocPhan,
                        })}
                    >
                        <td>{index + 1}</td>
                        <td>
                            <div className={cx('class__info')}>
                                <p className={cx('class__name')}>{item.tenMonHoc}</p>
                                <p>
                                    Trạng thái: &nbsp;
                                    <span className={cx('class__status')}>{item.trangThai}</span>
                                </p>
                                <p>
                                    Mã lớp học phần: &nbsp;
                                    <span>{item.maLopHocPhan}</span>
                                </p>
                            </div>
                        </td>
                        <td>
                            {item.soLuongSinhVienDKHienTai}/{item.siSoToiDa}
                        </td>
                    </tr>
                ))}
            </tbody>
        </Table>
    );
};

export default ClassesRegister;
