package com.example.MasAirlineBookingManagementSystem.Repository;

import com.example.MasAirlineBookingManagementSystem.Model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
}
