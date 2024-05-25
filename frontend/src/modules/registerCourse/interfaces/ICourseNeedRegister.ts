import ICourseType from './ICourseType';

interface ICourseNeedRegister {
    maHocPhan: string;
    tenMonHoc: string;
    soTinChi: number;
    loaiMonHoc: 'Bắt buộc' | 'Tự chọn';
    danhSachMonHocTruoc: ICourseType[] | null;
}

export default ICourseNeedRegister;
