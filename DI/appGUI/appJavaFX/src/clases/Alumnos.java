/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.ArrayList;

/**
 *
 * @author a18zemedufc
 */
class Alumnos extends Modulos /*implements Cursos*/{
    
    private int idA;
    private String nombreA;
    private int edad;
    
    public Alumnos(int id, String nombre, ArrayList<Modulos> modulos) {
        super(id, nombre, modulos);
    }

    public Alumnos(int idA, String nombreA, int edad, int id, String nombre, ArrayList<Modulos> modulos) {
        super(id, nombre, modulos);
        this.idA = idA;
        this.nombreA = nombreA;
        this.edad = edad;
    }

    public int getIdA() {
        return idA;
    }

    public void setIdA(int idA) {
        this.idA = idA;
    }

    public String getNombreA() {
        return nombreA;
    }

    public void setNombreA(String nombreA) {
        this.nombreA = nombreA;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    
    
    
}
