package com.car_rental.project.webController;


import com.car_rental.project.dto.BookingRequest;
import com.car_rental.project.dto.BookingResult;
import com.car_rental.project.facade.CarFacade;
import com.car_rental.project.model.Booking;
import com.car_rental.project.model.Branch;
import com.car_rental.project.model.Car;
import com.car_rental.project.repository.BookingRepository;
import com.car_rental.project.repository.BranchRepository;
import com.car_rental.project.restapi_controller.BookingController;
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
@RequestMapping("/booking/step")
@RequiredArgsConstructor

public class WebBookingController {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebBookingController.class);

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



    @GetMapping(path = "/one")

    public String showBookingStepOne() {

        return "BookingStepOne";
    }

    @PostMapping(path = "/two", produces = MediaType.APPLICATION_JSON_VALUE)
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

    @PostMapping("/saveBranch")
    public String saveBranch(@ModelAttribute("branch") Branch branch) {
        //save branch to database
        branchWebService.saveBranch(branch);
        return "redirect:/BranchManagement";

    }
}