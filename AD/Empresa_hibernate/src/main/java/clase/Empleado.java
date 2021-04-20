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
@Table(name = "empleados")
public class Empleado implements Serializable{

    @Id //pk
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "emNombre")
    private String nombre;
    @Column(name = "emApellidos")
    private String apellidos;
    @Column(name = "emSueldo")
    private Double sueldo;
//    @OneToOne(mappedBy = "empleado", cascade = CascadeType.ALL)
//    private Direccion direccion;

    Empleado() {
    }

    public Empleado( String nombre, String apellidos, Double sueldo/* Direccion direccion*/) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.sueldo = sueldo;
        //this.direccion = direccion;
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

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Double getSueldo() {
        return sueldo;
    }

    public void setSueldo(Double sueldo) {
        this.sueldo = sueldo;
    }

//    public Direccion getDireccion() {
//        return direccion;
//    }
//
//    public void setDireccion(Direccion direccion) {
//        this.direccion = direccion;
//    }

    @Override
    public String toString() {
        return "Empleado{" + "id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", sueldo=" + sueldo + '}';
    }
    

}
