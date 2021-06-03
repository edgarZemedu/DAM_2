/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Clases.Propietario;
import Libreria.ControlData;
import Menu.Menu;
import Operaciones.Operaciones;
import Operaciones.OperacionesMongoDB;
import Persistencia.Hibernate;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.Scanner;
import org.bson.Document;

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
            switch (Menu.pintarMenuPrincipal(sc)) {
                case 1:
                    System.out.print("\n************************************************************\n"
                            + " MENÚ PROPIETARIO ");
                    switch (Menu.menuPropietario(sc)) {
                        case 1:
                            System.out.println("\n************************************************************\n"
                                    + "Buscar/Mostrar un propietario por su id ");
                            Operaciones.buscarPropietario(sc);
                            break;

                        case 2:
                            System.out.println("\n************************************************************\n"
                                    + "Agregar propietario");
                            Propietario p = Operaciones.añadirP(sc);
                            Operaciones.gurdarP(p);

                            System.out.println("Quiere agregar datos Bancarios (S/N) ");
                            char siModificar = ControlData.lerLetra(sc);
                            if (Character.toUpperCase(siModificar) == 'S') {//Realizamos la operación
                                //Pide los datos por teclado
                                Operaciones.añadirDatosBancariosP(p, sc);
                            }
                            break;
                        case 3:
                            System.out.println("\n************************************************************\n"
                                    + "Eliminar propietario");
                            System.out.println("Dime el id a eliminar: ");
                            int id = sc.nextInt();
                            //mostrar para ser los existen y comprobar si mete bn los datos
                            Operaciones.eliminaP(id);
                            System.out.println("Se ha eliminado, pringaooo");
                            break;
                        case 4:
                            System.out.println("\n************************************************************\n"
                                    + "Modificar propietario");
                            Operaciones.actualizarP(sc);
                            break;
                        case 5:
                            System.out.println("\n************************************************************\n"
                                    + "Listar todos los propietario");
                            Operaciones.mostrarListaP();
                            break;

                        case 6:
                            System.out.println("\n************************************************************\n"
                                    + "Listar todos los Propietarios/Inmuebleres");
                            Operaciones.obtenerListaPI();
                            break;
                        case 7:
                            System.out.println("Hasta luego!!!");
                            finalizar = true;

                    }
                    break;
                case 2:
                    System.out.print("\n************************************************************\n"
                            + " MENÚ INMUEBLES ");
                    switch (Menu.subMenuInmuebles(sc)) {
                        case 1:
                            System.out.println("\n************************************************************\n"
                                    + " Buscar un Inmueble por su código(ID)");
                            Operaciones.obtenerInm();
                            break;

                        case 2:
                            System.out.println("\n************************************************************\n"
                                    + "Agregar Inmueble");
                            Operaciones.gurdarI();
                            break;
                        case 3:
                            System.out.println("\n************************************************************\n"
                                    + "Eliminar Inmueble");
                            Operaciones.eliminarI();
                            break;
                        case 4:
                            System.out.println("\n************************************************************\n"
                                    + "Modificar Inmueble");
                            Operaciones.menuActualizarI();
                            break;
                        case 5:
                            System.out.println("\n************************************************************\n"
                                    + "Listar todos los Propietarios/Inmuebleres ");
                            Operaciones.obtenerListaPI();
                            break;
                        case 6:
                            System.out.println("Hasta luego!!!");
                            finalizar = true;

                    }
                    break;
                case 3:
                    System.out.println("\n************************************************************\n"
                            + " MONGODB ");
                    MongoClient mongoClient = new MongoClient();
                    MongoDatabase db = mongoClient.getDatabase("Inmuebles");
                    MongoCollection<Document> coleccion = db.getCollection("Propietarios");

                    boolean finaliza = false;
                    do {
                        switch (Menu.menuMongoDB(sc)) {
                            case 1:
                                System.out.print("\n************************************************************\n"
                                        + " MOSTRAR TODOS LOS DATOS ");
                                OperacionesMongoDB.mostrarDatos(coleccion);
                                break;
                            case 2:
                                System.out.print("\n************************************************************\n"
                                        + " Actualice la información del teléfono \n");
                                OperacionesMongoDB.actualizarTelefono(coleccion);
                                break;
                            case 3:
                                System.out.print("\n************************************************************\n"
                                        + " FIN..... ");
                                break;
                        }

                    } while (!finaliza);
                    System.out.println("\nFin...");
                    mongoClient.close();
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
