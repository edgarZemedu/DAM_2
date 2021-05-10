/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.listModulos = new ArrayList<Modulos>();
        this.listObsM = FXCollections.observableArrayList();
        this.listAlumnos = new ArrayList<Alumnos>();
        comboModulos.setPromptText("Selecciona un Modulo");
    }

    @FXML
    void añadirModulo(ActionEvent event) throws IOException {
        m = new Modulos();
        String nombreModulo = JOptionPane.showInputDialog(null, "Escribe el nombre del módulo a crear",
                "Entrada", JOptionPane.QUESTION_MESSAGE);

        if (nombreModulo.isBlank()) {
            Errores.nullNombre();
        }
        if (!listObsM.contains(nombreModulo)) {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Alumnos.fxml"));
            Parent newRoot = loader.load();
            AddAlumnos controller = loader.getController();

            controller.init(nombreModulo, listAlumnos);

            Scene scene = new Scene(newRoot);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();

            listModulos.add(new Modulos(nombreModulo, listAlumnos));

            actualizarCombo();

        } else {
            Errores.comboBox();
        }
    }

    @FXML
    void modificarModulos(ActionEvent event) throws IOException {
        String nombreM = null;

        if (comboModulos.getValue().toString() != null && !comboModulos.getValue().toString().isEmpty()) {

            nombreM = comboModulos.getValue().toString();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Alumnos.fxml"));
            Parent newRoot = loader.load();

            AddAlumnos aA = loader.getController();

            for (int i = 0; i < listObsM.size(); i++) {
                if (listObsM.get(i).equals(nombreM)) {
                    aA.init(nombreM, listAlumnos);
                }
            }
            Scene scene = new Scene(newRoot);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.showAndWait();

            actualizarCombo();

        } else {
            Errores.estaVacio();
        }
    }

    @FXML
    void eliminarModulos(ActionEvent event) {
        String m = comboModulos.getValue();
        if (listObsM.contains(m)) {            
            for (int i = 0; i < listModulos.size(); i++) {
                if (listModulos.get(i).getNombreC() == m) {
                    listModulos.remove(i);
                }
            }
            listObsM.remove(m);
            comboModulos.setItems(listObsM);
        }
    }

    @FXML
    void selectModulo(ActionEvent event) {

    }

    public Cursos initAgregar(Cursos c) {
        menuTitulo.setText("Modulos de " + c.getNombreC());
        
        c.setModulos(listModulos);
        
        return c;
    }
    public void initAtributos(Cursos c) {
        menuTitulo.setText("Modulos de " + c.getNombreC());
        if (!c.getNombreC().isEmpty()) {
            //guardar en curso correspondiente
            this.listModulos = c.getModulos();
        }
        actualizarCombo();
    }

    public void actualizarCombo() {
        this.listObsM.clear();
        for (Modulos i : listModulos) {
            this.listObsM.add(i.getNombreM());
        }
        comboModulos.setItems(listObsM);
    }

    public Modulos getModulo() {
        return m;
    }
}
