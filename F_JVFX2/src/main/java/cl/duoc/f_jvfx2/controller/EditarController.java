package cl.duoc.f_jvfx2.controller;

import cl.duoc.f_jvfx2.Navegacion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class EditarController {

    @FXML
    protected void onVolverButtonClick (ActionEvent event) throws IOException {
        Navegacion.cambiarVista(event, "menu-view.fxml", "Menu principal");
    }
}
