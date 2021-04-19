/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author a18zemedufc
 */
public class Alumnos extends Modulos{

    private String nombreA, apellidos;
    private int edad;
    
    public Alumnos(){}
    
    public Alumnos(String nombreA, String apellidos, int edad) {
       // super();
        this.apellidos = apellidos;
        this.nombreA = nombreA;
        this.edad = edad;
    }

    public String getNombreA() {
        return nombreA;
    }

    public void setNombreA(String nombreA) {
        this.nombreA = nombreA;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

}
