/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.practica9.controller;

import org.uv.practica9.controller.DTOEmpleado;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
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
 * @author btoarriola
 */
@RestController
@RequestMapping("/api")
public class EmpleadoController {
    private static List<DTOEmpleado> listemp = new ArrayList<DTOEmpleado>();
    
    @Autowired
    private RepositoryEmpleado repositoryEmpleado;
    
    @GetMapping("/msg")
    public String holaMundo() {
        return "hola mundo";
    }
    
   @GetMapping("/empleado/{id}")
    public DTOEmpleado obtenerEmpleado(@PathVariable("id") long id){
        DTOEmpleado emp = null;
        for (DTOEmpleado emp1:listemp){
            if (emp1.getClave()==id){
                emp=emp1;
            }
        }
       return emp;
    }
    
     @GetMapping("/empleado")
     public List<DTOEmpleado> obtenerTodosLosEmpleados(){
        return listemp;
     }
    
    @PostMapping("/empleado")
    public DTOEmpleado crearEmpleado(@RequestBody DTOEmpleado empleadoDTO){
        Empleado empleadoPojo=new Empleado();
        
        empleadoPojo.setNombre(empleadoDTO.getNombre());
        empleadoPojo.setDireccion(empleadoDTO.getDireccion());
        empleadoPojo.setTelefono(empleadoDTO.getTelefono());
        
        Empleado empleadoPojoNew =repositoryEmpleado.save(empleadoPojo);
        
        DTOEmpleado empleadoDTONew=new DTOEmpleado();
        
        empleadoDTONew.setClave(empleadoPojoNew.getClave());
        empleadoDTONew.setNombre(empleadoPojoNew.getNombre());
        empleadoDTONew.setDireccion(empleadoPojoNew.getDireccion());
        empleadoDTONew.setTelefono(empleadoPojoNew.getTelefono());
        
        return empleadoDTONew;
    }
    
    @DeleteMapping("/empleado/{id}")
    public void borrarEmpleado(@PathVariable("id") Long id){
        //borrar
        return;
    }
    
    @PutMapping("/empleado/{id}")
    public DTOEmpleado modificarEmpleado(@PathVariable("id") Long id, @RequestBody DTOEmpleado empleado){
        //mapeo
        //buscar id
        //update
        return empleado;
    }
}
