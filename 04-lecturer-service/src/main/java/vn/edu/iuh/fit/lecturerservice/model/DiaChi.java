package vn.edu.iuh.fit.lecturerservice.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "diachi")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DiaChi {
    @Id
    private UUID id;
    private String soNha;
    private String duong;
    private String phuong;
    private String quan;
    private String thanhPho;
    private String quocGia;
    private String zipCode;

    public DiaChi(String soNha, String duong, String phuong, String quan, String thanhPho, String quocGia, String zipCode) {
        this.soNha = soNha;
        this.duong = duong;
        this.phuong = phuong;
        this.quan = quan;
        this.thanhPho = thanhPho;
        this.quocGia = quocGia;
        this.zipCode = zipCode;
    }

    @PrePersist
    private void ensureId(){
        this.id = UUID.randomUUID();
    }
}
