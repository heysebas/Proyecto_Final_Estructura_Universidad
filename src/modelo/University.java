/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import util.ArbolBinario;

import util.Nodo;

/**
 *
 * @author sebas
 */
public class University {

    private ArrayList<Student> listStudents;
    ArbolBinario<Student> arbol;

    public University() {
        this.listStudents = new ArrayList<>();
        this.arbol = new ArbolBinario<>();
    }
    
    
     public int listStudents() {
        return listStudents.size();
    }
     
      public Student student(int numero) {
        return listStudents.get(numero);
    }
     

    /**
     *
     * @param code
     * @return en este método estamos buscando en las listas de estudiantes si
     * ya hay un codigo igual de algun estudiante
     */
    public Student searchStudents(String code) {
        for (int i = 0; i < listStudents.size(); i++) {
            Student student = listStudents.get(i);
            if (student != null) {
                if (student.getCode().equals(code)) {
                    return student;
                }
            }
        }
        return null;
    }

    /**
     *
     * @param estudiante
     * @return en este método estamos agregando a un estudiante a la lista de
     * estudiantes
     */
    public boolean addStudent(Student student) {
        Student aux = searchStudents(student.getCode());
        if (aux == null) {
            listStudents.add(student);
            return true;
        }
        return false;
    }

//    public void addStudedentArbol(Student student) {
//        arbol.agregar(student);
////        System.out.println("si se guardo");
//    }

//    public void imprimirInprde() {
////        arbol.inorden();
//////        System.out.println("si se imprimio");
////    }

    /**
     * con este método lo que hacemos es buscar al estudiante que ya se
     * encuentra registrada en la lista de estudiantes y modificar los dato que
     * si son editable lo que no son editable,por ejemplo el codigo ya que es un
     * dato unico y el documento
     *
     * @param estudiante
     * @return no retorna un verdadero si el esttudiante fue editada
     * correctamente
     */
    public boolean editStudent(Student student) {
        Student aux = searchStudents(student.getCode());

        if (aux != null) {
            aux.setName(student.getName());
            aux.setSurNames(student.getSurNames());
            aux.setSemester(student.getSemester());
            aux.setCareer(student.getCareer());
            aux.setAverage(student.getAverage());
            return true;
        }
        return false;
    }

    /**
     * con este mentodo lo que buscamos hacer es eliminar al estudiante de la
     * lista estudiantes
     *
     * @param code
     * @return no retorna un verdadero si el estudiante fue eliminado
     * correctamente
     */
    public boolean deleteStudent(String code) {
        for (int i = 0; i < listStudents.size(); i++) {
            if (listStudents != null && listStudents.get(i).getCode().equals(code)) {
                listStudents.remove(i);
                return true;
            }
        }
        return false;
    }

}
