/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.sql.Connection;
import java.util.Scanner;

import ConexionSingleton.ConexionSingleton;
import MisExcepciones.Excepciones;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author A C E R
 */
public class Main {

    //static Scanner sc = new Scanner(System.in);
    //static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<Libro> losLibros = new ArrayList<Libro>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        
        boolean fin = false;
        //String nombreDB = "ejemplo2.db";
        
        try {
            Connection miConexion = ConexionSingleton.getConnection("jdbc:sqlite:.\\DB\\ejemploEspecial" /*+ nombreDB*/);
            do {
                //System.out.println("exito");                
                switch (miMenu.printMenu()) {
                    case 1: //crear la base de datos 
                        try{
                            new Consultas().crearBD(miConexion);   
                        } catch (Excepciones ex) {                            
                            ex.operacionBaseDatosException("Error case 1\n"
                                    + "Seguramente se ya está creada la base de datos\n");
                        }                            
                        break;

                    case 2: //altas en la tabla libros
                        try{
                            new Consultas().addDatos(miConexion);
                        } catch (Excepciones ex) {
                            ex.operacionBaseDatosException("Error case 2\n");
                        }                        
                        break;

                    case 3://BAJAS
                        try{
                            new Consultas().bajasDatos(miConexion);
                        } catch (Excepciones ex) {
                            ex.operacionBaseDatosException("Error case 2\n");
                        }                          
                        break;
                        
                    case 4://Consultas
                        switch(miMenu.printMenuConsultas()){
                            case 1: //consulta Tabla
                                try{
                                    new Consultas().colsultasTabla(miConexion);
                                } catch (Excepciones ex) {
                                    ex.operacionBaseDatosException("Error en la consulta de la tabla\n");
                                }
                                break;

                                
                            case 2:
                                break;
                            case 3:
                                break;
                            case 4:
                                break;
                            case 5:
                                break;
                            default:
                                break;
                        }
                        break;
                    case 5:
                        System.out.println("Chaoo!!");
                        fin = true;
                        break;
                    default:
                        throw new AssertionError();
                }
            } while (!fin);

        } catch (SQLException ex) {
            System.out.println("ERROR al entrar en la conección con la base de datos");
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
