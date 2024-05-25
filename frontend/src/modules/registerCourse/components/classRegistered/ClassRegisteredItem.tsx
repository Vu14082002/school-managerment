import MenuIcon from '@mui/icons-material/Menu';
import classNames from 'classnames/bind';
import React, { useRef, useState } from 'react';
import { useOnClickOutside } from 'usehooks-ts';
import deleteImage from '../../../../assets/images/ico-delete-min.png';
import Popper from '../../../../components/popper';
import { IPopper } from '../../../../interfaces';
import { IRegisteredClass } from '../../interfaces';
import styles from './styles.module.scss';

const cx = classNames.bind(styles);

const ClassRegisteredItem = ({ course, index }: { course: IRegisteredClass; index: number }) => {
    const ref = useRef<HTMLTableRowElement>(null);
    const [anchorEl, setAnchorEl] = useState<null | HTMLElement>(null);

    const handleClick = (event: React.MouseEvent<HTMLElement>) => {
        setAnchorEl(anchorEl ? null : event.currentTarget);
    };

    const open = Boolean(anchorEl);

    const handleClickClass = (e: React.MouseEvent<HTMLTableRowElement>) => {
        const element = e.currentTarget as HTMLTableRowElement;

        const selectedElements = document.querySelectorAll('.selected');
        selectedElements.forEach((el) => el.classList.remove('selected'));

        element.classList.add('selected');
    };

    const handleHidePopper = () => setAnchorEl(null);

    const popper: IPopper[] = [
        {
            title: 'Xem lịch',
            onClick: () => {
                console.log('Xem lịch');
                handleHidePopper();
            },
        },
        {
            title: 'Hủy đăng ký',
            onClick: () => {
                console.log('Hủy đăng ký');
                handleHidePopper();
            },
        },
    ];

    useOnClickOutside(ref, handleHidePopper);

    return (
        <tr key={course.maLopHocPhan} className={cx('class')} onClick={handleClickClass} ref={ref}>
            <td>
                <span onClick={handleClick}>
                    <MenuIcon fontSize="small" />
                </span>
                <Popper data={popper} placement="right" open={open} anchorEl={anchorEl} />
            </td>
            <td>{index + 1}</td>
            <td>{course.maLopHocPhan}</td>
            <td>{course.tenMonHoc}</td>
            <td>{course.lopHocPhanDuKien}</td>
            <td>{course.soTC}</td>
            {/* TODO */}
            <td></td>
            <td>{course.hocPhi}</td>
            <td>{course.hanNop}</td>
            <td>
                {/* TODO */}
                {/* <img className={cx('class__payment')} src={false ? selectImage : deleteImage} alt="" /> */}
                <img className={cx('class__payment')} src={deleteImage} alt="" />
            </td>
            <td>{course.trangThaiDk}</td>
            <td>{course.ngayDK}</td>
            <td>{course.trangThaiHocPhan}</td>
        </tr>
    );
};

export default ClassRegisteredItem;
