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
    private List<Alumnos> arrayPadre;

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
        a = new Alumnos();
        Errores.tfVacio(tfNombre.getText(), tfApellidos.getText());

        //Alumnos newA = new Alumnos();
        a.setNombreA(tfNombre.getText());
        a.setApellidos(tfApellidos.getText());

        Errores.tfVacioInteger(tfEdad.getText());//Control de entrada de datos

        a.setEdad(Integer.parseInt(tfEdad.getText()));

        if (listObs.contains(a)) {
            Errores.getObject();
        } else {
            //a = newA;
            listObs.add(a);
            //lo metemos en un arrayList
            arrayPadre.add(a);

        }
        Stage stg = (Stage) tfApellidos.getScene().getWindow();
        stg.close();
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
        int posicionAlumno = 0;
        Alumnos modificadoA = new Alumnos();
        if (tabla != null && !tabla.getSelectionModel().isEmpty()) {
            //alumno para modificar
            Alumnos modA = tabla.getSelectionModel().getSelectedItem();            
            
//            for (Alumnos i : listObs) {
//                if (i.equals(modA)) {                    
//                    
//                }
//            }
            for (int i = 0; i < listObs.size(); i++) {
                if (listObs.get(i).equals(modA)) {                    
                    posicionAlumno = i;
                    arrayPadre.remove(i);
                }
            }
            Errores.tfVacio(tfNombre.getText(), tfApellidos.getText());
            Errores.tfVacioInteger(tfEdad.getText());//Control de entrada de datos
            //Alumno modificado
            modificadoA.setNombreA(tfNombre.getText());
            modificadoA.setApellidos(tfNombre.getText());
            modificadoA.setEdad(Integer.parseInt(tfNombre.getText()));            

            listObs.add(posicionAlumno,modificadoA);
            arrayPadre.add(posicionAlumno,modificadoA);
            //añadimos a la clase padre
            a.setAlumnos(arrayPadre);

        } else {
            Errores.noHay();
        }

    }

}
