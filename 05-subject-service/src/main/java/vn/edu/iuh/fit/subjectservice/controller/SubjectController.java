//package vn.edu.iuh.fit.studentservice.controller;
//
//
//import lombok.AllArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import vn.edu.iuh.fit.studentservice.convert.ObjectConverter;
//import vn.edu.iuh.fit.studentservice.dto.SinhVienDto;
//import vn.edu.iuh.fit.studentservice.dto.SinhVienResponse;
//import vn.edu.iuh.fit.studentservice.event.SinhVienAuthEvent;
//import vn.edu.iuh.fit.studentservice.publisher.SinhVienProducer;
//import vn.edu.iuh.fit.studentservice.services.SinhVienService;
//
//@RestController
//@RequestMapping("${spring.api.version}")
//@AllArgsConstructor
//public class SubjectController {
//    private SinhVienProducer sinhVienProducer;
//    private SinhVienService sinhVienService;
//    private ObjectConverter objectConverter;
//
//
//    @GetMapping("/health")
//    public ResponseEntity<String> health() {
//        return ResponseEntity.ok("Student service is healthy");
//    }
//
//    @PostMapping
//    public ResponseEntity<SinhVienResponse> createOrder(@RequestBody SinhVienDto sinhVienDto) {
//        String passwordDefault = "1111";
//        try {
//            SinhVien sinhVien = sinhVienService.save(objectConverter.convertToSinhVien(sinhVienDto));
//            SinhVienAuthEvent sinhVienEvent = objectConverter.convertToSinhVienEvent(sinhVien.getMssv(), passwordDefault);
//            sinhVienProducer.sendToAuthService(sinhVienEvent);
//            SinhVienResponse sinhVienResponse = new SinhVienResponse(HttpStatus.CREATED.value(), "Success", sinhVien);
//            return ResponseEntity.status(HttpStatus.CREATED).body(sinhVienResponse);
//        } catch (Exception e) {
//            SinhVienResponse sinhVienResponse = new SinhVienResponse(HttpStatus.CREATED.value(), "Success", null);
//            return ResponseEntity.badRequest().body(sinhVienResponse);
//        }
//    }
//}
