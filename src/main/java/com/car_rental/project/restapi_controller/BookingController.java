package com.car_rental.project.restapi_controller;

import com.car_rental.project.dto.BookingRequest;
import com.car_rental.project.dto.BookingResult;
import com.car_rental.project.model.Booking;
import com.car_rental.project.facade.CarFacade;
import com.car_rental.project.model.Employee;
import com.car_rental.project.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/booking")
@RequiredArgsConstructor

public class BookingController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookingController.class);

    @Autowired
    private final CarFacade carFacade;

    @Autowired
    private final BookingRepository bookingRepository;

    @PostMapping(path = "/request", produces = MediaType.APPLICATION_JSON_VALUE)
    public BookingResult postBooking(@RequestBody BookingRequest bookingRequest) {

        LOGGER.debug("{}", bookingRequest);

       BookingResult bookingResult = carFacade.bookCar(bookingRequest);

       return bookingResult;
    }

    @GetMapping(path = "/result/customer/{id}", produces = MediaType.APPLICATION_JSON_VALUE)

    public List<Booking> getAllCustomerBookings (@PathVariable Long id) {

        return bookingRepository.findAllByIdCustomer_Id(id);
    }

}

