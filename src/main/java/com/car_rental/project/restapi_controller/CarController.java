package com.car_rental.project.restapi_controller;

import com.car_rental.project.model.Branch;
import com.car_rental.project.model.Car;
import com.car_rental.project.model.Employee;
import com.car_rental.project.services.BranchService;
import com.car_rental.project.services.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/car")
@RequiredArgsConstructor

public class CarController {

    @Autowired
    private final CarService carService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Car> getAllCars() {

        return carService.findAll();
    }

    @GetMapping(path = "/branch/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Car> getCarInBranch (@PathVariable Long id) {

        return carService.getAvailableCarsByBranch(id);
    }



}
