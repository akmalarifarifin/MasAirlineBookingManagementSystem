package com.example.MasAirlineBookingManagementSystem.Model;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Booking {
    private Long id;
    private Long flightId;
    private Long userId;
    private LocalDateTime bookingDate;
    private String status; // e.g., CONFIRMED, CANCELLED
    private String seatNumber; // e.g., 12A, 14C
    private boolean isAisleSeat;
}
