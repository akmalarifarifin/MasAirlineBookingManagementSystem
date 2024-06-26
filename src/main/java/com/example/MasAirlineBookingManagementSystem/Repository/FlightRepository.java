package com.example.MasAirlineBookingManagementSystem.Repository;

import com.example.MasAirlineBookingManagementSystem.Model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
}
