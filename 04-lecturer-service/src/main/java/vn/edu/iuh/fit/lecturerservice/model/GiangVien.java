package vn.edu.iuh.fit.lecturerservice.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import vn.edu.iuh.fit.lecturerservice.convert.ChucDanhEnumConverter;
import vn.edu.iuh.fit.lecturerservice.enums.ChucDanhEnum;
import vn.edu.iuh.fit.lecturerservice.enums.LoaiCongViec;
import vn.edu.iuh.fit.lecturerservice.enums.TrangThai;

import java.util.*;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "giangvien")
@Getter
@Setter
public class GiangVien {
    @Id
    @GeneratedValue(generator = "custom-id")
    @GenericGenerator(name = "custom-id", strategy = "vn.edu.iuh.fit.lecturerservice.custom.CustomIDGenerator")
    private String msgv;
    private String hoTen;
    private Date ngaySinh;
    private Boolean gioiTinh;
    private String cccd;
    private String dienThoai;
    private String email;
    @OneToOne(cascade = CascadeType.ALL)
    private DiaChi diaChi;
    @ElementCollection
    @CollectionTable(name = "GiangVien_Lop", joinColumns = @JoinColumn(name = "msgv"))
    @Column(name = "lopChuNhiem")
    private Set<String> lopChuNhiem= new HashSet<>();
    @Enumerated(EnumType.STRING)
    private TrangThai trangThai;
    @Enumerated(EnumType.STRING)
    private LoaiCongViec loaiCongViec;
    @Convert(converter = ChucDanhEnumConverter.class)
    private ChucDanhEnum chucDanh;
//    @Column(name = "lichHoc")
//    private String lichDay;
    @ElementCollection
    @CollectionTable(name = "GiangVien_ChuyenNganh", joinColumns = @JoinColumn(name = "msgv"))
    @Column(name = "chuyenNganh")
    private Set<String> chuyenNganh = new HashSet<>();
}
