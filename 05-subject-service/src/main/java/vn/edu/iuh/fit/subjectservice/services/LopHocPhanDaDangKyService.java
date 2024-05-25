package vn.edu.iuh.fit.subjectservice.services;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.subjectservice.dto.SinhVienLopHocPhanRequest;
import vn.edu.iuh.fit.subjectservice.dto.SinhVienLopHocPhanResponse;
import vn.edu.iuh.fit.subjectservice.enums.HocKyEnum;
import vn.edu.iuh.fit.subjectservice.model.SinhVien;
import vn.edu.iuh.fit.subjectservice.model.SinhVienLopHocPhan;
import vn.edu.iuh.fit.subjectservice.repositories.SinhVienLopHocPhanRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class LopHocPhanDaDangKyService {
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
//            sinhVienLopHocPhanResponse.setHocPhi(e.getSinhVienLopHocPhanKey().getLopHocPhanDangKy().);
        });


        return null;
    }



}
