/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import javax.swing.JPanel;
import modelo.Student;
import modelo.University;
import util.SimuladorArbolBinario;

/**
 *
 * @author sebas
 */
public class ControladorRegistrar {
    
    University university;
    SimuladorArbolBinario simulador;
    
    public ControladorRegistrar() {
        university = new University();
        simulador = new SimuladorArbolBinario();
    }
    
    public int listaStudents() {
        return university.listStudents();
    }
    
    public Student student(int numero) {
        return university.student(numero);
    }

    //------------------------------------------------------Buscar Student---------------------------------------------------------------------//
    public Student searchStudents(String code) {
        return university.searchStudents(code);
    }

    //---------------------------------------------------------------------------------------------------------------------------------------------//
    //------------------------------------------------------agregar Student---------------------------------------------------------------------//
    public boolean addStudent(Student student) {
        return university.addStudent(student);
    }
    
    public void addStudedentArbol(Student student) {
//        university.addStudedentArbol(student);
    }

    //---------------------------------------------------------------------------------------------------------------------------------------------//
    //------------------------------------------------------Editar Student----------------------------------------------------------------------//
    public boolean editStudent(Student student) {
        return university.editStudent(student);
    }

    //---------------------------------------------------------------------------------------------------------------------------------------------//
    //------------------------------------------------------Eliminar Student--------------------------------------------------------------------//
    public boolean deleteStudent(String document) {
        return university.deleteStudent(document);
    }
    
    public void imprimirInprde() {
//         university.imprimirInprde();
    }

    //---------------------------------------------------------------------------------------------------------------------------------------------//
    //------------------------------------------------------simulador-----------------------------------------------------------------------------//
    public boolean insertar(Student student) {
        return simulador.insertar(student);
    }
    
    public String inOrden() {
        return simulador.inOrden();
    }
    
    public String preOrden() {
        return simulador.preOrden();
    }
    
    public String postOrden() {
        return simulador.postOrden();
    }
    
    public JPanel getDibujo() {
        return simulador.getDibujo();
    }
    
    public boolean eliminar(Student student) {
        return simulador.eliminar(student);
    }
}
