package com.ZoomGo.Web_based.Vehicle.Rental.System.Repo;

import com.ZoomGo.Web_based.Vehicle.Rental.System.Model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepo extends JpaRepository<Booking, Integer> {

    @Query("SELECT b.status, COUNT(b), SUM(b.totalAmount) FROM Booking b GROUP BY b.status")
    List<Object[]> getBookingReport();

}
