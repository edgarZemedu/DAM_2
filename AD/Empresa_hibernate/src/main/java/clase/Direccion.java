/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clase;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author a18zemedufc
 */
@Entity
@Table (name = "direcciones")
public class Direccion implements Serializable {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "ciudad")
    private String ciudad;
    @OneToOne
    @JoinColumn(name = "idEmpleado")
    private Empleado empleado;

    Direccion() {
    }

    public Direccion(String direccion, String ciudad/*, Empleado empleado*/) {
        this.direccion = direccion;
        this.ciudad = ciudad;
        //this.empleado = empleado;
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

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    @Override
    public String toString() {
        return "Direccion{" + "id=" + id + ", direccion=" + direccion + ", ciudad=" + ciudad + '}';
    }
    
}
