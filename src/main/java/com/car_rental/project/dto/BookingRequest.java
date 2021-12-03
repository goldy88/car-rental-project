package com.car_rental.project.dto;

import com.car_rental.project.model.Car;
import com.car_rental.project.model.Customer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
public class BookingRequest {

    private Long idCustomer;

    private Long idCar;

    private String bookedFrom;

    private String bookedTo;

    private Long returnBranch;

    private Long rentalBranch;


}
