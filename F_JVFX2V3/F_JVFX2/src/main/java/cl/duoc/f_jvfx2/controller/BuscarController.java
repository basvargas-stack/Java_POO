package cl.duoc.f_jvfx2.controller;

import cl.duoc.f_jvfx2.model.Persona;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import cl.duoc.f_jvfx2.repository.PersonaRepository;
import cl.duoc.f_jvfx2.util.Navegacion;

import java.io.IOException;

public class BuscarController {

    @FXML private TextField txtRut;
    @FXML private TextField txtNombre;
    @FXML private TextField txtApellido;
    @FXML private DatePicker dpFechaNacimiento;
    @FXML private ComboBox<String> cmbTipoPersona;


    private final PersonaRepository repository = PersonaRepository.getInstance();

    @FXML
    private void  onBuscarButtonClick() {
        try {
            Persona persona = repository.buscarPorRut(txtRut.getText());

            if (persona == null){
                mostrarAlerta(Alert.AlertType.ERROR, "Busqueda sin coincidencias", "No se encontro el rut de " +
                        "la persona ingresada.");
                limpiarControles();
                return;
            }


            txtNombre.setText(persona.getNombre());
            txtApellido.setText(persona.getApellido());
            dpFechaNacimiento.setValue(persona.getFechaNacimiento());
            cmbTipoPersona.getSelectionModel().select(persona.getTipo());


        } catch (IllegalArgumentException e) {

        }

    }





    @FXML
    protected void onVolverButtonClick(ActionEvent event)throws IOException {


        Navegacion.cambiarVista(event, "menu-view.fxml", "Menu principal");
    }

    private void mostrarAlerta(Alert.AlertType tipo, String titulo, String mensaje){
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
    private void limpiarControles(){
        txtRut.clear();
        txtNombre.clear();
        txtApellido.clear();
        dpFechaNacimiento.setValue(null);
        cmbTipoPersona.getSelectionModel().selectFirst();
        txtRut.requestFocus();
    }

}
