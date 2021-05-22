package com.website.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppointmentController {
    @GetMapping("/appointment")
    public String appointmentMain(Model model) {
        return "appointment-main";
    }
}
