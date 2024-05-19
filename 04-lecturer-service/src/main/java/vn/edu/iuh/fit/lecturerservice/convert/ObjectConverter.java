package vn.edu.iuh.fit.lecturerservice.convert;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import vn.edu.iuh.fit.lecturerservice.dto.GiangVienDto;
import vn.edu.iuh.fit.lecturerservice.enums.ChucDanhEnum;
import vn.edu.iuh.fit.lecturerservice.enums.LoaiCongViec;
import vn.edu.iuh.fit.lecturerservice.enums.TrangThai;
import vn.edu.iuh.fit.lecturerservice.model.GiangVien;

import java.text.SimpleDateFormat;


@Component
@AllArgsConstructor
public class ObjectConverter {

    public GiangVien convertToGiangVien(GiangVienDto dto) throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        GiangVien giangVien = new GiangVien();
        giangVien.setMsgv(dto.getMsgv());
        giangVien.setHoTen(dto.getHoTen());
        giangVien.setNgaySinh(format.parse(dto.getNgaySinh()));
        giangVien.setGioiTinh(dto.getGioiTinh());
        giangVien.setCccd(dto.getCccd());
        giangVien.setDienThoai(dto.getDienThoai());
        giangVien.setEmail(dto.getEmail());
        giangVien.setDiaChi(dto.getDiaChi());
        giangVien.setLopChuNhiem(dto.getLopChuNhiem());
        giangVien.setTrangThai(TrangThai.fromValue(dto.getTrangThai()));
        giangVien.setLoaiCongViec(LoaiCongViec.fromValue(dto.getLoaiCongViec()));
        giangVien.setChucDanh(ChucDanhEnum.fromValue(dto.getChucDanh()));
        giangVien.setChuyenNganh(dto.getChuyenNganh());
        return giangVien;
    }
}
