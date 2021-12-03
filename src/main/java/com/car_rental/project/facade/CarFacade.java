package com.car_rental.project.facade;

import com.car_rental.project.dto.BookingRequest;
import com.car_rental.project.dto.BookingResult;
import com.car_rental.project.dto.BookingStepTwoForm;
import com.car_rental.project.model.Booking;
import com.car_rental.project.model.Branch;
import com.car_rental.project.model.Employee;
import com.car_rental.project.repository.BranchRepository;
import com.car_rental.project.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CarFacade {

    private final BookingService bookingService;

    @Autowired
    BranchRepository branchRepository;

    @Autowired
    public CarFacade( BookingService bookingService) {
        this.bookingService = bookingService;

    }

    public BookingResult bookCar (BookingRequest bookingRequest){


        // Optional<Branch> rentalBranch = branchRepository.findById(bookingRequest.getRentalBranch());
        // Optional<Branch> returnBranch = branchRepository.findById(bookingRequest.getReturnBranch());

        Booking booking =  bookingService.createBooking(bookingRequest); //rentalBranch, returnBranch

        BookingResult bookingResult = new BookingResult(booking);

        return bookingResult;
    }

    public Booking bookCarOnWeb (BookingStepTwoForm bookingStepTwoForm){

        Booking booking =  bookingService.createBookingOnWeb(bookingStepTwoForm); //rentalBranch, returnBranch



        return booking;
    }
}
