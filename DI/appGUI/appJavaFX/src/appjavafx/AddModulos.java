/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appjavafx;

import clases.Alumnos;
import clases.Cursos;
import clases.Modulos;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Menu;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author edgar
 */
public class AddModulos implements Initializable {

    @FXML
    private Menu menuTitulo;
    @FXML
    private ComboBox<String> comboModulos;
    @FXML
    private Button bAñadir;
    @FXML
    private Button bModificar;
    @FXML
    private Button bEliminar;
    private ObservableList<String> listObsM;
    private Modulos m;
    private List<Modulos> listModulos;
    private List<Alumnos> listAlumnos;
    private int posicionM;

    @FXML
    void añadirModulo(ActionEvent event) throws IOException {
        m = new Modulos();

        String nombreModulo = JOptionPane.showInputDialog(null, "Escribe el nombre del módulo a crear", "Entrada", JOptionPane.QUESTION_MESSAGE);
        //Modulos ms = new Modulos();
        if (!listObsM.contains(nombreModulo) || !nombreModulo.isEmpty()) {
            listObsM.add(nombreModulo);
            comboModulos.setItems(listObsM);

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Alumnos.fxml"));
            Parent newRoot = loader.load();

            AddAlumnos controller = loader.getController();
            controller.init(nombreModulo,listAlumnos);
            
            m.setNombreM(nombreModulo);
            m.setAlumnos(listAlumnos);

            listModulos.add(m);
            for (int i = 0; i < listModulos.size(); i++) {
                if (listModulos.equals(m)) {
                    posicionM = i;
                }
            }
            
            Scene scene = new Scene(newRoot);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            ///para gurdar el módulo en cursos
            listModulos.add(m);
            m.setModulos(listModulos);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("1.- Ya tienes en la lisa ese módulo"
                    + "\n2.- Debes introducir el modulo");
            alert.showAndWait();
        }
    }

    @FXML
    void modificarModulos(ActionEvent event) throws IOException {
        String nombreM = null;

        if (comboModulos.getValue().toString() != null && !comboModulos.getValue().toString().isEmpty()) {

            nombreM = comboModulos.getValue().toString();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Alumnos.fxml"));
            Parent newRoot = loader.load();

            AddAlumnos getController = loader.getController();
            for (int i = 0; i < listObsM.size(); i++) {
                if (listObsM.get(i).equals(nombreM)) {
                    getController.init(nombreM,listAlumnos);
                }
            }
            Scene scene = new Scene(newRoot);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.showAndWait();

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Primero selecciona el Módulo");
            alert.showAndWait();
        }
    }

    @FXML
    void eliminarModulos(ActionEvent event) {

    }

    @FXML
    void selectModulo(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listModulos = new ArrayList<>();
    }

    public void initAtributos(String nombreCurso, List<Modulos> listModulos) {
        listObsM = FXCollections.observableArrayList();
        
        menuTitulo.setText("Modulos de " + nombreCurso);
    }

    public Modulos getModulo() {
        return m;
    }
}
