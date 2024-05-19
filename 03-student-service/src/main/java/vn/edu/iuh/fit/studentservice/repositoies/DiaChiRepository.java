package vn.edu.iuh.fit.studentservice.repositoies;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.studentservice.model.DiaChi;

import java.util.UUID;

public interface DiaChiRepository extends JpaRepository<DiaChi, UUID> {
}