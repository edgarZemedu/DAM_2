/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author a18zemedufc
 */
public class Cursos {

    private String nombreC;
    private List<Modulos> modulos;
    
    public Cursos(){
        
    }
    
    public Cursos(String nombreC, List<Modulos> modulos) {
        this.nombreC = nombreC;
        this.modulos = modulos;
    }

    public String getNombreC() {
        return nombreC;
    }

    public void setNombreC(String nombreC) {
        this.nombreC = nombreC;
    }

    public List<Modulos> getModulos() {
        return modulos;
    }

    public void setModulos(List<Modulos> modulos) {
        this.modulos = modulos;
    }
    //para añadir
    public void addModulos(Modulos m){
        this.modulos.add(m);
    }
    
}
