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
    @Column (name = "idCliente", length = 11, nullable = false)
    private int id_cliente;    
    @Column (name = "idProducto", length = 11, nullable = false)
    private int id_producto;

    @ManyToOne
    @JoinColumn(name = "idCliente", referencedColumnName = "id", insertable = false, updatable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "idProducto", referencedColumnName = "codigoProducto", insertable = false, updatable = false)
    private Producto producto;

    public Pedidos() {
    }

    public Pedidos(int codigoPedido, int unidades, String direccion, String fecha, int estado, int idCliente, int idProducto) {
        this.codigoPedido = codigoPedido;
        this.unidades = unidades;
        this.direccion = direccion;
        this.fecha = fecha;
        this.estado = estado;
        this.id_cliente = idCliente;
        this.id_producto = idProducto;
    }

    public Pedidos(int unidades, String direccion, String fecha, int estado, int idCliente, int idProducto) {
        this.unidades = unidades;
        this.direccion = direccion;
        this.fecha = fecha;
        this.estado = estado;
        this.id_cliente = idCliente;
        this.id_producto = idProducto;
    }

    
    
    @Override
    public String toString() {
        return "Pedido{" + "codigoPedido=" + codigoPedido + ", unidades=" + unidades + ", direccion=" + direccion + ", fecha=" + fecha + ", estado=" + estado + '}';
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

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
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
