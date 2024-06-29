package com.example.MasAirlineBookingManagementSystem.Controller;

import com.example.MasAirlineBookingManagementSystem.Model.Booking;
import com.example.MasAirlineBookingManagementSystem.Model.Flight;
import com.example.MasAirlineBookingManagementSystem.Model.User;
import com.example.MasAirlineBookingManagementSystem.Service.BookingService;
import com.example.MasAirlineBookingManagementSystem.Service.FlightService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class BookingWebController {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private FlightService flightService;

    @GetMapping("/web/bookings")
    public String getAllBookings(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            model.addAttribute("error", "Access Denied: Please log in first.");
            return "access-denied";
        }

        List<Booking> bookings = bookingService.getAllBookings();
        model.addAttribute("bookings", bookings);
        return "bookings";
    }

    @GetMapping("/web/bookings/new")
    public String showCreateBookingForm(@RequestParam("flightId") Long flightId, Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            model.addAttribute("error", "Access Denied: Please log in first.");
            return "access-denied";
        }

        Flight flight = flightService.getFlightById(flightId);
        Booking booking = new Booking();
        booking.setFlightId(flightId);

        model.addAttribute("booking", booking);
        model.addAttribute("flight", flight);
        model.addAttribute("user", user);

        return "createBooking";
    }

    @PostMapping("/bookingnew")
    public String createBooking(@ModelAttribute Booking booking, Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            model.addAttribute("error", "Access Denied: Please log in first.");
            return "access-denied";
        }

        booking.setUserId(user.getId()); // Set the user ID in the booking object
        bookingService.createBooking(booking);
        return "redirect:/web/bookings";
    }

    @GetMapping("/web/bookings/{id}/edit")
    public String editBookingForm(@PathVariable("id") Long id, Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            model.addAttribute("error", "Access Denied: Please log in first.");
            return "access-denied";
        }

        Booking booking = bookingService.getBookingById(id);
        model.addAttribute("booking", booking);
        return "editBooking"; // Render editBooking.html template for editing the booking
    }

    @PostMapping("/web/bookings/{id}/update")
    public String updateBooking(@PathVariable("id") Long id, @ModelAttribute Booking updatedBooking, HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            model.addAttribute("error", "Access Denied: Please log in first.");
            return "access-denied";
        }

        bookingService.updateBooking(id, updatedBooking);
        return "redirect:/web/bookings";
    }

    @GetMapping("/home")
    public String showHomePage(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");

        List<Flight> flights = flightService.getAllFlights();
        model.addAttribute("flights", flights);
        return "home";
    }

    @GetMapping("/main-page")
    public String showMainPage(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            model.addAttribute("error", "Access Denied: Please log in first.");
            return "access-denied";
        }
        return "mainUserPage";
    }
}
