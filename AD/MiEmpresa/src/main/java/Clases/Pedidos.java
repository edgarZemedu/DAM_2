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
@Table(name = "pedidos")
public class Pedidos implements Serializable {

    @Id //pk
    @GeneratedValue(strategy = GenerationType.IDENTITY)//autoincremental
    private int codigoPedido;
    @Column(name = "unidades", nullable = false)
    private int unidades;
    @Column(name = "direccion", nullable = false)
    private String direccion;
    @Column(name = "fecha", nullable = false)
    private String fecha;
    @Column(name = "estado", nullable = false)
    private int estado;

    @ManyToOne
    @JoinColumn(name = "idCliente", referencedColumnName = "idCliente", insertable = false, updatable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "idProducto", referencedColumnName = "idCliente", insertable = false, updatable = false)
    private Producto producto;

    public Pedidos() {
    }

    public Pedidos(int codigoPedido, int unidades, String direccion, String fecha, int estado, Cliente cliente, Producto producto) {
        this.codigoPedido = codigoPedido;
        this.unidades = unidades;
        this.direccion = direccion;
        this.fecha = fecha;
        this.estado = estado;
        this.cliente = cliente;
        this.producto = producto;
    }

    public Pedidos(int unidades, String direccion, String fecha, int estado, Cliente cliente, Producto producto) {
        this.unidades = unidades;
        this.direccion = direccion;
        this.fecha = fecha;
        this.estado = estado;
        this.cliente = cliente;
        this.producto = producto;
    }

    

    @Override
    public String toString() {
        return "Inmueble{" + "codigoPedido=" + codigoPedido + ", unidades=" + unidades + ", direccion=" + direccion + ", fecha=" + fecha + ", estado=" + estado + ", cliente=" + cliente + ", producto=" + producto + '}';
    }

    public int getCodigoPedido() {
        return codigoPedido;
    }

    public void setCodigoPedido(int codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
    

    
}
