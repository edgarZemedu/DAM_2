/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appjavafx;

import clases.Alumnos;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
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
    private Alumnos a = new Alumnos();
    private ArrayList<Alumnos> listAlumnos = new ArrayList<>();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void initA(ObservableList<Alumnos> listObs, FilteredList<Alumnos> listaFilter) {
        this.listObs = listObs;
        this.listaFilter = listaFilter;
        
    }

    @FXML
    void onBotonGuardar(ActionEvent event) {
        //a = new Alumnos();
        Errores.tfVacio(tfNombre.getText(), tfApellidos.getText());

        Alumnos newA = new Alumnos();
        newA.setNombreA(tfNombre.getText());
        newA.setApellidos(tfApellidos.getText());

        Errores.tfVacioInteger(tfEdad.getText());//Control de entrada de datos

        newA.setEdad(Integer.parseInt(tfEdad.getText()));

        if (listObs.contains(newA)) {
            Errores.getObject(newA);
        } else {
            //a = newA;
            listObs.add(newA);
            //lo metemos en un arrayList
            listAlumnos.add(newA);
            //añadimos a la clase padre
            a.setAlumnos(listAlumnos);

        }
        //Stage stg = (Stage) tfApellidos.getScene().getWindow();
        //stg.close();
    }

    @FXML
    void onBotonSalir(ActionEvent event) {
        a = null;
        Stage stg = (Stage) tfApellidos.getScene().getWindow();
        stg.close();
    }

    public Alumnos getAlumno() {
        return a;
    }

    public void modificarA(TableView<Alumnos> tabla) {
        if (tabla != null && !tabla.getSelectionModel().isEmpty()) {
            Alumnos modiA = tabla.getSelectionModel().getSelectedItem();
            if (listObs.contains(modiA)) {
                tfNombre.setText(modiA.getNombreA());
                tfApellidos.setText(modiA.getApellidos());
                tfEdad.setText(modiA.getEdad() + "");
                if (listAlumnos.contains(modiA)) {
                    listAlumnos.remove(modiA);
                }
            }
            //onBotonGuardar(event);

            Errores.tfVacio(tfNombre.getText(), tfApellidos.getText());
            Errores.tfVacioInteger(tfEdad.getText());//Control de entrada de datos

            //a = modA;
            listObs.add(modiA);
            listAlumnos.add(modiA);
            //añadimos a la clase padre
            a.setAlumnos(listAlumnos);

        }
    }

}
