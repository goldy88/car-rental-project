package com.car_rental.project.util;

import com.car_rental.project.restapi_controller.BookingController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateHelper {

    private static final Logger LOGGER = LoggerFactory.getLogger(DateHelper.class);


    public static Date stringToDate(String dateInput) {

        try {

            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy H:m", Locale.ENGLISH);

            Date date = formatter.parse(dateInput);

            return date;

        } catch(ParseException parseException) {

            LOGGER.debug("Cannot parse date input: {}", dateInput);

            return null;
        }
    }
}
