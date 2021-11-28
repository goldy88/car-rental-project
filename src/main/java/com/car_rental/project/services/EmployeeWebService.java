package com.car_rental.project.services;

import com.car_rental.project.model.Employee;

import java.util.List;

public interface EmployeeWebService {
    List<Employee> getAllEmployees();
    void saveEmployee(Employee employee);
    Employee getEmployeeById(long id);
    void deleteEmployeeByID(long id);

   }

