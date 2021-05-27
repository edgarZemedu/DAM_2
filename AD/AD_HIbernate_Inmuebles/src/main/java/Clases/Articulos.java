/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author A C E R
 */
public class Articulos {
    private int id;
    private String nombre;
    private String tipo;
    private float precio;
    private int stock;

    public Articulos() {
    }

    public Articulos(int id, String nombre, String tipo, float precio, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.precio = precio;
        this.stock = stock;
    }

    public Articulos(String nombre, String tipo, float precio, int stock) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.precio = precio;
        this.stock = stock;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "-> Articulos{" + ", nombre = " + nombre + ", tipo = " + tipo + ", precio = " + precio + ", stock = " + stock + '}';
    }
    
    
}
