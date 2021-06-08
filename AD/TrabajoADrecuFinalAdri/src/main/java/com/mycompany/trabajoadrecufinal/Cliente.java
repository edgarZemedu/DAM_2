package com.mycompany.trabajoadrecufinal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;


@Entity
@Table (name = "clientes")
public class Cliente implements Serializable{
    
    @Id //pk
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_cliente")
    private int id_cliente;
    
    @Column(name = "nombre", length = 24, nullable = false)
    private String nombre;
    
    @Column(name = "nif", length = 15, nullable = false)
    private String nif;
    
    @Column(name = "correoe", length = 100, nullable = false)
    private String correoe;
    
    
    @OneToMany (mappedBy = "id_cliente")   
    private List<Cliente> clientes = new ArrayList<Cliente>();
    

    public Cliente() {}
    
    public Cliente(String nombre, String nif, String correoe) {
        this.nombre = nombre;
        this.nif = nif;
        this.correoe = correoe;
    }

    public int getId() {
        return id_cliente;
    }

    public void setId(int id) {
        this.id_cliente = id;
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

    public String getCorreoe() {
        return correoe;
    }

    public void setCorreoe(String correoe) {
        this.correoe = correoe;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }
    
}
