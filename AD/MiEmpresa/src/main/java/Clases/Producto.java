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
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author a18zemedufc
 */
@Entity
@Table(name = "productos")
public class Producto implements Serializable {

    @Id //pk
    @GeneratedValue(strategy = GenerationType.IDENTITY)//autoincremental
    private int codigoProducto;
    @Column(name = "nombre", length = 15, nullable = false)
    private String nombre;
    @Column(name = "stock", length = 4, nullable = false)
    private int stock;

    public Producto() {
    }

    public Producto(int codigoProducto, String nombre, int stock) {
        this.codigoProducto = codigoProducto;
        this.nombre = nombre;
        this.stock = stock;
    }

    public Producto(String nombre, int stock) {
        this.nombre = nombre;
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Producto{" + "codigoProducto=" + codigoProducto + ", nombre=" + nombre + ", stock=" + stock + '}';
    }

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
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
    
    
    
}
