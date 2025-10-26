package com.ZoomGo.Web_based.Vehicle.Rental.System.Controller;

import com.ZoomGo.Web_based.Vehicle.Rental.System.Dto.AdminDTO;
import com.ZoomGo.Web_based.Vehicle.Rental.System.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    // Show Login Page
    @GetMapping("/login")
    public String loginPage() {
        return "admin_login";
    }

    // Handle Login
    @PostMapping("/login")
    public String login(@ModelAttribute AdminDTO adminDTO, Model model) {
        boolean valid = adminService.validateAdmin(adminDTO.getName(), adminDTO.getPassword());
        if (valid) {
            return "redirect:/admin/dashboard";
        } else {
            model.addAttribute("error", true);
            return "admin_login";
        }
    }

    // Show Dashboard
    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        List<AdminDTO> admins = adminService.getAllAdmins();
        model.addAttribute("admins", admins);
        return "admin_dashboard";
    }

    // Save Admin (for Add button later)
    @PostMapping("/save")
    public String saveAdmin(@ModelAttribute AdminDTO adminDTO) {
        adminService.saveAdmin(adminDTO);
        return "redirect:/admin/dashboard";
    }

    // Delete Admin
    @GetMapping("/delete/{id}")
    public String deleteAdmin(@PathVariable int id) {
        adminService.deleteAdmin(id);
        return "redirect:/admin/dashboard";
    }

    // Show Add Admin Form
    @GetMapping("/add")
    public String addAdminForm(Model model) {
        model.addAttribute("admin", new AdminDTO());
        return "admin_form";
    }

    @GetMapping("/edit/{id}")
    public String editAdminForm(@PathVariable int id, Model model) {
        AdminDTO admin = adminService.getAdminById(id);
        model.addAttribute("admin", admin);
        return "admin_form";
    }






}
