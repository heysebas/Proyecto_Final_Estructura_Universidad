/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import util.Lista;

/**
 *
 * @author sebas
 */
public class Universidad {

    private Lista<Estudiante> listStudents;

    public Universidad() {
        this.listStudents = new Lista<>();
    }

    /**
     *
     * @param code
     * @return en este método estamos buscando en las listas de estudiantes si
     * ya hay un codigo igual de algun estudiante
     */
    public Estudiante searchStudents(String code) {
        for (int i = 0; i < listStudents.getTamano(); i++) {
            Estudiante student = listStudents.obtener(i);
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
    public boolean addStudent(Estudiante student) {
        Estudiante aux = searchStudents(student.getCode());
        if (aux == null) {
            listStudents.agregar(student);
            return true;
        }
        return false;
    }
    
    
    /**
     * con este método lo que hacemos es buscar al estudiante que ya se encuentra
     * registrada en la lista de estudiantes y modificar los dato que si son
     * editable lo que no son editable,por ejemplo el codigo ya que es un
     * dato unico y el documento
     *
     * @param estudiante
     * @return no retorna un verdadero si el esttudiante fue editada correctamente
     */
    public boolean editStudent(Estudiante student)  {
        Estudiante aux = searchStudents(student.getCode());

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
     * @return no retorna un verdadero si el estudiante fue eliminado correctamente
     */
    public boolean deleteStudent(String code)  {
        for (int i = 0; i < listStudents.getTamano(); i++) {
            if (listStudents != null && listStudents.obtener(i).getCode().equals(code)) {
                listStudents.obtener(i);
                return true;
            }
        }
        return false;
    }

}
