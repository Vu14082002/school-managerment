package vn.edu.iuh.fit.subjectservice.event;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class GiangVienEvent {
    private String  username ;
    private String password="1111";
    private String role;
    private String hoTen;
    private String chucDanh;

    public GiangVienEvent(String username) {
        this.username = username;
    }
}
