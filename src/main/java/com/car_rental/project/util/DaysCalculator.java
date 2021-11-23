package com.car_rental.project.util;

import com.car_rental.project.dto.BookingRequest;
import com.car_rental.project.model.Booking;

import java.util.Date;

public class DaysCalculator {


    public static Double calculateNumberOfDaysInBooking(BookingRequest bookingRequest) {


        Date startOfBooking = DateHelper.stringToDate(bookingRequest.getBookedFrom());
        Date endOfBooking = DateHelper.stringToDate(bookingRequest.getBookedTo());

        Double numberOfDays = ((endOfBooking.getTime() - startOfBooking.getTime()) / 1000D / 60 / 60 / 24);

        return numberOfDays;

    }
}
