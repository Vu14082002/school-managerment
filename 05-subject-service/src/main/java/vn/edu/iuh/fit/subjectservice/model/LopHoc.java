package vn.edu.iuh.fit.subjectservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "lophoc")
public class LopHoc {
    @Id
    private String maLopHocPhan;
    private String tenLopHocPhan;
    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)

    @CollectionTable(name = "lophocphan_sinhvien", joinColumns = @JoinColumn(name = "lopHocPhan"))
    @Column(name = "sinhvien", nullable = false)
    private Set<String> danhSachSinhVien = new HashSet<>();

    @OneToMany(mappedBy = "lopHocPhanChoDangKyKey.lopHocDuKien", cascade = {CascadeType.PERSIST,CascadeType.MERGE}, fetch = FetchType.EAGER)
    private Set<LopHocPhanChoDangKy> danhSachLopHocPhanChoDangKy = new HashSet<>();
    public LopHoc(String maLopHocPhan, String tenLopHocPhan) {
        this.maLopHocPhan = maLopHocPhan;
        this.tenLopHocPhan = tenLopHocPhan;
    }
}
