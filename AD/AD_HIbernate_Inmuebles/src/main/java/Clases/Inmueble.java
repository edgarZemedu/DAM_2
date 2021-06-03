/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.Serializable;
import java.util.Objects;
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
@Table(name = "inmuebles")
public class Inmueble implements Serializable {

    @Id //pk
    @GeneratedValue(strategy = GenerationType.IDENTITY)//autoincremental
    private int id;
    @Column(name = "inDireccion")
    private String direccion;
    @Column(name = "inCodZona")
    private int codigoPostal;
    @Column(name = "inEstado")
    private String estado;

    @ManyToOne
    @JoinColumn(name = "inPropietario", referencedColumnName = "id", insertable = false, updatable = false)
    private Propietario propietario;

    public Inmueble() {
    }

    public Inmueble(int id, String direccion, int codigoPostal, String estado, Propietario propietario) {
        this.id = id;
        this.direccion = direccion;
        this.codigoPostal = codigoPostal;
        this.estado = estado;
        this.propietario = propietario;
    }

    //constructor sin id
    public Inmueble(String direccion, int codigoPostal, String estado, Propietario propietario) {
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

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
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
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.id);
        hash = 17 * hash + Objects.hashCode(this.direccion);
        hash = 17 * hash + Objects.hashCode(this.codigoPostal);
        hash = 17 * hash + Objects.hashCode(this.estado);
        hash = 17 * hash + Objects.hashCode(this.propietario);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Inmueble other = (Inmueble) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.direccion, other.direccion)) {
            return false;
        }
        if (!Objects.equals(this.codigoPostal, other.codigoPostal)) {
            return false;
        }
        if (!Objects.equals(this.estado, other.estado)) {
            return false;
        }
        if (!Objects.equals(this.propietario, other.propietario)) {
            return false;
        }
        return true;
    }

}
