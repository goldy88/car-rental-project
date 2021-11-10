package com.car_rental.project.model;

import lombok.Data;
import org.hibernate.mapping.List;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "rental_office")
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

}
