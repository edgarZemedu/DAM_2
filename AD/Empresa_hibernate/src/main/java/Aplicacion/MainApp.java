/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplicacion;

import Libreria.ControlData;
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

        //AGREGAR DATOS A LA BASE DE DATOS 
        //crear 
//        Empleado e1 = new Empleado("Rosa", "Pin", 2000.0);
//        Empleado e2 = new Empleado("Alberto", "Pereira", 2500.0);
//
//        //guardar
//        Operaciones.gurdarE(e1);
//        e1.toString();
//        Operaciones.gurdarE(e2);
//        e2.toString();
//
//        //crear segunda instancia
//        Direccion d1 = new Direccion("C/Sol nº 5", "Vigo");
//        Direccion d2 = new Direccion("C/Principal nº 30", "Vigo");
//
//        d1.setEmpleado(e1);
//        d2.setEmpleado(e2);
//        //gurdar
//        Operaciones.gurdarD(d1);
//        d1.toString();
//        Operaciones.gurdarD(d2);
//        d2.toString();
        //VISUALIZAR LA DOS TABLAS DE LA BASE DE DATOS 
        List<Object[]> listaEmpleadosDireccion = Operaciones.obtenerListaED();

        if (!Objects.isNull(listaEmpleadosDireccion)) {
            System.out.println("\n      Hay " + listaEmpleadosDireccion.size()
                    + " empleados en la base de datos");
            for (int i = 0; i < listaEmpleadosDireccion.size(); i++) {
                //Para cada posición de la lista, recupera el índice 0 que son los
                //datos de la dirección y el índice 1 que son los datos del empleado
                System.out.println(listaEmpleadosDireccion.get(i)[0] + "\n-> " + listaEmpleadosDireccion.get(i)[1]);
            }
        }

        //LOCALIZAR DATOS A PARTIR DE SU ID
        System.out.println("\nLocalizar un empleado sin dirección a partir de su id");
        System.out.println(Operaciones.obtenEmpleado(19));
        System.out.println("\nLocalizar un EMPLEADO + DIRECCIÓN a partir de su id");
        /*usamos la lista de arriba*/
        if (!Objects.isNull(listaEmpleadosDireccion)) {
            System.out.println(listaEmpleadosDireccion.get(0)[0] + "\n --> " + listaEmpleadosDireccion.get(0)[1]);
        }
        //LOCALIZAR DATOS A PARTIR DE SU ID DE OTRA FORMA
        List<Object[]> listaEDconID = Operaciones.obtenerListaEDconID(16);
        if (!Objects.isNull(listaEDconID)) {
            System.out.println("\n      Hay " + listaEDconID.size()
                    + " empleados en la base de datos");
            for (int i = 0; i < listaEDconID.size(); i++) {
                System.out.println(listaEDconID.get(i)[0] + "\n --> " + listaEDconID.get(i)[1]);
            }
        }

        //ELIMINAR EMPLEADOS
        boolean borrado = false;
        borrado = Operaciones.eliminaE(19);
        if (borrado) {
            System.out.println("\nYa está borrado el empleado");
        }

        //ACTUALIZADO
        System.out.println("Introduce el id del elemento a modificar ");
        int id3 = ControlData.lerInt(sc);
        System.out.println("Introduce el nuevo nombre del empleado");
        String nombre = ControlData.lerString(sc);
        List<Object[]> empDire1 = Operaciones.obtenerListaEDconID(16);
        if (!Objects.isNull(empDire1)) {
            Empleado empActualizar = ((Empleado) (empDire1.get(0)[1]));
            empActualizar.setNombre(nombre);
            Operaciones.actualizaE(empActualizar);
            System.out.println("Hecho");
        }
        

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
