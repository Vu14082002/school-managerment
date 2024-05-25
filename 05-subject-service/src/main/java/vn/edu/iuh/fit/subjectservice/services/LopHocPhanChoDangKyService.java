package vn.edu.iuh.fit.subjectservice.services;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.subjectservice.dto.LopHocPhanChoDangKyDTO;
import vn.edu.iuh.fit.subjectservice.enums.HocKyEnum;
import vn.edu.iuh.fit.subjectservice.model.ChiTietLopHocPhan;
import vn.edu.iuh.fit.subjectservice.model.HocPhan;
import vn.edu.iuh.fit.subjectservice.model.LopHoc;
import vn.edu.iuh.fit.subjectservice.model.LopHocPhanChoDangKy;
import vn.edu.iuh.fit.subjectservice.repositories.HocPhanRepository;
import vn.edu.iuh.fit.subjectservice.repositories.LopHocPhanChoDangKyRepository;
import vn.edu.iuh.fit.subjectservice.repositories.SinhVienLopHocPhanRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class LopHocPhanChoDangKyService {

    private HocPhanRepository hocPhanRepository;
    private SinhVienLopHocPhanRepository  sinhVienLopHocPhanRepository;

    public List<LopHocPhanChoDangKyDTO> lopPhanChoChoDangKyTheoHocPhan(String maLopHocPhan) {
        int namHoc = Integer.parseInt(maLopHocPhan.substring(0, 4));
        HocKyEnum hocKi = HocKyEnum.fromValue(maLopHocPhan.substring(4, 7));
        int maMonHoc = Integer.parseInt(maLopHocPhan.substring(7, maLopHocPhan.length()));
        System.out.println("Nam hoc: "+namHoc);
        System.out.println("Hoc ki: "+hocKi);
        System.out.println("Ma mon hoc: "+maMonHoc);
        Optional<HocPhan> hocPhanByHocPhanKey = hocPhanRepository.findHocPhanByHocPhanKey(namHoc, hocKi, maMonHoc);
        if(!hocPhanByHocPhanKey.isPresent()){
            throw new RuntimeException("Học phần không tồn tại");
        }
        HocPhan hocPhan = hocPhanByHocPhanKey.get();
        Set<LopHocPhanChoDangKy> danhSachLopHocPhanChoDangKy = hocPhan.getDanhSachLopHocPhanChoDangKy();
        List<LopHocPhanChoDangKyDTO> lopHocPhanChoDangKyDTOS = new ArrayList<>();
        danhSachLopHocPhanChoDangKy.forEach(e->{
            LopHoc lopHoc = e.getLopHocPhanChoDangKyKey().getLopHocDuKien();
            Integer soLuongSinhVienHienTai = sinhVienLopHocPhanRepository.countBySinhVienLopHocPhanKeyLopHoc(lopHoc,namHoc,hocKi,maMonHoc);
//            set
            LopHocPhanChoDangKyDTO lopHocPhanChoDangKyDTO = new LopHocPhanChoDangKyDTO();
            lopHocPhanChoDangKyDTO.setMaLopHocPhan(e.getLopHocPhanChoDangKyKey().getLopHocDuKien().getMaLopHocPhan());
            lopHocPhanChoDangKyDTO.setTenMonHoc(e.getLopHocPhanChoDangKyKey().getHocPhan().getHocPhanKey().getMonHoc().getTenMonHoc());
            lopHocPhanChoDangKyDTO.setLopHocDuKien(e.getLopHocPhanChoDangKyKey().getLopHocDuKien().getTenLopHocPhan());
            lopHocPhanChoDangKyDTO.setSiSoToiDa(e.getLopHocPhanChoDangKyKey().getHocPhan().getSoTinChiLyThuyet()+e.getLopHocPhanChoDangKyKey().getHocPhan().getSoTinChiThucHanh());
            lopHocPhanChoDangKyDTO.setSoLuongSinhVienDKHienTai(soLuongSinhVienHienTai);
            lopHocPhanChoDangKyDTO.setMaMonHoc(e.getLopHocPhanChoDangKyKey().getHocPhan().getHocPhanKey().getMonHoc().getMaMonHoc());
            lopHocPhanChoDangKyDTOS.add(lopHocPhanChoDangKyDTO);
        });
        return lopHocPhanChoDangKyDTOS;
    }

}
