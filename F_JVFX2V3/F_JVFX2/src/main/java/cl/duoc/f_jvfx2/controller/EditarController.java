package cl.duoc.f_jvfx2.controller;

import cl.duoc.f_jvfx2.model.Alumno;
import cl.duoc.f_jvfx2.model.Persona;
import cl.duoc.f_jvfx2.model.Profesor;
import cl.duoc.f_jvfx2.repository.PersonaRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import cl.duoc.f_jvfx2.util.Navegacion;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EditarController implements Initializable {

    @FXML private TextField txtRut;
    @FXML private TextField txtNombre;
    @FXML private TextField txtApellido;
    @FXML private DatePicker dpFechaNacimiento;
    @FXML private ComboBox<String> cmbTipoPersona;


    private final PersonaRepository repositorio = PersonaRepository.getInstance();

    private Persona persona;


    public void onBuscarButtonClick() {
        try {

            persona = repositorio.buscarPorRut(txtRut.getText());

            if (persona == null){
                mostrarAlerta(Alert.AlertType.WARNING, "Rut no encontrado", "El rut ingresado no se encontró");
                limpiarControles();
                return;
            }

            txtNombre.setText(persona.getNombre());
            txtApellido.setText(persona.getApellido());
            dpFechaNacimiento.setValue(persona.getFechaNacimiento());
            cmbTipoPersona.getSelectionModel().select(persona.getTipo());
            habilitarFormulario(false);


        } catch (IllegalArgumentException e){
            mostrarAlerta(Alert.AlertType.WARNING, "El rut no existe", "El rut ingresado no existe en los registros");

        }
    }

    public void onButtonLimpiarClick(ActionEvent event) {
        limpiarControles();
    }

    public void onButtonActualizarClick(ActionEvent event) {
        if (persona == null){
            throw new IllegalArgumentException("No existe una persona con ese rut");
        }

        try {
            Persona personaActualizar;

            if ("Profesor".equals(cmbTipoPersona.getSelectionModel().getSelectedItem())){
                personaActualizar = new Profesor(txtRut.getText(), txtNombre.getText(), txtApellido.getText(),
                        dpFechaNacimiento.getValue());
            } else {
                personaActualizar = new Alumno(txtRut.getText(), txtNombre.getText(), txtApellido.getText(),
                        dpFechaNacimiento.getValue());

            }

            repositorio.Actualizar(personaActualizar);
            mostrarAlerta(Alert.AlertType.INFORMATION, "Actualización exitosa", "La actualización ha sido actualizada correctamente");


        } catch (IllegalArgumentException e){
            mostrarAlerta(Alert.AlertType.ERROR, "ERROR", "No se pudo realizar el registro de manera exitosa");
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

    private void habilitarFormulario(boolean habilitar){
        txtNombre.setDisable(habilitar);
        txtApellido.setDisable(habilitar);
        dpFechaNacimiento.setDisable(habilitar);
        cmbTipoPersona.setDisable(habilitar);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cmbTipoPersona.getItems().addAll("Alumno", "Profesor");
        habilitarFormulario(true);
    }


}
