package com.car_rental.project.model;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
@Table(name = "car")
public class Car {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    private String make;

    private String model;

    @Column(name = "body_type")
    private String bodyType;

    private int year;

    private String color;

    private String status;

    @Column(name = "branch_car")
    private int branchCar;

}
