package cl.duoc.aurora.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class main_controller implements Initializable {

    @FXML private ComboBox<String> cmbTipo;
    @FXML private TextField txtCodigo;
    @FXML private TextField txtTitulo;
    @FXML private TextField txtDias;
    @FXML private TextField txtAutor;






    public void onGuardarButtonClick(ActionEvent event) throws IOException {




    }


    public void HabilitarCampos(boolean Habilitar) throws IOException {



    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cmbTipo.getItems().addAll("Revista", "Libro");


    }
}
