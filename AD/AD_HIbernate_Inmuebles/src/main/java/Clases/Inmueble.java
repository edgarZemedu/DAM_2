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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author a18zemedufc
 */
@Entity
@Table (name = "inmuebles")
public class Inmueble implements Serializable{
    @Id //pk
    @GeneratedValue(strategy = GenerationType.IDENTITY)//autoincremental
    private int id;
    @Column(name = "inDireccion")
    private String direccion;
    @Column(name = "idCodZona")
    private char codigoPostal;
    @Column(name = "inEstado")
    private char estado;
    
    @ManyToOne
    @JoinColumn(name = "inPropietario")
    private Propietario propietario;

    public Inmueble() {
    }

    public Inmueble(int id, String direccion, char codigoPostal, char estado, Propietario propietario) {
        this.id = id;
        this.direccion = direccion;
        this.codigoPostal = codigoPostal;
        this.estado = estado;
        this.propietario = propietario;
    }
    //constructor sin id
    public Inmueble(String direccion, char codigoPostal, char estado, Propietario propietario) {
        this.direccion = direccion;
        this.codigoPostal = codigoPostal;
        this.estado = estado;
        this.propietario = propietario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public char getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(char codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    @Override
    public String toString() {
        return "Inmueble{" + "id=" + id + ", direccion=" + direccion + ", codigoPostal=" + codigoPostal + ", estado=" + estado + ", propietario=" + propietario + '}';
    }
    
    
}
