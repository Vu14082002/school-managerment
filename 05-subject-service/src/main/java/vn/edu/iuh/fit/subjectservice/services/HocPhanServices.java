package vn.edu.iuh.fit.subjectservice.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.subjectservice.dto.HocPhanDTO;
import vn.edu.iuh.fit.subjectservice.enums.HocKyEnum;
import vn.edu.iuh.fit.subjectservice.enums.LoaiMonHocEnum;
import vn.edu.iuh.fit.subjectservice.model.ChuyenNganh;
import vn.edu.iuh.fit.subjectservice.model.ChuyenNganhRepository;
import vn.edu.iuh.fit.subjectservice.model.HocPhan;
import vn.edu.iuh.fit.subjectservice.model.SinhVien;
import vn.edu.iuh.fit.subjectservice.repositories.HocPhanRepository;
import vn.edu.iuh.fit.subjectservice.repositories.SinhVienRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class HocPhanServices {
    private HocPhanRepository hocPhanRepository;
    private ChuyenNganhRepository chuyenNganhRepository;
    private SinhVienRepository sinhVienRepository;

    public List<HocPhanDTO> danhSachHoocPhanTheoKyVaChuyeNganh(int namHoc, String hk, String chuyenNganhHoc, int mssv) throws Exception {

        ChuyenNganh chuyenNganh = chuyenNganhRepository.findChuyenNganhByMaChuyenNganh(chuyenNganhHoc);
        Optional<SinhVien> byId = sinhVienRepository.findById(mssv);
        if(!byId.isPresent()){throw new Exception("Sinh viên không tồn tại");
        }
        SinhVien sinhVien = byId.get();
//        List<HocPhan> all = hocPhanRepository.danhSachHocPhanTheoHocKi(namHoc, HocKyEnum.fromValue(hk));
//        List<HocPhan> all = hocPhanRepository.danhSachHocPhanTheoHocKiTheoChuyenNganh(namHoc, HocKyEnum.fromValue(hk),chuyenNganh);
        List<HocPhan> all = hocPhanRepository.danhSachHocPhanTheoHocKiTheoChuyenNganhVaSinhVien(namHoc, HocKyEnum.fromValue(hk), chuyenNganh, sinhVien);
        List<HocPhanDTO> hocPhanDTOS = new ArrayList<>();
        System.out.println(all.size());
        all.forEach(e -> {
            String maHocPhan = "" + namHoc+"-"+hk +"-"+ e.getHocPhanKey().getMonHoc().getMaMonHoc();
            HocPhanDTO hocPhanDTO = new HocPhanDTO();
            hocPhanDTO.setTenMonHoc(e.getHocPhanKey().getMonHoc().getTenMonHoc());
            hocPhanDTO.setMaHocPhan(maHocPhan);
            hocPhanDTO.setSoTinChi(e.getSoTinChiLyThuyet() + e.getSoTinChiThucHanh());
            String loaiMonHoc = LoaiMonHocEnum.toValue(e.getHocPhanKey().getMonHoc().getLoaiMonHoc());
            e.getHocPhanKey().getMonHoc().getMonHocTruoc().forEach(m -> {
                hocPhanDTO.getDanhSachMonHocTruoc().add(m.getMaMonHoc());
            });
            hocPhanDTO.setLoaiMonHoc(loaiMonHoc);
            hocPhanDTOS.add(hocPhanDTO);
        });
        return hocPhanDTOS;
    }

}
