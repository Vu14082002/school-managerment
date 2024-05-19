package vn.edu.iuh.fit.subjectservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import vn.edu.iuh.fit.subjectservice.model.GiangVien;

public interface GiangVienRepository extends JpaRepository<GiangVien, String>, JpaSpecificationExecutor<GiangVien> {
}