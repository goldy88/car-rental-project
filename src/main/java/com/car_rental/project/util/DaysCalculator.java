package com.car_rental.project.util;


import com.car_rental.project.model.Booking;

import java.util.Date;

public class DaysCalculator {


    public static Double calculateNumberOfDaysInBooking(String bookedFrom, String bookedTo) {


        Date startOfBooking = DateHelper.stringToDate(bookedFrom);
        Date endOfBooking = DateHelper.stringToDate(bookedTo);

        return ((endOfBooking.getTime() - startOfBooking.getTime()) / 1000D / 60 / 60 / 24);

    }
}
