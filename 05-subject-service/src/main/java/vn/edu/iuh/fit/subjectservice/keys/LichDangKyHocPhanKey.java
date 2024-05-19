package vn.edu.iuh.fit.subjectservice.keys;

import jakarta.persistence.Embeddable;
import lombok.*;
import vn.edu.iuh.fit.subjectservice.enums.HocKyEnum;

import java.io.Serializable;
import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class LichDangKyHocPhanKey implements Serializable {

    private int namhoc;
    private HocKyEnum hocKy;
}
