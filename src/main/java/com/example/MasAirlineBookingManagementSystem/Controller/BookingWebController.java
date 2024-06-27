package com.example.MasAirlineBookingManagementSystem.Controller;

import com.example.MasAirlineBookingManagementSystem.Model.Booking;
import com.example.MasAirlineBookingManagementSystem.Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class BookingWebController {

    @Autowired
    private BookingService bookingService;

    @GetMapping("/web/bookings")
    public String getAllBookings(Model model) {
        List<Booking> bookings = bookingService.getAllBookings();
        model.addAttribute("bookings", bookings);
        return "bookings";
    }

    @GetMapping("/web/bookings/new")
    public String showCreateBookingForm(Model model) {
        model.addAttribute("booking", new Booking());
        return "createBooking";
    }

    @PostMapping("/bookingnew")
    public String createBooking(@ModelAttribute Booking booking, Model model) {
        bookingService.createBooking(booking);
        return "redirect:/web/bookings";
    }
}
