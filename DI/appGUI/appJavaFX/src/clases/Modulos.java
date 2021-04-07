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
class Modulos extends Cursos {
    private int idM;
    private String nombreM;
    private ArrayList<Alumnos> alumnos;

    public Modulos(int id, String nombre, ArrayList<Modulos> modulos) {
        super(id, nombre, modulos);
    }    
    
    
}
