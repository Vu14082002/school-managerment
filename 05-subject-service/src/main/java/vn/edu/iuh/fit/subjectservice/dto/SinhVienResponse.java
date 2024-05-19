package vn.edu.iuh.fit.studentservice.dto;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SinhVienResponse {
    private int code;
    private String message;
    private Object data;
}
