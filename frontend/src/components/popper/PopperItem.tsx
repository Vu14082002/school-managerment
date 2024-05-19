import classNames from 'classnames/bind';
import { IPopper } from '../../interfaces';
import styles from './styles.module.scss';

const cx = classNames.bind(styles);

const PopperItem = ({ popper }: { popper: IPopper }) => {
    return (
        <div className={cx('item')} onClick={popper.onClick}>
            {popper.title}
        </div>
    );
};

export default PopperItem;
