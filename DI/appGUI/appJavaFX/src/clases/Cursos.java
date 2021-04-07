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
public class Cursos {
    
    private int id;
    private String nombre;
    private ArrayList<Modulos> modulos;

    public Cursos(int id, String nombre, ArrayList<Modulos> modulos) {
        this.id = id;
        this.nombre = nombre;
        this.modulos = modulos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Modulos> getModulos() {
        return modulos;
    }

    public void setModulos(ArrayList<Modulos> modulos) {
        this.modulos = modulos;
    }
    
    
    
}
