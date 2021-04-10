/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appjavafx;

import clases.Cursos;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author a18zemedufc
 */
public class FXMLController implements Initializable {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML
    private Button bAñadir;

    @FXML
    private Button bModificar;

    @FXML
    private Button bEliminar;

    @FXML // fx:id="comboCurso"
    private ComboBox<String> comboCurso; // Value injected by FXMLLoader
    
    private ObservableList<String> listaCursos;

    @FXML
    void añadirCurso(ActionEvent event) throws IOException {
        String nombreCurso;

        nombreCurso = JOptionPane.showInputDialog(null, "Escribe el nombre del curso a crear", "Entrada", JOptionPane.QUESTION_MESSAGE);
        
        if (nombreCurso != null) {
            
            
            Parent root = FXMLLoader.load(getClass().getResource("/FXML/Cursos.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.showAndWait();
            
            //añadimos los nombres de los cursos
            listaCursos.add(nombreCurso);
            comboCurso.setItems(listaCursos);
            
        }

    }

    @FXML   //ESTO ES DEL menufile
    void cambiarCursos(ActionEvent event) {

    }

    @FXML
    void eliminarCursi(ActionEvent event) {

    }

    @FXML   //ESTO ES DEL menufile
    void guardarCurso(ActionEvent event) {

    }

    @FXML   //ESTO ES DEL menufile
    void inforCursos(ActionEvent event) {

    }

    @FXML
    void modificarCurso(ActionEvent event) {

    }

    @FXML
    void selectCombo(ActionEvent event) {

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert comboCurso != null : "fx:id=\"comboCurso\" was not injected: check your FXML file 'Cursos.fxml'.";

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
