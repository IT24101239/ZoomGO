package com.ZoomGo.Web_based.Vehicle.Rental.System.Config;

import com.ZoomGo.Web_based.Vehicle.Rental.System.Model.Admin;
import com.ZoomGo.Web_based.Vehicle.Rental.System.Repo.AdminRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initAdmin(AdminRepo adminRepo) {
        return args -> {
            // Insert default admin if no one exists
            if (adminRepo.count() == 0) {
                Admin defaultAdmin = new Admin();
                defaultAdmin.setName("admin");
                defaultAdmin.setPassword("admin123");
                adminRepo.save(defaultAdmin);
                System.out.println("✅ Default admin created: username=admin, password=admin123");
            }
        };
    }
}
