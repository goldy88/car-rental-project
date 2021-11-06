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

    @Column(name = "id_employee")
    private int idEmployee;

    @Temporal(TemporalType.DATE)
    @Column(name = "rental_date")
    private Date rentalDate;

    @Column(name = "id_booking")
    private int idBooking;

    private String comments;
}
