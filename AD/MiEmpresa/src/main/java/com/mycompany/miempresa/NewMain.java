/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.miempresa;

import Libreria.ControlData;
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

        boolean finalizar = false;
        //boolean correcta = false;

        //Obtenemos la lista de contactos de la base de datos
        do {
            switch (Menu.pintarMenuPrincipal(sc)) {
                case 1:
                    System.out.print("\n************************************************************\n"
                            + " MENÚ CLIENTES ");
                    switch (Menu.menuCliente(sc)) {
                        case 1:
                            System.out.println("\n************************************************************\n"
                                    + "Insertar cliente ");
                            Operaciones.gurdarCliente(Operaciones.añadirCliente(sc));
                            break;

                        case 2:
                            System.out.println("\n************************************************************\n"
                                    + "Buscar cliente por NIF");
                            //Propietario p = Operaciones.añadirP(sc);
                            //Operaciones.gurdarP(p);

                            System.out.println("Quiere agregar datos Bancarios (S/N) ");
                            char siModificar = ControlData.lerLetra(sc);
                            if (Character.toUpperCase(siModificar) == 'S') {//Realizamos la operación
                                //Pide los datos por teclado
                                //Operaciones.añadirDatosBancariosP(p, sc);
                            }
                            break;
                        case 3:
                            System.out.println("\n************************************************************\n"
                                    + "Modificar cliente");
                            System.out.println("Dime el id a eliminar: ");
                            int id = sc.nextInt();
                            //mostrar para ser los existen y comprobar si mete bn los datos
                            //Operaciones.eliminaP(id);
                            System.out.println("Se ha eliminado, pringaooo");
                            break;
                        case 4:
                            System.out.println("\n************************************************************\n"
                                    + "Eliminar cliente");
                            //Operaciones.actualizarP(sc);
                            break;
                        case 5:
                            System.out.println("Chaoo!!!");

                    }
                    break;
                case 2:
                    System.out.print("\n************************************************************\n"
                            + " MENÚ PRODUCTOS ");
                    switch (Menu.menuProducto(sc)) {
                        case 1:
                            System.out.println("\n************************************************************\n"
                                    + "Insertar producto");
                            //Operaciones.obtenerInm();
                            break;

                        case 2:
                            System.out.println("\n************************************************************\n"
                                    + "Buscar producto por código");
                            //Operaciones.gurdarI();
                            break;
                        case 3:
                            System.out.println("\n************************************************************\n"
                                    + "Modificar producto");
                            //Operaciones.eliminarI();
                            break;
                        case 4:
                            System.out.println("\n************************************************************\n"
                                    + ". Eliminar producto");
                            //Operaciones.menuActualizarI();
                            break;
                        case 6:
                            System.out.println("Chaoo!!!");

                    }
                    break;
                case 3:
                    System.out.print("\n************************************************************\n"
                            + " MENÚ PEDIDOS ");
                    switch (Menu.menuPedidos(sc)) {
                        case 1:
                            System.out.println("\n************************************************************\n"
                                    + " Crear pedido");
                            //Operaciones.obtenerInm();
                            break;

                        case 2:
                            System.out.println("\n************************************************************\n"
                                    + "Ver estado del pedido");
                            //Operaciones.gurdarI();
                            break;
                        case 3:
                            System.out.println("\n************************************************************\n"
                                    + "Modificar pedido");
                            //Operaciones.eliminarI();
                            break;
                        case 4:
                            System.out.println("\n************************************************************\n"
                                    + "Eliminar pedido");
                            //Operaciones.menuActualizarI();
                            break;
                        case 5:
                            System.out.println("\n************************************************************\n"
                                    + "Cambiar el estado del pedido");
                            //Operaciones.menuActualizarI();
                            break;
                        case 6:
                            System.out.println("Chaoo!!!");

                    }
                    break;
                case 4:
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
