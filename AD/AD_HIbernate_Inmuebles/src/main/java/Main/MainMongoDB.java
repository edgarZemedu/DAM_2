/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.bson.Document;

/**
 *
 * @author a18zemedufc
 */
public class MainMongoDB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MongoClient mongoClient = new MongoClient();
        MongoDatabase db = mongoClient.getDatabase("COMPRAS");
        //CREAR
        db.createCollection("articulos");        
            //una forma de añadir
            
        List<Document> d = new ArrayList<Document>
            .append("_id", 1)
            .append("Nombre ", "MULTIFUNCION HP DESKJET 2675")
            .append("Tipo ", "impresora")
            .append("Precio", "3000")
            .append("Stock ", 20);
            //Esta es otra forma de añadir
            
        
        
        MongoCollection<Document> coleccion = db.getCollection("articulos");
        coleccion.insertOne(d);
        coleccion.insertMany(documents);
        //VISUALIZAR
        Iterator it = coleccion.find().iterator();        
        while(it.hasNext()){
            System.out.println("\n-> "+ it.next().toString());
            
        }
    }
    
}
