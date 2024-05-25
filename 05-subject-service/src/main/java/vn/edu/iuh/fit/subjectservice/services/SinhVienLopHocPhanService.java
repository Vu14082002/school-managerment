package vn.edu.iuh.fit.subjectservice.services;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.subjectservice.dto.DangKyHocPhanRequestDTO;
import vn.edu.iuh.fit.subjectservice.dto.SinhVienLopHocPhanRequest;
import vn.edu.iuh.fit.subjectservice.dto.SinhVienLopHocPhanResponse;
import vn.edu.iuh.fit.subjectservice.enums.TrangThaiDangKyEnum;
import vn.edu.iuh.fit.subjectservice.enums.TrangThaiHocPhanEnum;
import vn.edu.iuh.fit.subjectservice.keys.SinhVienLopHocPhanKey;
import vn.edu.iuh.fit.subjectservice.model.LopHoc;
import vn.edu.iuh.fit.subjectservice.model.SinhVienLopHocPhan;
import vn.edu.iuh.fit.subjectservice.repositories.LopHocRepository;
import vn.edu.iuh.fit.subjectservice.repositories.SinhVienLopHocPhanRepository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SinhVienLopHocPhanService {
    private SinhVienLopHocPhanRepository sinhVienLopHocPhanRepository;
    private LopHocRepository lopHocRepository;

    public List<SinhVienLopHocPhanResponse> getLopHocPhanDaDangKy(SinhVienLopHocPhanRequest sinhVienLopHocPhanRequest) {
        int namHoc = sinhVienLopHocPhanRequest.getNamHoc();
        String hocKy = sinhVienLopHocPhanRequest.getHocKy();
        int mssv = sinhVienLopHocPhanRequest.getMssv();
        List<SinhVienLopHocPhan> allByMssvNamHocHocKy = sinhVienLopHocPhanRepository.findAllByMssvNamHocHocKy(mssv, namHoc, hocKy);

        List<SinhVienLopHocPhanResponse> sinhVienLopHocPhanResponses = new ArrayList<>();

        SinhVienLopHocPhanResponse sinhVienLopHocPhanResponse = new SinhVienLopHocPhanResponse();
        allByMssvNamHocHocKy.forEach(e->{
            sinhVienLopHocPhanResponse.setMaLopHocPhan(e.getSinhVienLopHocPhanKey().getLopHocPhanDangKy().getLopHocPhanChoDangKyKey().getLopHocDuKien().getMaLopHocPhan());
            sinhVienLopHocPhanResponse.setTenMonHoc(e.getSinhVienLopHocPhanKey().getLopHocPhanDangKy().getLopHocPhanChoDangKyKey().getHocPhan().getHocPhanKey().getMonHoc().getTenMonHoc());
            sinhVienLopHocPhanResponse.setLopHocPhanDuKien(e.getSinhVienLopHocPhanKey().getLopHocPhanDangKy().getLopHocPhanChoDangKyKey().getLopHocDuKien().getTenLopHocPhan());
            sinhVienLopHocPhanResponse.setSoTC(e.getSinhVienLopHocPhanKey().getLopHocPhanDangKy().getLopHocPhanChoDangKyKey().getHocPhan().getSoTinChiLyThuyet()+e.getSinhVienLopHocPhanKey().getLopHocPhanDangKy().getLopHocPhanChoDangKyKey().getHocPhan().getSoTinChiThucHanh());
            double hocPhi = e.getSinhVienLopHocPhanKey().getLopHocPhanDangKy().getLopHocPhanChoDangKyKey().getHocPhan().getHocPhiLyThuyet() * e.getSinhVienLopHocPhanKey().getLopHocPhanDangKy().getLopHocPhanChoDangKyKey().getHocPhan().getSoTinChiLyThuyet() +
                    e.getSinhVienLopHocPhanKey().getLopHocPhanDangKy().getLopHocPhanChoDangKyKey().getHocPhan().getHocPhiThucHanh() * e.getSinhVienLopHocPhanKey().getLopHocPhanDangKy().getLopHocPhanChoDangKyKey().getHocPhan().getSoTinChiThucHanh();
            sinhVienLopHocPhanResponse.setHocPhi(hocPhi);
            sinhVienLopHocPhanResponse.setTrangThaiDk("Đăng ký mới");
            sinhVienLopHocPhanResponse.setNgayDK(e.getNgayDangKy().toString());
            sinhVienLopHocPhanResponse.setTrangThaiHocPhan(TrangThaiHocPhanEnum.toValue(e.getSinhVienLopHocPhanKey().getLopHocPhanDangKy().getTrangThaiHocPhan()));
            sinhVienLopHocPhanResponses.add(sinhVienLopHocPhanResponse);
        });
        return sinhVienLopHocPhanResponses;
    }

    public Boolean dangKyHocPhanMoi(DangKyHocPhanRequestDTO dangKyHocPhanRequestDTO) {
       try{
           int namHoc = Integer.parseInt(dangKyHocPhanRequestDTO.getMaHocPhan().substring(0, 4));
           String hocKy = dangKyHocPhanRequestDTO.getMaHocPhan().substring(4, 7);
           int maMonHoc = Integer.parseInt(dangKyHocPhanRequestDTO.getMaHocPhan().substring(7));
           String maLopHocPhan = dangKyHocPhanRequestDTO.getMaLopHocPhan();
           int mssv = dangKyHocPhanRequestDTO.getMssv();
           String trangThaiDangKy = TrangThaiDangKyEnum.toValue(TrangThaiDangKyEnum.DK_MOI);
           sinhVienLopHocPhanRepository.sinHVienDangKyHocPhanMoi(trangThaiDangKy, mssv, hocKy, namHoc, maMonHoc, maLopHocPhan);
           return true;
       }catch (Exception e){
           e.printStackTrace();
           throw new RuntimeException("Đăng ký học phần mới thất bại");
       }
    }
}
