package com.car_rental.project.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "employee")
public class Employee {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    @Column(name = "name_and_surname")
    private String nameAndSurname;

    private String position;

    @Column(name = "id_branch")
    private int idBranch;

}
