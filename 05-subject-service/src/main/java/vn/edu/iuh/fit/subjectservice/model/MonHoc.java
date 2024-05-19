package vn.edu.iuh.fit.subjectservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.edu.iuh.fit.subjectservice.converters.LoaiMonHocConverter;
import vn.edu.iuh.fit.subjectservice.enums.LoaiMonHocEnum;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "monhoc")
public class MonHoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maMonHoc;

    private String tenMonHoc;

    @OneToMany(mappedBy = "monHocSau", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private Set<MonHoc> monHocTruoc = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maMonHocSau")
    private MonHoc monHocSau;

    @Convert(converter = LoaiMonHocConverter.class)
    private LoaiMonHocEnum loaiMonHoc;

    private String mota;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private Set<ChuyenNganh> chuyenNganh = new HashSet<>();
}
