package com.car_rental.project.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "employee")
public class Employee {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name = "name_and_surname")
    private String nameAndSurname;

    private String position;

    @ManyToOne
    @JoinColumn(name = "id_branch", referencedColumnName="id")
    private Branch idBranch;

    @OneToOne(mappedBy = "idEmployee")
    private Rental rentalEmployee;

    @OneToOne(mappedBy = "employeeNr")
    private Return returnEmployee;

}
