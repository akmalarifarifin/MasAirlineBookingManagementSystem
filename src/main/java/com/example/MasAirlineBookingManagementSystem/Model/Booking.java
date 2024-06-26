package com.example.MasAirlineBookingManagementSystem.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long flightId;
    private Long userId;
    private LocalDateTime bookingDate;
    private String status; // CONFIRMED, CANCELLED
    private String seatNumber; // e.g., 12A, 14C
    private boolean isAisleSeat;
}
