package cl.duoc.f_jvfx2.controller;

import cl.duoc.f_jvfx2.Navegacion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CrearController implements Initializable {

    @FXML private TextField txtRut;
    @FXML private TextField txtNombre;
    @FXML private TextField txtApellido;
    @FXML private DatePicker dpFechaNacimiento;
    @FXML private ComboBox<String> cmbTipoPersona;



    @FXML
    protected void onVolverButtonClick (ActionEvent event) throws IOException {
        Navegacion.cambiarVista(event, "menu-view.fxml", "Menu principal");
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        cmbTipoPersona.getItems().addAll("Alumno", "Profesor", "Otro");
        cmbTipoPersona.getSelectionModel().selectFirst();

    }

}
