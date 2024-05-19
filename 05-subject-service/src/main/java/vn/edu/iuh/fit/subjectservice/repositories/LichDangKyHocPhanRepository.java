package vn.edu.iuh.fit.subjectservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import vn.edu.iuh.fit.subjectservice.keys.LichDangKyHocPhanKey;
import vn.edu.iuh.fit.subjectservice.model.LichDangKyHocPhan;

import java.util.List;

public interface LichDangKyHocPhanRepository extends JpaRepository<LichDangKyHocPhan, LichDangKyHocPhanKey>, JpaSpecificationExecutor<LichDangKyHocPhan> {

    @Query("SELECT l FROM LichDangKyHocPhan l order by l.lichDangKyHocPhanKey.namhoc asc , l.lichDangKyHocPhanKey.hocKy asc")
    List<LichDangKyHocPhan> findAll();

}