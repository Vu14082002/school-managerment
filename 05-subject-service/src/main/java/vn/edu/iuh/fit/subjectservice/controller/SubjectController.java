package vn.edu.iuh.fit.subjectservice.controller;


import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.subjectservice.dto.*;
import vn.edu.iuh.fit.subjectservice.services.ChiTietLopHocPhanService;
import vn.edu.iuh.fit.subjectservice.services.HocPhanServices;
import vn.edu.iuh.fit.subjectservice.services.LichDangKyHocPhanServices;
import vn.edu.iuh.fit.subjectservice.services.LopHocPhanChoDangKyService;

import java.util.List;


@RestController
@RequestMapping("${spring.api.version}")
@CrossOrigin(origins = "http://localhost:5173")
@AllArgsConstructor
public class SubjectController {

    private LichDangKyHocPhanServices lichDangKyHocPhanServices;
    private HocPhanServices hocPhanServices;
    private DataResponse dataResponse;
    private LopHocPhanChoDangKyService lopHocPhanChoDangKyService;
    private ChiTietLopHocPhanService chiTietLopHocPhanService;
    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("Subject service is healthy");
    }


    @GetMapping("/DangKyHocPhan/DotDangKy")
    public ResponseEntity<DataResponse> dotdangky() {
        try {
            List<LichDangKyHocPhanDTO> allLichDangKyHocPhan = lichDangKyHocPhanServices.getAllLichDangKyHocPhan();
            dataResponse.setData(allLichDangKyHocPhan);
            dataResponse.setMessage("Success");
            dataResponse.setCode(200);
            return ResponseEntity.ok(dataResponse);
        } catch (Exception e) {
            dataResponse.setData(null);
            dataResponse.setMessage("Error");
            dataResponse.setCode(500);
            return ResponseEntity.ok(dataResponse);
        }
    }

    @GetMapping("/DangKyHocPhan/DotDangKy/DanhSachHocPhan")
    public ResponseEntity<DataResponse> danhsachhocphan(@ModelAttribute HocPhanTheoKyDTO hocPhanTheoKyDTO) {
        try {
            List<HocPhanDTO> hocPhanDTOS = hocPhanServices.danhSachHoocPhanTheoKyVaChuyeNganh(hocPhanTheoKyDTO.getNamHoc(),
                    hocPhanTheoKyDTO.getHocKy(),hocPhanTheoKyDTO.getChuyenNganh(),hocPhanTheoKyDTO.getMssv());
            dataResponse.setData(hocPhanDTOS);
            dataResponse.setMessage("Success");
            dataResponse.setCode(200);
            return ResponseEntity.ok(dataResponse);
        } catch (Exception e) {
            dataResponse.setData(null);
            dataResponse.setMessage("Error");
            dataResponse.setCode(500);
            return ResponseEntity.ok(dataResponse);
        }
    }
    @GetMapping("/DangKyHocPhan/DotDangKy/DanhSachHocPhan/LopHocPhanChoDangKy")
    public ResponseEntity<DataResponse> lopphanphanchodangky(@ModelAttribute LopHPChoDKRequest lopHPChoDKRequest) {
        try {
            List<LopHocPhanChoDangKyDTO> lopHocPhanChoDangKyDTOS =
                    lopHocPhanChoDangKyService.lopPhanChoChoDangKyTheoHocPhan(lopHPChoDKRequest.getMaHocPhan());
            dataResponse.setData(lopHocPhanChoDangKyDTOS);
            dataResponse.setMessage("Success");
            dataResponse.setCode(200);
            return ResponseEntity.ok(dataResponse);
        } catch (Exception e) {
            dataResponse.setData(null);
            dataResponse.setMessage("Error");
            dataResponse.setCode(500);
            return ResponseEntity.ok(dataResponse);
        }
    }
    @GetMapping("/DangKyHocPhan/DotDangKy/DanhSachHocPhan/LopHocPhanChoDangKy/ChiTietLopHocPhan")
    public ResponseEntity<DataResponse> chiTietLopHocPhan(@RequestBody ChiTietLopHocPhanRequest  chiTietLopHocPhan) {
        chiTietLopHocPhanService.findAllByLopHocPhanAndNamHoc(chiTietLopHocPhan);
        try {
            dataResponse.setData(null);
            dataResponse.setMessage("Success");
            dataResponse.setCode(200);
            return ResponseEntity.ok(dataResponse);
        } catch (Exception e) {
            dataResponse.setData(null);
            dataResponse.setMessage("Error");
            dataResponse.setCode(500);
            return ResponseEntity.ok(dataResponse);
        }
    }

}
