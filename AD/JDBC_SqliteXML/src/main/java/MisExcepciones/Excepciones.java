/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MisExcepciones;

/**
 *
 * @author A C E R
 */
public class Excepciones extends Exception {
    
    //constructor vacio
    public Excepciones(){     
        super();
    }
    
    //numero fuera de rango
    public void NumeroFueraRangoException(int i_rango, int f_rango) {
        System.out.println("Nº fuera de rango, debe introducir un nº entero >= "
                + i_rango + " y <= " + f_rango);
    }
    public void operacionBaseDatosException(String message){
        System.out.println(message);
    } 
    public void tipoNotBooleanException() {
        System.out.println("O valor introducido non se corresponde cun número de tipo" +
                " boolean que se caracteriza permitir só os valores true e false ");  
    }
    public void tipoNotByteException() {
        System.out.println("O valor introducido non se corresponde cun número de tipo" +
                " byte que se caracteriza por ser un enteiro entre "+
                Byte.MIN_VALUE+" y "+Byte.MAX_VALUE);  
    }
    public void tipoNotCharException() {
        System.out.println("Error. Debe introducir un carácter");  
    }
    public void tipoNotDoubleException() {
        System.out.println("O valor introducido non se corresponde cun número de tipo" +
                " double que se caracteriza por ser un real entre "+
                Double.MIN_VALUE+" y "+Double.MAX_VALUE);  
    }
    public void tipoNotFloatException() {
        System.out.println("O valor introducido non se corresponde cun número de tipo" +
                " float que se caracteriza por ser un real entre "+
                Float.MIN_VALUE+" y "+Float.MAX_VALUE);  
    }
    public void tipoNotIntException() {
        System.out.println("O valor introducido non se corresponde cun número de tipo" +
                " byte que se caracteriza por ser un enteiro entre "+
                Integer.MIN_VALUE+" y "+Integer.MAX_VALUE);  
    }
    public void tipoNotLongException() {
        System.out.println("O valor introducido non se corresponde cun número de tipo" +
                " long que se caracteriza por ser un enteiro entre "+
                Long.MIN_VALUE+" y "+Long.MAX_VALUE);  
    }
    public void tipoNotNomeException() {
        System.out.println("Error. Só se adminten letras nos datos introducidos");  
    }
    public void tipoNotShortException() {
        System.out.println("O valor introducido non se corresponde cun número de tipo" +
                " short que se caracteriza por ser un enteiro entre "+
                Short.MIN_VALUE+" y "+Short.MAX_VALUE);  
    }
    public void tipoNotStringException() {
        System.out.println("Error. Debe introducir unha cadea de caracteres");  
    }
    public void validacionException(String tipoValidacion, String causa) {        
        System.out.println("Error de validación en "+tipoValidacion+" debido a "+causa);
    }    
    public void ErrorBuffer(){
        System.out.println("Error del buffer de lectura por teclado");
    }
    
}
