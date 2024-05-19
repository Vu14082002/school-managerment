package vn.edu.iuh.fit.lecturerservice.controller;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.lecturerservice.convert.ObjectConverter;
import vn.edu.iuh.fit.lecturerservice.dto.GiangVienDto;
import vn.edu.iuh.fit.lecturerservice.dto.GiangVienResponse;
import vn.edu.iuh.fit.lecturerservice.event.GiangVienEvent;
import vn.edu.iuh.fit.lecturerservice.model.GiangVien;
import vn.edu.iuh.fit.lecturerservice.repository.GiangVienRepository;
import vn.edu.iuh.fit.lecturerservice.service.GiangVienService;

@RestController
@RequestMapping("${spring.api.version}")
@AllArgsConstructor
public class GiangVienController {
    private ObjectConverter objectConverter;
    private GiangVienService giangVienService;


    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("GiangVien service is healthy");
    }
    @PostMapping
    public ResponseEntity<GiangVienResponse> createOrder(@RequestBody GiangVienDto giangVienDto) {
        try {
            GiangVien giangVienSaved = giangVienService.save(objectConverter.convertToGiangVien(giangVienDto));
            GiangVienResponse giangVienResponse = new GiangVienResponse(HttpStatus.CREATED.value(), "Success", giangVienSaved);
            return ResponseEntity.status(HttpStatus.CREATED).body(giangVienResponse);
        } catch (Exception e) {
            e.printStackTrace();
            GiangVienResponse giangVienResponse = new GiangVienResponse(HttpStatus.BAD_REQUEST.value(), "Fail", null);
            return ResponseEntity.badRequest().body(giangVienResponse);
        }
    }
}
