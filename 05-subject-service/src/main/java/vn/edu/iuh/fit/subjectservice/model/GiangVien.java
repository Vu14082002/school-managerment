package vn.edu.iuh.fit.subjectservice.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.edu.iuh.fit.subjectservice.converters.ChucDanhEnumConverter;
import vn.edu.iuh.fit.subjectservice.enums.ChucDanhEnum;

@Getter
@Setter
@Entity
@Table(name = "giangvien")
@NoArgsConstructor
@AllArgsConstructor
public class GiangVien {
    @Id
    private String magv;
    private String hoten;
    @Convert(converter = ChucDanhEnumConverter.class)
    private ChucDanhEnum chucDanh;

    public GiangVien(String hoten, ChucDanhEnum chucDanh) {
        this.hoten = hoten;
        this.chucDanh = chucDanh;
    }

}
