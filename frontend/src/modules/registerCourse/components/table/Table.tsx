import TableMui from '@mui/joy/Table';
import classNames from 'classnames/bind';
import { ReactNode } from 'react';
import styles from './styles.module.scss';

const cx = classNames.bind(styles);

const Table = ({
    title,
    children,
    detail,
    className = '',
}: {
    title?: string;
    children: ReactNode;
    detail?: ReactNode;
    className?: string;
}) => {
    return (
        <div className={className}>
            {title && <h5 className={cx('title')}>{title}</h5>}

            {detail}

            <TableMui
                sx={{
                    '& thead tr th': {
                        textAlign: 'center',
                        whiteSpace: 'wrap',
                        verticalAlign: 'middle',
                        color: '#1da1f2',
                        backgroundColor: '#f3f7f9',
                    },
                    '& tr > *:not(:nth-of-type(4))': {
                        textAlign: 'center',
                    },
                }}
                borderAxis="both"
            >
                {children}
            </TableMui>
        </div>
    );
};

export default Table;
