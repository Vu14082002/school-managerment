package vn.edu.iuh.fit.subjectservice.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vn.edu.iuh.fit.subjectservice.keys.ChuyenNganhKey;

public interface ChuyenNganhRepository extends JpaRepository<ChuyenNganh, ChuyenNganhKey> {

    @Query("select cn from ChuyenNganh cn where cn.chuyenNganhKey.maChuyenNganh = :maChuyenNganh")
    ChuyenNganh findChuyenNganhByMaChuyenNganh(String maChuyenNganh);
}