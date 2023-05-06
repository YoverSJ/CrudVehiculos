/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.pe.crud.service;

import com.pe.crud.model.Vehicle;
import java.util.List;

/**
 *
 * @author yoversj
 */
public interface VehicleService {
    
    public void guardar(Vehicle vehicle);
    
    public void eliminar(Vehicle vehicle);
    
    public List<Vehicle> listar();
    
    public Vehicle encontrarPorId(Vehicle vehicle);
}
