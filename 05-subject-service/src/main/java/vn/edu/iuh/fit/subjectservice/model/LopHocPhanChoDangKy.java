package vn.edu.iuh.fit.subjectservice.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.edu.iuh.fit.subjectservice.converters.TrangThaiHocPhanConverter;
import vn.edu.iuh.fit.subjectservice.enums.TrangThaiHocPhanEnum;
import vn.edu.iuh.fit.subjectservice.keys.LopHocPhanChoDangKyKey;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "lop_hoc_phan_cho_dang_ky")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LopHocPhanChoDangKy {

    @EmbeddedId
    private LopHocPhanChoDangKyKey lopHocPhanChoDangKyKey;

    private int soLuongSinhVienToiDa;

    @Convert(converter = TrangThaiHocPhanConverter.class)
    private TrangThaiHocPhanEnum trangThaiHocPhan;

    @OneToMany(mappedBy = "lopHocPhanDuKien")
    private Set<ChiTietLopHocPhan> danhSachChiTietLopHocPhan = new HashSet<>();

}
