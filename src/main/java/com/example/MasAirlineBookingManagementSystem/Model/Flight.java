package com.example.MasAirlineBookingManagementSystem.Model;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Flight {
    private Long id;
    private String flightNumber;
    private String origin;
    private String destination;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private int totalSeats;
    private int availableSeats;
}
