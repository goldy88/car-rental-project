package com.car_rental.project.services;

import com.car_rental.project.model.Branch;
import com.car_rental.project.model.Employee;
import com.car_rental.project.repository.BranchRepository;
import com.car_rental.project.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchService {

    private final BranchRepository branchRepository;

    private final EmployeeRepository employeeRepository;

    public BranchService(BranchRepository branchRepository, EmployeeRepository employeeRepository) {
        this.branchRepository = branchRepository;
        this.employeeRepository = employeeRepository;
    }

    public List<Branch> findAll() {
        return branchRepository.findAll();
    }

    public List<Employee> getEmployeesByBranchId(Long branchId) {
        return employeeRepository.findAllByIdBranch_Id(branchId);
    }

}
