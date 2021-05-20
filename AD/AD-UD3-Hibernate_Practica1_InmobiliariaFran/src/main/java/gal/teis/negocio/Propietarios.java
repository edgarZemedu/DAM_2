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

import javax.persistence.*;

/**
 *
 * @author Fran
 * https://www.javatutoriales.com/2009/05/hibernate-parte-1-persistiendo-objetos.html
 * http://www.mastertheboss.com/jboss-frameworks/maven-tutorials/maven-hibernate-jpa/maven-and-hibernate-4-tutorial
 */
@Entity
@Table(name = "propietarios")
public class Propietarios implements Serializable {

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
    private long id;
    @Column(name = "prDNI", length = 9, nullable = false)
    private String prDNI;
    @Column(name = "prNombre", length = 30, nullable = false)
    private String prNombre;
    @Column(name = "prApellidos", length = 40, nullable = false)
    private String prApellidos;
    @Column(name = "prDireccion", length = 50, nullable = false)
    private String prDireccion;
    @Column(name = "prTelefono", length = 9, nullable = false)
    private String prTelefono;
    
    

    
  

//   @OneToMany
//    private List<Inmuebles> inmuebles = new ArrayList<>();
    /**
     * El constructor sin argumentos es obligatorio ya que Hibernate creará
     * instancias de esta clase usando reflexion cuando recupere las entidades
     * de la BD. Este constructor puede ser privado (si es que no quieren
     * permitir que alguien más lo utilice), pero usualmente el nivel de acceso
     * más restrictivo que usaremos es el de paquete (el default), ya que esto
     * hace más eficiente la creación de los objetos.
     */
    Propietarios() {
    }

    public Propietarios(String prDNI, String prNombre, String prApellidos, String prDireccion, String prTelefono) {

        this.prDNI = prDNI;
        this.prNombre = prNombre;
        this.prApellidos = prApellidos;
        this.prDireccion = prDireccion;
        this.prTelefono = prTelefono;
 

    }


    public long getId() {
        return id;
    }

    public String getPrDNI() {
        return prDNI;
    }

    public String getPrNombre() {
        return prNombre;
    }

    public String getPrApellidos() {
        return prApellidos;
    }

    public String getPrDireccion() {
        return prDireccion;
    }

    public String getPrTelefono() {
        return prTelefono;
    }

    public void setPrDNI(String prDNI) {
        this.prDNI = prDNI;
    }

    public void setPrNombre(String prNombre) {
        this.prNombre = prNombre;
    }

    public void setPrApellidos(String prApellidos) {
        this.prApellidos = prApellidos;
    }

    public void setPrDireccion(String prDireccion) {
        this.prDireccion = prDireccion;
    }

    public void setPrTelefono(String prTelefono) {
        this.prTelefono = prTelefono;
    }

    @Override
    public String toString() {
        return "Propietarios{" + "id=" + id + ", prDNI=" + prDNI + ", prNombre=" + prNombre + ", prApellidos=" + prApellidos + ", prDireccion=" + prDireccion + ", prTelefono=" + prTelefono + '}';
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((prNombre == null) ? 0 : prTelefono.hashCode());
        result = (int) (prime * result + id);
        result = prime * result + ((prNombre == null) ? 0 : prNombre.hashCode());
        return result;
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
        Propietarios other = (Propietarios) obj;
        if (prTelefono == null) {
            if (other.prTelefono != null) {
                return false;
            }
        } else if (!prTelefono.equals(other.prTelefono)) {
            return false;
        }
        if (id != other.id) {
            return false;
        }
        if (prNombre == null) {
            if (other.prNombre != null) {
                return false;
            }
        } else if (!prNombre.equals(other.prNombre)) {
            return false;
        }
        return true;
    }

}
