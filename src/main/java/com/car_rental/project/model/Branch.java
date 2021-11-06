package com.car_rental.project.model;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
@Table(name = "branch")
public class Branch {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    private String address;

    @Column(name = "id_rental_office")
    private int idRentalOffice;
}
