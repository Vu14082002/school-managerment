package vn.edu.iuh.fit.subjectservice.consumer;


import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.subjectservice.enums.ChucDanhEnum;
import vn.edu.iuh.fit.subjectservice.event.GiangVienEvent;
import vn.edu.iuh.fit.subjectservice.event.SinhVienEvent;
import vn.edu.iuh.fit.subjectservice.model.GiangVien;
import vn.edu.iuh.fit.subjectservice.model.SinhVien;
import vn.edu.iuh.fit.subjectservice.repositories.GiangVienRepository;
import vn.edu.iuh.fit.subjectservice.repositories.SinhVienRepository;

@Service
@AllArgsConstructor
public class SubjectConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(SubjectConsumer.class);
    private SinhVienRepository sinhVienRepository;
    private GiangVienRepository giangVienRepository;

    @RabbitListener(queues = {"${student.subject.queue}"})
    public void receiveFromStudentQueue(SinhVienEvent sinhVienEvent) {
        SinhVien sinhVien = new SinhVien();
        sinhVien.setMssv(sinhVienEvent.getUsername());
        sinhVien.setHoTen(sinhVienEvent.getHoTen());
        sinhVien.setLopDanhNghia(sinhVienEvent.getLopDanhNghia());
        sinhVien.setChuyenNganh(sinhVienEvent.getChuyenNganh());
        sinhVienRepository.save(sinhVien);
        LOGGER.info(String.format("Received GiangVien: %s", sinhVienEvent.getUsername()));
    }
    @RabbitListener(queues = {"${lecturer.subject.queue}"})
    public void receiveFromGiangVienQueue(GiangVienEvent giangVienEvent) {
        GiangVien giangVien = new GiangVien();
        giangVien.setMagv(giangVienEvent.getUsername());
        giangVien.setHoten(giangVienEvent.getHoTen());
        giangVien.setChucDanh(ChucDanhEnum.fromValue(giangVienEvent.getChucDanh()));
        giangVienRepository.save(giangVien);
        LOGGER.info(String.format("Received student: %s", giangVienEvent.getUsername()));
    }

}

