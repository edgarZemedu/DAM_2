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
@Table(name = "inquilinos")
public class Inquilinos implements Serializable {
    
    @Id //pk
    @GeneratedValue(strategy = GenerationType.IDENTITY)//autoincremental
    private int id;
    @Column(name = "nombre")
    private String numCuenta;
    @Column(name = "dni")
    private String dni;
    
    @OneToOne
    @JoinColumn(name = "id_Inmueble")
    private Inmueble inmueble;

    public Inquilinos() {
    }

    public Inquilinos(String numCuenta, String dni, Inmueble inmueble) {
        this.numCuenta = numCuenta;
        this.dni = dni;
        this.inmueble = inmueble;
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Inmueble getInmueble() {
        return inmueble;
    }

    public void setInmueble(Inmueble inmueble) {
        this.inmueble = inmueble;
    }

    @Override
    public String toString() {
        return "Inquilinos{" + "numCuenta=" + numCuenta + ", dni=" + dni + ", inmueble=" + inmueble + '}';
    }
    
}
