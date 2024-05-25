package vn.edu.iuh.fit.subjectservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DangKyHocPhanRequestDTO {
    private String maLopHocPhan;
    private String maHocPhan;
    private int mssv;
}
