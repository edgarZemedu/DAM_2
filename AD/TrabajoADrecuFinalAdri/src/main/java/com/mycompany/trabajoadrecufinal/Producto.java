package com.mycompany.trabajoadrecufinal;

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


@Entity
@Table (name = "productos")
public class Producto implements Serializable{
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_producto")
    private int id_producto;
   
    @Column(name = "nombre", length = 50, nullable = false)
    private String nombre;
   
    @Column(name = "stock", length = 15, nullable = false)
    private int stock;
    
    
    @OneToMany(mappedBy ="id_producto")
    private List<Pedido> pedidos = new ArrayList<Pedido>();

    
    public Producto() {}

    public Producto(int id, String nombre, int stock) {
        this.id_producto = id;
        this.nombre = nombre;
        this.stock = stock;
    }
    
    public Producto( String nombre, int stock) {
       
        this.nombre = nombre;
        this.stock = stock;
    }
    
 

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }
    
    
    
}
