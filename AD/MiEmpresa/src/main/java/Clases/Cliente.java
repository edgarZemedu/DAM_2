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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author A C E R
 */
@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {

    @Id //pk
    @GeneratedValue(strategy = GenerationType.IDENTITY)//autoincremental
    private int id;
    @Column(name = "nombre", length = 15, nullable = false)
    private String nombre;
    @Column(name = "NIF", length = 40, nullable = false)
    private String nif;
    @Column(name = "correo", length = 50, nullable = false)
    private String correo;

    public Cliente() {
    }

    public Cliente(int id, String nombre, String nif, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.nif = nif;
        this.correo = correo;
    }

    public Cliente(String nombre, String nif, String correo) {
        this.nombre = nombre;
        this.nif = nif;
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nombre=" + nombre + ", nif=" + nif + ", correo=" + correo + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    
    
}
