package com.car_rental.project.controller;

import com.car_rental.project.model.Branch;
import com.car_rental.project.model.Employee;
import com.car_rental.project.repository.BranchRepository;
import com.car_rental.project.services.BranchService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/branch")
@RequiredArgsConstructor

public class BranchController {

    @Autowired
    private final BranchService branchService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Branch> getAll() {

        return branchService.findAll();
    }

    @GetMapping(path = "/{id}/employee", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Employee> getEmployeeInBranch (@PathVariable Long id) {
        return branchService.getEmployeesByBranchId(id);

    }
}
