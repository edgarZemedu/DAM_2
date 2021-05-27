/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operaciones;

import Clases.Articulos;
import Libreria.ControlData;
import Menu.Menu;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.gte;
import static com.mongodb.client.model.Filters.lte;
import static com.mongodb.client.model.Filters.ne;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import org.bson.Document;

/**
 *
 * @author A C E R
 */
public class OperacionesMongoDB {

    static Scanner sc = new Scanner(System.in);

    public static void agregarDatos(MongoCollection<Document> coleccion) {
        System.out.println("Dime el id: ");
        int id = ControlData.lerInt(sc);
        System.out.println("Dime el nombre: ");
        String nombre = ControlData.lerString(sc);
        System.out.println("Dime el tipo: ");
        String tipo = ControlData.lerString(sc);
        System.out.println("Dime el precio: ");
        int precio = ControlData.lerInt(sc);
        System.out.println("Dime el stock: ");
        int stock = ControlData.lerInt(sc);

        Articulos a = new Articulos(id, nombre, tipo, precio, stock);
        if (a != null) {
            Document d = new Document()
                    .append("_id", id)
                    .append("Nombre ", nombre)
                    .append("Tipo ", tipo)
                    .append("Precio", precio)
                    .append("Stock ", stock);
//
//        List<Document> listD = new ArrayList<Document>();
//        listD.add(new Document()
//                .append("_id", 2)
//                .append("Nombre", "MULTIFUNCION EPSON EXPRESSION XP241")
//                .append("Tipo ", "impresora")
//                .append("Precio", 3700)
//                .append("Stock ", 5)
//        );
//        );
//        listD.add(new Document()
//                .append("_id", 4)
//                .append("Nombre", "LED 22 PHILIPS")
//                .append("Tipo ", "monitor")
//                .append("Precio", 5700)
//                .append("Stock ", 4)
//        );
//        listD.add(new Document()
//                .append("_id", 5)
//                .append("Nombre", "LED 27 PHILIPS")
//                .append("Tipo ", "monitor")
//                .append("Precio", 12000)
//                .append("Stock ", 21)
//        );

            coleccion.insertOne(d);
            //coleccion.insertMany(listD);
            System.out.println("Éxitooo...");
        }
    }

    public static void mostrarDatos(MongoCollection<Document> coleccion) {

        Iterator it = coleccion.find().iterator();
        System.out.println("Empieza...\n");

        while (it.hasNext()) {
            System.out.println("-> " + it.next().toString());

        }
    }

    public static void mostrarDatosSinImp(MongoCollection<Document> coleccion) {

        Iterator it = coleccion.find(ne("tipo", "impresora")).iterator();
        System.out.println("Empieza...\n");

        while (it.hasNext()) {
            System.out.println("-> " + it.next().toString());

        }
    }

    public static void mostrarDatosMouse(MongoCollection<Document> coleccion) {

        Iterator it = coleccion.find(eq("tipo", "mouse")).iterator();
        System.out.println("Empieza...\n");

        while (it.hasNext()) {
            System.out.println("-> " + it.next().toString());

        }
    }

    public static void mostrarDatosMayor(MongoCollection<Document> coleccion) {

        Iterator it = coleccion.find(gte("precio", 5000)).iterator();
        System.out.println("Empieza...\n");

        while (it.hasNext()) {
            System.out.println("-> " + it.next().toString());

        }
    }

    public static void mostrarDatosImpresorasMenores(MongoCollection<Document> coleccion) {

        Iterator it = coleccion.find(and(eq("tipo", "impresora"), gte("precio", 3500))).iterator();
        System.out.println("Empieza...\n");

        while (it.hasNext()) {
            System.out.println("-> " + it.next().toString());

        }
    }

    public static void mostrarDatosStock(MongoCollection<Document> coleccion) {

        Iterator it = coleccion.find(and(gte("stock", 0), lte("stock", 4))).iterator();
        System.out.println("Empieza...\n");

        while (it.hasNext()) {
            System.out.println("-> " + it.next().toString());

        }
    }

    public static void modificarPrecioMouse(MongoCollection<Document> coleccion) {

        coleccion.updateOne(
                new Document("nombre", "LOGITECH M90"),
                new Document("$set", new Document("precio", 200)));
        System.out.println("PRECIO MOFIFICADO");
    }

    public static void moficarStockConID(MongoCollection<Document> coleccion) {
        coleccion.updateOne(
                new Document("_id", 6),
                new Document("$set", new Document("stock", 0)));
        System.out.println("STOCK MOFIFICADO");

    }

    public static void agregarArray(MongoCollection<Document> coleccion) {

//        coleccion.updateOne(
//                new Document("_id", 6),
//                new Document("$set", new Document("proveedores", "Martinez")));
//          coleccion.updateOne(
//                  {"_id": 6},
//                  [{$set:{proveedores:{$concatArrays:["$proveedores",["dsdg","asa"]]}}}]);
        List<String> lista = new ArrayList<>();
        lista.add("Martinez");
        lista.add("Gutierrez");

        Document setLista = new Document("proveedres", lista);
        Document update = new Document("$set", setLista);
        Document query = new Document("_id", 6);

        coleccion.updateOne(query, update);

    }

    public static void eliminarCampo(MongoCollection<Document> coleccion) {        
        //coleccion.deleteOne(new Document("_id", 6));
        
//        List<String> lista = new ArrayList<>();
//        lista.add("Martinez");
//        lista.add("Gutierrez");
//
//        Document setLista = new Document("proveedres", lista);
        Document update = new Document("$unset", "proveedres");
        Document query = new Document("_id", 6);
        
        coleccion.updateOne(query, update);
        
        System.out.println("Hecho...\n");
    }

    public static void modificarDatos(MongoCollection<Document> coleccion) {
        //clave-valor
//        System.out.println("Dime que quieres modificar(id/precio):");
//        String eleccion = ControlData.lerString(sc);
//
//        if (eleccion.equalsIgnoreCase("precio")) {
//            System.out.println("Dime el precio");
//            int precioMOdif = ControlData.lerInt(sc);
//            if (precioMOdif == 0) {
//                coleccion.updateOne(
//                        new Document("nombre", "LOGITECH M90"),
//                        new Document("$set", new Document("precio", precioMOdif)));
//
//                System.out.println("PRECIO MOFIFICADO a: "+precioMOdif);
//            }
//
//        }
        System.out.println("Dime el id: ");
        int id = ControlData.lerInt(sc);
        System.out.println("Dime el nombre: ");
        String nombre = ControlData.lerString(sc);
        System.out.println("Dime el tipo: ");
        String tipo = ControlData.lerString(sc);
        System.out.println("Dime el precio: ");
        int precio = ControlData.lerInt(sc);
        System.out.println("Dime el stock: ");
        int stock = ControlData.lerInt(sc);

        Articulos a = new Articulos(id, nombre, tipo, precio, stock);
        coleccion.replaceOne(new Document("_id", a.getId()),
                new Document()
                        .append("nombre", nombre)
                        .append("tipo", tipo)
                        .append("precio", precio)
                        .append("stock", stock));

        //coleccion.insertMany(listD);
        System.out.println("El producto con id " + id + " y " + nombre + " ha sido introducido correctamente");
//        Document dBuscar = new Document("nombre", "LOGITECH M90");
//        FindIterable findIterable = (FindIterable) coleccion
//                .find(dBuscar)
//                .limit(1); //solo extrae un resultado
//
//        Iterator<Document> it = findIterable.iterator();
//        //Iterable iterator = coleccion.find(gte("precio", 5000));
//        System.out.println("Empieza...\n");
//        Articulos a = new Articulos();
//        while (it.hasNext()) {
//            Document d = it.next();
//            a.setId(d.getInteger("_id"));
//            a.setNombre(d.getString("Nombre"));
//            a.setTipo(d.getString("Tipo"));
//            a.setPrecio(Float.parseFloat(d.getString("Precio")));
//            a.setStock(d.getInteger("Stock"));
//            System.out.println(a.toString());
//        }

    }
//
//    public static void modificarPrecio(MongoDatabase db) {
//
//        MongoCollection<Document> coleccion = db.getCollection("articulos");
//        db.getCollection("articulos")
//                .updateOne(new Document("nombre", "LOGITECH M90"),
//                        new Document("$set", new Document("precio", 6)));
//    }
//    public static void actualizarDatosporNombre() {
//        System.out.println("el id ");
//        MongoCollection<Document> coleccion = db.getCollection("articulos");
//        db.getCollection("articulos")
//                .updateOne(new Document("nombre", "LOGITECH M90"),
//                        new Document("$set", new Document("precio", 6)));
//    }
}
