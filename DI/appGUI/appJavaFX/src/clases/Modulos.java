/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.List;

/**
 *
 * @author a18zemedufc
 */
public class Modulos /*extends Cursos*/ {
    
    private String nombreM;    
    private List<Alumnos> alumnos;
    
    public Modulos(){        
    }
    
    public Modulos(String nombreM,List<Alumnos> alumnos) {
        //super();
        this.nombreM = nombreM;
        this.alumnos = alumnos;
    }    

    public String getNombreM() {
        return nombreM;
    }

    public void setNombreM(String nombreM) {
        this.nombreM = nombreM;
    }

    public List<Alumnos> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumnos> alumnos) {
        this.alumnos = alumnos;
    }
    
    
}
