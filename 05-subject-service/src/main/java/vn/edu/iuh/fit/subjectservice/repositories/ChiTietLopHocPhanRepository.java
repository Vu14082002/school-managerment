package vn.edu.iuh.fit.subjectservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import vn.edu.iuh.fit.subjectservice.enums.HocKyEnum;
import vn.edu.iuh.fit.subjectservice.model.ChiTietLopHocPhan;

import java.util.List;
import java.util.Optional;

public interface ChiTietLopHocPhanRepository extends JpaRepository<ChiTietLopHocPhan, Long>, JpaSpecificationExecutor<ChiTietLopHocPhan> {


    @Query(value = "SELECT c FROM ChiTietLopHocPhan c WHERE c.lopHocPhanDuKien.lopHocPhanChoDangKyKey.lopHocDuKien.maLopHocPhan = ?1 " +
            "AND  c.lopHocPhanDuKien.lopHocPhanChoDangKyKey.hocPhan.hocPhanKey.lichDangKyHocPhan.lichDangKyHocPhanKey.namhoc = ?2 AND " +
            "c.lopHocPhanDuKien.lopHocPhanChoDangKyKey.hocPhan.hocPhanKey.lichDangKyHocPhan.lichDangKyHocPhanKey.hocKy = ?3 " +
            "AND c.lopHocPhanDuKien.lopHocPhanChoDangKyKey.hocPhan.hocPhanKey.monHoc.maMonHoc = ?4")
    List<ChiTietLopHocPhan> findByMaLopHocPhan(String maLopHocPhan, int namHoc, HocKyEnum hocKy, int maMonHoc);
}