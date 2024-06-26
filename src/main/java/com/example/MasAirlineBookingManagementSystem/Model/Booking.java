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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isAisleSeat() {
        return isAisleSeat;
    }

    public void setAisleSeat(boolean aisleSeat) {
        isAisleSeat = aisleSeat;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }
}
