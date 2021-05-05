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
import javax.swing.JOptionPane;

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

    private ObservableList<Alumnos> listObs;

    private Alumnos a;
    //private List<Alumnos> arrayPadre;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void initA(ObservableList<Alumnos> listObs) {
        this.listObs = listObs;
    }

    public void initAtri(ObservableList<Alumnos> listObs, Alumnos a) {
        this.listObs = listObs;
        this.a = a;

        this.tfNombre.setText(a.getNombre());
        this.tfApellidos.setText(a.getApellidos());
        this.tfEdad.setText(a.getEdad() + "");
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
        } else if (a != null) {
            //mofdificar
            a.setNombreA(newA.getNombreA());
            a.setApellidos(newA.getApellidos());
            a.setEdad(newA.getEdad());
            Errores.correcto();
        } else {
            //insertar
            a = newA;
            Errores.correcto();
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
}
