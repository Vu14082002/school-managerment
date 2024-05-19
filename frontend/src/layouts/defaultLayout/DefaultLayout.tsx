import classNames from 'classnames/bind';
import { ReactNode } from 'react';
import Header from '../../components/header';
import styles from './styles.module.scss';

const cx = classNames.bind(styles);

const DefaultLayout = ({ children }: { children: ReactNode }) => {
    return (
        <div>
            <Header />

            <div className={cx('body')}>
                <div className="container">{children}</div>
            </div>
        </div>
    );
};

export default DefaultLayout;
