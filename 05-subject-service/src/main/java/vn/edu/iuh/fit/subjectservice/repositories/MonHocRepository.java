package vn.edu.iuh.fit.subjectservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import vn.edu.iuh.fit.subjectservice.model.MonHoc;

public interface MonHocRepository extends JpaRepository<MonHoc, Integer>, JpaSpecificationExecutor<MonHoc> {
}