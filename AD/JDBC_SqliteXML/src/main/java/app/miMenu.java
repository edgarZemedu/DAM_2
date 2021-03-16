/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import ControlData.ControlData;
import MisExcepciones.Excepciones;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author A C E R
 */
public class miMenu {

    static Scanner sc= new Scanner(System.in);
    private static ArrayList<String> opcionesMenu;
    private static int numOpciones;

    public miMenu(ArrayList opcionesMenu) {
        this.opcionesMenu = opcionesMenu;
        this.numOpciones = opcionesMenu.size();
    }

    /**
     * Imprime o menú na pantalla
     */
    public static byte printMenu() {
        byte opcionElegida = 0;
        boolean correcto = false;
        //añadir opciones del menú
        opcionesMenu = new ArrayList<String>();
        opcionesMenu.add("Crear una base de datos");
        opcionesMenu.add("Altas");
        opcionesMenu.add("Bajas");
        opcionesMenu.add("Consultas");
        opcionesMenu.add("Finalizar");
        //mostrar
        do {
            for (int i = 1; i <= opcionesMenu.size(); i++) {
                System.out.println(i + ".- " + opcionesMenu.get(i - 1));
            }
            //elegir una opción
            miMenu m = new miMenu(opcionesMenu);
            try{
                opcionElegida = ControlData.lerByte(sc);
                m.rango(opcionElegida);
                correcto = true;
            }catch(Excepciones e){
                e.NumeroFueraRangoException(1, numOpciones);
            }
            
        } while (!correcto);
            
        return opcionElegida;
    }
    /**
     * menú para consultas
     */
    public static byte printMenuConsultas() {
        byte opcionElegida = 0;
        boolean correcto = false;
        //añadir opciones del menú
        opcionesMenu = new ArrayList<String>();
        opcionesMenu.add("Ver Todos los Libros");
        opcionesMenu.add("Ver por titulo");
        opcionesMenu.add("Ver por id");
        opcionesMenu.add("Ver por autor");
        opcionesMenu.add("Ver por el precio");
        opcionesMenu.add("Finalizar");
        //mostrar
        do {
            for (int i = 1; i <= opcionesMenu.size(); i++) {
                System.out.println(i + ".- " + opcionesMenu.get(i - 1));
            }
            //elegir una opción
            miMenu m = new miMenu(opcionesMenu);
            try{
                opcionElegida = ControlData.lerByte(sc);
                m.rango(opcionElegida);
                correcto = true;
            }catch(Excepciones e){
                e.NumeroFueraRangoException(1, numOpciones);
            }
            
        } while (!correcto);
            
        return opcionElegida;
    }

    /**
     * Comproba que o parámetro está dentro do rango de opcións coas que se
     * creou o menú. Lanza unha excepción propia no caso de que o nº non estea
     * dentro do rango das opcións posibles.
     *
     * @param op int - valor a analizar como pertencente ou non ao rango de
     * opcións do menú
     * @return boolean - true se está no rango e false en caso contrario
     */
    public void rango(byte op) throws Excepciones {
        boolean enrango = true;
        if (op < 1 || op > numOpciones) {
            enrango = false;
            throw new Excepciones();
        }
    }

}
