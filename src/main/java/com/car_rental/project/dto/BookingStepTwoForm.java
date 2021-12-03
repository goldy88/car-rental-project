package com.car_rental.project.dto;


import com.car_rental.project.model.Car;
import com.car_rental.project.model.Customer;
import com.car_rental.project.model.Rental;
import com.car_rental.project.model.Return;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class BookingStepTwoForm {



    private String customerEmail;

    private String bookedCarId;

    private String bookedFrom;

    private String bookedTo;

    private Long returnBranch;
}
