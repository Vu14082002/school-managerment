package vn.edu.iuh.fit.subjectservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import vn.edu.iuh.fit.subjectservice.keys.HocPhanKey;
import vn.edu.iuh.fit.subjectservice.model.HocPhan;

public interface HocPhanRepository extends JpaRepository<HocPhan, HocPhanKey>, JpaSpecificationExecutor<HocPhan> {
}