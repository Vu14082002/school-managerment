import classNames from 'classnames/bind';
import styles from './styles.module.scss';

const cx = classNames.bind(styles);

const Loading = () => {
    return (
        <div className={cx('container')}>
            <div className={cx('loading-wave')}>
                <div className={cx('loading-bar')}></div>
                <div className={cx('loading-bar')}></div>
                <div className={cx('loading-bar')}></div>
                <div className={cx('loading-bar')}></div>
            </div>
        </div>
    );
};

export default Loading;