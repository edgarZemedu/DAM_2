/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import Excepciones.MisExcepciones;
import Libreria.ControlData;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author a18zemedufc
 */
public class Menu {

    private ArrayList<String> opciones = new ArrayList<String>();
    private int numOpciones;

    public Menu(ArrayList opciones) {
        this.opciones = opciones;
        this.numOpciones = opciones.size();
    }

    public Menu() {
    }

    /**
     * Imprime o menú na pantalla
     */
    public void printMenu() {
        for (int i = 1; i <= opciones.size(); i++) {
            System.out.println(i + ".- " + opciones.get(i - 1));
        }
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
    public void rango(byte op) throws MisExcepciones {
        boolean enrango = true;
        if (op < 1 || op > numOpciones) {
            enrango = false;
            throw new MisExcepciones();
        }
    }

    /**
     * Lee un n´º por teclado ata que se introduce un nº correcto para o rango
     * establecido polas opcións do menú
     *
     * @param sc Scanner - Instancia de Scanner para ler
     */
    public void rango(Scanner sc) {
        boolean enrango = true;
        byte op = ControlData.lerByte(sc);
        do {
            if (op < 1 || op > numOpciones) {
                enrango = false;
                System.out.println("\tERRO: debe introducir un valor dentro do rango de números posibles. "
                        + "\n\t\tVolva a introducir un número: \n");
            }
        } while (!enrango);
    }

    /**
     * Dibuja un menú en la consola a partir con unas opciones determinadas
     */
    public static byte pintarMenuPrincipal(Scanner sc) {
        byte opcion = 0;
        boolean correcta;

        ArrayList<String> misOpciones = new ArrayList<String>() {
            {
                add("MENÚ PROPIETARIO");
                add("MENÚ INMUEBLES");
                add("MENÚ MONGODB");
                add("Finalizar");
            }
        };

        /*La clase Menu permite imprimir el menú a partir de los datos de un ArrayList<String>
            y utilizar métodos para control de rango*/
        Menu miMenu = new Menu(misOpciones);

        System.out.println("\n\n*******************************************************************************************************");
        /* Solo sale del While cuando se selecciona una opción correcta en rango y tipo*/
        do {
            miMenu.printMenu();

            /*La clase ControlData permite hacer un control de tipo leído*/
            try {
                opcion = ControlData.lerByte(sc);
                /*miMenu.rango() lanza una excepción propia en el caso de que 
                el parámetro opcion esté fuera del rango posible */
                miMenu.rango(opcion);
                correcta = true;
            } catch (MisExcepciones e) {//Excepción personalizada
                System.out.println(e.getMessage());
                correcta = false;
            }

        } while (!correcta);

        return opcion;
    }

    public static byte menuPropietario(Scanner sc) {
        byte opcion = 0;
        boolean correcta;

        ArrayList<String> misOpciones = new ArrayList<String>() {
            {
                add("Buscar/Mostrar un propietario por su id");
                add("Agregar propietario");
                add("Eliminar propietario");
                add("Modificar propietario");
                add("Listar todos los propietario");
                add("Listar todos los Propietarios/Inmuebleres");
                add("Finalizar");
            }
        };

        /*La clase Menu permite imprimir el menú a partir de los datos de un ArrayList<String>
            y utilizar métodos para control de rango*/
        Menu miMenu = new Menu(misOpciones);

        System.out.println("\n\n*******************************************************************************************************");
        /* Solo sale del While cuando se selecciona una opción correcta en rango y tipo*/
        do {
            miMenu.printMenu();

            /*La clase ControlData permite hacer un control de tipo leído*/
            try {
                opcion = ControlData.lerByte(sc);
                /*miMenu.rango() lanza una excepción propia en el caso de que 
                el parámetro opcion esté fuera del rango posible */
                miMenu.rango(opcion);
                correcta = true;
            } catch (MisExcepciones e) {//Excepción personalizada
                System.out.println(e.getMessage());
                correcta = false;
            }

        } while (!correcta);

        return opcion;
    }
    public static byte subMenuModificarP(Scanner sc) {
        byte opcion = 0;
        boolean correcta;

        ArrayList<String> misOpciones = new ArrayList<String>() {
            {
                add("DNI");
                add("Nombre");
                add("Apellidos");
                add("Dirección");
                add("Teléfono");
                add("Modificar Datos Bancarios");
                add("cancelar");
            }
        };

        /*La clase Menu permite imprimir el menú a partir de los datos de un ArrayList<String>
            y utilizar métodos para control de rango*/
        Menu miMenu = new Menu(misOpciones);

        System.out.println("\n\n*******************************************************************************************************");
        /* Solo sale del While cuando se selecciona una opción correcta en rango y tipo*/
        do {
            miMenu.printMenu();

            /*La clase ControlData permite hacer un control de tipo leído*/
            try {
                opcion = ControlData.lerByte(sc);
                /*miMenu.rango() lanza una excepción propia en el caso de que 
                el parámetro opcion esté fuera del rango posible */
                miMenu.rango(opcion);
                correcta = true;
            } catch (MisExcepciones e) {//Excepción personalizada
                System.out.println(e.getMessage());
                correcta = false;
            }

        } while (!correcta);

        return opcion;
    }


    public static byte subMenuInmuebles(Scanner sc) {
        byte opcion = 0;
        boolean correcta;

        ArrayList<String> misOpciones = new ArrayList<String>() {
            {
                add("Buscar un Inmueble por su código(ID)");
                add("Agregar Inmueble");
                add("Eliminar Inmueble");
                add("Modificar Inmueble");
                add("Listar todos los Propietarios/Inmuebleres");
                add("Finalizar");
            }
        };

        /*La clase Menu permite imprimir el menú a partir de los datos de un ArrayList<String>
            y utilizar métodos para control de rango*/
        Menu miMenu = new Menu(misOpciones);

        System.out.println("\n\n************************************************************************************");
        /* Solo sale del While cuando se selecciona una opción correcta en rango y tipo*/
        do {
            miMenu.printMenu();

            /*La clase ControlData permite hacer un control de tipo leído*/
            try {
                opcion = ControlData.lerByte(sc);
                /*miMenu.rango() lanza una excepción propia en el caso de que 
                el parámetro opcion esté fuera del rango posible */
                miMenu.rango(opcion);
                correcta = true;
            } catch (MisExcepciones e) {//Excepción personalizada
                System.out.println(e.getMessage());
                correcta = false;
            }

        } while (!correcta);

        return opcion;
    }
    public static byte pintarMenuModificarInmueble(Scanner sc) {
        byte opcion = 0;
        boolean correcta;

        ArrayList<String> misOpciones = new ArrayList<String>() {
            {
                add("ID");
                add("Dirección");
                add("Código Zona");
                add("Estado");
                add("Propietario");
                add("cancelar");
            }
        };

        /*La clase Menu permite imprimir el menú a partir de los datos de un ArrayList<String>
            y utilizar métodos para control de rango*/
        Menu miMenu = new Menu(misOpciones);

        System.out.println("\n\n*****************************************************************************************");
        /* Solo sale del While cuando se selecciona una opción correcta en rango y tipo*/
        do {
            miMenu.printMenu();

            /*La clase ControlData permite hacer un control de tipo leído*/
            try {
                opcion = ControlData.lerByte(sc);
                /*miMenu.rango() lanza una excepción propia en el caso de que 
                el parámetro opcion esté fuera del rango posible */
                miMenu.rango(opcion);
                correcta = true;
            } catch (MisExcepciones e) {//Excepción personalizada
                System.out.println(e.getMessage());
                correcta = false;
            }

        } while (!correcta);

        return opcion;
    }
    public static byte menuMongoDB(Scanner sc) {
        byte opcion = 0;
        boolean correcta;

        ArrayList<String> misOpciones = new ArrayList<String>() {
            {
                add("MOSTRAR TODOS LOS DATOS");
                add("Actualizar la información del teléfono.");
                add("Finalizar");
            }
        };

        /*La clase Menu permite imprimir el menú a partir de los datos de un ArrayList<String>
            y utilizar métodos para control de rango*/
        Menu miMenu = new Menu(misOpciones);

        System.out.println("\n\n******************************************************************************************");
        /* Solo sale del While cuando se selecciona una opción correcta en rango y tipo*/
        do {
            miMenu.printMenu();

            /*La clase ControlData permite hacer un control de tipo leído*/
            try {
                opcion = ControlData.lerByte(sc);
                /*miMenu.rango() lanza una excepción propia en el caso de que 
                el parámetro opcion esté fuera del rango posible */
                miMenu.rango(opcion);
                correcta = true;
            } catch (MisExcepciones e) {//Excepción personalizada
                System.out.println(e.getMessage());
                correcta = false;
            }

        } while (!correcta);

        return opcion;
    }
    public static byte subMenuMongoDB(Scanner sc) {
        byte opcion = 0;
        boolean correcta;

        ArrayList<String> misOpciones = new ArrayList<String>() {
            {
                add("MOSTRAR TODOS LOS ARTICULOS QUE NO SON IMPRESORAS ");
                add("MOSTRAR TODOS LOS ARTICULOS QUE PERTENECEN A MOUSE");
                add("Mostrar todos los artículos con un precio mayor o igual a 5000");
                add("Mostrar todas las impresoras que tienen un precio mayor o igual a 3500");
                add("Mostrar todos los artículos cuyo stock se encuentra comprendido entre 0 y 4");
                add("Finalizar");
            }
        };

        /*La clase Menu permite imprimir el menú a partir de los datos de un ArrayList<String>
            y utilizar métodos para control de rango*/
        Menu miMenu = new Menu(misOpciones);

        System.out.println("\n\n*******************************************************************************************************");
        /* Solo sale del While cuando se selecciona una opción correcta en rango y tipo*/
        do {
            miMenu.printMenu();

            /*La clase ControlData permite hacer un control de tipo leído*/
            try {
                opcion = ControlData.lerByte(sc);
                /*miMenu.rango() lanza una excepción propia en el caso de que 
                el parámetro opcion esté fuera del rango posible */
                miMenu.rango(opcion);
                correcta = true;
            } catch (MisExcepciones e) {//Excepción personalizada
                System.out.println(e.getMessage());
                correcta = false;
            }

        } while (!correcta);

        return opcion;
    }

}
