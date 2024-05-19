package vn.edu.iuh.fit.subjectservice.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "sinhvien")
public class SinhVien {

    @Id
    private Integer mssv;
    private String hoTen;
    @ElementCollection
    @CollectionTable(name = "SinhVien_Lop", joinColumns = @JoinColumn(name = "mssv"))
    @Column(name = "lopDanhNghia")
    private Set<String> lopDanhNghia= new HashSet<>();

    @ElementCollection
    @CollectionTable(name = "SinhVien_ChuyenNganh", joinColumns = @JoinColumn(name = "mssv"))
    @Column(name = "chuyenNganh")
    private Set<String> chuyenNganh = new HashSet<>();

    @ManyToMany
    private Set<HocPhan> danhSachMonHocDangKy;


}
