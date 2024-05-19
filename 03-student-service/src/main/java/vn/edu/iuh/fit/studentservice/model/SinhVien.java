package vn.edu.iuh.fit.studentservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sinhvien")
@Getter
@Setter
public class SinhVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer mssv;
    private String hoTen;
    private Date ngaySinh;
    private Boolean gioiTinh;
    private String cccd;
    private String dienThoai;
    private String email;
    @OneToOne(cascade = CascadeType.ALL)
    private DiaChi diaChi;

    @ElementCollection
    @CollectionTable(name = "SinhVien_Lop", joinColumns = @JoinColumn(name = "mssv"))
    @Column(name = "lopDanhNghia")
    private Set<String> lopDanhNghia= new HashSet<>();
    private String trangThai;
//    @Column(name = "lichHoc")
//    private String lichHoc;
    @ElementCollection
    @CollectionTable(name = "SinhVien_ChuyenNganh", joinColumns = @JoinColumn(name = "mssv"))
    @Column(name = "chuyenNganh")
    private Set<String> chuyenNganh = new HashSet<>();
}
