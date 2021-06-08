package com.mycompany.excepciones;


public class NumeroFueraRangoException extends Exception {

    public NumeroFueraRangoException(int i_rango, int f_rango) {
        super ("Nº fuera de rango, debe introducir un nº entero >= "+
                i_rango+" y <= "+f_rango);
    }
    
}
