/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author sebas
 */
public class Estudiante {
    
    private String name;  //nombre del estudiante
    private String surNames; // apellidos del estudiante
    private String code; // codigo del estudiante
    private String document; // documento del estudiante
    private String semester; // semestre
    private String career; // carrera
    private double average; // promedio
    
    Estudiante  left; // izquierdo
    Estudiante right; // derecho

    public Estudiante() {
    }

    public Estudiante(String name, String surNames, String code, String document, String semester, String career, double average) {
        this.name = name;
        this.surNames = surNames;
        this.code = code;
        this.document = document;
        this.semester = semester;
        this.career = career;
        this.average = average;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurNames() {
        return surNames;
    }

    public void setSurNames(String surNames) {
        this.surNames = surNames;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

     @Override
    public String toString() {
        return "Estudiante{" +
                "nombres='" + name + '\'' +
                ", apellidos='" + surNames + '\'' +
                ", codigo=" + code +
                ", cedula='" + document + '\'' +
                ", semestre=" + semester +
                ", carrera='" + career + '\'' +
                ", promedio=" + average +
                '}';
    }
    
    
}
