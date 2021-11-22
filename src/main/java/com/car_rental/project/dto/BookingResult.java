package com.car_rental.project.dto;

import com.car_rental.project.model.Booking;
import lombok.Data;

@Data
public class BookingResult {

    private Booking booking;

    public BookingResult(Booking booking) {
        this.booking = booking;
    }
}
