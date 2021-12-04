package com.car_rental.project.webController;


import com.car_rental.project.dto.BookingRequest;
import com.car_rental.project.dto.BookingResult;
import com.car_rental.project.dto.BookingStepTwoForm;
import com.car_rental.project.facade.CarFacade;
import com.car_rental.project.model.Booking;
import com.car_rental.project.model.Branch;
import com.car_rental.project.model.Car;
import com.car_rental.project.repository.BookingRepository;
import com.car_rental.project.repository.BranchRepository;
import com.car_rental.project.services.BookingService;
import com.car_rental.project.services.BranchWebService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor

public class BookingWebController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookingWebController.class);

    @Autowired
    private final CarFacade carFacade;

    @Autowired
    private final BookingRepository bookingRepository;

    @Autowired
    private final BranchWebService branchWebService;

    @Autowired
    private final BookingService bookingService;

    @Autowired
    private final BranchRepository branchRepository;



    @GetMapping(path = "rentcar/booking/step/one")

    public String showBookingStepOne() {

        return "BookingStepOne";
    }

    @PostMapping(path = "rentcar/booking/step/two", produces = MediaType.APPLICATION_JSON_VALUE)
    public String showCars(final ModelMap modelMap, @ModelAttribute("from") String from, @ModelAttribute("to") String to) {

        LOGGER.debug("received dates from user from {} to {}", from, to);

        List<Car> allCarsForBooking = bookingService.showCarsForGivenDates(from, to);

        // !!!!!!! Wauuuu
        modelMap.addAttribute("listOfCars", allCarsForBooking);
        modelMap.addAttribute("bookedFrom", from);
        modelMap.addAttribute("bookedTo", to);
        modelMap.addAttribute("listOfBranches", branchRepository.findAll());

        LOGGER.debug("{} all cars for booking", allCarsForBooking);

        return "BookingStepTwo";
    }

    @PostMapping(path = "rentcar/booking/step/final", produces = MediaType.APPLICATION_JSON_VALUE)

    public String saveBooking(final ModelMap modelMap, @ModelAttribute BookingStepTwoForm bookingStepTwoForm) {

        LOGGER.debug("received data from booking step two form to {}", bookingStepTwoForm);

        Booking booking = carFacade.bookCarOnWeb(bookingStepTwoForm);

        modelMap.addAttribute("booking", booking);

        LOGGER.debug("{} all cars for booking",booking);

        return "BookingStepFinal";
    }

}