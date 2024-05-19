package vn.edu.iuh.fit.studentservice.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.studentservice.event.SinhVienEvent;
import vn.edu.iuh.fit.studentservice.model.SinhVien;
import vn.edu.iuh.fit.studentservice.publisher.SinhVienAuthProducer;
import vn.edu.iuh.fit.studentservice.publisher.SinhVienSubjectProducer;
import vn.edu.iuh.fit.studentservice.repositoies.SinhVienRepository;

@Service
@AllArgsConstructor
public class SinhVienService {
    private SinhVienRepository sinhVienRepository;
    private SinhVienAuthProducer sinhVienAuthProducer;
    private SinhVienSubjectProducer sinhVienSubjectProducer;

    public SinhVien save(SinhVien sinhVien) {
        SinhVien sinhvienSaved = sinhVienRepository.save(sinhVien);
//
        String role="STUDENT";
        SinhVienEvent sinhVienEvent = new SinhVienEvent();
        sinhVienEvent.setUsername(sinhvienSaved.getMssv());
        sinhVienEvent.setPassword("1111");
        sinhVienEvent.setRole(role);
        sinhVienEvent.setHoTen(sinhvienSaved.getHoTen());
        sinhVienEvent.setLopDanhNghia(sinhvienSaved.getLopDanhNghia());
        sinhVienEvent.setChuyenNganh(sinhvienSaved.getChuyenNganh());
//
        sinhVienAuthProducer.sendToAuthService(sinhVienEvent);
        sinhVienSubjectProducer.sendToAuthService(sinhVienEvent);
        return sinhvienSaved;
    }
}
