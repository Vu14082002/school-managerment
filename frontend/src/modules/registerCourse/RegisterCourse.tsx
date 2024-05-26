import { Option, Radio, RadioGroup, Select } from '@mui/joy';
import axios from 'axios';
import classNames from 'classnames/bind';
import { useEffect, useState } from 'react';
import { useAppDispatch, useAppSelector } from '../../app/hooks';
import { RootState } from '../../app/store';
import ClassRegisterDetail from './components/classRegisterDetail';
import ClassRegistered from './components/classRegistered';
import ClassesRegister from './components/classesRegister';
import CoursesNeedRegister from './components/coursesNeedRegister';
import { setSubject } from './features/classes/classesSlice';
import { getRegisteredClasses, setRegisteredClasses } from './features/registeredClasses/registeredClassesSlice';
import { getSubjects, setHocKyVaNamHoc, setSubjects } from './features/subjects/subjectsSlice';
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
    { id: 'hk3_2019_2020', name: 'HK3 (2019-2020)' },
    { id: 'hk2_2019_2020', name: 'HK2 (2019-2020)' },
    { id: 'hk1_2019_2020', name: 'HK1 (2019-2020)' },
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

const RegisterCourse = () => {
    const { user } = useAppSelector((state: RootState) => state.user);
    console.log('🚀 ~ RegisterCourse ~ user:', user);
    const [typeChecked, setTypeChecked] = useState<string>('new_learning');
    const [semester, setSemester] = useState<string>('');
    const dispatch = useAppDispatch();

    const handleChangeType = (e: React.ChangeEvent<HTMLInputElement>) => setTypeChecked(e.target.value);
    const handleChange = (_event: React.SyntheticEvent | null, newValue: string | null) =>
        newValue && setSemester(newValue);

    // FIXME: ChuyenNganh
    // TODO: Loại đăng ký
    useEffect(() => {
        dispatch(setSubject(undefined));

        if (!semester || !user) {
            dispatch(setSubjects([]));
            dispatch(setRegisteredClasses([]));
            return;
        }

        const source = axios.CancelToken.source();

        const getData = async () => {
            const [sHocKy, sNamHoc] = semester.split('_');

            const namHoc = +sNamHoc;
            const hocKy = sHocKy.toUpperCase();

            dispatch(setHocKyVaNamHoc({ hocKy, namHoc }));
            dispatch(
                getSubjects({
                    data: {
                        hocKy,
                        namHoc,
                        mssv: user.mssv,
                        chuyenNganh: 'CN01',
                    },
                    cancelToken: source.token,
                }),
            );

            dispatch(getRegisteredClasses({ data: { hocKy, namHoc, mssv: user.mssv }, cancelToken: source.token }));
        };

        getData();

        return () => {
            source.cancel();
        };
    }, [dispatch, semester, typeChecked, user]);

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

            <CoursesNeedRegister />

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
