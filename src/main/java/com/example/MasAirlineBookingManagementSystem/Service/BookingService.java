package com.example.MasAirlineBookingManagementSystem.Service;

import com.example.MasAirlineBookingManagementSystem.Model.Booking;
import com.example.MasAirlineBookingManagementSystem.Model.Flight;
import com.example.MasAirlineBookingManagementSystem.Repository.BookingRepository;
import com.example.MasAirlineBookingManagementSystem.Repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private FlightRepository flightRepository;

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id).orElse(null);
    }

    public Booking createBooking(Booking booking) {
        Flight flight = flightRepository.findById(booking.getFlightId()).orElse(null); // Notice the change here
        if (flight != null && flight.getAvailableSeats() > 0) {
            booking.setBookingDate(LocalDateTime.now());
            booking.setSeatNumber(assignSeat(booking.isAisleSeat()));
            flight.setAvailableSeats(flight.getAvailableSeats() - 1);
            flightRepository.save(flight);
            return bookingRepository.save(booking);
        }
        return null;
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
