import { Option, Radio, RadioGroup, Select } from '@mui/joy';
import classNames from 'classnames/bind';
import { useEffect, useState } from 'react';
import ClassRegisterDetail from './components/classRegisterDetail';
import ClassRegistered from './components/classRegistered';
import ClassesRegister from './components/classesRegister';
import CoursesNeedRegister from './components/coursesNeedRegister';
import { ICourseNeedRegister } from './interfaces';
import style from './style.module.scss';

const cx = classNames.bind(style);

const semesters = [
    { id: 'hk3_2024_2025', name: 'HK3 (2024-2025)' },
    { id: 'hk2_2024_2025', name: 'HK2 (2024-2025)' },
    { id: 'hk1_2024_2025', name: 'HK1 (2024-2025)' },
    { id: 'hk3_2023_2024', name: 'HK3 (2023-2024)' },
    { id: 'hk2_2023_2024', name: 'HK2 (2023-2024)' },
    { id: 'hk1_2023_2024', name: 'HK1 (2023-2024)' },
    { id: 'hk3_2022_2023', name: 'HK3 (2022-2023)' },
    { id: 'hk2_2022_2023', name: 'HK2 (2022-2023)' },
    { id: 'hk1_2022_2023', name: 'HK1 (2022-2023)' },
    { id: 'hk3_2021_2022', name: 'HK3 (2021-2022)' },
    { id: 'hk2_2021_2022', name: 'HK2 (2021-2022)' },
    { id: 'hk1_2021_2022', name: 'HK1 (2021-2022)' },
    { id: 'hk3_2020_2021', name: 'HK3 (2020-2021)' },
    { id: 'hk2_2020_2021', name: 'HK2 (2020-2021)' },
    { id: 'hk1_2020_2021', name: 'HK1 (2020-2021)' },
];

const types = [
    {
        id: 'new_learning',
        name: 'Học mới',
    },
    {
        id: 're_learning',
        name: 'Học lại',
    },
    {
        id: 'school_improvement',
        name: 'Học cải thiện',
    },
];

const courses: ICourseNeedRegister[] = [
    {
        id: '4203003193',
        name: 'Toán ứng dụng',
        credit: 3,
        required: false,
        courses: [
            {
                type: 'a',
                id: '003591',
            },
        ],
    },
];

const RegisterCourse = () => {
    const [typeChecked, setTypeChecked] = useState<string>('new_learning');
    const [semester, setSemester] = useState<string>('');

    const handleChangeType = (e: React.ChangeEvent<HTMLInputElement>) => setTypeChecked(e.target.value);
    const handleChange = (_event: React.SyntheticEvent | null, newValue: string | null) =>
        newValue && setSemester(newValue);

    useEffect(() => {
        console.group('RegisterCourse');
        console.log('semester:', semester);
        console.log('typeChecked:', typeChecked);
        console.groupEnd();
    }, [semester, typeChecked]);

    return (
        <div className={cx('container')}>
            <h4 className={cx('title')}>Đăng ký học phần</h4>

            <div className={cx('flex justify-center items-center', 'form')}>
                <Select
                    onChange={handleChange}
                    placeholder="Chọn đợt đăng ký"
                    name="semester"
                    className={cx('semester')}
                >
                    {semesters.map((semester) => (
                        <Option key={semester.id} value={semester.id}>
                            {semester.name}
                        </Option>
                    ))}
                </Select>
                <RadioGroup orientation="horizontal" defaultValue="outlined" name="type">
                    {types.map((type) => (
                        <Radio
                            checked={typeChecked === type.id}
                            onChange={handleChangeType}
                            key={type.id}
                            value={type.id}
                            label={type.name}
                            variant="outlined"
                        />
                    ))}
                </RadioGroup>
            </div>

            <CoursesNeedRegister courses={courses} />

            <div className={cx('flex', 'course-detail')}>
                <div className={cx('flex-1', 'classes')}>
                    <ClassesRegister />
                </div>
                <div className={cx('flex-1', 'class-detail')}>
                    <ClassRegisterDetail />
                </div>
            </div>

            <ClassRegistered className={cx('registered-classes')} />
        </div>
    );
};

export default RegisterCourse;
