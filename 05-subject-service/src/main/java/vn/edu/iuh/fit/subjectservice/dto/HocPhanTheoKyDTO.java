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
public class HocPhanTheoKyDTO {
    private int namHoc;
    private String hocKy;
    private String chuyenNganh;
    private int mssv;
}
