package com.car_rental.project.services;

import com.car_rental.project.model.Car;

import java.util.List;

public interface CarWebService {
    List<Car> getAllCars();
    void saveCar(Car car);
    Car getCarById(long id);
    void deleteCarByID(long id);

   }

