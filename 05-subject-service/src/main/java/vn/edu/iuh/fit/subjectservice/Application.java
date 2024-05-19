package vn.edu.iuh.fit.subjectservice;

import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import vn.edu.iuh.fit.subjectservice.repositories.GiangVienRepository;
import vn.edu.iuh.fit.subjectservice.repositories.SinhVienRepository;

@SpringBootApplication
@AllArgsConstructor
public class Application {

    private GiangVienRepository giangVienRepository;
    private SinhVienRepository sinhVienRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner init( ) {
        return args -> {
        };
    }

}
