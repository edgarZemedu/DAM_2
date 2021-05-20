/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.negocio;

/**
 *
 * @author Fran
 */
public class PropietariosDatosBancarios {
    
    private long idDatosBancarios;
    private String numCuenta;
    private String nombreBanco;
    
    private long idPropietario;
    private String prDNI;
    private String prNombre;
    private String prApellidos;
    private String prDireccion;
    private String prTelefono;

    public PropietariosDatosBancarios(long idDatosBancarios, String numCuenta, String nombreBanco, long idPropietario, String prDNI, String prNombre, String prApellidos, String prDireccion, String prTelefono) {
        this.idDatosBancarios = idDatosBancarios;
        this.numCuenta = numCuenta;
        this.nombreBanco = nombreBanco;
        this.idPropietario = idPropietario;
        this.prDNI = prDNI;
        this.prNombre = prNombre;
        this.prApellidos = prApellidos;
        this.prDireccion = prDireccion;
        this.prTelefono = prTelefono;
    }

    public long getIdDatosBancarios() {
        return idDatosBancarios;
    }

    public void setIdDatosBancarios(long idDatosBancarios) {
        this.idDatosBancarios = idDatosBancarios;
    }

    public long getIdPropietario() {
        return idPropietario;
    }

    public void setIdPropietario(long idPropietario) {
        this.idPropietario = idPropietario;
    }

    public String getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    public String getNombreBanco() {
        return nombreBanco;
    }

    public void setNombreBanco(String nombreBanco) {
        this.nombreBanco = nombreBanco;
    }

    public String getPrDNI() {
        return prDNI;
    }

    public void setPrDNI(String prDNI) {
        this.prDNI = prDNI;
    }

    public String getPrNombre() {
        return prNombre;
    }

    public void setPrNombre(String prNombre) {
        this.prNombre = prNombre;
    }

    public String getPrApellidos() {
        return prApellidos;
    }

    public void setPrApellidos(String prApellidos) {
        this.prApellidos = prApellidos;
    }

    public String getPrDireccion() {
        return prDireccion;
    }

    public void setPrDireccion(String prDireccion) {
        this.prDireccion = prDireccion;
    }

    public String getPrTelefono() {
        return prTelefono;
    }

    public void setPrTelefono(String prTelefono) {
        this.prTelefono = prTelefono;
    }

    @Override
    public String toString() {
        return "PropietariosDatosBancarios{" + "idDatosBancarios=" + idDatosBancarios + ", numCuenta=" + numCuenta + ", nombreBanco=" + nombreBanco + ", idPropietario=" + idPropietario + ", prDNI=" + prDNI + ", prNombre=" + prNombre + ", prApellidos=" + prApellidos + ", prDireccion=" + prDireccion + ", prTelefono=" + prTelefono + '}';
    }


    
    
    
    
    
    
    
}
