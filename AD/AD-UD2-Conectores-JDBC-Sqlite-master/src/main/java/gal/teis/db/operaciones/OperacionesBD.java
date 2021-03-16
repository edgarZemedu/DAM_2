/*
 * This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS for A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package gal.teis.db.operaciones;

import gal.teis.excepciones.OperacionBaseDatosException;
import java.io.File;
import java.io.StringWriter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

/**
 *
 * @author Esther Ferreiro
 */
public class OperacionesBD {

    /**
     * ****************** CREAR BASE DE DATOS********************************
     */
    /**
     * Crea las tablas de la base de datos
     *
     * @param laConexion Objeto Connection, conexión de la base de datos
     * @throws OperacionBaseDatosException
     */
    public static void crearBD(Connection laConexion) throws OperacionBaseDatosException {

        try {
            Statement elStatement = laConexion.createStatement();

            elStatement.execute("CREATE TABLE LIBROS "
                    + "(IDLIBRO INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
                    + " TITULO  VARCHAR(50) NOT NULL,"
                    + " AUTOR  VARCHAR(50) NOT NULL,"
                    + " PRECIO  FLOAT);");

        } catch (SQLException ex) {
            //En el caso de que no se pueda ejecutar, lo más probable es que sea porque ya están creadas
            //El mensaje lo tomo hasta e primer \n pues es donde indica la información útil
            String mensaje = "No se ha podido realiazar la operación\n"
                    + ex.getMessage();
            throw new OperacionBaseDatosException(mensaje);
        }

    }

    /*
     * ****************** ALTAS EN LA BASE DE DATOS**************************
     */
    /**
     * Da de alta libros en la tabla LIBROS
     *
     * @param laConexion Objeto Connection, conexión de la base de datos
     * @param titulo String, título del libro
     * @param autor String, autor del libro
     * @param precio double, precio del libro
     * @return String, mensaje resultado de la operación
     * @throws OperacionBaseDatosException
     */
    public static String altaLibros(Connection laConexion, String titulo, String autor, double precio) throws OperacionBaseDatosException {
        String mensaje = "";
        try {
            // Preparamos la consulta
            // El parámetro Statement.RETURN_GENERATED_KEYS permite recuperar el ID autogenerado tras el INSERT
            PreparedStatement elPrepareStatement = laConexion.prepareStatement("INSERT INTO LIBROS (TITULO,AUTOR, PRECIO) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);
            //Asignamos los parámetros
            elPrepareStatement.setString(1, titulo);
            elPrepareStatement.setString(2, autor);
            elPrepareStatement.setDouble(3, precio);
            //Ejecutamos la operación de inserción en la tabla LIBROS
            int affectedRows = elPrepareStatement.executeUpdate();
            mensaje = "Se ha agregado " + affectedRows + " libro a la tabla LIBROS";
        } catch (SQLException e) {
            //En el caso de que no se pueda ejecutar, lo más probable es que sea porque ya están creadas
            mensaje = "No se ha podido realizar la operación de alta solicitada\n";
            throw new OperacionBaseDatosException(mensaje + "\n" + e.getMessage());
        }
        return mensaje;
    }

    /**
     * ****************** BAJAS EN LA BASE DEDATO******************************
     */
    /**
     * Permite dar de baja un libro conociendo el título
     *
     * @param laConexion Objeto Connection, conexión de la base de datos
     * @param titulo String, título del libro
     * @return String, mensaje resultado de la operación
     * @throws OperacionBaseDatosException
     */
    public static String bajaLibrosPorTitulo(Connection laConexion, String titulo) throws OperacionBaseDatosException {
        String mensaje = "";
        try {
            // Preparamos la consulta
            // El parámetro Statement.RETURN_GENERATED_KEYS permite recuperar el ID autogenerado tras el INSERT
            PreparedStatement elPrepareStatement = laConexion.prepareStatement("DELETE FROM LIBROS WHERE TITULO = ?", Statement.RETURN_GENERATED_KEYS);
            //Asignamos los parámetros
            elPrepareStatement.setString(1, titulo);
            //Ejecutamos la operación de inserción en la tabla LIBROS
            int affectedRows = elPrepareStatement.executeUpdate();
            mensaje = "Se ha eliminado " + affectedRows + " libro de la tabla LIBROS";
        } catch (SQLException e) {
            //En el caso de que no se pueda ejecutar, lo más probable es que sea porque ya están creadas
            mensaje = "No se ha podido realizar la operación de alta solicitada\n";
            throw new OperacionBaseDatosException(mensaje + "\n" + e.getMessage());
        }
        return mensaje;

    }

    /**
     * ****************** CONSULTAS EN LA BASE DE DATOS************************
     */
    /**
     * Muestra los libros que se corresponden con un título determinado
     *
     * @param laConexion Objeto Connection, conexión de la base de datos
     * @param titulo String, título del libro, campo de búsqueda
     * @return String, mensaje con la información de los libros encontrados
     * @throws OperacionBaseDatosException
     */
    public static String consultaLibroPorTitulo(Connection laConexion, String titulo) throws OperacionBaseDatosException {

        PreparedStatement elPrepareStatement = null;
        String resultado = "";
        ResultSet elResultSet = null;
        int count = 0;
        try {
            // Preparamos la consulta
            elPrepareStatement = laConexion.prepareStatement("SELECT * FROM LIBROS WHERE TITULO = ?");
            //Asignamos los parámetros
            elPrepareStatement.setString(1, titulo);
            //ejecuta la operación de inserción
            elResultSet = elPrepareStatement.executeQuery();

            /*Recorre el ResultSet, conociendo en nombre y el tipo de los
                campos que se quieren leer*/
            while (elResultSet.next()) {
                resultado += " ID: " + elResultSet.getInt("IDLIBRO");
                resultado += " TITULO: " + elResultSet.getString("TITULO");
                resultado += " AUTOR: " + elResultSet.getString("AUTOR");
                resultado += " PRECIO: " + elResultSet.getDouble("PRECIO");
                resultado += "\n";
                count++;
            }
            resultado += "Se han encontrado " + count + " libros";
        } catch (SQLException e) {
            //En el caso de que no se pueda ejecutar, lo más probable es que sea porque ya están creadas
            String mensaje = "Se ha producido un error desconocido en la base de datos.\n Póngase en contacto con el/la responsable\n";
            throw new OperacionBaseDatosException(mensaje);
        }
        return resultado;

    }

    /**
     * Muestra los libros que se corresponden con un ID determinado
     *
     * @param laConexion Objeto Connection, conexión de la base de datos
     * @param id in, identificador único del libro, campo de búsqueda
     * @return String, mensaje con la información de los libros encontrados
     * @throws OperacionBaseDatosException
     */
    public static String consultaLibroPorId(Connection laConexion, int id) throws OperacionBaseDatosException {

        PreparedStatement elPrepareStatement = null;
        String resultado = "";
        ResultSet elResultSet = null;
        int count = 0;
        try {
            // Preparamos la consulta
            elPrepareStatement = laConexion.prepareStatement("SELECT * FROM LIBROS WHERE IDLIBRO = ?");
            //Asignamos los parámetros
            elPrepareStatement.setInt(1, id);
            //ejecuta la operación de inserción
            elResultSet = elPrepareStatement.executeQuery();

            /*Recorre el ResultSet, conociendo en nombre y el tipo de los
                campos que se quieren leer*/
            while (elResultSet.next()) {
                resultado += " ID: " + elResultSet.getInt("IDLIBRO");
                resultado += " TITULO: " + elResultSet.getString("TITULO");
                resultado += " AUTOR: " + elResultSet.getString("AUTOR");
                resultado += " PRECIO: " + elResultSet.getDouble("PRECIO");
                resultado += "\n";
                count++;
            }
            resultado += "Se han encontrado " + count + " libros";
        } catch (SQLException e) {
            //En el caso de que no se pueda ejecutar, lo más probable es que sea porque ya están creadas
            String mensaje = "Se ha producido un error desconocido en la base de datos.\n Póngase en contacto con el/la responsable\n";
            throw new OperacionBaseDatosException(mensaje);
        }
        return resultado;

    }

    /**
     * Muestra los libros que se corresponden con un autor determinado
     *
     * @param laConexion Objeto Connection, conexión de la base de datos
     * @param autor String, autor del libro, campo de búsqueda
     * @return String, mensaje con la información de los libros encontrados
     * @throws OperacionBaseDatosException
     */
    public static String consultaLibroPorAutor(Connection laConexion, String autor) throws OperacionBaseDatosException {

        PreparedStatement elPrepareStatement = null;
        String resultado = "";
        ResultSet elResultSet = null;
        int count = 0;
        try {
            // Preparamos la consulta
            elPrepareStatement = laConexion.prepareStatement("SELECT * FROM LIBROS WHERE AUTOR = ?");
            //Asignamos los parámetros
            elPrepareStatement.setString(1, autor);
            //ejecuta la operación de inserción
            elResultSet = elPrepareStatement.executeQuery();

            /*Recorre el ResultSet, conociendo en nombre y el tipo de los
                campos que se quieren leer*/
            while (elResultSet.next()) {
                resultado += " ID: " + elResultSet.getInt("IDLIBRO");
                resultado += " TITULO: " + elResultSet.getString("TITULO");
                resultado += " AUTOR: " + elResultSet.getString("AUTOR");
                resultado += " PRECIO: " + elResultSet.getDouble("PRECIO");
                resultado += "\n";
                count++;
            }
            resultado += "Se han encontrado " + count + " libros";
        } catch (SQLException e) {
            //En el caso de que no se pueda ejecutar, lo más probable es que sea porque ya están creadas
            String mensaje = "Se ha producido un error desconocido en la base de datos.\n Póngase en contacto con el/la responsable\n";
            throw new OperacionBaseDatosException(mensaje);
        }
        return resultado;

    }

    /**
     * Muestra los libros que se corresponden con un autor determinado
     *
     * @param laConexion Objeto Connection, conexión de la base de datos
     * @param precio double, precio del libro, campo de búsqueda
     * @return String, mensaje con la información de los libros encontrados
     * @throws OperacionBaseDatosException
     */
    public static String consultaLibroPorPrecio(Connection laConexion, double precio) throws OperacionBaseDatosException {

        PreparedStatement elPrepareStatement = null;
        String resultado = "";
        ResultSet elResultSet = null;
        int count = 0;
        try {
            // Preparamos la consulta
            elPrepareStatement = laConexion.prepareStatement("SELECT * FROM LIBROS WHERE PRECIO = ?");
            //Asignamos los parámetros
            elPrepareStatement.setDouble(1, precio);
            //ejecuta la operación de inserción
            elResultSet = elPrepareStatement.executeQuery();

            /*Recorre el ResultSet, conociendo en nombre y el tipo de los
                campos que se quieren leer*/
            while (elResultSet.next()) {
                resultado += " ID: " + elResultSet.getInt("IDLIBRO");
                resultado += " TITULO: " + elResultSet.getString("TITULO");
                resultado += " AUTOR: " + elResultSet.getString("AUTOR");
                resultado += " PRECIO: " + elResultSet.getDouble("PRECIO");
                resultado += "\n";
                count++;
            }
            resultado += "Se han encontrado " + count + " libros";
        } catch (SQLException e) {
            //En el caso de que no se pueda ejecutar, lo más probable es que sea porque ya están creadas
            String mensaje = "Se ha producido un error desconocido en la base de datos.\n Póngase en contacto con el/la responsable\n";
            throw new OperacionBaseDatosException(mensaje);
        }
        return resultado;

    }

    /**
     * Muestra todos los libros de la tabla LIBROS
     *
     * @param laConexion Objeto Connection, conexión de la base de datos
     * @return String, mensaje con la información de los libros encontrados
     * @throws OperacionBaseDatosException
     */
    public static String consultaTodoLosLibros(Connection miConexion) throws OperacionBaseDatosException {
        String resultado = "";
        // Preparamos la consulta
        try ( Statement elStatement = miConexion.createStatement()) {
            String sql = "SELECT * FROM LIBROS";

            try ( ResultSet resul = elStatement.executeQuery(sql)) {

                //Se utilizan metadatos para averiguar el nombre de los campos
                for (int i = 1; i <= resul.getMetaData().getColumnCount(); i++) {
                    resultado += resul.getMetaData().getColumnName(i) + "\t\t\t";
                }

                resultado += "\n";

                while (resul.next()) {
                    /*Se utilizan metadatos para recorrer la columnas del recordset
                    Se recoge todo como String por el el tipo que puede incluir a 
                    todos los tipos específicos de la tabla*/
                    for (int i = 1; i <= resul.getMetaData().getColumnCount(); i++) {
                        resultado += resul.getString(i) + "\t\t\t";
                    }
                    resultado += "\n";
                }
            }
        } catch (SQLException e) {
            //Envio a la excepción propia el mensaje de la excepción que se produzca aquí
            throw new OperacionBaseDatosException(e.getMessage());
        }
        return resultado;
    }

    public static String consultaTodoLosLibrosToXML(Connection miConexion) throws OperacionBaseDatosException {
        String resultado = "";
        // Preparamos la consulta
        try ( Statement elStatement = miConexion.createStatement()) {
            //String sql = "SELECT * FROM LIBROS";

            String sql = "SELECT * FROM LIBROS";

            try ( ResultSet resul = elStatement.executeQuery(sql)) {

                //Se utilizan metadatos para averiguar el nombre de los campos
                for (int i = 1; i <= resul.getMetaData().getColumnCount(); i++) {
                    resultado += resul.getMetaData().getColumnName(i) + "\t\t\t";
                }

                resultado += "\n";

                while (resul.next()) {
                    /*Se utilizan metadatos para recorrer la columnas del recordset
                    Se recoge todo como String por el el tipo que puede incluir a 
                    todos los tipos específicos de la tabla*/
                    for (int i = 1; i <= resul.getMetaData().getColumnCount(); i++) {
                        resultado += resul.getString(i) + "\t\t\t";
                    }
                    resultado += "\n";
                }
            }
        } catch (SQLException e) {
            //Envio a la excepción propia el mensaje de la excepción que se produzca aquí
            throw new OperacionBaseDatosException(e.getMessage());
        }
        return resultado;

    }

    public static void crearXML(Connection miConexion) throws Exception {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.newDocument();
        Element libross = doc.createElement("LIBROS");
        doc.appendChild(libross);

        ResultSet rs = miConexion.createStatement().executeQuery("SELECT * FROM LIBROS");

        while (rs.next()) {
            Element libro = doc.createElement("LIBRO");
            libross.appendChild(libro);
            for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                String columnName = rs.getMetaData().getColumnName(i);
                Object value = rs.getObject(i);
                if (columnName.equals("IDLIBRO")) {
                    Attr atributo = doc.createAttribute(columnName);
                    atributo.setValue(String.valueOf(value));
                    libro.setAttributeNode(atributo);
                } else {
                    Element elemento = doc.createElement(columnName);
                    elemento.appendChild(doc.createTextNode(value.toString()));
                    libro.appendChild(elemento);
                }
            }
        }
        System.out.println("Éxito, se ha creado el fichero! ....Viendolo por consola -> \n");
        crearFicheroXML(doc);
        if (!Objects.isNull(doc)) {
            System.out.println("Acceso Recursivo");
            Node node = doc;
            mostrarDOM_Recursivo(node);
        }

        rs.close();

    }

    public static void crearFicheroXML(Document documento) throws TransformerException {
        Source sourceDOM = new DOMSource(documento);
        Result resultado = new StreamResult(new File("libros.xml"));//PARA CREAR EL FICHERO
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.transform(sourceDOM, resultado);
    }

    static void mostrarXML(Document documento) throws TransformerException {
        Source sourceDOM = new DOMSource(documento);
        Result consola = new StreamResult(System.out);
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.transform(sourceDOM, consola);
        //POR CONSOLA
    }

    static void mostrarDOM_Recursivo(Node node) {

        switch (node.getNodeType()) {
            case Node.DOCUMENT_NODE:
                Document doc = (Document) node;
                mostrarDOM_Recursivo(doc.getDocumentElement());
            case Node.ELEMENT_NODE:
                Element elemento = (Element) node;
                System.out.print("<" + elemento.getNodeName());
                NamedNodeMap atributo = elemento.getAttributes();
                //NodeList hijos = node.getChildNodes();
                if (atributo.getLength() != 0) {
                    for (int i = 0; i < atributo.getLength(); i++) {
                        mostrarDOM_Recursivo(atributo.item(i));
                    }
                }
                System.out.println(">");
                if (node.getChildNodes().getLength() > 0) {
                    for (int i = 0; i < node.getChildNodes().getLength(); i++) {
                        mostrarDOM_Recursivo(node.getChildNodes().item(i));
                    }
                }
                System.out.println("</" + elemento.getNodeName() + ">");
                break;
            case Node.ATTRIBUTE_NODE:
                Attr at = (Attr) node;
                System.out.print(" " + at.getNodeName() + " = " + at.getNodeValue());
                break;
            case Node.TEXT_NODE:
                Text texto = (Text) node;
                System.out.println("\t" + texto.getTextContent().strip());
                break;
        }

//  static void mostrarDOM_Recursivo(Document documento) {
//        System.out.println("Acceso Recursivo");
//        NodeList nodeLista =  documento.getChildNodes();
//        
//        boolean salir = false;
//        for (int i = 0; i < nodeLista.getLength(); i++) {
//            Node node = nodeLista.item(i);
//            switch (node.getNodeType()) {
//                case Node.ELEMENT_NODE:
//                    Element elemento = (Element) node;
//                    System.out.println("<" + elemento.getNodeName());
//                    NamedNodeMap atributo = elemento.getAttributes();
//                    //NodeList hijos = node.getChildNodes();
//                    if (atributo.getLength() != 0) {
//                        salir = false;
//                    }
//                    if (node.getChildNodes().getLength() > 0) {
//                        System.out.print(">");
//                        if (node.getChildNodes() != null) {
//                            salir = false;
//                        }
//                        System.out.println("\n</" + elemento.getNodeName() + ">");
//                    } else {
//                        System.out.println("/>");
//                    }//
//                    break;
//                case Node.ATTRIBUTE_NODE:
//                    Attr at = (Attr) node;
//                    System.out.println(" "+at.getNodeName()+" = "+at.getNodeValue());
//                    break;
//                case Node.TEXT_NODE:
//                    Text texto = (Text) node;
//                    System.out.println(texto.getTextContent().strip());
//                    break;
//            }
//        }
    }

}
