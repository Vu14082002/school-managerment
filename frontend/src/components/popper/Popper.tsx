import { Popper as PopperMui, PopperProps } from '@mui/material';
import classNames from 'classnames/bind';
import React from 'react';
import { IPopper } from '../../interfaces';
import styles from './styles.module.scss';

const cx = classNames.bind(styles);

import PopperItem from './PopperItem';

const Popper = ({ data, ...props }: { data: IPopper[] } & PopperProps & React.RefAttributes<HTMLDivElement>) => {
    return (
        <PopperMui disablePortal {...props}>
            <div className={cx('wrapper')}>
                {data.map((item, index) => (
                    <PopperItem key={index} popper={item} />
                ))}
            </div>
        </PopperMui>
    );
};

export default Popper;
