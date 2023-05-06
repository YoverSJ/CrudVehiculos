/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pe.crud.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import lombok.Data;

/**
 *
 * @author yoversj
 */
@Entity
@Data
public class Vehicle {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotEmpty(message = "El campo nombre no debe estar vacio")
    @Column(name = "name", length = 100)
    private String name;
    
    @NotEmpty
    @Column(name = "brand", length = 100)
    private String brand;
    
    @NotEmpty
    @Column(name = "model", length = 100)
    private String model;
    
    @NotEmpty
    @Column(name = "plate", length = 100)
    private String plate;
    
    @NotEmpty
    @Column(name = "color", length = 100)
    private String color;
    
    @Column(name = "indActive", length = 1)
    private int indActive;
    
    @Column(name = "createAt")
    private LocalDateTime createAt;
    
}
