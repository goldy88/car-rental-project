package com.car_rental.project.services;

import com.car_rental.project.model.Branch;
import com.car_rental.project.model.Car;
import com.car_rental.project.model.Employee;
import com.car_rental.project.repository.BranchRepository;
import com.car_rental.project.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private final CarRepository carRepository;


    public CarService(CarRepository carRepository) {

        this.carRepository = carRepository;
    }

    public List<Car> findAll() {

        return carRepository.findAll();
    }

    public List<Car> getCarsByCarBranch(Long carBranch) {

        return carRepository.findAllByCarBranch_Id(carBranch);
    }
}
