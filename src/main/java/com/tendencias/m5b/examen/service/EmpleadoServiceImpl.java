/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tendencias.m5b.examen.service;

import com.tendencias.m5b.examen.model.Empleado;
import com.tendencias.m5b.examen.repository.EmpleadoRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author lilis
 */
@Service
public class EmpleadoServiceImpl extends GenericServiceImpl<Empleado, Integer> implements GenericService<Empleado, Integer> {
     
     @Autowired
    EmpleadoRespository empleadoRepository;
    @Override
    public CrudRepository<Empleado, Integer> getDao() {
        
         return empleadoRepository;
        
    }
    
}
