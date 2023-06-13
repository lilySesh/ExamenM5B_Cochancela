/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tendencias.m5b.examen.controller;

import com.tendencias.m5b.examen.model.Empleado;
import com.tendencias.m5b.examen.repository.EmpleadoRespository;
import com.tendencias.m5b.examen.service.EmpleadoServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author lilis
 */
@RestController
@RequestMapping("/empleado")
public class EmpleadoController {
     @Autowired
     EmpleadoServiceImpl empleadoService;
     @Operation(summary = "Se obtiene la lista de Empleados")
    @GetMapping("/listar")
    public ResponseEntity<List<Empleado>> listaEmpleados() {
        return new ResponseEntity<>( empleadoService.findByAll(), HttpStatus.OK);
    }

    @Operation(summary = "Debe enviar los campos del Empleado")
    @PostMapping("/crear")
    public ResponseEntity<Empleado> creaEmpleado(@RequestBody Empleado em) {
        return new ResponseEntity<>( empleadoService.save(em), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Empleado> actualizarEmpleado(@PathVariable Integer id, @RequestBody Empleado em) {
        Empleado empleado = empleadoService.findById(id);
        if (empleado != null) {
            try {
                   //condicion si el sueldo es mayor a 
                   empleado.setNombre(em.getNombre());
                   empleado.setApellido(em.getApellido());
                   empleado.setTelefono(em.getTelefono());
                   empleado.setFecha_nac(em.getFecha_nac());
                   empleado.setDireccion(em.getDireccion());
                   empleado.setObeservacion(em.getObeservacion());
                   empleado.setDias_trabajo(em.getDias_trabajo());
                if (empleado.getDias_trabajo()>= 20 ) {
                    double bono= empleado.CalcularSueldo()*0.02;
                    empleado.setSueldo( bono);
                   
                    return new ResponseEntity<>(empleadoService.save(empleado), HttpStatus.CREATED);
                } else {
                    if(empleado.getDias_trabajo() >= 30){
                        double bono= empleado.CalcularSueldo()*0.05;
                        empleado.setSueldo( bono);
                        return new ResponseEntity<>(empleadoService.save(empleado), HttpStatus.CREATED);
                    }
                      
                      
                     empleado.setSueldo(em.CalcularSueldo());
                    return new ResponseEntity<>(empleadoService.save(empleado), HttpStatus.CREATED);
                }
                   
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Empleado> elimiarEmpleado(@PathVariable Integer id) {
         empleadoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
