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
@Table(name = "branch")
public class Branch {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String address;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "id_rental_office", referencedColumnName="id")
    private RentalOffice idRentalOffice;

    @OneToMany
    @JsonIgnore
    @JoinColumn (name = "id_branch")
    private Set<Employee> employees;

    /* @OneToMany
    @JsonIgnore
    @JoinColumn (name = "car_branch")
    private Set<Car> cars; */

}
