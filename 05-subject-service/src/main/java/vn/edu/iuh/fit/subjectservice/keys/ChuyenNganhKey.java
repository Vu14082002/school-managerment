package vn.edu.iuh.fit.subjectservice.keys;

import jakarta.persistence.Embeddable;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter@Setter
@EqualsAndHashCode
@Embeddable
public class ChuyenNganhKey {
    private String maChuyenNganh;
    private String maKhoa;
}
