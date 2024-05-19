package vn.edu.iuh.fit.subjectservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.edu.iuh.fit.subjectservice.keys.ChuyenNganhKey;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "chuyennganh")
@Embeddable
public class ChuyenNganh {

    @EmbeddedId
    private ChuyenNganhKey chuyenNganhKey;
    private String tenChuyenNganh;
    private String moTa;
    @ManyToMany(mappedBy = "chuyenNganh", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private Set<MonHoc> monHocSet = new HashSet<>();

    @ManyToMany(mappedBy = "chuyenNganh", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private Set<MonHoc> danhSachMonHoc = new HashSet<>();

}
