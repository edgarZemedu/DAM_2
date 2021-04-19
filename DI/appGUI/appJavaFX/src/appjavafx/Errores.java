/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appjavafx;

import clases.Alumnos;
import javafx.scene.control.Alert;

/**
 *
 * @author A C E R
 */
public class Errores {
    //Control de entrada de datos

    public static void tfVacio(String tfN, String tfA) {
        if (tfN.isEmpty() || tfA == null || tfA == "") {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Error,no puede quedar el nombre");
            alert.showAndWait();
        }
        if (tfA.isEmpty() || tfA == null || tfA == "") {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Error,no puede quedar vacio el apellido");
            alert.showAndWait();
        }
    }

    public static void tfVacioInteger(String tfE) {
        try {
            Integer.parseInt(tfE);
        } catch (NumberFormatException nfe) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Error,la edad tiene que ser un número entero");
            alert.showAndWait();
        }
    }
    //objeto vacio
    public static void getObject(Alumnos a) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setTitle("Error");
        alert.setContentText("La persona introducida ya está en la tabla");
        alert.showAndWait();
    }
}
