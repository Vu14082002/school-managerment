import { Checkbox } from '@mui/joy';
import classNames from 'classnames/bind';
import { ChangeEvent, useState } from 'react';
import { IClass } from '../../interfaces';
import Table from '../table';
import styles from './styles.module.scss';

const cx = classNames.bind(styles);

const classes: IClass[] = [
    {
        id: '420300334502 - DHNL19A',
        name: 'Vật lý đại cương',
        status: 'Đã khóa',
        quantity: 82,
        maxQuantity: 85,
    },
];

const ClassesRegister = () => {
    const [classId, setClassId] = useState<string>('');
    const [showNotOverlap, setShowNotOverlap] = useState<boolean>(false);
    console.log('🚀 ~ ClassesRegister ~ showNotOverlap:', showNotOverlap);

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
                        onClick={() => setClassId(item.id)}
                        key={item.id}
                        className={cx('class', {
                            selected: classId === item.id,
                        })}
                    >
                        <td>{index + 1}</td>
                        <td>
                            <div className={cx('class__info')}>
                                <p className={cx('class__name')}>{item.name}</p>
                                <p>
                                    Trạng thái: &nbsp;
                                    <span className={cx('class__status')}>{item.status}</span>
                                </p>
                                <p>
                                    Mã lớp học phần: &nbsp;
                                    <span>{item.id}</span>
                                </p>
                            </div>
                        </td>
                        <td>
                            {item.quantity}/{item.maxQuantity}
                        </td>
                    </tr>
                ))}
            </tbody>
        </Table>
    );
};

export default ClassesRegister;
