package com.car_rental.project.repository;

import com.car_rental.project.model.Car;
import com.car_rental.project.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    @Query(
            value = "SELECT c FROM Car c WHERE c.branch.id = :branchCar AND c.status = :status")
    List<Car> findAvailableCarsByBranch_Id(Long branchCar, String status);

    @Query(
            value= "SELECT c FROM Car c WHERE c.status = :status")
    List<Car> getCarsByStatus(String status);


    }

