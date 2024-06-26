package com.example.MasAirlineBookingManagementSystem.Service;


import com.example.MasAirlineBookingManagementSystem.Model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlightService {
    @Autowired
    private FlightRepository flightRepository;
    private List<Flight> flights = new ArrayList<>();
    private Long nextId = 1L;

    public List<Flight> getAllFlights() {
        return flights;
    }

    public Flight getFlightById(Long id) {
        for (Flight flight : flights) {
            if (flight.getId().equals(id)) {
                return flight;
            }
        }
        return null;
    }

    public Flight addFlight(Flight flight) {
        flight.setId(nextId++);
        flights.add(flight);
        return flight;
    }

    public Flight updateFlight(Long id, Flight updatedFlight) {
        for (int i = 0; i < flights.size(); i++) {
            Flight flight = flights.get(i);
            if (flight.getId().equals(id)) {
                flights.set(i, updatedFlight);
                return updatedFlight;
            }
        }
        return null;
    }

    public void deleteFlight(Long id) {
        flights.removeIf(flight -> flight.getId().equals(id));
    }
}
