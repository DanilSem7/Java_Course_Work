package com.website.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Главная страница");
        return "home";
    }

    @GetMapping("/doctors")
    public String doctors(Model model) {
        model.addAttribute("title", "Врачи");
        return "doctors";
    }

    @GetMapping("/services")
    public String services(Model model) {
        model.addAttribute("title", "Услуги");
        return "services";
    }

    @GetMapping("/vaccination")
    public String reviews(Model model) {
        model.addAttribute("title", "Вакцинация");
        return "vaccination";
    }
}
