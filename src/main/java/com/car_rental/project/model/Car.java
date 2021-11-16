package com.car_rental.project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "car")

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
    @JsonIgnore
    @JoinColumn(name = "car_branch", referencedColumnName="id")
    private Branch branch;

    @OneToMany
    @JoinColumn (name = "id_car")
    private Set<Booking> bookings;

    @OneToOne(mappedBy = "rentalBranch")
    private Booking bookingBranch;

}
