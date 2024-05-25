package vn.edu.iuh.fit.subjectservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LopHocPhanChoDangKyDTO {
    private String maLopHocPhan;
    private String tenMonHoc;
    private int maMonHoc;
    private String lopHocDuKien;
    private Integer siSoToiDa;
    private Integer soLuongSinhVienDKHienTai;
    private String trangThai;
}
