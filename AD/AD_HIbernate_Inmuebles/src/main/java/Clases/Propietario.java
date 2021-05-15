/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author A C E R
 */
@Entity
@Table(name = "propietarios")
public class Propietario implements Serializable {

    @Id //pk
    @GeneratedValue(strategy = GenerationType.IDENTITY)//autoincremental
    private int id;
    @Column(name = "prDNI", length = 9, nullable = false)
    private String dni;
    @Column(name = "prNombre", length = 15, nullable = false)
    private String nombre;
    @Column(name = "prApellidos", length = 40, nullable = false)
    private String apellidos;
    @Column(name = "prDireccion", length = 50, nullable = false)
    private String direccion;
    @Column(name = "prTelefono", length = 9, nullable = false)
    private String telefono;

    //importantes
    @OneToMany(mappedBy = "propietarios")
    private List<Inmueble> inmuebles = new ArrayList<Inmueble>();

    public List<Inmueble> getInmuebles() {
        return inmuebles;
    }
    public void setInmuebles(List<Inmueble> inmuebles) {
        this.inmuebles = inmuebles;
    }

    public Propietario() {
    }

    public Propietario(String dni, String nombre, String apellidos, String direccion, String telefono) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.telefono = telefono;
    }
    //contructor con id
    public Propietario(int id, String dni, String nombre, String apellidos, String direccion, String telefono) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.telefono = telefono;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDNI() {
        return dni;
    }

    public void setDNI(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Propietario{" + "id=" + id + ", dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + ", direccion=" + direccion + ", telefono=" + telefono + '}';
    }

}
