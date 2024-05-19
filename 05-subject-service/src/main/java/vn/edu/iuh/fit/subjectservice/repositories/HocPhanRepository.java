package vn.edu.iuh.fit.subjectservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.edu.iuh.fit.subjectservice.enums.HocKyEnum;
import vn.edu.iuh.fit.subjectservice.keys.HocPhanKey;
import vn.edu.iuh.fit.subjectservice.model.ChuyenNganh;
import vn.edu.iuh.fit.subjectservice.model.HocPhan;
import vn.edu.iuh.fit.subjectservice.model.SinhVien;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface HocPhanRepository extends JpaRepository<HocPhan, HocPhanKey>, JpaSpecificationExecutor<HocPhan> {

    @Query("select distinct hp from HocPhan hp where hp.hocPhanKey.lichDangKyHocPhan.lichDangKyHocPhanKey.namhoc = :namhoc " +
            "and hp.hocPhanKey.lichDangKyHocPhan.lichDangKyHocPhanKey.hocKy = :hocKy ")
    List<HocPhan> danhSachHocPhanTheoHocKi(int namhoc, HocKyEnum hocKy);


    @Query("select distinct hp from HocPhan hp where hp.hocPhanKey.lichDangKyHocPhan.lichDangKyHocPhanKey.namhoc = :namhoc " +
            "and hp.hocPhanKey.lichDangKyHocPhan.lichDangKyHocPhanKey.hocKy = :hocKy " +
            "and :chuyenNganh member of hp.hocPhanKey.monHoc.chuyenNganh")
    List<HocPhan> danhSachHocPhanTheoHocKiTheoChuyenNganh(
            @Param("namhoc") int namhoc,
            @Param("hocKy") HocKyEnum hocKy,
            @Param("chuyenNganh") ChuyenNganh chuyenNganh);

    @Query("select distinct hp from HocPhan hp where hp.hocPhanKey.lichDangKyHocPhan.lichDangKyHocPhanKey.namhoc = :namhoc " +
            "and hp.hocPhanKey.lichDangKyHocPhan.lichDangKyHocPhanKey.hocKy = :hocKy " +
            "and :chuyenNganh member of hp.hocPhanKey.monHoc.chuyenNganh " +
            "and :mssv not in (select e.sinhVienLopHocPhanKey.maSinhVien from SinhVienLopHocPhan e " +
            "where e.sinhVienLopHocPhanKey.lopHocPhanDangKy member of hp.danhSachLopHocPhanChoDangKy)")
    List<HocPhan> danhSachHocPhanTheoHocKiTheoChuyenNganhVaSinhVien(
            @Param("namhoc") int namhoc,
            @Param("hocKy") HocKyEnum hocKy,
            @Param("chuyenNganh") ChuyenNganh chuyenNganh,
            @Param("mssv") SinhVien mssv
    );

    @Query("select hp from HocPhan hp where hp.hocPhanKey.lichDangKyHocPhan.lichDangKyHocPhanKey.namhoc = :namhoc " +
            "and hp.hocPhanKey.lichDangKyHocPhan.lichDangKyHocPhanKey.hocKy = :hocKy " +
            "and hp.hocPhanKey.monHoc.maMonHoc = :maMonHoc")
    Optional<HocPhan> findHocPhanByHocPhanKey(int namhoc, HocKyEnum hocKy, int maMonHoc);

}
