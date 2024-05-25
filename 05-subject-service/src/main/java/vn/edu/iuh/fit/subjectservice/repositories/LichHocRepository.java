package vn.edu.iuh.fit.subjectservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import vn.edu.iuh.fit.subjectservice.keys.LichHocKey;
import vn.edu.iuh.fit.subjectservice.model.LichHoc;

import java.util.List;

public interface LichHocRepository extends JpaRepository<LichHoc, LichHocKey>, JpaSpecificationExecutor<LichHoc> {

    @Query("SELECT lh FROM LichHoc lh WHERE lh.chiTietLopHocPhan.id = ?1")
    List<LichHoc> findByChiTietLopHocPhanId(Long maLopHocPhan);
}