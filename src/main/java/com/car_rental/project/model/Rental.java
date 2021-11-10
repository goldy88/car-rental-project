package com.car_rental.project.model;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "rental")
public class Rental {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    @OneToOne
    @JoinColumn(name = "id_employee", referencedColumnName="id")
    private Employee idEmployee;

    @Temporal(TemporalType.DATE)
    @Column(name = "rental_date")
    private Date rentalDate;

    @OneToOne
    @JoinColumn(name = "id_booking", referencedColumnName="id")
    private Booking idBooking;

    private String comments;
}
