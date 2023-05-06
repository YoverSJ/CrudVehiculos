/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pe.crud.controller;

import com.pe.crud.model.Vehicle;
import com.pe.crud.repository.VehicleRepository;
import com.pe.crud.service.VehicleService;
import jakarta.validation.Valid;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author yoversj
 */
@Controller
@Slf4j
public class VehicleController {
    
    @Autowired
    private VehicleService vehicleService;
    
    @GetMapping("/")
    public String home(){
        return "index";
    }
    
    @GetMapping("/vehicles")
    public String listVehicles(Model model){
        var vehicles = vehicleService.listar();
        model.addAttribute("vehicles", vehicles);
        return "vehicles";
    }
    
    @GetMapping("/vehicles/new")
    public String createVehicle(Vehicle vehicle){
        return "formVehicle";
    }
    
    @PostMapping("/save")
    public String saveVehicle(@Valid Vehicle vehicle, Errors errors){
        
        if (errors.hasErrors()) {
            return "formVehicle";
        }
        
        LocalDateTime fechaActual = LocalDateTime.now();
        vehicle.setCreateAt(fechaActual);
        
        vehicleService.guardar(vehicle);
        
        return "redirect:/vehicles";
    }
    
    @GetMapping("/vehicle/edit/{id}")
    public String editVehicle(Vehicle vehicle, Model model){
        String accion = "Editar";
        vehicle = vehicleService.encontrarPorId(vehicle);
        //log.info(vehicle.toString());
        model.addAttribute("vehicle", vehicle);
        model.addAttribute("accion", accion);
        return "formVehicle";
    }
    
    @GetMapping("/vehicle/delete/{id}")
    public String deleteVehicle(Vehicle vehicle){
        vehicleService.eliminar(vehicle);
        return "redirect:/vehicles";
    }
    
}
