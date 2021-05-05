/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appjavafx;

import clases.Alumnos;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;
import javax.swing.JOptionPane;

/**
 *
 * @author edgar
 */
public class AddAlumnos implements Initializable {

    @FXML
    private Menu menuModulo;
    @FXML
    private TableView<Alumnos> tablaAlumnos;
    @FXML
    private TableColumn<Alumnos, String> colNombre;
    @FXML
    private TableColumn<Alumnos, String> colApellidos;
    @FXML
    private TableColumn<Alumnos, Integer> colEdad;
    @FXML
    private TextField tfFiltrar;
    private ObservableList<Alumnos> listObs;
    private FilteredList<Alumnos> listFilter;
    private List<Alumnos> listaAlumnos;
    //private Alumnos a;

    @FXML
    void añadirAlumno(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/añadirA.fxml"));
            Parent newRoot;

            newRoot = loader.load();

            AñadirA controllerA = loader.getController();
            controllerA.initA(listObs);

            Scene scene = new Scene(newRoot);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();
            Alumnos a = controllerA.getAlumno();
            if (a != null && !listObs.contains(a)) {
                listObs.add(a);
                if (a.getNombreA().toLowerCase().contains(tfFiltrar.getText().toLowerCase())) {
                    listFilter.add(a);
                } else {
                    Errores.filter();
                }
                tablaAlumnos.setItems(listFilter);
                tablaAlumnos.refresh();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("Esta vacio alumno");
                alert.showAndWait();
            }
            
            actualizar();
            
        } catch (IOException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void modificarAlumno(ActionEvent event) throws IOException {
        Alumnos ASeleccionado = tablaAlumnos.getSelectionModel().getSelectedItem();

        if (tablaAlumnos.getSelectionModel().getSelectedItem() != null) {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/añadirA.fxml"));
            Parent par = fxmlLoader.load();

            AñadirA ac = fxmlLoader.getController();
            ac.initA(listObs);

            Scene scene = new Scene(par);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();
            Alumnos al = ac.getAlumno();
            if (al != null) {
                if (ASeleccionado.getNombreA().toLowerCase().contains(tfFiltrar.getText().toLowerCase())) {
                    listFilter.remove(al);
                }
            }

            //listObs.indexOf(ASeleccionado);
            tablaAlumnos.setItems(listFilter);
            tablaAlumnos.refresh();
        } else {
            Errores.noHay();
        }

    }

    @FXML
    void eliminarAlumno(ActionEvent event) {
        Alumnos a = new Alumnos();
        a = tablaAlumnos.getSelectionModel().getSelectedItem();
        listObs.remove(a);
        tablaAlumnos.refresh();
    }

    @FXML
    void filtrarNombre(KeyEvent event) {

        String filtroNombre = this.tfFiltrar.getText();

        // Si el texto del nombre esta vacio, seteamos la tabla de personas con el original
        if (filtroNombre.isEmpty()) {
            this.tablaAlumnos.setItems(listObs);
        } else {
            // Limpio la lista
            this.listFilter.clear();

            for (Alumnos a : this.listObs) {
                if (a.getNombreA().toLowerCase().contains(filtroNombre.toLowerCase())) {
                    this.listObs.add(a);
                }
            }
            tablaAlumnos.setItems(listObs);
            tablaAlumnos.refresh();
        }
    }

    public void init(String nombreModulo, List<Alumnos> listaAlumnos) {
        if (nombreModulo != null) {

        }
        menuModulo.setText("Alumnos del módulo de " + nombreModulo);

    }

    public void actualizar() {
        this.listaAlumnos.clear();
        listaAlumnos.addAll(listObs);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listObs = FXCollections.observableArrayList();
        listFilter = new FilteredList(listObs);

        tablaAlumnos.setItems(listObs);

        colNombre.setCellValueFactory(new PropertyValueFactory<Alumnos, String>("nombreA"));
        colApellidos.setCellValueFactory(new PropertyValueFactory<Alumnos, String>("apellidos"));
        colEdad.setCellValueFactory(new PropertyValueFactory<Alumnos, Integer>("edad"));

    }

}
