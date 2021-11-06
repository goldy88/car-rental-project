package com.car_rental.project.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "booking")
public class Booking {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name = "id_customer")
    private int idCustomer;

    @Column(name = "id_car")
    private int idCar;

    @Temporal(TemporalType.DATE)
    @Column(name = "booked_from")
    private Date bookedFrom;

    @Temporal(TemporalType.DATE)
    @Column(name = "booked_to")
    private Date bookedTo;

    @Column(name = "return_branch")
    private int return_branch;

    @Column(name = "booking_amount")
    private int bookingAmount;


}
