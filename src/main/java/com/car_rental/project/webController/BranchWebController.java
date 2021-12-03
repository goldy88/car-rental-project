package com.car_rental.project.webController;

import com.car_rental.project.model.Branch;
import com.car_rental.project.services.BranchWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BranchWebController {

    @Autowired
    private BranchWebService branchWebService;

    // display list of branch
    @GetMapping("/rentcar/BranchManagement")
    public String viewHomePage(Model model) {
        model.addAttribute("listBranch", branchWebService.getAllBranch());
        return "BranchManagement";
    }


    @GetMapping("/showNewBranchForm")
    public String showNewBranchForm(Model model) {
        // create model attribute to bind form data
        Branch branch = new Branch();
        model.addAttribute("branch", branch);
        return "new-branch";
    }

    @PostMapping("/saveBranch")
    public String saveBranch(@ModelAttribute("branch") Branch branch) {
        //save branch to database
        branchWebService.saveBranch(branch);
        return "redirect:/rentcar/BranchManagement";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
        //get branch from the service
        Branch branch = branchWebService.getBranchById(id);

        //set branch as a model attribute to pre-populate the form
        model.addAttribute("branch", branch);
        return "update-branch";
    }

    @GetMapping("/deleteBranch/{id}")
    public String deleteBranch(@PathVariable(value = "id") long id) {

        //call delete branch method
        this.branchWebService.deleteBranchByID(id);
        return "redirect:/rentcar/BranchManagement";
    }


}


