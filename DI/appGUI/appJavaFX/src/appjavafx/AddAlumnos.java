/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appjavafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 *
 * @author edgar
 */
public class AddAlumnos {
    
    @FXML
    private TableView<?> tablaAlumnos;
    
    @FXML
    private TableColumn<?, ?> colNombre;

    @FXML
    private TableColumn<?, ?> colApellidos;

    @FXML
    private TableColumn<?, ?> colEdad;

    @FXML
    private TextField idFiltrar;

    @FXML
    void añadirAlumno(ActionEvent event) {

    }

    @FXML
    void eliminarAlumno(ActionEvent event) {

    }

    @FXML
    void filtrarNombre(ActionEvent event) {

    }

    @FXML
    void modificarAlumno(ActionEvent event) {

    }
    
}
