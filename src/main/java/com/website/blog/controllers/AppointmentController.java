package com.website.blog.controllers;

import com.website.blog.models.appointment;
import com.website.blog.repo.appointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AppointmentController {

    @Autowired
    private appointmentRepository appointmentRepository;

    @GetMapping("/view")
    public String appointmentMain(Model model) {
        Iterable<appointment> appointments = appointmentRepository.findAll();
        model.addAttribute("appointments", appointments);
        return "viewingAppointments";
    }

    @GetMapping("/appointment")
    public String appointmentAdd(Model model) {
        return "appointment-main";
    }

    @PostMapping("/appointment")
    public String addedAppointment(String date, @RequestParam String doctor, @RequestParam String time,
                                   @RequestParam String telephone, @RequestParam String status, Model model) {
        appointment appointment = new appointment(date, doctor, time, telephone, status);
        appointmentRepository.save(appointment);
        return "redirect:/view";
    }
}
