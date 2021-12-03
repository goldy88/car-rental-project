package com.car_rental.project.webController;


import com.car_rental.project.model.Branch;
import com.car_rental.project.model.Employee;
import com.car_rental.project.services.BranchWebService;
import com.car_rental.project.services.EmployeeWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class EmployeeWebController {

    @Autowired
    private EmployeeWebService employeeWebService;

    @Autowired
    private BranchWebService branchWebService;

    // display list of employees
    @GetMapping("/rentcar/employeemanagement")
    public String viewHomePage2(Model model) {
            model.addAttribute("listEmployees", employeeWebService.getAllEmployees());
        return "employeemanagement";
    }

    @GetMapping("/showNewEmployeeForm")
    public String showNewEmployeeForm(Model model) {
        List<Branch> branches = branchWebService.getAllBranch();
        // create model attribute to bind form data
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        model.addAttribute("branches", branches);
        return "new-employee";
    }


    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") @Valid Employee employee ) {
        //save employee to database
        employeeWebService.saveEmployee(employee);
        return "redirect:/rentcar/employeemanagement";
    }

    @GetMapping("/showFormForUpdate2/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
        //get employee from the service
        List<Branch> branches = branchWebService.getAllBranch();
        Employee employee = employeeWebService.getEmployeeById(id);

        //set employee as a model attribute to pre-populate the form
        model.addAttribute("employee", employee);
        model.addAttribute("branches", branches);
        return "update-employee";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable(value = "id") long id) {

        //call delete employee method
        this.employeeWebService.deleteEmployeeByID(id);
        return "redirect:/rentcar/employeemanagement";
    }



}
