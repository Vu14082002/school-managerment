package vn.edu.iuh.fit.subjectservice.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SinhVienLopHocPhanResponse {
    private String maLopHocPhan;
    private String tenMonHoc;
    private String lopHocPhanDuKien;
    private String soTC;
    private String hocPhi;
    private String hanNop;
    private Boolean daDongHocPhi=false;
    private String trangThaiDk;
    private String ngayDK;
    private String trangThaiHocPhan;
}
