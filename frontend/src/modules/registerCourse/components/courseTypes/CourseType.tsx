import classNames from 'classnames/bind';
import { ICourseType } from '../../interfaces';
import styles from './styles.module.scss';

const cx = classNames.bind(styles);

const CourseType = ({ type }: { type: ICourseType }) => {
    if (!type.id) return null;

    return (
        <span className={cx('title', 'flex items-center')}>
            {type.id}
            &nbsp;
            <pre className={cx('type')}>({type.type})</pre>
        </span>
    );
};

export default CourseType;
