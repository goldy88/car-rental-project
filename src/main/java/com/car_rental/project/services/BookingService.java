package com.car_rental.project.services;

import com.car_rental.project.dto.BookingRequest;
import com.car_rental.project.model.Booking;
import com.car_rental.project.model.Car;
import com.car_rental.project.model.Customer;
import com.car_rental.project.repository.BookingRepository;
import com.car_rental.project.repository.CarRepository;
import com.car_rental.project.repository.CustomerRepository;
import com.car_rental.project.util.DateHelper;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final CustomerRepository customerRepository;
    private final CarRepository carRepository;

    public BookingService(BookingRepository bookingRepository, CustomerRepository customerRepository, CarRepository carRepository) {
        this.bookingRepository = bookingRepository;
        this.customerRepository = customerRepository;
        this.carRepository = carRepository;
    }

    public Booking createBooking(BookingRequest bookingRequest){

        Customer idCustomer = customerRepository.getById(bookingRequest.getIdCustomer());
        Car idCar = carRepository.getById(bookingRequest.getIdCar());

        // túto premennú idCustomer budeme brať potom z BookingRequets z nejakej metódy getCustomerId (obyčajný getter)

        Booking booking = Booking.builder()
                .date(new Date())
                .idCustomer(idCustomer)
                .idCar(idCar)
                .bookedFrom(DateHelper.stringToDate(bookingRequest.getBookedFrom()))
                .bookedTo(DateHelper.stringToDate(bookingRequest.getBookedTo()))
                .rentalBranch(bookingRequest.getIdRentalBranch())
                .returnBranch(bookingRequest.getIdReturnBranch())
                .bookingAmount(0)
                .build();

      return bookingRepository.save(booking);

    }
}
