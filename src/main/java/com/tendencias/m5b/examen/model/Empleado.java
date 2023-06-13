/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tendencias.m5b.examen.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.Date;
import lombok.Data;

/**
 *
 * @author lilis
 */
 @Data
@Entity
public class Empleado {
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleado")
    private int id;
    @Size( max = 45, message = "El usuario debe tener entre 3 y 10 caracteres")
    @NotBlank(message = " no puede estar en blanco")
    @Column(name = "nombre")
    private String nombre;
    @Size( max = 45, message = "El usuario debe tener entre 3 y 10 caracteres")
    @NotBlank(message = " no puede estar en blanco")
    @Column(name = "apellido")
    private String  apellido;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "direccion")
    private String  direccion;
    @Column(name = "fecha_nac")
    @Temporal(TemporalType.DATE)
    private Date  fecha_nac;
    @Column(name = "observacion")
    private String obeservacion;
    @Column(name = "dias_trabajo")
     private int dias_trabajo;
    @Column(name = "sueldo")
     private double sueldo ;
      
    public double CalcularSueldo(){
        double calculos= 15 *dias_trabajo;
       return calculos;
    }
    
}
