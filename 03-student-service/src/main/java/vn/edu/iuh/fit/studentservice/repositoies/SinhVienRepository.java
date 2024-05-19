package vn.edu.iuh.fit.studentservice.repositoies;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.studentservice.model.SinhVien;

public interface SinhVienRepository extends JpaRepository<SinhVien, Integer> {
}