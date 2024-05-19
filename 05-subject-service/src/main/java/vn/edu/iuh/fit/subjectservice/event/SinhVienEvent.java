package vn.edu.iuh.fit.subjectservice.event;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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