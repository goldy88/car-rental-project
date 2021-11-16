package com.car_rental.project.restapi_controller;

import com.car_rental.project.model.Branch;
import com.car_rental.project.model.Car;
import com.car_rental.project.model.Employee;
import com.car_rental.project.services.BranchService;
import com.car_rental.project.services.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/branch")
@RequiredArgsConstructor

public class BranchController {

    @Autowired
    private final BranchService branchService;


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Branch> getAllBranches() {

        return branchService.findAll();
    }

    @GetMapping(path = "/{id}/employees", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Employee> getEmployeeInBranch (@PathVariable Long id) {
        return branchService.getEmployeesByBranchId(id);
    }
}
