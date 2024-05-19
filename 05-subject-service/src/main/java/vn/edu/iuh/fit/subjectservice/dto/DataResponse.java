package vn.edu.iuh.fit.subjectservice.dto;


import lombok.*;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Component
public class DataResponse {
    private int code;
    private String message;
    private Object data;
}
