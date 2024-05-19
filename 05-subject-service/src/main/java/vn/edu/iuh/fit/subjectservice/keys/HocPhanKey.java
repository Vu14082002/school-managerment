package vn.edu.iuh.fit.subjectservice.keys;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.edu.iuh.fit.subjectservice.enums.HocKyEnum;
import vn.edu.iuh.fit.subjectservice.model.LichDangKyHocPhan;
import vn.edu.iuh.fit.subjectservice.model.MonHoc;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Embeddable
public class HocPhanKey  {

    @ManyToOne
    private MonHoc monHoc;

    @ManyToOne
    private LichDangKyHocPhan lichDangKyHocPhan;
}
