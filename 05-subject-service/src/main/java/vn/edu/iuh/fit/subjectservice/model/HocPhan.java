package vn.edu.iuh.fit.subjectservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.edu.iuh.fit.subjectservice.keys.HocPhanKey;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "hocphan")
public class HocPhan {

    @EmbeddedId
    private HocPhanKey hocPhanKey;

    @Column(name = "tinchi_lythuyet")
    private int soTinChiLyThuyet;
    @Column(name = "tinchi_thuchanh")
    private int soTinChiThucHanh;
    @Column(name = "hocphi_lythuyet")
    private Double hocPhiLyThuyet;
    @Column(name = "hocphi_thuchanh")
    private Double hocPhiThucHanh;

    @OneToMany(mappedBy = "lopHocPhanChoDangKyKey.hocPhan")
    private Set<LopHocPhanChoDangKy> danhSachLopHocPhanChoDangKy = new HashSet<>();

}
