package vn.edu.iuh.fit.subjectservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.edu.iuh.fit.subjectservice.enums.PhongHocEnum;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "phonghoc")
public class PhongHoc {
    @Id
    private String maPhongHoc;
    private String tenPhongHoc;
    private int soChoNgoi;
    @Enumerated(EnumType.ORDINAL)
    private PhongHocEnum loaiPhongHoc;
    private Boolean tinhTrang;

}
