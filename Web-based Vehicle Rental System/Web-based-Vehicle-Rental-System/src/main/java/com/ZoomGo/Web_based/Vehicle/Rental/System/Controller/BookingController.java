package com.ZoomGo.Web_based.Vehicle.Rental.System.Controller;

import com.ZoomGo.Web_based.Vehicle.Rental.System.Model.Booking;
import com.ZoomGo.Web_based.Vehicle.Rental.System.Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    // Show all bookings
    @GetMapping
    public String bookingDashboard(Model model) {
        List<Booking> bookings = bookingService.getAllBookings();
        model.addAttribute("bookings", bookings);
        return "booking_dashboard";
    }

    // Approve booking
    @GetMapping("/approve/{id}")
    public String approveBooking(@PathVariable int id) {
        bookingService.approveBooking(id);
        return "redirect:/admin/bookings";
    }

    // Cancel booking
    @GetMapping("/cancel/{id}")
    public String cancelBooking(@PathVariable int id) {
        bookingService.cancelBooking(id);
        return "redirect:/admin/bookings";
    }
}
