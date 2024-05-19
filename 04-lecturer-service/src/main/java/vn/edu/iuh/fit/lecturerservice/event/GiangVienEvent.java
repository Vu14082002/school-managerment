package vn.edu.iuh.fit.lecturerservice.event;


import lombok.*;
import org.springframework.beans.factory.annotation.Value;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class GiangVienEvent {
    private String  username ;
    @Value("${spring.lecturer.password.default}")
    private String password="1111";
    @Value("${spring.lecturer.role}")
    private String role;
    private String hoTen;
    private String chucDanh;

    public GiangVienEvent(String username) {
        this.username = username;
    }
}
