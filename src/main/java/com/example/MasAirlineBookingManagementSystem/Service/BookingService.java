package com.example.MasAirlineBookingManagementSystem.Service;


import com.example.MasAirlineBookingManagementSystem.Model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private FlightRepository flightRepository;

    private List<Booking> bookings = new ArrayList<>();
    private Long nextId = 1L;

    public List<Booking> getAllBookings() {
        return bookingsRepository.findAll();
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
