package com.car_rental.project.repository;

import com.car_rental.project.model.Booking;
import com.car_rental.project.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query(value = "SELECT c FROM Customer c WHERE c.email = :email")
    Customer  findCustomerByEmail(String email);

}