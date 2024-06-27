package com.example.MasAirlineBookingManagementSystem.Config;

import com.example.MasAirlineBookingManagementSystem.Model.Booking;
import com.example.MasAirlineBookingManagementSystem.Model.Flight;
import com.example.MasAirlineBookingManagementSystem.Model.User;
import com.example.MasAirlineBookingManagementSystem.Repository.BookingRepository;
import com.example.MasAirlineBookingManagementSystem.Repository.FlightRepository;
import com.example.MasAirlineBookingManagementSystem.Repository.UserRepository;
import com.example.MasAirlineBookingManagementSystem.Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@Configuration
public class DataLoader {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private UserRepository userRepository;
    private final BookingService bookingService;

    @Autowired
    public DataLoader(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @Bean
    public CommandLineRunner loadData() {
        return args -> {
            loadFlights();
            loadUsers();
            loadBookings();
        };
    }

    private void loadFlights() {
        flightRepository.save(new Flight(null, "MH100", "Kuala Lumpur", "Singapore", LocalDateTime.of(2024, 7, 1, 8, 0), LocalDateTime.of(2024, 7, 1, 10, 0), 180, 150));
        flightRepository.save(new Flight(null, "MH101", "Kuala Lumpur", "Bangkok", LocalDateTime.of(2024, 7, 1, 9, 0), LocalDateTime.of(2024, 7, 1, 11, 0), 200, 180));
        flightRepository.save(new Flight(null, "MH102", "Kuala Lumpur", "Jakarta", LocalDateTime.of(2024, 7, 1, 10, 0), LocalDateTime.of(2024, 7, 1, 12, 0), 220, 200));
        flightRepository.save(new Flight(null, "MH103", "Kuala Lumpur", "Manila", LocalDateTime.of(2024, 7, 1, 11, 0), LocalDateTime.of(2024, 7, 1, 14, 0), 180, 150));
        flightRepository.save(new Flight(null, "MH104", "Kuala Lumpur", "Hanoi", LocalDateTime.of(2024, 7, 1, 12, 0), LocalDateTime.of(2024, 7, 1, 14, 0), 200, 180));
        flightRepository.save(new Flight(null, "MH105", "Kuala Lumpur", "Ho Chi Minh City", LocalDateTime.of(2024, 7, 1, 13, 0), LocalDateTime.of(2024, 7, 1, 15, 0), 220, 200));
        flightRepository.save(new Flight(null, "MH106", "Kuala Lumpur", "Phnom Penh", LocalDateTime.of(2024, 7, 1, 14, 0), LocalDateTime.of(2024, 7, 1, 16, 0), 180, 150));
        flightRepository.save(new Flight(null, "MH107", "Kuala Lumpur", "Siem Reap", LocalDateTime.of(2024, 7, 1, 15, 0), LocalDateTime.of(2024, 7, 1, 17, 0), 200, 180));
        flightRepository.save(new Flight(null, "MH108", "Kuala Lumpur", "Yangon", LocalDateTime.of(2024, 7, 1, 16, 0), LocalDateTime.of(2024, 7, 1, 18, 0), 220, 200));
        flightRepository.save(new Flight(null, "MH109", "Kuala Lumpur", "Vientiane", LocalDateTime.of(2024, 7, 1, 17, 0), LocalDateTime.of(2024, 7, 1, 19, 0), 180, 150));
    }

    private void loadUsers() {
        userRepository.save(new User(null, "John Lee", "john@gmail.com", "password1"));
        userRepository.save(new User(null, "Emily Chen", "emily@gmail.com", "password2"));
        userRepository.save(new User(null, "Ahmed Khan", "ahmed@gmail.com", "password3"));
        userRepository.save(new User(null, "Priya Patel", "priya@gmail.com", "password4"));
        userRepository.save(new User(null, "Muhammad Ali", "ali@gmail.com", "password5"));
        userRepository.save(new User(null, "Mei Lin", "mei@gmail.com", "password6"));
        userRepository.save(new User(null, "Omar Abdullah", "omar@gmail.com", "password7"));
        userRepository.save(new User(null, "Natasha Singh", "natasha@gmail.com", "password8"));
        userRepository.save(new User(null, "David Nguyen", "david@gmail.com", "password9"));
        userRepository.save(new User(null, "Aisha Rahman", "aisha@gmail.com", "password10"));
        userRepository.save(new User(null, "Michael Kim", "michael@gmail.com", "password11"));
        userRepository.save(new User(null, "Sana Ahmed", "sana@gmail.com", "password12"));
        userRepository.save(new User(null, "Jason Tan", "jason@gmail.com", "password13"));
        userRepository.save(new User(null, "Leila Mansour", "leila@gmail.com", "password14"));
        userRepository.save(new User(null, "Ryan Wong", "ryan@gmail.com", "password15"));
        userRepository.save(new User(null, "Fatima Abbas", "fatima@gmail.com", "password16"));
        userRepository.save(new User(null, "Daniel Wu", "daniel@gmail.com", "password17"));
        userRepository.save(new User(null, "Layla Said", "layla@gmail.com", "password18"));
        userRepository.save(new User(null, "Peter Zhao", "peter@gmail.com", "password19"));
        userRepository.save(new User(null, "Sarah Malik", "sarah@gmail.com", "password20"));
    }

    private void loadBookings() {
        IntStream.rangeClosed(1, 10).forEach(i -> {
            Booking booking = new Booking();
            booking.setFlightId((long) i); // Assuming flights have IDs from 1 to 10
            booking.setUserId((long) i);   // Assuming users have IDs from 1 to 10
            booking.setBookingDate(LocalDateTime.now().minusDays(i)); // Booking dates for last 10 days
            booking.setStatus("CONFIRMED");
            booking.setSeatNumber(generateRandomSeatNumber());
            booking.setAisleSeat(new Random().nextBoolean());

            bookingService.createBooking(booking);
        });
    }

    private String generateRandomSeatNumber() {
        Random random = new Random();
        int row = random.nextInt(30) + 1; // Random row number from 1 to 30
        char seat = (char) (random.nextInt(6) + 'A'); // Random seat letter from A to F
        return row + String.valueOf(seat);
    }

}
