package vn.edu.iuh.fit.subjectservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ChiTietLopHocPhanRequest {
    private int maLopHocPhan;
}
