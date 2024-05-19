package vn.edu.iuh.fit.subjectservice.services;

import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.subjectservice.dto.ChiTietLopHocPhanResponseDTO;
import vn.edu.iuh.fit.subjectservice.model.LopHoc;
import vn.edu.iuh.fit.subjectservice.repositories.ChiTietLopHocPhanRepository;
import vn.edu.iuh.fit.subjectservice.repositories.LopHocRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ChiTietLopHocPhanService {
    private ChiTietLopHocPhanRepository chiTietLopHocPhanRepository;
    private LopHocRepository lopHocRepository;

    public List<ChiTietLopHocPhanResponseDTO> findAllByLopHocPhan(int maLopHocPhan) {

//        Optional<LopHoc> byId = chiTietLopHocPhanRepository.findById(maLopHocPhan);
//        if (!byId.isPresent()) {
//            throw new RuntimeException("Lop hoc phan khong ton tai");
//        }
//        LopHoc lopHoc = byId.get();
        return null;
    }
}
