/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
<<<<<<< HEAD
=======
import javax.persistence.OneToMany;
>>>>>>> 8813502d5264ccccc41e237b55deaf62efe04d74
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
<<<<<<< HEAD
 * @author a18zemedufc
 */
@Entity
@Table(name = "datosBancarios")
public class DatosBancarios implements Serializable {

    @Id //pk
    @GeneratedValue(strategy = GenerationType.IDENTITY)//autoincremental
    private int id;
    @Column(name = "numCuenta", length = 9, nullable = false)
    private String numCuenta;
    @Column(name = "nombreBanco", length = 15, nullable = false)
    private String nombreBanco;
    
    @OneToOne
    @JoinColumn(name = "idPropietario")
    private Propietario Propietario;

    public DatosBancarios() {
    }

    public DatosBancarios(int id, String numCuenta, String nombreBanco, Propietario Propietario) {
        this.id = id;
        this.numCuenta = numCuenta;
        this.nombreBanco = nombreBanco;
        this.Propietario = Propietario;
    }
    //sin el id
    public DatosBancarios(String numCuenta, String nombreBanco, Propietario Propietario) {
        this.numCuenta = numCuenta;
        this.nombreBanco = nombreBanco;
        this.Propietario = Propietario;
=======
 * @author A C E R
 */
@Entity
@Table (name = "datosBancarios")
public class DatosBancarios implements Serializable{
        
    @Id //pk
    @GeneratedValue(strategy = GenerationType.IDENTITY)//autoincremental
    @Column (name = "id")
    private int id;
        
    @Column (name = "numCuenta")
    private String numCuenta;
    
    @Column (name = "nombreBanco")
    private String nombreBanco;

    @OneToOne
    @JoinColumn (name = "idPropietario")
    private Propietario propietario;
    
    public DatosBancarios() {
    }

    public DatosBancarios(String numCuenta, String nombreBanco,Propietario propietario) {
        this.numCuenta = numCuenta;
        this.nombreBanco = nombreBanco;
        this.propietario = propietario;
>>>>>>> 8813502d5264ccccc41e237b55deaf62efe04d74
    }

    public int getId() {
        return id;
    }
<<<<<<< HEAD

    public void setId(int id) {
        this.id = id;
    }

    public String getNumCuenta() {
        return numCuenta;
    }

=======
      
    public String getNumCuenta() {
        return numCuenta;
    }
>>>>>>> 8813502d5264ccccc41e237b55deaf62efe04d74
    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    public String getNombreBanco() {
        return nombreBanco;
    }
<<<<<<< HEAD

=======
>>>>>>> 8813502d5264ccccc41e237b55deaf62efe04d74
    public void setNombreBanco(String nombreBanco) {
        this.nombreBanco = nombreBanco;
    }

<<<<<<< HEAD
    public Propietario getPropietario() {
        return Propietario;
    }

    public void setPropietario(Propietario Propietario) {
        this.Propietario = Propietario;
=======
    public Propietario getIdPropietario() {
        return propietario;
    }
    public void setIdPropietario(Propietario propietario) {
        this.propietario = propietario;
>>>>>>> 8813502d5264ccccc41e237b55deaf62efe04d74
    }

    @Override
    public String toString() {
<<<<<<< HEAD
        return "DatosBancarios{" + "id=" + id + ", numCuenta=" + numCuenta + ", nombreBanco=" + nombreBanco + ", Propietario=" + Propietario + '}';
    }
    
=======
        return "DatosBancarios{" + "numCuenta=" + numCuenta + ", nombreBanco=" + nombreBanco + '}';
    }
    
        
>>>>>>> 8813502d5264ccccc41e237b55deaf62efe04d74
    
}
