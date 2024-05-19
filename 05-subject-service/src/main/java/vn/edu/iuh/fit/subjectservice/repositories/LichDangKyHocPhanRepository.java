package vn.edu.iuh.fit.subjectservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import vn.edu.iuh.fit.subjectservice.keys.LichDangKyHocPhanKey;
import vn.edu.iuh.fit.subjectservice.model.LichDangKyHocPhan;

public interface LichDangKyHocPhanRepository extends JpaRepository<LichDangKyHocPhan, LichDangKyHocPhanKey>, JpaSpecificationExecutor<LichDangKyHocPhan> {
}