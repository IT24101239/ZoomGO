package com.ZoomGo.Web_based.Vehicle.Rental.System.Service;

import com.ZoomGo.Web_based.Vehicle.Rental.System.Dto.AdminDTO;
import com.ZoomGo.Web_based.Vehicle.Rental.System.Model.Admin;
import com.ZoomGo.Web_based.Vehicle.Rental.System.Repo.AdminRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class AdminService {

    @Autowired
    private AdminRepo adminRepo;

    @Autowired
    private ModelMapper modelMapper;

    // Create or Update Admin
    public AdminDTO saveAdmin(AdminDTO adminDTO) {
        Admin admin = modelMapper.map(adminDTO, Admin.class);
        Admin saved = adminRepo.save(admin);
        return modelMapper.map(saved, AdminDTO.class);
    }

    // Get All Admins
    public List<AdminDTO> getAllAdmins() {
        return adminRepo.findAll()
                .stream()
                .map(admin -> modelMapper.map(admin, AdminDTO.class))
                .collect(Collectors.toList());
    }

    // Get Admin by ID
    public AdminDTO getAdminById(int id) {
        Optional<Admin> admin = adminRepo.findById(id);
        return admin.map(value -> modelMapper.map(value, AdminDTO.class)).orElse(null);
    }

    // Delete Admin
    public boolean deleteAdmin(int id) {
        if (adminRepo.existsById(id)) {
            adminRepo.deleteById(id);
            return true;
        }
        return false;
    }

    // Login check
    public boolean validateAdmin(String username, String password) {
        Admin admin = adminRepo.findByName(username);
        return admin != null && admin.getPassword().equals(password);
    }
}
