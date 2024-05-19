package vn.edu.iuh.fit.lecturerservice.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.edu.iuh.fit.lecturerservice.enums.ChucDanhEnum;
import vn.edu.iuh.fit.lecturerservice.model.DiaChi;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GiangVienDto {
    private String msgv;
    private String hoTen;
    private String ngaySinh;
    private Boolean gioiTinh;
    private String cccd;
    private String dienThoai;
    private String email;
    private DiaChi diaChi;
    private Set<String> lopChuNhiem= new HashSet<>();
    private String trangThai;
    private String loaiCongViec;
    private String chucDanh;
    private Set<String> chuyenNganh = new HashSet<>();
}
