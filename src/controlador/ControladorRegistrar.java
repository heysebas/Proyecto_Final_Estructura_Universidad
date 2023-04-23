/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.Estudiante;
import modelo.Universidad;

/**
 *
 * @author sebas
 */
public class ControladorRegistrar {

    Universidad universidad;

    public ControladorRegistrar() {
        universidad = new Universidad();
    }

    //------------------------------------------------------Buscar Estudiante---------------------------------------------------------------------//
    public Estudiante searchStudents(String code) {
        return universidad.searchStudents(code);
    }

    //---------------------------------------------------------------------------------------------------------------------------------------------//
    //------------------------------------------------------agregar Estudiante---------------------------------------------------------------------//
    public boolean addStudent(Estudiante student) {
        return universidad.addStudent(student);
    }

    //---------------------------------------------------------------------------------------------------------------------------------------------//
    //------------------------------------------------------Editar Estudiante----------------------------------------------------------------------//
    public boolean editStudent(Estudiante student) {
        return universidad.editStudent(student);
    }

    //---------------------------------------------------------------------------------------------------------------------------------------------//
    //------------------------------------------------------Eliminar Estudiante--------------------------------------------------------------------//
       public boolean deleteStudent(String cedula) {
        return universidad.deleteStudent(cedula);
    }
}
