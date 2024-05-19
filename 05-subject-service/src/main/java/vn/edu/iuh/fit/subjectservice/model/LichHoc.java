package vn.edu.iuh.fit.subjectservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.edu.iuh.fit.subjectservice.converters.HinhThucHocEnumConverter;
import vn.edu.iuh.fit.subjectservice.enums.CosoTruongHocEnum;
import vn.edu.iuh.fit.subjectservice.enums.HinhThucHocEnum;
import vn.edu.iuh.fit.subjectservice.enums.ThoiGian;
import vn.edu.iuh.fit.subjectservice.keys.LichHocKey;

import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "lichhoc")
@IdClass(LichHocKey.class)
public class LichHoc {

    @Id
    private LocalDate ngayHoc;

    @Id
    private LocalTime thoiGianBatDau;

    @Id
    private LocalTime thoiGianKetThuc;

    @Id
    @OneToOne
    private PhongHoc phongHoc;

    @Id
    @ManyToOne
    private ChiTietLopHocPhan chiTietLopHocPhan;

    @Id
    private CosoTruongHocEnum coso;

    @ManyToOne
    private GiangVien giangVien;

    @Convert(converter = HinhThucHocEnumConverter.class)
    private HinhThucHocEnum hinhThucHoc;

    private String ghiChu;
}
