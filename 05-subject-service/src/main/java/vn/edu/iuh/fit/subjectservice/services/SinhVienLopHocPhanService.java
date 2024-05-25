package vn.edu.iuh.fit.subjectservice.services;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.subjectservice.dto.SinhVienLopHocPhanRequest;
import vn.edu.iuh.fit.subjectservice.dto.SinhVienLopHocPhanResponse;
import vn.edu.iuh.fit.subjectservice.enums.TrangThaiHocPhanEnum;
import vn.edu.iuh.fit.subjectservice.model.SinhVienLopHocPhan;
import vn.edu.iuh.fit.subjectservice.repositories.SinhVienLopHocPhanRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class SinhVienLopHocPhanService {
    private SinhVienLopHocPhanRepository sinhVienLopHocPhanRepository;

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



}
