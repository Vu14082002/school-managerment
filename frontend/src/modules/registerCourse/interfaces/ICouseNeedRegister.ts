import ICourseType from './ICourseType';

interface ICouseNeedRegister {
    id: string;
    name: string;
    credit: number;
    required: boolean;
    courses: ICourseType[];
}

export default ICouseNeedRegister;
