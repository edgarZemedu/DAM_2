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
public class Modulos extends Cursos {
    
    private String nombreM;    
    private ArrayList<Alumnos> alumnos;
    
    public Modulos(){        
    }
    
    public Modulos(String nombreM,ArrayList<Alumnos> alumnos) {
        super();
        this.nombreM = nombreM;        
    }    

    public String getNombreM() {
        return nombreM;
    }

    public void setNombreM(String nombreM) {
        this.nombreM = nombreM;
    }

    public ArrayList<Alumnos> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(ArrayList<Alumnos> alumnos) {
        this.alumnos = alumnos;
    }
    
    
}
