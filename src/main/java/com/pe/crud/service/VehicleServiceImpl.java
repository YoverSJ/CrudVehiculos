/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pe.crud.service;

import com.pe.crud.model.Vehicle;
import com.pe.crud.repository.VehicleRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author yoversj
 */
@Service
public class VehicleServiceImpl implements VehicleService{
    
    @Autowired
    private VehicleRepository vehicleRepo;

    @Override
    @Transactional
    public void guardar(Vehicle vehicle) {
        vehicleRepo.save(vehicle);
    }

    @Override
    @Transactional
    public void eliminar(Vehicle vehicle) {
        vehicleRepo.delete(vehicle);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Vehicle> listar() {
        return (List<Vehicle>)vehicleRepo.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Vehicle encontrarPorId(Vehicle vehicle) {
        return vehicleRepo.findById(vehicle.getId()).orElse(null);
    }
    
}
