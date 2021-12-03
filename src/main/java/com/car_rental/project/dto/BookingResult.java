package com.car_rental.project.dto;

import com.car_rental.project.model.Booking;
import com.car_rental.project.model.Branch;
import lombok.Data;

import java.util.Optional;

@Data
public class BookingResult {

    private Booking booking;

    public BookingResult(Booking booking) {
        this.booking = booking;
    }

}

   // private Branch rentalBranch;
   // private Branch returnBranch;

 // public BookingResult(Booking booking, Optional<Branch> rentalBranch, Optional<Branch> returnBranch) {}



