/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import clases.Alumnos;
import clases.Modulos;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
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
import javafx.stage.Modality;
import javafx.stage.Stage;

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
    private TextField idFiltrar;
    private ObservableList<Alumnos> listObs;
    private FilteredList<Alumnos> listFilter;
    private List<Alumnos> listaAlumnos;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listObs = FXCollections.observableArrayList();
        listaAlumnos = new ArrayList<>();
        listFilter = new FilteredList(listObs);

        idFiltrar.setPromptText("Buscar...");
        idFiltrar.textProperty().addListener((observable, oldValue, newValue) -> {
            listFilter.setPredicate(a -> {
                if (newValue.isEmpty()) {
                    return true;
                }
                if (a.getNombreA().toLowerCase().contains(newValue.toLowerCase())) {
                    return true;
                } else if (a.getApellidos().toLowerCase().contains(newValue.toLowerCase())) {
                    return true;
                }
                return false;
            });
        });
        //this.tablaAlumnos.setItems(listFilter);        

        colNombre.setCellValueFactory(new PropertyValueFactory<Alumnos, String>("nombreA"));
        colApellidos.setCellValueFactory(new PropertyValueFactory<Alumnos, String>("apellidos"));
        colEdad.setCellValueFactory(new PropertyValueFactory<Alumnos, Integer>("edad"));
    }

    @FXML
    void añadirAlumno(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/añadirA.fxml"));
            Parent newRoot = loader.load();

            AñadirA controllerA = loader.getController();
            controllerA.initA(listObs);

            Scene scene = new Scene(newRoot);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();

            Alumnos a = controllerA.getAlumno();

            if (a != null) {
                listObs.add(a);
                tablaAlumnos.setItems(listObs);
                tablaAlumnos.refresh();
                listaAlumnos.add(a);
            } else {
                Errores.estaVacio();
            }

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
        Alumnos a = tablaAlumnos.getSelectionModel().getSelectedItem();

        if (a != null) {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/añadirA.fxml"));
            Parent par = fxmlLoader.load();
            AñadirA ac = fxmlLoader.getController();

            ac.initAtri(listObs, a);

            Scene scene = new Scene(par);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();

            Alumnos al = ac.getAlumno();

            if (a != null) {
                if (a.getNombreA().toLowerCase().contains(idFiltrar.getText().toString().toLowerCase())) {
                    listObs.remove(a);
                    listObs.add(al);

                    listaAlumnos.remove(a);
                    listaAlumnos.add(al);
                }
                tablaAlumnos.setItems(listFilter);
                tablaAlumnos.refresh();
            } else {
                Errores.estaVacio();
            }
        } else {
            Errores.noHay();
        }
        //actualizar();

    }

    @FXML
    void eliminarAlumno(ActionEvent event) {
        Alumnos a = new Alumnos();
        a = tablaAlumnos.getSelectionModel().getSelectedItem();
        listObs.remove(a);
        listaAlumnos.remove(a);
        actualizarTabla();
    }

    public Modulos init(Modulos mo) {
        menuModulo.setText("Alumnos del módulo de " + mo.getNombreM());

        mo.setAlumnos(listaAlumnos);

        return mo;
    }

    public void initM(Modulos mo) {
        menuModulo.setText("Alumnos del módulo de " + mo.getNombreM());
        if (mo != null) {
            this.listaAlumnos.addAll(mo.getAlumnos());
        }
        actualizarTabla();
    }

    public void actualizarTabla() {
        this.listObs.clear();
        for (Alumnos i : listaAlumnos) {
            this.listObs.add(i);
        }
        tablaAlumnos.setItems(listFilter);
        tablaAlumnos.refresh();
    }

//    @FXML
//    public void onFilter(KeyEvent ke){
//        String filterNombre = idFiltrar.getText();
//        
//        if (filterNombre.isBlank()) {
//            tablaAlumnos.setItems(listObs);
//        }else{
//            listFilter.clear();
//            for (Alumnos i : listaAlumnos) {
//                if (i.getNombreA().toLowerCase().contains(filterNombre.toLowerCase())) {
//                    listFilter.add(i);
//                }
//            }
//            tablaAlumnos.setItems(listFilter);
//        }
//        
//    }
}
