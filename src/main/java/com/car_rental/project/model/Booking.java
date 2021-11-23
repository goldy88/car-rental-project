package com.car_rental.project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "booking")
public class Booking {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date date;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "id_customer", referencedColumnName="id")
    private Customer idCustomer;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "id_car", referencedColumnName="id")
    private Car idCar;

    @Temporal(TemporalType.DATE)
    @Column(name = "booked_from")
    private Date bookedFrom;

    @Temporal(TemporalType.DATE)
    @Column(name = "booked_to")
    private Date bookedTo;

    @Column(name = "rental_branch")
    private Long rentalBranch;

    @Column(name = "return_branch")
    private Long returnBranch;

    @Column(name = "booking_amount")
    private Long bookingAmount;


    /*@OneToOne
    @JoinColumn(name = "rental_branch", referencedColumnName="car_branch")
    private Car rentalBranch;*/

    @OneToOne(mappedBy = "idBooking")
    private Rental rental;

    @OneToOne(mappedBy = "bookingNr")
    private Return returned;

}
