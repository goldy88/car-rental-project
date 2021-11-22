package com.car_rental.project.repository;

import com.car_rental.project.model.Booking;
import com.car_rental.project.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    @Query(
            value = "SELECT e FROM Booking e WHERE e.idCustomer.id = :idCustomer")
    List<Booking> findAllByIdCustomer_Id(Long idCustomer);

}