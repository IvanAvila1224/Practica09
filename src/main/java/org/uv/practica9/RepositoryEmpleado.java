/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.uv.practica9;

import org.springframework.data.jpa.repository.JpaRepository;



public interface RepositoryEmpleado extends JpaRepository<Empleado, Long>  {
    
}
