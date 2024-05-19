package vn.edu.iuh.fit.subjectservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HocPhanDTO {
    private String maHocPhan;
    private String tenMonHoc;
    private int soTinChi;
    private String loaiMonHoc;
    private List<Integer> danhSachMonHocTruoc;
}
