package com.example.MasAirlineBookingManagementSystem.Controller;

import com.example.MasAirlineBookingManagementSystem.Model.Flight;
import com.example.MasAirlineBookingManagementSystem.Service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @GetMapping
    public String getAllFlights(Model model) {
        List<Flight> flights = flightService.getAllFlights();
        model.addAttribute("flights", flights);
        return "flightList";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Flight getFlightById(@PathVariable Long id) {
        return flightService.getFlightById(id);
    }

    @PostMapping
    @ResponseBody
    public Flight addFlight(@RequestBody Flight flight) {
        return flightService.addFlight(flight);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public Flight updateFlight(@PathVariable Long id, @RequestBody Flight flight) {
        return flightService.updateFlight(id, flight);
    }

    @PostMapping("/delete/{id}")
    public String deleteFlight(@PathVariable Long id) {
        flightService.deleteFlight(id);
        return "redirect:/flights";
    }

    @GetMapping("/new")
    public String showCreateFlightForm(Model model) {
        model.addAttribute("flight", new Flight());
        return "createFlight";
    }

    @GetMapping("/edit/{id}")
    public String showEditFlightForm(@PathVariable Long id, Model model) {
        Flight flight = flightService.getFlightById(id);
        model.addAttribute("flight", flight);
        return "editFlight";
    }

    @PostMapping("/new")
    public String createFlight(@ModelAttribute Flight flight, Model model) {
        flightService.createFlight(flight);
        return "redirect:/flights";
    }
}
