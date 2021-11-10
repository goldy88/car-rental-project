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

    @OneToOne
    @JoinColumn(name = "employee_nr", referencedColumnName="id")
    private Employee employeeNr;

    @Column(name = "return_date")
    @Temporal(TemporalType.DATE)
    private Date returnDate;

    @OneToOne
    @JoinColumn(name = "booking_nr", referencedColumnName="id")
    private Booking bookingNr;

    @Column(name = "additional_payment")
    private int additionalPayment;

    private String comments;
}
