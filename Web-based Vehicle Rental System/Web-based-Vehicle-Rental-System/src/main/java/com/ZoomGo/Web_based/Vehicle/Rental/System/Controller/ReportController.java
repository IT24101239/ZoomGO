package com.ZoomGo.Web_based.Vehicle.Rental.System.Controller;

import com.ZoomGo.Web_based.Vehicle.Rental.System.Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/reports")
public class ReportController {

    @Autowired
    private BookingService bookingService;

    @GetMapping
    public String reportPage(Model model) {
        var report = bookingService.getBookingReport();
        model.addAttribute("report", report);
        return "booking_report";
    }
}
