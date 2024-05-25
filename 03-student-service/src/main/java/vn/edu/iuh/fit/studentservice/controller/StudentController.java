package vn.edu.iuh.fit.studentservice.controller;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.studentservice.convert.ObjectConverter;
import vn.edu.iuh.fit.studentservice.dto.SinhVienDto;
import vn.edu.iuh.fit.studentservice.dto.SinhVienResponse;
import vn.edu.iuh.fit.studentservice.model.SinhVien;
import vn.edu.iuh.fit.studentservice.services.SinhVienService;

@RestController
@RequestMapping("${spring.api.version}")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class StudentController {
    private SinhVienService sinhVienService;
    private ObjectConverter objectConverter;


    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("Student service is healthy");
    }
    @PostMapping
    public ResponseEntity<SinhVienResponse> createOrder(@RequestBody SinhVienDto sinhVienDto) {
        try {
            SinhVien sinhVien = sinhVienService.save(objectConverter.convertToSinhVien(sinhVienDto));
            SinhVienResponse sinhVienResponse = new SinhVienResponse(HttpStatus.CREATED.value(), "Success", sinhVien);
            return ResponseEntity.status(HttpStatus.CREATED).body(sinhVienResponse);
        } catch (Exception e) {
            SinhVienResponse sinhVienResponse = new SinhVienResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Fail", null);
            return ResponseEntity.badRequest().body(sinhVienResponse);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<SinhVienResponse> getStudentById(@PathVariable("id") Integer id) {
        try {
            SinhVienDto sinhVienDto = sinhVienService.findById(id);
            SinhVienResponse sinhVienResponse = new SinhVienResponse(HttpStatus.OK.value(), "Success", sinhVienDto);
            return ResponseEntity.ok(sinhVienResponse);
        } catch (Exception e) {
            SinhVienResponse sinhVienResponse = new SinhVienResponse(HttpStatus.NOT_FOUND.value(), "Fail", null);
            return ResponseEntity.badRequest().body(sinhVienResponse);
        }
    }
}
