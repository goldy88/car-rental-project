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
            value = "SELECT c FROM Car c WHERE c.branch.id = :carBranch")
    List<Car> findAllByCarBranch_Id(Long carBranch);

}
