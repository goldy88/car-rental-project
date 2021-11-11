package com.car_rental.project.model;

import lombok.Data;
import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "branch")
public class Branch {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String address;

    @ManyToOne
    @JoinColumn(name = "id_rental_office", referencedColumnName="id")
    private RentalOffice idRentalOffice;

    @OneToMany
    @JoinColumn (name = "id_branch")
    private Set<Employee> employees;

    @OneToMany
    @JoinColumn (name = "branch_car")
    private Set<Car> cars;

}
