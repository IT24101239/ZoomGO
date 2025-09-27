package com.ZoomGo.Web_based.Vehicle.Rental.System.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @ManyToOne
    private User user;

    @ManyToOne
    private Vehicle vehicle;

    private LocalDate startDate;
    private LocalDate endDate;

    private String status; // PENDING, APPROVED, CANCELLED
    private double totalAmount;
}
