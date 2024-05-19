package vn.edu.iuh.fit.subjectservice.keys;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import vn.edu.iuh.fit.subjectservice.model.LopHocPhanChoDangKy;
import vn.edu.iuh.fit.subjectservice.model.SinhVien;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class SinhVienLopHocPhanKey {
    @ManyToOne
    private SinhVien maSinhVien;
    @ManyToOne
    private LopHocPhanChoDangKy lopHocPhanDangKy;

}
