package com.car_rental.project.model;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Entity
@Data
@Table(name = "return")
public class Return {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    @Column(name = "employee_nr")
    private int employeeNr;

    @Column(name = "return_date")
    @Temporal(TemporalType.DATE)
    private Date returnDate;

    @Column(name = "booking_nr")
    private int bookingNr;

    @Column(name = "additional_payment")
    private int additionalPayment;

    private String comments;
}
