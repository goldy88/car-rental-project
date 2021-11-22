package com.car_rental.project.facade;

import com.car_rental.project.dto.BookingRequest;
import com.car_rental.project.dto.BookingResult;
import com.car_rental.project.model.Booking;
import com.car_rental.project.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CarFacade {

    private final BookingService bookingService;

    @Autowired
    public CarFacade( BookingService bookingService) {
        this.bookingService = bookingService;

    }

    public BookingResult bookCar (BookingRequest bookingRequest){

        Booking booking =  bookingService.createBooking(bookingRequest);

        BookingResult bookingResult = new BookingResult(booking);

        return bookingResult;
    }
}
