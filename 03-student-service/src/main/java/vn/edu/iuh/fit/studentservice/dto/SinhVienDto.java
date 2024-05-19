package vn.edu.iuh.fit.studentservice.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.edu.iuh.fit.studentservice.model.DiaChi;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SinhVienDto {
    private Integer mssv;
    private String hoTen;
    private String ngaySinh;
    private Boolean gioiTinh;
    private String cccd;
    private String dienThoai;
    private String email;
    private DiaChi diaChi;
    private Set<String> lopDanhNghia= new HashSet<>();
    private String trangThai;
//    private String lichHoc;
    private Set<String> chuyenNganh = new HashSet<>();
}
