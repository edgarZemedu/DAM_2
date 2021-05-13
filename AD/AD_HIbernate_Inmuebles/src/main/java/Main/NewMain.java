/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Menu.Menu;
import Operaciones.Operaciones;
import Persistencia.Hibernate;
import java.util.Scanner;

/**
 *
 * @author a18zemedufc
 */
public class NewMain {

    static Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Variables de control de operaciones
        boolean finalizar = false;
        boolean correcta = false;

        //Obtenemos la lista de contactos de la base de datos
        do {
//            Menu m = new Menu();
//            m.printMenu();
            switch (Menu.pintarMenuPrincipal(sc)) {
                case 1:
                    System.out.print("\n************************************************************\n"
                            + " MENÚ PROPIETARIO ");
                    switch (Menu.subMenuPropietario(sc)) {
                        case 1:
                            System.out.println("\n************************************************************\n"
                                    + "Buscar/Mostrar un propietario por su id ");
                            //mostrarTodos();
                            break;

                        case 2:
                            System.out.println("\n************************************************************\n"
                                    + "Agregar propietario");
                            Operaciones.gurdarP(Operaciones.añadirP(sc));
                            break;
                        case 3:
                            System.out.println("\n************************************************************\n"
                                    + "Eliminar propietario");
                            System.out.println("Dime el id a eliminar: ");
                            int id = sc.nextInt();
                            //mostrar para ser los existen y comprobar si mete bn los datos
                            Operaciones.eliminaP(id);
                            break;
                        case 4:
                            System.out.println("\n************************************************************\n"
                                    + "Modificar propietario");
                            //menuActualizarElemento();
                            break;
                        case 5:
                            System.out.println("\n************************************************************\n"
                                    + "Listar todos los propietario");
                            //menuEliminarElemento();
                            break;

                        case 6:
                            System.out.println("\n************************************************************\n"
                                    + "Listar todos los Propietarios/Inmuebleres");
                            //menuEliminarElemento();
                            break;
                        case 7:
                            System.out.println("Hasta luego!!!");
                            finalizar = true;
                        //Cierra la sesión de Hibernate

                    }
                    break;
                case 2:
                    System.out.print("\n************************************************************\n"
                            + " MENÚ INMUEBLES ");
                    switch (Menu.subMenuInimuebles(sc)) {
                        case 1:
                            System.out.println("\n************************************************************\n"
                                    + " Buscar un Inmueble por su código(ID)");
                            //mostrarTodos();
                            break;

                        case 2:
                            System.out.println("\n************************************************************\n"
                                    + "Agregar Inmueble");
                            //menuGuardarElemento();
                            break;
                        case 3:
                            System.out.println("\n************************************************************\n"
                                    + "Eliminar Inmueble");
                            //menuBuscarElemento();
                            break;
                        case 4:
                            System.out.println("\n************************************************************\n"
                                    + "Modificar Inmueble");
                            //menuActualizarElemento();
                            break;
                        case 5:
                            System.out.println("\n************************************************************\n"
                                    + "Listar todos los Propietarios/Inmuebleres ");
                            //menuEliminarElemento();
                            break;
                        case 6:
                            System.out.println("Hasta luego!!!");
                            finalizar = true;
                        //Cierra la sesión de Hibernate

                    }
                    break;
                case 3:
                    System.out.println("Hasta luego!!!");
                    finalizar = true;
                    //Cierra la sesión de Hibernate
                    try {
                        Hibernate.shutdown();
                    } catch (ExceptionInInitializerError e) {
                        System.out.println(e.getMessage());
                    }

                    break;
            }
        } while (!finalizar);

    }

}
