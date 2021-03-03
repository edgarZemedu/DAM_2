package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller  implements Initializable {

    @FXML
    private TextField tfFiltrar;
    @FXML
    private TableColumn columnaN, columnaA, columnaE;
    @FXML
    private Button bAgregar, bModificar, bEliminar;
    @FXML
    private TextField tfNombre, tfApellidos, tfEdad;

    @FXML
    private TableView tablaPersonas;

    private Persona persona;

    private ObservableList<Persona> lista;
    private FilteredList<Persona> listaFilter;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lista = FXCollections.observableArrayList();
        listaFilter = new FilteredList(lista);

        columnaN.setCellValueFactory(new PropertyValueFactory<Persona,String>("nombre"));
        columnaA.setCellValueFactory(new PropertyValueFactory<Persona,String>("apellidos"));
        columnaE.setCellValueFactory(new PropertyValueFactory<Persona,Integer>("edad"));
    }
    @FXML
    public boolean addPersona(ActionEvent evento) throws IOException{

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("FXML/ventanaAdd.fxml"));
        AnchorPane rutaVSegunda = (AnchorPane)loader.load();

            //le meto al controlador personas
            tfNombre.setText(persona.getNombre());
            tfApellidos.setText(persona.getApellido());
            tfEdad.setText(persona.getEdad()+"");
            /*********************************************************************************/

            /*Stage w = (Stage) bAgregar.getScene().getWindow();
            w.setScene(new Scene(rutaVSegunda));
            w.showAndWait();*/
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(rutaVSegunda));
            stage.showAndWait();
            if (persona != null){
                lista.add(persona);
                //if (){

                //}
            }




            /*Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText(null);
            alerta.setTitle("ERROR");
            alerta.setContentText(e.getMessage());
            alerta.showAndWait();*/




        return true;
    }
    @FXML
    public void bAgregar(ActionEvent evento){

        //una vez creado el scene, meter a las personas
        String nombre = tfNombre.getText();
        String apellidos = tfApellidos.getText();
        int edad =Integer.valueOf(tfEdad.getText()); //alternativo Integer.parseInt();

        Persona newPersona = new Persona(nombre,apellidos,edad);
        //comprobar en la tabla si está esta persona
        if (!lista.contains(newPersona)){
            if (persona == null){
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setHeaderText("null");
                alerta.setTitle("Información");
                alerta.setContentText("Se ha añadido, muy bien!   :))");
                alerta.showAndWait();
            }else{
                //modicación
                persona.setNombre(nombre);
                persona.setApellido(apellidos);
                persona.setEdad(edad);

                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setHeaderText("Espabila pringao");
                alerta.setTitle("Info: ");
                alerta.setContentText("Se a modificado!   :)");
                alerta.showAndWait();
            }
        }else{
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText("Espabila pringao");
            alerta.setTitle("Error");
            alerta.setContentText("Esta pesona ya existe!   :((");
            alerta.showAndWait();
        }
    }

    @FXML
    public void bSalir(ActionEvent evento){
        if (persona == null){
            Stage stage;/**************/
        }
    }

    public void tfFiltrar(javafx.scene.input.KeyEvent keyEvent) {
        tfFiltrar.textProperty().addListener((observable, oldValue, newValue) -> {
            listaFilter.setPredicate(person -> {
                // If filter text is empty, display all persons.
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if (person.getNombre().toLowerCase().startsWith(lowerCaseFilter)) {
                    return true; // Filter matches first name.
                }
                return false; // Does not match.
            });
            //tabla.setItems(listaFilter);
        });
    }

    public void modificarP(ActionEvent actionEvent) {
    }

    public void elimanarP(ActionEvent actionEvent) {
    }
}
