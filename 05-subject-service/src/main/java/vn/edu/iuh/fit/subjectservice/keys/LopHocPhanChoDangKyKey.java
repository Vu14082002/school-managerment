package vn.edu.iuh.fit.subjectservice.keys;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import vn.edu.iuh.fit.subjectservice.model.HocPhan;
import vn.edu.iuh.fit.subjectservice.model.LopHoc;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode
@Embeddable
public class LopHocPhanChoDangKyKey {

    @ManyToOne
    private LopHoc lopHocDuKien;

    @ManyToOne
    private HocPhan hocPhan;

}
