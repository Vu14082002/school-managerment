package vn.edu.iuh.fit.subjectservice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import vn.edu.iuh.fit.subjectservice.converters.TrangThaiDangKyEnumConverter;
import vn.edu.iuh.fit.subjectservice.enums.TrangThaiDangKyEnum;
import vn.edu.iuh.fit.subjectservice.keys.SinhVienLopHocPhanKey;

import java.time.LocalDate;

@Entity
@Table(name = "sinhvien_lophocphan")
@Getter
@Setter
public class SinhVienLopHocPhan {


    @EmbeddedId
    private SinhVienLopHocPhanKey sinhVienLopHocPhanKey;

    private LocalDate ngayDangKy;

    @Convert(converter = TrangThaiDangKyEnumConverter.class)
    private TrangThaiDangKyEnum trangThaiDangKy;
}
