package vn.edu.iuh.fit.studentservice.event;


import lombok.*;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SinhVienEvent {
    private Integer username ;
    private String password;
    private String role;
    private String hoTen;
    private Set<String> lopDanhNghia= new HashSet<>();
    private Set<String> chuyenNganh = new HashSet<>();
}
