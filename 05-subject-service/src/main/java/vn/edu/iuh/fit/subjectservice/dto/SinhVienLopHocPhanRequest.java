package vn.edu.iuh.fit.subjectservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SinhVienLopHocPhanRequest {
    private int namHoc;
    private String hocKy;
    private int mssv;
}
