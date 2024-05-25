package vn.edu.iuh.fit.subjectservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ChiTietLopHocPhanResponseDTO {
    private String lichHoc;
    private int nhomThucHanh;
    private String phongHoc;
    private String cs;
    private String giangVien;
}
