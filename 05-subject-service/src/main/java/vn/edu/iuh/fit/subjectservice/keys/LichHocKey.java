package vn.edu.iuh.fit.subjectservice.keys;

import lombok.*;
import vn.edu.iuh.fit.subjectservice.enums.CosoTruongHocEnum;
import vn.edu.iuh.fit.subjectservice.enums.ThoiGian;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class LichHocKey implements Serializable {
    private LocalDate ngayHoc;
    private LocalTime thoiGianBatDau;
    private LocalTime thoiGianKetThuc;
    private String phongHoc;
    private Long chiTietLopHocPhan;
    private CosoTruongHocEnum coso;

}
