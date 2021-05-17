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
    private ObservableList<String> listObsM;
    private Modulos m;
    private List<Modulos> listModulos;
    private List<Alumnos> listAlumnos;
    private int posicionM;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.listModulos = new ArrayList<Modulos>();
        this.listObsM = FXCollections.observableArrayList();
        this.m = m;
        
        comboModulos.setPromptText("Selecciona un Modulo");
    }

    @FXML
    void añadirModulo(ActionEvent event) throws IOException {
        m = new Modulos();
        String nombreModulo = JOptionPane.showInputDialog(null, "Escribe el nombre del módulo a crear",
                "Entrada", JOptionPane.QUESTION_MESSAGE);

        if (nombreModulo.isEmpty()) {
            Errores.nullNombre();
        }
        if (!listObsM.contains(nombreModulo)) {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Alumnos.fxml"));
            Parent newRoot = loader.load();
            AddAlumnos controller = loader.getController();
            
            m.setNombreM(nombreModulo);
            controller.init(m);

            Scene scene = new Scene(newRoot);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();

            if (!listModulos.contains(m)) {
                this.listModulos.add(m);
                this.listObsM.add(m.getNombreM());
            }
            this.comboModulos.setItems(listObsM);

            actualizarCombo();

        } else {
            Errores.comboBox();
        }
    }

    @FXML
    void modificarModulos(ActionEvent event) throws IOException {
        Modulos mo = new Modulos();
        String nombreM = comboModulos.getValue().toString();

        if (nombreM != null && !nombreM.isEmpty()) {

            nombreM = comboModulos.getValue().toString();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Alumnos.fxml"));
            Parent newRoot = loader.load();
            AddAlumnos aA = loader.getController();            
            
            mo.setNombreM(nombreM);
            for (Modulos i : listModulos) {
                if (i.getNombreM().equalsIgnoreCase(mo.getNombreM())) {
                    mo =  i;
                }
            }
            aA.initM(mo);            
            
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
        for (Modulos i : listModulos) {
            if (i.getNombreM().equalsIgnoreCase(m)) {
                listModulos.remove(i);
                listObsM.remove(m);
                comboModulos.setItems(listObsM);
            }
        }
    }

    public Cursos initAgregar(Cursos c) {
        menuTitulo.setText("Modulos de " + c.getNombreC());
        c.setModulos(listModulos);
        return c;
    }

    public Cursos initAtributos(Cursos c) {
        menuTitulo.setText("Modulos de " + c.getNombreC());
        if (!c.getNombreC().isEmpty()) {
            //guardar en curso correspondiente
            this.listModulos = c.getModulos();
        }
        actualizarCombo();
        c.setModulos(listModulos);
        return c;
    }

    public void actualizarCombo() {
        this.listObsM.clear();
        for (Modulos i : listModulos) {
            this.listObsM.add(i.getNombreM());
        }
        comboModulos.setItems(listObsM);
    }
}
