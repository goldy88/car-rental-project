package com.car_rental.project.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "rental_office")
@AllArgsConstructor
public class RentalOffice {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String name;
    private String domain;
    private String owner;
    private String logotype;

    @OneToMany
    @JoinColumn (name = "id_rental_office")
    private Set<Branch> branches;

    public RentalOffice() {
    }

    @Override
    public String toString(){
        return "RentalOffice{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", owner='" + owner + '\'' +
                ", logotype='" + logotype + '\'' +
                '}';
    }


}

