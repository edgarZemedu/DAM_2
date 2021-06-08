package com.mycompany.trabajoadrecufinal;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table (name = "pedidos")
public class Pedido implements Serializable{
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private int id;
    
    @Column (name = "id_producto", length = 11, nullable = false)
    private int id_producto;
    
    @Column (name = "uni_pedido", length = 11, nullable = false)
    private int unipedido;
    
    @Column (name = "id_cliente", length = 11, nullable = false)
    private int id_cliente;
    
    @Column (name = "direccion", length = 9, nullable = false)
    private String direccion;
    
    @Column (name = "fecha", length = 9, nullable = false)
    private String fecha;
    
    @Column (name = "estado", length = 9, nullable = false)
    private int estado;
    
    
    @ManyToOne 
    @JoinColumn (name="id_producto" ,referencedColumnName = "id_producto", insertable = false, updatable = false)
    private Producto producto;
    
    @ManyToOne 
    @JoinColumn (name="id_cliente", referencedColumnName ="id_cliente", insertable = false, updatable = false)
    private Cliente cliente;
    
//    @ManyToOne(targetEntity = Producto.class, cascade = { CascadeType.ALL })  
//    
//    @JoinTable(name = "pedidos",   
//    joinColumns = { @JoinColumn(name = "id") },   
//    inverseJoinColumns = { @JoinColumn(name = "id_producto") }
//    )  


    public Pedido() {}

    public Pedido(int id_producto, int unipedido, int id_cliente,
            String direccion, String fecha, int estado) {
        
        this.id_producto = id_producto;
        this.unipedido = unipedido;
        this.id_cliente = id_cliente;
        this.direccion = direccion;
        this.fecha = fecha;
        this.estado = estado;
    }
    
    public Pedido(int unipedido,String direccion, String fecha, int estado) {
        
        this.unipedido = unipedido;
        this.direccion = direccion;
        this.fecha = fecha;
        this.estado = estado;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getUnipedido() {
        return unipedido;
    }

    public void setUnipedido(int unipedido) {
        this.unipedido = unipedido;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
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
    
}
