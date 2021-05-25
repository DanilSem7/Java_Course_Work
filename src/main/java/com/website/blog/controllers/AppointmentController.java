package com.website.blog.controllers;

import com.website.blog.models.appointment;
import com.website.blog.repo.appointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

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
    public String addedAppointment(@RequestParam String date, @RequestParam String doctor, @RequestParam String time,
                                   @RequestParam String telephone, @RequestParam String status, Model model) {
        appointment appointment = new appointment(date, doctor, time, telephone, status);
        appointmentRepository.save(appointment);
        return "redirect:/";
    }

    @GetMapping("/view/{id}")
    public String appointmentDetails(@PathVariable(value = "id") long id, Model model) {
        if(!appointmentRepository.existsById(id)){
            return "redirect:/";
        }
        Optional<appointment> appointment = appointmentRepository.findById(id);
        ArrayList<appointment> res = new ArrayList<>();
        appointment.ifPresent(res::add);
        model.addAttribute("appointment", res);
        return "appointment-details";
    }

    @GetMapping("/view/{id}/edit")
    public String appointmentEdit(@PathVariable(value = "id") long id, Model model) {
        if(!appointmentRepository.existsById(id)){
            return "redirect:/";
        }
        Optional<appointment> appointment = appointmentRepository.findById(id);
        ArrayList<appointment> res = new ArrayList<>();
        appointment.ifPresent(res::add);
        model.addAttribute("appointment", res);
        return "appointment-edit";
    }

    @PostMapping("/view/{id}/edit")
    public String appointmentUpdate(@PathVariable(value = "id") long id, @RequestParam String date,
                                    @RequestParam String doctor, @RequestParam String time,
                                   @RequestParam String telephone, @RequestParam String status, Model model) {
        appointment appointment = appointmentRepository.findById(id).orElseThrow();
        appointment.setDoctor(doctor);
        appointment.setDate(date);
        appointment.setTime(time);
        appointment.setTelephone(telephone);
        appointment.setStatus(status);
        appointmentRepository.save(appointment);
        return "redirect:/";
    }
}
