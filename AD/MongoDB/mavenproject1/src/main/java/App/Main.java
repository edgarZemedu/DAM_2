/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import Clase.Modulo;
import java.util.Iterator;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
/**
 *
 * @author a18zemedufc
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        MongoClient mongoClient = new MongoClient();
        MongoDatabase db = mongoClient.getDatabase("InstitutoTeis");
        
        MongoCollection<Document> coleccion = db.getCollection("DAM_2");
        
        Iterator it = coleccion.find().iterator();
          
        while(it.hasNext()){
            System.out.println("\n-> "+" => "+ it.next().toString());
        }
        
        /***********OPERACIONES CRUD**********/
        //INSERTAR
        Document doc = new Document()
            .append("_id", 2)
            .append("Asignatura ", " AD")
            .append("Descripcion ", " Acceso a datos desde java")
            .append("Horas ", 157);
        coleccion.insertOne(doc);  
        it = coleccion.find().iterator();
        while(it.hasNext()){
            System.out.println("\n-> "+ it.next().toString());
        }
        //BORRADO
        coleccion.deleteOne(new Document("_id",3));
        //LECTURA
        Modulo m = new Modulo();
        Document doc2 = new Document("Asignatura","AD");
        FindIterable itBuscador = (FindIterable) db.getCollection("DAM_2")
                    .find(doc2)
                    .limit(1);
        Iterator it3 = itBuscador.iterator();
        it = itBuscador.iterator();
        while(it.hasNext()){//
            Document docCaptura = (Document) it.next();
            m.setId(0);
        }
        
        mongoClient.close();
    }
    
}
