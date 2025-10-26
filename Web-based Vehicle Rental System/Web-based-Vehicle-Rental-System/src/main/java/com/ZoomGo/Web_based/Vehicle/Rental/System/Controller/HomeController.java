package com.ZoomGo.Web_based.Vehicle.Rental.System.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/zoomgo")
    public String home() {
        return "home"; // Thymeleaf will render home.html
    }
}

