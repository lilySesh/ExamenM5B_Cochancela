/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tendencias.m5b.examen.repository;

import com.tendencias.m5b.examen.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author lilis
 */
public interface EmpleadoRespository extends JpaRepository<Empleado, Integer>{
     @Query(value = "Select * from empleado u where u.nombre = :nombre", nativeQuery = true)
    public Empleado buscarEmpleado(String nombre);
    
}
