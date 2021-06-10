/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.miempresa;

import Clases.Cliente;
import Clases.Pedidos;
import Libreria.ControlData;
import Menu.Menu;
import Operaciones.Operaciones;
import Persistencia.Hibernate;
import java.util.List;
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
                            System.out.println("Éxito,se añadio un cliente");
                            break;

                        case 2:
                            System.out.println("\n************************************************************\n"
                                    + "Buscar cliente por NIF");

                            Operaciones.buscarPorNIF(sc);

                            break;
                        case 3:
                            System.out.println("\n************************************************************\n"
                                    + "Modificar cliente");
                            Operaciones.modificarCliente(sc);
                            System.out.println("Se ha modificado el cliente, pringaooo");

                            //PARA HACER 
                            break;
                        case 4:
                            System.out.println("\n************************************************************\n"
                                    + "Eliminar cliente");
                            Operaciones.eliminarCliente(sc);
                            break;
                        case 5:
                            System.out.println("-->!!!");
                            List<Cliente> lista = Operaciones.ObtenListaClientes();
                            for (Cliente c : lista) {
                                System.out.println("-> "+ c.toString());
                            }
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
                            Operaciones.gurdarProducto(Operaciones.añadirProducto(sc));
                            System.out.println("Éxito,se añadio un producto");
                            break;

                        case 2:
                            System.out.println("\n************************************************************\n"
                                    + "Buscar producto por código");
                            Operaciones.buscarPorCodigoProducto(sc);
                            break;
                        case 3:
                            System.out.println("\n************************************************************\n"
                                    + "Modificar producto");
                            Operaciones.moficarProducto(sc);

                            // PARA HACER
                            break;
                        case 4:
                            System.out.println("\n************************************************************\n"
                                    + ". Eliminar producto");
                            Operaciones.eliminarProducto(sc);

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
                            Operaciones.añadirPedidos(sc);
                            break;

                        case 2:
                            System.out.println("\n************************************************************\n"
                                    + "Ver el estado del pedido");
                            Operaciones.verEstadoPedido(sc);
                            break;
                        case 3:
                            System.out.println("\n************************************************************\n"
                                    + "Modificar pedido");
                            Operaciones.moficarPedidos(sc);
                            break;
                        case 4:
                            System.out.println("\n************************************************************\n"
                                    + "Eliminar pedido");
                            Operaciones.eliminarPedidos(sc);
                            break;
                        case 5:
                            System.out.println("\n************************************************************\n"
                                    + "Cambiar el estado del pedido");
                            Operaciones.moficarEstadoPedido(sc);
                            break;
                        case 6:
                            System.out.println("-->!!!");
                            List<Pedidos> listapedidos = Operaciones.ObtenListaPedidos();
                            for (Pedidos p : listapedidos) {
                                System.out.println("-> "+ p.toString());
                            }                            
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
