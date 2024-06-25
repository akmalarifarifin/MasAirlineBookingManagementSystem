package com.example.MasAirlineBookingManagementSystem.Service;


import com.example.MasAirlineBookingManagementSystem.Model.Booking;
import java.util.List;
import java.util.ArrayList;

public class BookingService {
    private List<Booking> bookings = new ArrayList<>();
    private Long nextId = 1L;

    public List<Booking> getAllBookings() {
        return bookings;
    }

    public Booking getBookingById(Long id) {
        for (Booking booking : bookings) {
            if (booking.getId().equals(id)) {
                return booking;
            }
        }
        return null;
    }

}
