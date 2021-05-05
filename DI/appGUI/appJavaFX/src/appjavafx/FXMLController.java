/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appjavafx;

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
    private ObservableList<String> listObsC;
    private List<Cursos> listCursos;
    private List<Modulos> listModulos;
    private Cursos c;
    private int posicionC;

    @FXML
    private void añadirCurso(ActionEvent event) throws IOException {
        c = new Cursos();
        String nombreCurso = JOptionPane.showInputDialog(null, "Escribe el nombre del curso a crear", "Entrada", JOptionPane.QUESTION_MESSAGE);

        if (!listObsC.contains(nombreCurso) || !nombreCurso.isEmpty()) {
            listObsC.add(nombreCurso);
            comboCurso.setItems(listObsC);
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Modulos.fxml"));
            Parent newRoot = loader.load();
            
            AddModulos controller = loader.getController();
            controller.initAtributos(nombreCurso,listModulos); 
            c.setNombreC(nombreCurso);
            c.setModulos(listModulos);
            
            listCursos.add(c);
            for (int i = 0; i < listCursos.size(); i++) {
                if (listCursos.equals(c)) {
                    posicionC = i;
                }
            }
            
            Scene scene = new Scene(newRoot);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            
            actualizar();
            
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
        
        if (!comboCurso.getValue().toString().isEmpty()) {
            
            nombreC = comboCurso.getValue().toString();
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Modulos.fxml"));
            Parent newRoot = loader.load();
            
            AddModulos am = loader.getController();
            am.initAtributos(nombreC, listModulos);
            
            for (int i = 0; i < listObsC.size(); i++) {
                if (listObsC.get(i).equals(nombreC)) {
                    am.initAtributos(nombreC,listModulos);
                }                
            }
            
            actualizar();
            
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
        listObsC = FXCollections.observableArrayList();
        listCursos = new ArrayList<>();
        comboCurso.setPromptText("Selecciona un curso");

    }
    public void actualizar(){
        this.listCursos.clear();
        for (int i = 0; i < listObsC.size(); i++) {
            listCursos.add(new Cursos(listObsC.get(i), listModulos));
        }        
    }
    
}
