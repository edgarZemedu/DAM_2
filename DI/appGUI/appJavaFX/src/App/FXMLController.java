/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import clases.Cursos;
import java.io.File;
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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 * @author a18zemedufc
 */
public class FXMLController implements Initializable {

    @FXML // fx:id="comboCurso"
    private ComboBox<String> comboCurso; // Value injected by FXMLLoader
    private ObservableList<String> listObsC;
    private List<Cursos> listCursos;
    private Cursos c;
    //private int posicionC;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listObsC = FXCollections.observableArrayList();
        this.listCursos = new ArrayList<Cursos>();
        comboCurso.setPromptText("Selecciona un curso");

    }

    @FXML
    private void añadirCurso(ActionEvent event) throws IOException {
        c = new Cursos();
        String nombreCurso = JOptionPane.showInputDialog(null, "Escribe el nombre del curso a crear",
                "Entrada", JOptionPane.QUESTION_MESSAGE);

        if (nombreCurso.isEmpty()) {
            Errores.nullNombre();
        } else {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Modulos.fxml"));
            Parent newRoot = loader.load();
            AddModulos controller = loader.getController();

            c.setNombreC(nombreCurso);
            controller.initAgregar(c);

            Scene scene = new Scene(newRoot);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();

            if (!listCursos.contains(c)) {
                this.listCursos.add(c);
                this.listObsC.add(c.getNombreC());
            }
            this.comboCurso.setItems(listObsC);
        }
    }

    @FXML
    void modificarCurso(ActionEvent event) throws IOException {
        String nombreC = null;

        if (!comboCurso.getValue().isEmpty()) {
            //para cuando quiera modificar el nombre del combo

            nombreC = comboCurso.getValue().toString();

            for (Cursos i : listCursos) {
                if (i.getNombreC().equalsIgnoreCase(nombreC)) {
                    c = i;
                }
            }
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Modulos.fxml"));
            Parent newRoot = loader.load();
            AddModulos am = loader.getController();

            am.initAtributos(c);

            Scene scene = new Scene(newRoot);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.showAndWait();

            //actualizar observable para ponerlo en combobox
            actualizarCombo();

        } else {
            Errores.seleccionar();
        }

    }

    @FXML
    void eliminarCurso(ActionEvent event) {
        String ncurso = comboCurso.getValue().toString();
        for (Cursos i : listCursos) {
            if (i.getNombreC().equalsIgnoreCase(ncurso)) {
                listCursos.remove(i);
                listObsC.remove(ncurso);
                comboCurso.setItems(listObsC);
            }
        }

    }

    public void actualizarCombo() {
        this.listObsC.clear();
        for (Cursos i : listCursos) {
            this.listObsC.add(i.getNombreC());
        }
        this.comboCurso.setItems(listObsC);
    }

    @FXML   //ESTO ES DEL menufile
    private void openFile(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();

        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("JSON files (*.json)", "*.json");
        fileChooser.getExtensionFilters().add(extFilter);
        fileChooser.setTitle("Selecciona el archivo JSON a cargar");
        File selectedFile = fileChooser.showOpenDialog((Stage) (comboCurso.getScene().getWindow()));

        try {

            ObjectMapper objectMapper = new ObjectMapper();
            //PersonaListWrapper wrapper = objectMapper.readValue(file, PersonaListWrapper.class);

            listObsC.clear();
            listObsC.addAll((ArrayList) objectMapper.readValue(selectedFile, objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, Cursos.class)));
            //lista.addAll(wrapper.getPersons());

            //tabla.setItems(listaFilter);
        } catch (Exception e) { // catches ANY exception
            System.out.println("....Error O " + e.getMessage());
        }

    }

    @FXML   //ESTO ES DEL menufile
    private void guardarCursoJSON(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();

        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("JSON files (.json)", ".json");
        fileChooser.getExtensionFilters().add(extFilter);
        fileChooser.setTitle("Guardar en JSON");
        File selectedFile =  fileChooser.showSaveDialog((Stage) (comboCurso.getScene().getWindow()));

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            //PersonaListWrapper wrapper = new PersonaListWrapper();
            //wrapper.setPersons(lista);

            //objectMapper.writeValue(file, wrapper);
            objectMapper.writeValue(selectedFile, listCursos);

            //objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, Persona.class));
        } catch (Exception e) { // catches ANY exception
            System.out.println("....Error G: " + e.getMessage());
        }
    }

}
