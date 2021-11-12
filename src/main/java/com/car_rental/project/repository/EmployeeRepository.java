package com.car_rental.project.repository;

import com.car_rental.project.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {


    // List<Employee> findAllByIdBranch_Id(Long idBranch);

    @Query(
    value = "SELECT e FROM Employee e WHERE e.idBranch.id = :idBranch")
    List<Employee> findAllByIdBranch_Id(Long idBranch);


}