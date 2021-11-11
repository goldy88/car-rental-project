package com.car_rental.project.model;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "car")
@Accessors(chain = true)
public class Car {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

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
