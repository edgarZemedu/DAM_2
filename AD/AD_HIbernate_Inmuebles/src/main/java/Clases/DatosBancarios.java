/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author A C E R
 */
@Entity
@Table (name = "datosBancarios")
public class DatosBancarios implements Serializable{
        
    @Id //pk
    @GeneratedValue(strategy = GenerationType.IDENTITY)//autoincremental
    @Column (name = "id")
    private int id;
        
    @Column (name = "numCuenta")
    private String numCuenta;
    
    @Column (name = "nombreBanco")
    private String nombreBanco;

    @OneToOne
    @JoinColumn (name = "idPropietario")
    private Propietario propietario;
    
    public DatosBancarios() {
    }

    public DatosBancarios(String numCuenta, String nombreBanco,Propietario propietario) {
        this.numCuenta = numCuenta;
        this.nombreBanco = nombreBanco;
        this.propietario = propietario;
    }

    public int getId() {
        return id;
    }
      
    public String getNumCuenta() {
        return numCuenta;
    }
    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    public String getNombreBanco() {
        return nombreBanco;
    }
    public void setNombreBanco(String nombreBanco) {
        this.nombreBanco = nombreBanco;
    }

    public Propietario getIdPropietario() {
        return propietario;
    }
    public void setIdPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    @Override
    public String toString() {
        return "DatosBancarios{" + "numCuenta=" + numCuenta + ", nombreBanco=" + nombreBanco + '}';
    }
    
        
    
}
