package vn.edu.iuh.fit.studentservice.convert;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import vn.edu.iuh.fit.studentservice.dto.SinhVienDto;
import vn.edu.iuh.fit.studentservice.model.SinhVien;

import java.text.SimpleDateFormat;


@Component
@AllArgsConstructor
public class ObjectConverter {

    public SinhVien convertToSinhVien(SinhVienDto dto) throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        SinhVien sv = new SinhVien();
        sv.setGioiTinh(dto.getGioiTinh());
        sv.setHoTen(dto.getHoTen());
        sv.setCccd(dto.getCccd());
        sv.setDienThoai(dto.getDienThoai());
        sv.setEmail(dto.getEmail());
        sv.setNgaySinh(format.parse(dto.getNgaySinh()));
        sv.setTrangThai(dto.getTrangThai());
        sv.setLopDanhNghia(dto.getLopDanhNghia());
        sv.setChuyenNganh(dto.getChuyenNganh());
        sv.setDiaChi(dto.getDiaChi());
        return sv;
    }
}
