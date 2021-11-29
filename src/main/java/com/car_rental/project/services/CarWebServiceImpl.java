package com.car_rental.project.services;

import com.car_rental.project.model.Car;
import com.car_rental.project.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class CarWebServiceImpl implements CarWebService {

    @Autowired
    private CarRepository carRepository;

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public void saveCar(Car car) {
        this.carRepository.save(car);
    }

    @Override
    public Car getCarById(long id) {
        Optional<Car> optional = carRepository.findById(id);
        Car car = null;
        if (optional.isPresent()) {
            car = optional.get();
        } else {
            throw new RuntimeException(" Car not found for id :: " + id);
        }
        return car;

    }

    @Override
    public void deleteCarByID(long id) {
        this.carRepository.deleteById(id);
    }


}
