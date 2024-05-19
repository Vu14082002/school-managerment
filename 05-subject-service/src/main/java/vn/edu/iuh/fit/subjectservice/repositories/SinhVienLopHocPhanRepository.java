package vn.edu.iuh.fit.subjectservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import vn.edu.iuh.fit.subjectservice.keys.SinhVienLopHocPhanKey;
import vn.edu.iuh.fit.subjectservice.model.SinhVienLopHocPhan;

public interface SinhVienLopHocPhanRepository extends JpaRepository<SinhVienLopHocPhan, SinhVienLopHocPhanKey>, JpaSpecificationExecutor<SinhVienLopHocPhan> {
}