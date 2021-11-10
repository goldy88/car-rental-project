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

    @ManyToOne
    @JoinColumn(name = "id_customer", referencedColumnName="id")
    private Customer idCustomer;

    @ManyToOne
    @JoinColumn(name = "id_car", referencedColumnName="id")
    private Car idCar;

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

    @OneToOne(mappedBy = "idBooking")
    private Rental rental;

    @OneToOne(mappedBy = "bookingNr")
    private Return returned;



}
