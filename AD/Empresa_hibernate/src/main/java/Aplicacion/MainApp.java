/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplicacion;

import clase.Direccion;
import clase.Empleado;
import Libreria.Menu;
import Persistencia.Hibernate;
import Persistencia.Operaciones;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author a18zemedufc
 */
public class MainApp {

    static Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //crear 
        Empleado e1 = new Empleado("Rosa", "Pin", 2000.0);
        Empleado e2 = new Empleado("Alberto", "Pereira", 2500.0);

        //guardar
        Operaciones.gurdarE(e1);
        e1.toString();
        Operaciones.gurdarE(e2);
        e2.toString();

        //crear segunda instancia
        Direccion d1 = new Direccion("C/Sol nº 5", "Vigo");
        Direccion d2 = new Direccion("C/Principal nº 30", "Vigo");

        //gurdar
        Operaciones.gurdarD(d1);
        d1.toString();
        Operaciones.gurdarD(d2);
        d2.toString();

//        List<Object[]> listaEmpleadosDireccion = Operaciones.obtenerListaED();
//        if (!Objects.isNull(listaEmpleadosDireccion)) {
//            System.out.println("Hay " + listaEmpleadosDireccion.size()
//                    + " empleados en la base de datos");
//            for (int i = 0; i < listaEmpleadosDireccion.size(); i++) {
////Para cada posición de la lista, recupera el índice 0 que son los
////datos de la dirección y el índice 1 que son los datos del empleado
//                System.out.println(listaEmpleadosDireccion.get(i)[0] + listaEmpleadosDireccion.get(i)[1]);
//            }
//        }


//          //Variables de control de operaciones
//        boolean finalizar = false;
//        boolean correcta = false;
//
//        //Obtenemos la lista de contactos de la base de datos
//        do {
//            switch (Menu.printMenu()) {
//                case 1:
//                    System.out.println("\n************************************************************\n"
//                            + " ");
//                    //mostrarTodos();
//                    break;
//
//                case 2:
//                    System.out.println("\n************************************************************\n"
//                            + "");
//                    //menuGuardarElemento();
//                    break;
//                case 3:
//                    System.out.println("\n************************************************************\n"
//                            + "");
//                    //menuBuscarElemento();
//                    break;
//                case 4:
//                    System.out.println("\n************************************************************\n"
//                            + "");
//                    //menuActualizarElemento();
//                    break;
//                case 5:
//                    System.out.println("\n************************************************************\n"
//                            + "");
//                    //menuEliminarElemento();
//                    break;
//                case 6:
//                    System.out.println("Hasta luego!!!");
//                    finalizar = true;
//                    //Cierra la sesión de Hibernate
//                    Hibernate.shutdown();
//
//            }
//        } while (!finalizar);
    }

}
