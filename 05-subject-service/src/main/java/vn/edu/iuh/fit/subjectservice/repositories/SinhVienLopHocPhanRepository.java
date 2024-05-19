package vn.edu.iuh.fit.subjectservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.edu.iuh.fit.subjectservice.enums.HocKyEnum;
import vn.edu.iuh.fit.subjectservice.keys.SinhVienLopHocPhanKey;
import vn.edu.iuh.fit.subjectservice.model.LopHoc;
import vn.edu.iuh.fit.subjectservice.model.SinhVienLopHocPhan;

public interface SinhVienLopHocPhanRepository extends JpaRepository<SinhVienLopHocPhan, SinhVienLopHocPhanKey>, JpaSpecificationExecutor<SinhVienLopHocPhan> {


    @Query("select count(e) from SinhVienLopHocPhan e where " +
            "e.sinhVienLopHocPhanKey.lopHocPhanDangKy.lopHocPhanChoDangKyKey.hocPhan.hocPhanKey.lichDangKyHocPhan.lichDangKyHocPhanKey.hocKy = :hocKy " +
            "and e.sinhVienLopHocPhanKey.lopHocPhanDangKy.lopHocPhanChoDangKyKey.hocPhan.hocPhanKey.lichDangKyHocPhan.lichDangKyHocPhanKey.namhoc=:namHoc " +
            "and e.sinhVienLopHocPhanKey.lopHocPhanDangKy.lopHocPhanChoDangKyKey.hocPhan.hocPhanKey.monHoc.maMonHoc=:maMonHoc " +
            "and  e.sinhVienLopHocPhanKey.lopHocPhanDangKy.lopHocPhanChoDangKyKey.lopHocDuKien=:lopHoc")
    Integer countBySinhVienLopHocPhanKeyLopHoc(LopHoc lopHoc, int namHoc, HocKyEnum hocKy, int maMonHoc);
}