/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Menu.Menu;
import Operaciones.OperacionesMongoDB;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.Scanner;
import org.bson.Document;

/**
 *
 * @author a18zemedufc
 */
public class MainMongoDB {

    /**
     * @param args the command line arguments
     */
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // TODO code application logic here
        MongoClient mongoClient = new MongoClient();
        MongoDatabase db = mongoClient.getDatabase("COMPRAS");
        MongoCollection<Document> coleccion = db.getCollection("articulos");

        boolean finalizar = false;
        do {
            switch (Menu.menuMongoDB(sc)) {
                case 1:
                    System.out.print("\n************************************************************\n"
                            + " MOSTRAR TODOS LOS DATOS DE ARTICULOS ");
                    OperacionesMongoDB.mostrarDatos(coleccion);

                    boolean fin = false;
                    do {
                        
                        switch (Menu.subMenuMongoDB(sc)) {
                            case 1:
                                OperacionesMongoDB.mostrarDatosSinImp(coleccion);
                                System.out.println("\nhecho submenuMostrar1");
                                break;
                            case 2:
                                OperacionesMongoDB.mostrarDatosMouse(coleccion);
                                System.out.println("\nhecho submenuMostrar2");
                                break;
                            case 3:
                                OperacionesMongoDB.mostrarDatosMayor(coleccion);
                                System.out.println("\nhecho submenuMostrar3");
                                break;
                            case 4:
                                OperacionesMongoDB.mostrarDatosImpresorasMenores(coleccion);
                                System.out.println("\nhecho submenuMostrar4");
                                break;
                            case 5:
                                OperacionesMongoDB.mostrarDatosStock(coleccion);
                                System.out.println("\nhecho submenuMostrar5");
                                break;
                            case 6:
                                System.out.print("\n*****************************************************\n"
                                        + " FIN.....volviendo al menu principal ");
                                fin = true;
                                break;
//                            default:
//                                System.out.println("Error con submenú de MOSTRAR");
//                                break;
                        }
                    } while (!fin);
                    break;
                ////SEGUNDA PARTE 
                case 2:
                    System.out.print("\n************************************************************\n"
                            + "AGREGAR DATOS \n");
                    OperacionesMongoDB.agregarDatos(coleccion);
                    break;
                case 3:
                    System.out.print("\n************************************************************\n"
                            + "Modificar el precio del mouse 'LOGITECH M90' \n");
                    OperacionesMongoDB.modificarPrecioMouse(coleccion);
                    break;
                case 4:
                    System.out.print("\n************************************************************\n"
                            + " Fijar el stock en 0 del artículo cuyo _id es 6");
                    OperacionesMongoDB.moficarStockConID(coleccion);
                    break;
                case 5:
                    System.out.print("\n************************************************************\n"
                            + "Agregar el campo proveedores con el array [Martinez','Gutierrez'] para el artículo(_id=6)\n");
                    OperacionesMongoDB.agregarArray(coleccion);
                    break;
                case 6:
                    System.out.print("\n************************************************************\n"
                            + " ELIMINAR DATOS ");
                    OperacionesMongoDB.eliminarCampo(coleccion);
                    break;
                case 7:
                    System.out.print("\n************************************************************\n"
                            + " MODIFICAR EL ARTICULO ENTERO CON ID DE REFENCIA ");
                    OperacionesMongoDB.modificarDatos(coleccion);
                    break;
                case 8:
                    System.out.print("\n************************************************************\n"
                            + " FIN..... ");
                    break;
            }

        } while (!finalizar);
        System.out.println("\nFin...");
        mongoClient.close();

    }

}
