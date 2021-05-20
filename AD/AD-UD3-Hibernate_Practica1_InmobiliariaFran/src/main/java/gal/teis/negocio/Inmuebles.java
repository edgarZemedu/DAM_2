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
@Table (name = "inmuebles")
public class Inmuebles implements Serializable {

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
    @Column(name = "id", length = 5)
    private char id;
    @Column(name = "inDireccion", length = 50)
    private String inDireccion;
    @Column(name = "inCodZona", length = 5)
    private String inCodZona;
    @Column(name = "inEstado", length = 1)
    private String inEstado;

    
    @ManyToOne
    @JoinColumn(name ="inPropietario")
    private Propietarios propietarios;


    /**
     * El constructor sin argumentos es obligatorio ya que Hibernate creará
     * instancias de esta clase usando reflexion cuando recupere las entidades
     * de la BD. Este constructor puede ser privado (si es que no quieren
     * permitir que alguien más lo utilice), pero usualmente el nivel de acceso
     * más restrictivo que usaremos es el de paquete (el default), ya que esto
     * hace más eficiente la creación de los objetos.
     */
    Inmuebles() {
    }

    public Inmuebles(char id, String inDireccion, String inCodZona, String inEstado, Propietarios propietarios) {
        this.id = id;
        this.inDireccion = inDireccion;
        this.inCodZona = inCodZona;
        this.inEstado = inEstado;
        this.propietarios = propietarios;
    }

    public char getId() {
        return id;
    }

    public void setId(char id) {
        this.id = id;
    }

    public String getInDireccion() {
        return inDireccion;
    }

    public void setInDireccion(String inDireccion) {
        this.inDireccion = inDireccion;
    }

    public String getInCodZona() {
        return inCodZona;
    }

    public void setInCodZona(String inCodZona) {
        this.inCodZona = inCodZona;
    }

    public String getInEstado() {
        return inEstado;
    }

    public void setInEstado(String inEstado) {
        this.inEstado = inEstado;
    }

    public Propietarios getPropietarios() {
        return propietarios;
    }

    public void setPropietarios(Propietarios propietarios) {
        this.propietarios = propietarios;
    }

    @Override
    public String toString() {
        return "Inmuebles{" + "id=" + id + ", inDireccion=" + inDireccion + ", inCodZona=" + inCodZona + ", inEstado=" + inEstado + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.id);
        hash = 17 * hash + Objects.hashCode(this.inDireccion);
        hash = 17 * hash + Objects.hashCode(this.inCodZona);
        hash = 17 * hash + Objects.hashCode(this.inEstado);
        hash = 17 * hash + Objects.hashCode(this.propietarios);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Inmuebles other = (Inmuebles) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.inDireccion, other.inDireccion)) {
            return false;
        }
        if (!Objects.equals(this.inCodZona, other.inCodZona)) {
            return false;
        }
        if (!Objects.equals(this.inEstado, other.inEstado)) {
            return false;
        }
        if (!Objects.equals(this.propietarios, other.propietarios)) {
            return false;
        }
        return true;
    }

   
}

