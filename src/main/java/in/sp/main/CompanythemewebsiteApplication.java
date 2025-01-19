package in.sp.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication

@EntityScan(basePackages = {"in.sp.main.entity", "in.sp.main.model"})
public class CompanythemewebsiteApplication {
    public static void main(String[] args) {
        SpringApplication.run(CompanythemewebsiteApplication.class, args);
    }
}
