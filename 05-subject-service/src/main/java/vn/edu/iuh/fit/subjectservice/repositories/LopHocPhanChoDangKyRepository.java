package vn.edu.iuh.fit.subjectservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import vn.edu.iuh.fit.subjectservice.keys.LopHocPhanChoDangKyKey;
import vn.edu.iuh.fit.subjectservice.model.LopHocPhanChoDangKy;

public interface LopHocPhanChoDangKyRepository extends JpaRepository<LopHocPhanChoDangKy, LopHocPhanChoDangKyKey>, JpaSpecificationExecutor<LopHocPhanChoDangKy> {
}