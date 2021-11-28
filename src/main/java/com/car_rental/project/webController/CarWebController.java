package com.car_rental.project.webController;


import com.car_rental.project.model.Branch;
import com.car_rental.project.model.Car;
import com.car_rental.project.services.BranchWebService;
import com.car_rental.project.services.CarWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CarWebController {

    @Autowired
    private CarWebService carWebService;

    @Autowired
    private BranchWebService branchWebService;

    // display list of cars
    @GetMapping("/cars-management")
    public String viewHomePage3(Model model) {
        model.addAttribute("listCars", carWebService.getAllCars());
        return "cars-management";
    }

    @GetMapping("/showNewCarForm")
    public String showNewCarForm(Model model) {
        List<Branch> branches = branchWebService.getAllBranch();
        // create model attribute to bind form data
        Car car = new Car();
        model.addAttribute("car", car);
        model.addAttribute("branches", branches);
        return "new-cars";
    }


    @PostMapping("/saveCar")
    public String saveCar(@ModelAttribute("car") @Valid Car car) {
        //save car to database
        carWebService.saveCar(car);
        return "redirect:/cars-management";
    }

    @GetMapping("/showFormForUpdate3/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
        //get car from the service
        List<Branch> branches = branchWebService.getAllBranch();
        Car car = carWebService.getCarById(id);

        //set car as a model attribute to pre-populate the form
        model.addAttribute("car", car);
        model.addAttribute("branches", branches);
        return "update-cars";
    }

    @GetMapping("/deleteCar/{id}")
    public String deleteCar(@PathVariable(value = "id") long id) {

        //call delete car method
        this.carWebService.deleteCarByID(id);
        return "redirect:/cars-management";
    }


}
