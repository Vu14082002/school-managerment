package vn.edu.iuh.fit.subjectservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.edu.iuh.fit.subjectservice.enums.HocKyEnum;
import vn.edu.iuh.fit.subjectservice.keys.SinhVienLopHocPhanKey;
import vn.edu.iuh.fit.subjectservice.model.LopHoc;
import vn.edu.iuh.fit.subjectservice.model.SinhVienLopHocPhan;

import java.util.List;

public interface SinhVienLopHocPhanRepository extends JpaRepository<SinhVienLopHocPhan, SinhVienLopHocPhanKey>, JpaSpecificationExecutor<SinhVienLopHocPhan> {


    @Query("select count(e) from SinhVienLopHocPhan e where " +
            "e.sinhVienLopHocPhanKey.lopHocPhanDangKy.lopHocPhanChoDangKyKey.hocPhan.hocPhanKey.lichDangKyHocPhan.lichDangKyHocPhanKey.hocKy = :hocKy " +
            "and e.sinhVienLopHocPhanKey.lopHocPhanDangKy.lopHocPhanChoDangKyKey.hocPhan.hocPhanKey.lichDangKyHocPhan.lichDangKyHocPhanKey.namhoc=:namHoc " +
            "and e.sinhVienLopHocPhanKey.lopHocPhanDangKy.lopHocPhanChoDangKyKey.hocPhan.hocPhanKey.monHoc.maMonHoc=:maMonHoc " +
            "and  e.sinhVienLopHocPhanKey.lopHocPhanDangKy.lopHocPhanChoDangKyKey.lopHocDuKien=:lopHoc")
    Integer countBySinhVienLopHocPhanKeyLopHoc(LopHoc lopHoc, int namHoc, HocKyEnum hocKy, int maMonHoc);

    @Query(value = "SELECT * FROM sinhvien_lophocphan WHERE " +
            "lop_hoc_phan_dang_ky_hoc_phan_lich_dang_ky_hoc_phan_namhoc = :namhoc AND " +
            "ma_sinh_vien_mssv = :mssv AND " +
            "lop_hoc_phan_dang_ky_hoc_phan_lich_dang_ky_hoc_phan_hoc_ky = :hocKy",
            nativeQuery = true)
    List<SinhVienLopHocPhan> findAllByMssvNamHocHocKy(@Param("mssv") int mssv,
                                                      @Param("namhoc") int namHoc,
                                                      @Param("hocKy") String hocKy);

}