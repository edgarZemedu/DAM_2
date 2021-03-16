/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexionSingleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Properties;

/**
 *
 * @author A C E R
 */
public class ConexionSingleton {
    private final String cadenaConexion;
    private final Connection laConexion;

    private static ConexionSingleton laConexionSingelton;

    /**
     * Devuelve una conexión de la base de datos y garantiza que solo existirá
     * una instancia de la misma.
     *
     * @param cadenaConexion La cadena de conexión de la base de datos
     * @return una instancia de la conexión a una base de datos
     */
    public static Connection getConnection(String cadenaConexion)
            throws SQLException {
        if (Objects.isNull(laConexionSingelton)) {
            laConexionSingelton = new ConexionSingleton(cadenaConexion);
        }
        return laConexionSingelton.laConexion;
    }

    public static Connection getConnection(String cadenaConexion, String usuario, String pass)
            throws SQLException {
        if (Objects.isNull(laConexionSingelton)) {
            laConexionSingelton = new ConexionSingleton(cadenaConexion);
        }
        return laConexionSingelton.laConexion;
    }
    /**
     * Constructor privado que es llamado por el método público y estático de la
     * clase para garantizar la existencia de una única instancia de la misma.     *
     * @param url
     * @param baseDatos
     */
    private ConexionSingleton(String cadenaConexion) throws SQLException {
        this.cadenaConexion = cadenaConexion;
        this.laConexion = DriverManager.getConnection(cadenaConexion);
    }

    private ConexionSingleton(String cadenaConexion, String username, String password) throws SQLException {
        Properties connectionProps = new Properties();
        connectionProps.put("user", username);
        connectionProps.put("password", password);
        //connectionProps.put("serverTimezone", "UTC");
        this.cadenaConexion = cadenaConexion;
        this.laConexion = DriverManager.getConnection(cadenaConexion, connectionProps);
    }
}
