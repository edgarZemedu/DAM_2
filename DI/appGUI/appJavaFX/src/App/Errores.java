/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import clases.Alumnos;
import javafx.scene.control.Alert;

/**
 *
 * @author A C E R
 */
public class Errores {

    //Control de entrada de datos
    public static void nullNombre() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setTitle("Error");
        alert.setContentText("Debes introducir el nombre ");
        alert.showAndWait();
    }

    public static void comboBox() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setTitle("Error");
        alert.setContentText("Ya existe uno con este nombre");
        alert.showAndWait();
    }

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

    public static void estaVacio() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setTitle("Error");
        alert.setContentText("Esta vacio ");
        alert.showAndWait();
    }

    //objeto vacio
    public static void getObject() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setTitle("Error");
        alert.setContentText(" Ya existe ese objeto");
        alert.showAndWait();
    }

    public static void noHay() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setTitle("Error");
        alert.setContentText("No existe ese Alumno"
                + "\nDebes seleccionar al alumno primero para modificar");
        alert.showAndWait();
    }

    public static void correcto() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("Informacion");
        alert.setContentText("Se ha modificado correctamente");
        alert.showAndWait();
    }

    public static void seleccionar() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setTitle("Error");
        alert.setContentText("Primero selecciona el curso");
        alert.showAndWait();
    }
}
