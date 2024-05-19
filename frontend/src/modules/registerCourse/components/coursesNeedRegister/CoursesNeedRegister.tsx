import { Radio } from '@mui/joy';
import classNames from 'classnames/bind';
import { MouseEvent } from 'react';
import deleteImage from '../../../../assets/images/ico-delete-min.png';
import selectImage from '../../../../assets/images/ico-select-min.png';
import CourseTypes from '../../components/courseTypes';
import { ICourseNeedRegister, ICourseType } from '../../interfaces';
import Table from '../table';
import styles from './styles.module.scss';

const cx = classNames.bind(styles);

const CoursesNeedRegister = ({ courses }: { courses: ICourseNeedRegister[] }) => {
    const handleClickCourseItem = (e: MouseEvent) => {
        const rowElement = e.currentTarget;
        const radioElement = rowElement.querySelector('input[type="radio"]') as HTMLInputElement;

        const selectedRowElement = document.querySelector('.course.selected');
        selectedRowElement?.classList.remove('selected');

        rowElement.classList.add('selected');
        radioElement?.click();
    };

    return (
        <Table title="Môn học/học phần đang chờ đăng ký" className={cx('courses-table')}>
            <thead>
                <tr>
                    <th style={{ width: '40px' }}></th>
                    <th style={{ width: '55px' }}>STT</th>
                    <th style={{ width: '150px' }}>Mã học phần</th>
                    <th style={{ width: '452px' }}>Tên môn học/học phần</th>
                    <th style={{ width: '43px' }}>TC</th>
                    <th style={{ width: '108px' }}>Bắt buộc</th>
                    <th>học phần: học trước (a), tiên quyết (b), song hành (c)</th>
                </tr>
            </thead>
            <tbody>
                {courses.map((course, index) => (
                    <tr key={course.id} className={cx('course')} onClick={handleClickCourseItem}>
                        <td>
                            <Radio variant="outlined" />
                        </td>
                        <td>{index + 1}</td>
                        <td>{course.id}</td>
                        <td>{course.name}</td>
                        <td>{course.credit}</td>
                        <td>
                            <img
                                className={cx('course__required')}
                                src={course.required ? selectImage : deleteImage}
                                alt=""
                            />
                        </td>
                        <td>
                            <CourseTypes types={course.courses as ICourseType[]} />
                        </td>
                    </tr>
                ))}
            </tbody>
        </Table>
    );
};

export default CoursesNeedRegister;
