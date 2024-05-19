package vn.edu.iuh.fit.lecturerservice.dto;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GiangVienResponse {
    private int code;
    private String message;
    private Object data;
}
