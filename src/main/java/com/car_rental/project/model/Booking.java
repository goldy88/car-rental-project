package com.car_rental.project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "booking")
public class Booking {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date date;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "id_customer", referencedColumnName="id")
    private Customer idCustomer;

    @ManyToOne
    @JsonIgnore
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

    @OneToOne
    @JoinColumn(name = "rental_branch", referencedColumnName="branch_car")
    private Car rentalBranch;

    @OneToOne(mappedBy = "idBooking")
    private Rental rental;

    @OneToOne(mappedBy = "bookingNr")
    private Return returned;

}
