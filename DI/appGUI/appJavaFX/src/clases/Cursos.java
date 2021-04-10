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

    private String nombreC;
    private ArrayList<Modulos> modulos;
    
    public Cursos(){
        
    }
    
    public Cursos(String nombreC, ArrayList<Modulos> modulos) {
        this.nombreC = nombreC;
        this.modulos = modulos;
    }

    public String getNombre() {
        return nombreC;
    }

    public void setNombre(String nombre) {
        this.nombreC = nombre;
    }

    public ArrayList<Modulos> getModulos() {
        return modulos;
    }

    public void setModulos(ArrayList<Modulos> modulos) {
        this.modulos = modulos;
    }

}
