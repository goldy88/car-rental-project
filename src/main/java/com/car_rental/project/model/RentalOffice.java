package com.car_rental.project.model;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
@Table(name = "rental_office")
public class RentalOffice {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    private String name;
    private String domain;
    private String owner;
    private String logotype;

}
