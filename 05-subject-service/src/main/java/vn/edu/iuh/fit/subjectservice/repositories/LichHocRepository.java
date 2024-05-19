package vn.edu.iuh.fit.subjectservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import vn.edu.iuh.fit.subjectservice.keys.LichHocKey;
import vn.edu.iuh.fit.subjectservice.model.LichHoc;

public interface LichHocRepository extends JpaRepository<LichHoc, LichHocKey>, JpaSpecificationExecutor<LichHoc> {
}