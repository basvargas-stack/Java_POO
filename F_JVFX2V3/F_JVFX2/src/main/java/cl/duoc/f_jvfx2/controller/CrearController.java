package cl.duoc.f_jvfx2.controller;

import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import cl.duoc.f_jvfx2.model.Alumno;
import cl.duoc.f_jvfx2.model.Persona;
import cl.duoc.f_jvfx2.model.Profesor;
import cl.duoc.f_jvfx2.repository.PersonaRepository;
import cl.duoc.f_jvfx2.util.Navegacion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CrearController implements Initializable {

    @FXML private TextField txtRut;
    @FXML private TextField txtNombre;
    @FXML private TextField txtApellido;
    @FXML private DatePicker dpFechaNacimiento;
    @FXML private ComboBox<String> cmbTipoPersona;

    private final PersonaRepository repositorio = PersonaRepository.getInstance();




    @FXML
    protected void onVolverButtonClick(ActionEvent event)throws IOException {


        Navegacion.cambiarVista(event, "menu-view.fxml", "Menu principal");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cmbTipoPersona.getItems().addAll("Alumno", "Profesor");
        cmbTipoPersona.getSelectionModel().selectFirst();
    }





    @FXML
    protected void onGuardarButtonClick(ActionEvent event)throws IOException {
        try{
            Persona nuevaPersona;

            if ("Profesor".equals(cmbTipoPersona.getSelectionModel().getSelectedItem())) {
                nuevaPersona = new Profesor
                        (txtRut.getText(),
                        txtNombre.getText(),
                        txtApellido.getText(),
                        dpFechaNacimiento.getValue()
                );

            }else {
                nuevaPersona = new Alumno(
                        txtRut.getText(),
                        txtNombre.getText(),
                        txtApellido.getText(),
                        dpFechaNacimiento.getValue()
                );
            }


            repositorio.agregar(nuevaPersona);
            mostrarAlerta(Alert.AlertType.INFORMATION, "Exitoso", "Se ha registrado correctamente la persona con rut"+
                    txtRut.getText());

            limpiarControles();


        }catch (IllegalArgumentException e){
            mostrarAlerta(Alert.AlertType.ERROR, "Error", e.getMessage());
        }
    }

    private void limpiarControles(){
        txtRut.clear();
        txtNombre.clear();
        txtApellido.clear();
        dpFechaNacimiento.setValue(null);
        cmbTipoPersona.getSelectionModel().selectFirst();
        txtRut.requestFocus();
    }

    @FXML
    protected void onLimpiarButtonClick(ActionEvent event)throws IOException {
        limpiarControles();

    }

    private void mostrarAlerta(Alert.AlertType tipo, String titulo, String mensaje){
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();


    }





}
