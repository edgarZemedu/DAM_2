/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clase;

/**
 *
 * @author a18zemedufc
 */
public class Modulo {
    private int id;
    private String asignatura;
    private String descripcion;
    private int horas;

    public Modulo() {
    }

    public Modulo(int id, String asignatura, String descripcion, int horas) {
        this.id = id;
        this.asignatura = asignatura;
        this.descripcion = descripcion;
        this.horas = horas;
    }
    //SIN EL ID
    public Modulo(String asignatura, String descripcion, int horas) {
        this.asignatura = asignatura;
        this.descripcion = descripcion;
        this.horas = horas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }
        
}
