package vn.edu.iuh.fit.subjectservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "lop_hoc_phan_detail")
public class ChiTietLopHocPhan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private LopHocPhanChoDangKy lopHocPhanDuKien;

    private int nhomThucHanh;

    private LocalDate thoiGianBatDauMonHoc;

    private LocalDate thoiGianKetThucMonHoc;

    @OneToMany(mappedBy = "chiTietLopHocPhan", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LichHoc> lichHocLyThuyet = new ArrayList<>();

    @OneToMany(mappedBy = "chiTietLopHocPhan", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LichHoc> lichHocThucHanh = new ArrayList<>();

    private int soBuoiHocLyThuyet;

    private int soBuoiHocThucHanh;

}
