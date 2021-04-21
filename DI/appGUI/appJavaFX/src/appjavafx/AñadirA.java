/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appjavafx;

import clases.Alumnos;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author A C E R
 */
public class AñadirA implements Initializable {

    @FXML
    private TextField tfNombre;
    @FXML
    private TextField tfApellidos;
    @FXML
    private TextField tfEdad;
    @FXML
    private Text textError;

    private ObservableList<Alumnos> listObs;
    private FilteredList<Alumnos> listaFilter;
    private Alumnos a;
    //private List<Alumnos> arrayPadre;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listObs = FXCollections.observableArrayList();
        
    }
    public void initA(ObservableList<Alumnos> listObs,Alumnos a) {
        this.listObs = listObs;
        this.a = a;

    }

    public void initA(ObservableList<Alumnos> listObs) {
        this.a = a;

    }

    @FXML
    void onBotonGuardar(ActionEvent event) {
        Alumnos newA = new Alumnos();
        
        Errores.tfVacio(tfNombre.getText(), tfApellidos.getText());     
        Errores.tfVacioInteger(tfEdad.getText());//Control de entrada de datos
        
        newA.setNombreA(tfNombre.getText());
        newA.setApellidos(tfApellidos.getText());

        newA.setEdad(Integer.parseInt(tfEdad.getText()));

        if (listObs.contains(newA)) {
            Errores.getObject();
        } else {   
            //insertar
            a = newA; 
        }
        Stage stg = (Stage) tfApellidos.getScene().getWindow();
        stg.close();
    }

    @FXML
    void onBotonSalir(ActionEvent event) {
        this.a = null;
        Stage stg = (Stage) tfApellidos.getScene().getWindow();
        stg.close();
    }

    public Alumnos getAlumno() {
        return a;
    }

//    public void modificarA(ObservableList<Alumnos> listObs, FilteredList<Alumnos> listaFilter,Alumnos a) {
//        int posicionAlumno = 0;
//        Alumnos modificadoA = tabla.getSelectionModel().getSelectedItem();
//        if (tabla != null && modificadoA != null ) {
//            //alumno para modificar            
//            a = modificadoA;
//            
//            if (modificadoA.getNombre().toLowerCase().contains(s)) {
//                
//            }
//
//        } else {
//            Errores.noHay();
//        }
//
//    }

}
