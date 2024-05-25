package vn.edu.iuh.fit.subjectservice.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.subjectservice.dto.ChiTietLopHocPhanRequest;
import vn.edu.iuh.fit.subjectservice.dto.ChiTietLopHocPhanResponseDTO;
import vn.edu.iuh.fit.subjectservice.enums.HocKyEnum;
import vn.edu.iuh.fit.subjectservice.model.ChiTietLopHocPhan;
import vn.edu.iuh.fit.subjectservice.model.LichHoc;
import vn.edu.iuh.fit.subjectservice.model.LopHoc;
import vn.edu.iuh.fit.subjectservice.repositories.ChiTietLopHocPhanRepository;
import vn.edu.iuh.fit.subjectservice.repositories.LichDangKyHocPhanRepository;
import vn.edu.iuh.fit.subjectservice.repositories.LichHocRepository;
import vn.edu.iuh.fit.subjectservice.repositories.LopHocRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ChiTietLopHocPhanService {
    private ChiTietLopHocPhanRepository chiTietLopHocPhanRepository;
    private LopHocRepository lopHocRepository;
    private LichHocRepository lichHocRepository;

    public List<ChiTietLopHocPhanResponseDTO> findAllByLopHocPhanAndNamHoc(ChiTietLopHocPhanRequest chiTietLopHocPhanRequest) {
        System.out.println("Come here");
        String maLopHocPhan = chiTietLopHocPhanRequest.getMaLopHocPhan();
        int namHoc = Integer.parseInt(chiTietLopHocPhanRequest.getMaHocPhan().substring(0, 4));
        System.out.println(chiTietLopHocPhanRequest.getMaHocPhan().substring(4, 7));
        HocKyEnum hocKyEnum = HocKyEnum.fromValue(chiTietLopHocPhanRequest.getMaHocPhan().substring(4, 7));
        int maMonhoc = Integer.parseInt(chiTietLopHocPhanRequest.getMaHocPhan().substring(7));

        List<ChiTietLopHocPhan> chiTietLopHocPhanList = chiTietLopHocPhanRepository.findByMaLopHocPhan(maLopHocPhan, namHoc, hocKyEnum, maMonhoc);

        chiTietLopHocPhanList.forEach(e->{
            List<LichHoc> lichHocLopHoc = lichHocRepository.findByChiTietLopHocPhanId(e.getId());
            lichHocLopHoc.forEach(k->{
                System.out.println(k);
            });
        });

        return null;
    }

}
