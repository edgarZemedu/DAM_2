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
import javafx.scene.control.Alert;
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

    @FXML // fx:id="comboCurso"
    private ComboBox<String> comboCurso; // Value injected by FXMLLoader
    private ObservableList<String> listaCursos;
    private Cursos c;

    @FXML
    private void añadirCurso(ActionEvent event) throws IOException {
        c = new Cursos();
        String nombreCurso = JOptionPane.showInputDialog(null, "Escribe el nombre del curso a crear", "Entrada", JOptionPane.QUESTION_MESSAGE);

        if (!listaCursos.contains(nombreCurso) || !nombreCurso.isEmpty()) {
            listaCursos.add(nombreCurso);
            comboCurso.setItems(listaCursos);
            c.setNombre(nombreCurso);
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Modulos.fxml"));
            Parent newRoot = loader.load();
            
            AddModulos controller = loader.getController();
            controller.initAtributos(nombreCurso); 
            
            Scene scene = new Scene(newRoot);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("1.- Ya tienes en la lisa ese curso"
                    + "\n2.- Debes introducir el curso");
            alert.showAndWait();
        }
    }
    
    @FXML
    void modificarCurso(ActionEvent event) throws IOException {
        String nombreC = null;
        
        if (comboCurso.getValue().toString() != null && !comboCurso.getValue().toString().isEmpty()) {
            
            nombreC = comboCurso.getValue().toString();
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Modulos.fxml"));
            Parent newRoot = loader.load();
            
            AddModulos getController = loader.getController();
            for (int i = 0; i < listaCursos.size(); i++) {
                if (listaCursos.get(i).equals(nombreC)) {
                    getController.initAtributos(nombreC);
                }                
            }
            Scene scene = new Scene(newRoot);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.showAndWait();
        
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Primero selecciona el curso");
            alert.showAndWait();
        }
    }

    @FXML
    void eliminarCurso(ActionEvent event) {
        
    }
    
    @FXML   //ESTO ES DEL menufile
    private void cambiarCursos(ActionEvent event) {

    }

    @FXML   //ESTO ES DEL menufile
    void guardarCurso(ActionEvent event) {

    }

    @FXML   //ESTO ES DEL menufile
    void inforCursos(ActionEvent event) {

    }
    

    @FXML
    void selectCombo(ActionEvent event) {
        /*comboCurso.setOnAction((event) -> {
            int
        });*/
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listaCursos = FXCollections.observableArrayList();
        comboCurso.setPromptText("Selecciona un curso");

    }
    
}
