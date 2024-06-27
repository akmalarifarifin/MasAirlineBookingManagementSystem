package com.example.MasAirlineBookingManagementSystem.Service;

import com.example.MasAirlineBookingManagementSystem.Model.Booking;
import com.example.MasAirlineBookingManagementSystem.Model.Flight;
import com.example.MasAirlineBookingManagementSystem.Repository.BookingRepository;
import com.example.MasAirlineBookingManagementSystem.Repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;
import java.util.Random;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final FlightRepository flightRepository;

    @Autowired
    public BookingService(BookingRepository bookingRepository, FlightRepository flightRepository) {
        this.bookingRepository = bookingRepository;
        this.flightRepository = flightRepository;
    }


    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Booking createBooking(Booking booking) {
        if (booking != null) {
            return bookingRepository.save(booking);
        } else {
            throw new IllegalArgumentException("Booking cannot be null");
        }
    }

    private String assignSeat(boolean isAisleSeat) {
        Random random = new Random();
        if (isAisleSeat) {
            return "A" + (random.nextInt(50) + 1);
        } else {
            return "B" + (random.nextInt(50) + 1);
        }
    }

    public Booking updateBooking(Long id, Booking updatedBooking) {
        if (bookingRepository.existsById(id)) {
            updatedBooking.setId(id);
            return bookingRepository.save(updatedBooking);
        }
        return null;
    }

    public void cancelBooking(Long id) {
        Booking booking = bookingRepository.findById(id).orElse(null);
        if (booking != null) {
            bookingRepository.deleteById(id);
            Flight flight = flightRepository.findById(booking.getFlightId()).orElse(null);
            if (flight != null) {
                flight.setAvailableSeats(flight.getAvailableSeats() + 1);
                flightRepository.save(flight);
            }
        }
    }
}
