package com.car_rental.project.model;

import lombok.Data;
import javax.persistence.*;
import java.util.Set;

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

    @ManyToOne
    @JoinColumn(name = "branch_car", referencedColumnName="id")
    private Branch branchCar;

    @OneToMany
    @JoinColumn (name = "id_car")
    private Set<Booking> bookings;

}
