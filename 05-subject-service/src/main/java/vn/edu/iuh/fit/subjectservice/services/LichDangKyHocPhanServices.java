package vn.edu.iuh.fit.subjectservice.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.subjectservice.dto.LichDangKyHocPhanDTO;
import vn.edu.iuh.fit.subjectservice.model.LichDangKyHocPhan;
import vn.edu.iuh.fit.subjectservice.repositories.LichDangKyHocPhanRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class LichDangKyHocPhanServices {
    private LichDangKyHocPhanRepository lichDangKyHocPhanRepository;

    public List<LichDangKyHocPhanDTO> getAllLichDangKyHocPhan() {
        List<LichDangKyHocPhan> all = lichDangKyHocPhanRepository.findAll();
        List<LichDangKyHocPhanDTO> lichDangKyHocPhanDTOS = new ArrayList<>();
        all.forEach(e->{
            LichDangKyHocPhanDTO lichDangKyHocPhanDTO = new LichDangKyHocPhanDTO();
            lichDangKyHocPhanDTO.setHk(e.getLichDangKyHocPhanKey().getHocKy().name());
            lichDangKyHocPhanDTO.setNamHoc(e.getLichDangKyHocPhanKey().getNamhoc()+"");
            lichDangKyHocPhanDTOS.add(lichDangKyHocPhanDTO);
        });
        return lichDangKyHocPhanDTOS;
    }

}
