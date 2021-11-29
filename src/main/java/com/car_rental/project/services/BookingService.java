package com.car_rental.project.services;

import com.car_rental.project.dto.BookingRequest;
import com.car_rental.project.model.Booking;
import com.car_rental.project.model.Car;
import com.car_rental.project.model.Customer;
import com.car_rental.project.repository.BookingRepository;
import com.car_rental.project.repository.CarRepository;
import com.car_rental.project.repository.CustomerRepository;
import com.car_rental.project.util.DateHelper;
import com.car_rental.project.util.DaysCalculator;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final CustomerRepository customerRepository;
    private final CarRepository carRepository;

    private static final int returnAtOtherBranchFee = 50;


    public BookingService(BookingRepository bookingRepository, CustomerRepository customerRepository, CarRepository carRepository) {
        this.bookingRepository = bookingRepository;
        this.customerRepository = customerRepository;
        this.carRepository = carRepository;
    }

    public Booking createBooking(BookingRequest bookingRequest) {

        Customer idCustomer = customerRepository.getById(bookingRequest.getIdCustomer());
        Car car = carRepository.getById(bookingRequest.getIdCar());

        // túto premennú idCustomer budeme brať potom z BookingRequets z nejakej metódy getCustomerId (obyčajný getter)

        Long calculatedBookingAmount = calculateBookingAmount(car.getPrice(), bookingRequest);

        Booking booking = Booking.builder()
                .date(new Date())
                .idCustomer(idCustomer)
                .idCar(car)
                .bookedFrom(DateHelper.stringToDate(bookingRequest.getBookedFrom()))
                .bookedTo(DateHelper.stringToDate(bookingRequest.getBookedTo()))
                .rentalBranch(bookingRequest.getIdRentalBranch())
                .returnBranch(bookingRequest.getIdReturnBranch())
                .bookingAmount(calculatedBookingAmount)
                .build();

        return bookingRepository.save(booking);

    }

      public Long calculateBookingAmount(Long bookingPrice, BookingRequest bookingRequest){

         Double numberOfDays = DaysCalculator.calculateNumberOfDaysInBooking(bookingRequest);

         Long bookingAmount = Math.round(numberOfDays * bookingPrice);

         if (!Objects.equals(bookingRequest.getIdRentalBranch(), bookingRequest.getIdReturnBranch())) {

             bookingAmount += returnAtOtherBranchFee;
         }

         return bookingAmount;

        }

        public List<Car> showCarsForGivenDates(String dateFrom, String dateTo){

            Date dateFromObject = DateHelper.stringToDate(dateFrom);
            Date dateToObject = DateHelper.stringToDate(dateTo);

            return carRepository.findAvailableCarsOnGivenDate(dateFromObject, dateToObject, "available");

        // druhý možný zápis:
        // return carRepository.findAvailableCarsOnGivenDate(DateHelper.stringToDate(dateFrom),
            // DateHelper.stringToDate(dateTo), "available");

        }

    }

