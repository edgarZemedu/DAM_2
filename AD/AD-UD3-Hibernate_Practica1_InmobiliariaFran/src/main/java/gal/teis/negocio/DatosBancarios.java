/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.negocio;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;

/**
 *
 * @author Fran
 * https://www.javatutoriales.com/2009/05/hibernate-parte-1-persistiendo-objetos.html
 * http://www.mastertheboss.com/jboss-frameworks/maven-tutorials/maven-hibernate-jpa/maven-and-hibernate-4-tutorial
 */
@Entity
@Table(name = "datosbancarios")
public class DatosBancarios implements Serializable {

    /**
     * La propiedad "id" mantendrá un valor único que identificará a cada una de
     * las instancias de "Contacto". El uso de un identificador único para cada
     * entidad es necesario si queremos utilizar todas las funcionalidades que
     * nos ofrece Hibernate. No debemos usar directamente este idetificador,
     * sino que debe ser la base de datos quin la genere al guardar la entidad e
     * Hibernate quien lo asigne al ojeto, por ello, el setter de id debe ser
     * privador. Hibernate podrá acceder a los atributos privados
     */
    @Id //pk
    @GeneratedValue(strategy = GenerationType.IDENTITY)//autoincremental
    //@Column (name = "id")
    private long id;
    
    
    @Column(name = "numCuenta", length = 24, nullable = false)
    private String numCuenta;
    
    
    @Column(name = "nombreBanco", length = 100, nullable = false)
    private String nombreBanco;
    
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idPropietario")
    private Propietarios propietario;

    /**
     * El constructor sin argumentos es obligatorio ya que Hibernate creará
     * instancias de esta clase usando reflexion cuando recupere las entidades
     * de la BD. Este constructor puede ser privado (si es que no quieren
     * permitir que alguien más lo utilice), pero usualmente el nivel de acceso
     * más restrictivo que usaremos es el de paquete (el default), ya que esto
     * hace más eficiente la creación de los objetos.
     */
    public DatosBancarios() {
    }

    
    public DatosBancarios(String numCuenta, String nombreBanco, Propietarios propietario) {
        this.numCuenta = numCuenta;
        this.nombreBanco = nombreBanco;
        this.propietario = propietario;

    }







    public Propietarios getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietarios propietario) {
        this.propietario = propietario;
    }

    
    public String getNumCuenta() {
        return numCuenta;
    }

    public String getNombreBanco() {
        return nombreBanco;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    public void setNombreBanco(String nombreBanco) {
        this.nombreBanco = nombreBanco;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "DatosBancarios{" + "id=" + id + ", numCuenta=" + numCuenta + ", nombreBanco=" + nombreBanco + '}';
    }



    @Override
    public int hashCode() {
        return Objects.hash(id, numCuenta, nombreBanco);
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DatosBancarios)) return false;
        DatosBancarios that = (DatosBancarios) o;
        return id == that.id && numCuenta.equals(that.numCuenta) && nombreBanco.equals(that.nombreBanco);
    }

}
