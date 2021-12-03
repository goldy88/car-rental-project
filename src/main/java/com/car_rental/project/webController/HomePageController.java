package com.car_rental.project.webController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {

    @GetMapping("/rentcar/homepage")
    public String viewHomePage(Model model) {
        return "rentcar-homepage";
    }

}

