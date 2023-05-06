/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.practica9;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class controller {

    @Autowired
    private RepositoryEmpleado repositoryEmpleado;

    @GetMapping("/msg")
    public String holamundo(){
        return "Hola mundo";
    }
    
    @GetMapping("/{id}")
    public Empleado obtenerEmpleado(@PathVariable("id") long id) {
        Optional<Empleado> optionalEmpleado = repositoryEmpleado.findById(id);
        if (optionalEmpleado.isPresent()) {
            Empleado empleado = optionalEmpleado.get();
            return empleado;
        } else {
            return null;
        }
    }

    @GetMapping
    public List<Empleado> obtenerTodosLosEmpleados() {
        List<Empleado> empleados = (List<Empleado>) repositoryEmpleado.findAll();

        return empleados;
    }

    @PostMapping
    public Empleado crearEmpleado(@RequestBody DTOEmpleado empleadoDTO) {
        Empleado empleado = new Empleado();
        empleado.setNombre(empleadoDTO.getNombre());
        empleado.setDireccion(empleadoDTO.getDireccion());
        empleado.setTelefono(empleadoDTO.getTelefono());

        Empleado empleadoNuevo = repositoryEmpleado.save(empleado);

        return empleadoNuevo;
    }

    @PutMapping("/{id}")
    public Empleado actualizarEmpleado(@PathVariable("id") Long id, @RequestBody DTOEmpleado empleadoDTO) {
        Optional<Empleado> optionalEmpleado = repositoryEmpleado.findById(id);
        if (optionalEmpleado.isPresent()) {
            Empleado empleado = optionalEmpleado.get();
            empleado.setNombre(empleadoDTO.getNombre());
            empleado.setDireccion(empleadoDTO.getDireccion());
            empleado.setTelefono(empleadoDTO.getTelefono());

            Empleado empleadoActualizado = repositoryEmpleado.save(empleado);

            return empleadoActualizado;
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void eliminarEmpleado(@PathVariable("id") Long id) {
        repositoryEmpleado.deleteById(id);
    }
    
}
