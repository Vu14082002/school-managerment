package vn.edu.iuh.fit.lecturerservice.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.lecturerservice.enums.ChucDanhEnum;
import vn.edu.iuh.fit.lecturerservice.event.GiangVienEvent;
import vn.edu.iuh.fit.lecturerservice.model.GiangVien;
import vn.edu.iuh.fit.lecturerservice.publisher.GiangVienAuthProducer;
import vn.edu.iuh.fit.lecturerservice.publisher.GiangVienSubjectProducer;
import vn.edu.iuh.fit.lecturerservice.repository.GiangVienRepository;

@Service
@AllArgsConstructor
public class GiangVienService {
    private GiangVienRepository giangVienRepository;
    private GiangVienAuthProducer giangVienAuthProducer;
    private GiangVienSubjectProducer giangVienSubjectProducer;

    public GiangVien save(GiangVien giangVien) {
        GiangVien giangvienSaved = giangVienRepository.save(giangVien);
        GiangVienEvent giangVienEvent = new GiangVienEvent();
        giangVienEvent.setUsername(giangvienSaved.getMsgv());
        giangVienEvent.setPassword("1111");
        giangVienEvent.setRole("LECTURER");
        giangVienEvent.setHoTen(giangvienSaved.getHoTen());
        giangVienEvent.setChucDanh(ChucDanhEnum.toValue(giangvienSaved.getChucDanh()));
//
        giangVienAuthProducer.sendToAuthService(giangVienEvent);
        giangVienSubjectProducer.sendToAuthService(giangVienEvent);

        return giangvienSaved;

    }
}
