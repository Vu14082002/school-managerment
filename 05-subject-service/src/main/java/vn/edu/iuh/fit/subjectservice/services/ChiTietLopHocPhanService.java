package vn.edu.iuh.fit.subjectservice.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.subjectservice.dto.ChiTietLopHocPhanRequest;
import vn.edu.iuh.fit.subjectservice.dto.ChiTietLopHocPhanResponseDTO;
import vn.edu.iuh.fit.subjectservice.enums.CosoTruongHocEnum;
import vn.edu.iuh.fit.subjectservice.enums.HocKyEnum;
import vn.edu.iuh.fit.subjectservice.model.ChiTietLopHocPhan;
import vn.edu.iuh.fit.subjectservice.model.LichHoc;
import vn.edu.iuh.fit.subjectservice.repositories.ChiTietLopHocPhanRepository;
import vn.edu.iuh.fit.subjectservice.repositories.LichHocRepository;
import vn.edu.iuh.fit.subjectservice.repositories.LopHocRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ChiTietLopHocPhanService {
    private ChiTietLopHocPhanRepository chiTietLopHocPhanRepository;
    private LopHocRepository lopHocRepository;
    private LichHocRepository lichHocRepository;

    public List<ChiTietLopHocPhanResponseDTO> findAllByLopHocPhanAndNamHoc(ChiTietLopHocPhanRequest chiTietLopHocPhanRequest) {
        String maLopHocPhan = chiTietLopHocPhanRequest.getMaLopHocPhan();
        int namHoc = Integer.parseInt(chiTietLopHocPhanRequest.getMaHocPhan().substring(0, 4));
        System.out.println(chiTietLopHocPhanRequest.getMaHocPhan().substring(4, 7));
        HocKyEnum hocKyEnum = HocKyEnum.fromValue(chiTietLopHocPhanRequest.getMaHocPhan().substring(4, 7));
        int maMonhoc = Integer.parseInt(chiTietLopHocPhanRequest.getMaHocPhan().substring(7));

        List<ChiTietLopHocPhan> chiTietLopHocPhanList = chiTietLopHocPhanRepository.findByMaLopHocPhan(maLopHocPhan, namHoc, hocKyEnum, maMonhoc);

        System.out.println("chiTietLopHocPhanList");
        chiTietLopHocPhanList.forEach(e -> {
            System.out.println(e);
        });


        List<ChiTietLopHocPhanResponseDTO> chiTietLopHocPhanResponseDTOList = new ArrayList<>();

        chiTietLopHocPhanList.forEach(e -> {
            ChiTietLopHocPhanResponseDTO chiTietLopHocPhanResponseDTO = new ChiTietLopHocPhanResponseDTO();
            chiTietLopHocPhanResponseDTO.setLichHoc("from "+e.getThoiGianBatDauMonHoc().toString() + " to " + e.getThoiGianKetThucMonHoc().toString());
            chiTietLopHocPhanResponseDTO.setNhomThucHanh(e.getNhomThucHanh());
            chiTietLopHocPhanResponseDTO.setPhongHoc(e.getLichHocThucHanh().get(0).getPhongHoc().getMaPhongHoc());
            chiTietLopHocPhanResponseDTO.setCs(CosoTruongHocEnum.toValue(e.getLichHocThucHanh().get(0).getCoso()));
            chiTietLopHocPhanResponseDTO.setGiangVien(e.getLichHocThucHanh().get(0).getGiangVien().getHoten());
            chiTietLopHocPhanResponseDTOList.add(chiTietLopHocPhanResponseDTO);
        });
        return chiTietLopHocPhanResponseDTOList;
    }

}
