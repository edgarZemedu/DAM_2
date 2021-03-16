/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import ControlData.ControlData;
import MisExcepciones.Excepciones;
import static app.miMenu.sc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author A C E R
 */
public class Consultas {

    static ArrayList<Libro> listaLibros = new ArrayList<Libro>();

    public void crearBD(Connection conexion) throws Excepciones {

        try {
            Statement statement = conexion.createStatement();
            statement.execute("CREATE TABLE LIBROS ("
                    + "ID INT NOT NULL PRIMARY KEY AUTOINCREMENT,"
                    + "TITULO VARCHAR(50) NOT NULL,"
                    + "AUTOR VARCHAR(50) NOT NULL,"
                    + "PRECIO FLOAT "
                    + ");");
            System.out.println("La tabla se ha creado!! ");
        } catch (SQLException ex) {
            throw new Excepciones();
        }
    }

    public void addDatos(Connection conexion) throws Excepciones {
        do {
            System.out.println("Introduce el título del libro: ");
            String titulo = ControlData.lerString(sc);
            System.out.println("Introduce el autor del libro: ");
            String autor = ControlData.lerString(sc);
            System.out.println("Introduce el precio del libro: ");
            Double precio = ControlData.lerDouble(sc);

            //id se calcula automaticamente
            Libro libro = new Libro(titulo, autor, precio);
            listaLibros.add(libro);
            System.out.println("Quieres seguir metiendo libros: (s/n)");

        } while ((ControlData.lerNome(sc).equalsIgnoreCase("s")));    //.toString()

        try {
            conexion.setAutoCommit(false);

            for (Libro i : listaLibros) {

                PreparedStatement ps = conexion.prepareStatement("INSERT INTO LIBROS VALUES (?,?,?)");

                ps.setString(1, i.titulo);
                ps.setString(2, i.autor);
                ps.setDouble(3, i.precio);

                System.out.println("Se agrego " + ps.executeUpdate() + " libro de la tabla");
            }
            conexion.commit();
            conexion.setAutoCommit(true);
        } catch (SQLException ex) {
            throw new Excepciones();
        }
    }

    /**
     * bajas
     */
    public void bajasDatos(Connection conexion) throws Excepciones {
        do {
            System.out.println("Introduce el título del libro: ");
            String titulo = ControlData.lerString(sc);

            try {
                PreparedStatement ps = conexion.prepareStatement("DELETE FROM LIBROS WHERE TITULO = ?", Statement.RETURN_GENERATED_KEYS);
                 ps.setString(1, titulo);

                System.out.println("Se eliminó " + ps.executeUpdate() + " libro de la tabla");

            } catch (SQLException ex) {
                throw new Excepciones();
            } 
            
            System.out.println("Quieres seguir eliminando libros: (s/n)");      
        } while ((ControlData.lerNome(sc).equalsIgnoreCase("s")));
    }
    
    public void colsultasTabla(Connection conexion) throws Excepciones{
        String resultado = "";
        try{
            
            Statement st = conexion.createStatement();
            String consultaSQL = "SELECT * FROM LIBROS";

            ResultSet rs = st.executeQuery(consultaSQL);
            //nombre de las columnas
            for (int i = 0; i <= rs.getMetaData().getColumnCount(); i++) {
                resultado = rs.getMetaData().getCatalogName(i)+"\t\t\t";
            }
            resultado += "\n";
            //valores de cada columna
            while(rs.next()){
                for (int i = 0; i <= rs.getMetaData().getColumnCount(); i++) {
                    resultado = rs.getString(i)+"\t\t\t";
                }
                resultado += "\n";
            }
            System.out.println(resultado);
        } catch (SQLException ex) {
            throw new Excepciones();
        }
    }

}
