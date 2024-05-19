package vn.edu.iuh.fit.subjectservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.edu.iuh.fit.subjectservice.converters.HocKyEnumConverter;
import vn.edu.iuh.fit.subjectservice.enums.HocKyEnum;
import vn.edu.iuh.fit.subjectservice.keys.LichDangKyHocPhanKey;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "lichDangKyHocPhan")
public class LichDangKyHocPhan  {

    @EmbeddedId
    private LichDangKyHocPhanKey lichDangKyHocPhanKey;

    @OneToMany(mappedBy = "hocPhanKey.lichDangKyHocPhan", cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private Set<HocPhan> danhSachHocPhanChoDangKy;


}
