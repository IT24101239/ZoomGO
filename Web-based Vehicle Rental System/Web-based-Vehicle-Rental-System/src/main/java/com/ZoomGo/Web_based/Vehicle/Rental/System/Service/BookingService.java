package com.ZoomGo.Web_based.Vehicle.Rental.System.Service;

import com.ZoomGo.Web_based.Vehicle.Rental.System.Model.Booking;
import com.ZoomGo.Web_based.Vehicle.Rental.System.Repo.BookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepo bookingRepo;

    public List<Booking> getAllBookings() {
        return bookingRepo.findAll();
    }

    public Booking getBookingById(int id) {
        return bookingRepo.findById(id).orElseThrow();
    }

    public void saveBooking(Booking booking) {
        bookingRepo.save(booking);
    }

    public void approveBooking(int id) {
        Booking booking = getBookingById(id);
        booking.setStatus("APPROVED");
        bookingRepo.save(booking);
    }

    public void cancelBooking(int id) {
        Booking booking = getBookingById(id);
        booking.setStatus("CANCELLED");
        bookingRepo.save(booking);
    }

    public List<Object[]> getBookingReport() {
        List<Object[]> report = bookingRepo.getBookingReport();
        return report;
    }

}
