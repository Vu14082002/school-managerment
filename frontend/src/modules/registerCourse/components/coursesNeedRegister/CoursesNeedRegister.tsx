import { Radio } from '@mui/joy';
import classNames from 'classnames/bind';
import { MouseEvent, useState } from 'react';
import { useSelector } from 'react-redux';
import { useAppDispatch } from '../../../../app/hooks';
import { RootState } from '../../../../app/store';
import deleteImage from '../../../../assets/images/ico-delete-min.png';
import selectImage from '../../../../assets/images/ico-select-min.png';
import CourseTypes from '../../components/courseTypes';
import { setSubject } from '../../features/classes/classesSlice';
import { ICourseNeedRegister, ICourseType } from '../../interfaces';
import Table from '../table';
import styles from './styles.module.scss';

const cx = classNames.bind(styles);

const CoursesNeedRegister = () => {
    const [subjectChecked, setSubjectChecked] = useState<string>('');
    const { subjects } = useSelector((state: RootState) => state.subjects);
    const dispatch = useAppDispatch();

    const handleClickCourseItem = (subject: ICourseNeedRegister) => (e: MouseEvent) => {
        const rowElement = e.currentTarget;

        const selectedRowElement = document.querySelector(`.${cx('course')}.selected`);
        selectedRowElement?.classList.remove('selected');

        rowElement.classList.add('selected');

        dispatch(setSubject(subject));
        setSubjectChecked(subject.maHocPhan);
    };

    if (!subjects.length) return null;

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
                {subjects.map((subject, index) => (
                    <tr key={subject.maHocPhan} className={cx('course')} onClick={handleClickCourseItem(subject)}>
                        <td>
                            <Radio
                                id={subject.maHocPhan}
                                name="ma-hoc-phan"
                                variant="outlined"
                                checked={subjectChecked === subject.maHocPhan}
                            />
                        </td>
                        <td>{index + 1}</td>
                        <td>{subject.maHocPhan}</td>
                        <td>{subject.tenMonHoc}</td>
                        <td>{subject.soTinChi}</td>
                        <td>
                            <img
                                className={cx('course__required')}
                                src={subject.loaiMonHoc === 'Bắt buộc' ? selectImage : deleteImage}
                                alt=""
                            />
                        </td>
                        <td>
                            {subject.danhSachMonHocTruoc && (
                                <CourseTypes types={subject.danhSachMonHocTruoc as ICourseType[]} />
                            )}
                        </td>
                    </tr>
                ))}
            </tbody>
        </Table>
    );
};

export default CoursesNeedRegister;
