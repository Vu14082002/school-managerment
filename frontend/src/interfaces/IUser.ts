import IAddress from './IAddress';

interface IUser {
    mssv: number;
    hoTen: string;
    ngaySinh: string;
    gioiTinh: boolean;
    cccd: string;
    dienThoai: string;
    email: string;
    diaChi: IAddress;
    lopDanhNghia: string[];
    trangThai: string;
    chuyenNganh: string[];
}

export default IUser;
