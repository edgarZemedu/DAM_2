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
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author a18zemedufc
 */
@Entity
@Table(name = "datosBancarios")
public class DatosBancarios implements Serializable {

    @Id //pk
    @GeneratedValue(strategy = GenerationType.IDENTITY)//autoincremental
    private int id;
    @Column(name = "numCuenta", length = 9, nullable = false)
    private String numCuenta;
    @Column(name = "nombreBanco", length = 15, nullable = false)
    private String nombreBanco;
    
    @OneToOne
    @JoinColumn(name = "idPropietario")
    private Propietario Propietario;

    public DatosBancarios() {
    }

    public DatosBancarios(int id, String numCuenta, String nombreBanco, Propietario Propietario) {
        this.id = id;
        this.numCuenta = numCuenta;
        this.nombreBanco = nombreBanco;
        this.Propietario = Propietario;
    }
    //sin el id
    public DatosBancarios(String numCuenta, String nombreBanco, Propietario Propietario) {
        this.numCuenta = numCuenta;
        this.nombreBanco = nombreBanco;
        this.Propietario = Propietario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Propietario getPropietario() {
        return Propietario;
    }

    public void setPropietario(Propietario Propietario) {
        this.Propietario = Propietario;
    }

    @Override
    public String toString() {
        return "DatosBancarios{" + "id=" + id + ", numCuenta=" + numCuenta + ", nombreBanco=" + nombreBanco + ", Propietario=" + Propietario + '}';
    }
    
    
}
