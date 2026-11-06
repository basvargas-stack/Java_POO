package cl.duoc.f_jvfx2.controller;

import cl.duoc.f_jvfx2.util.Navegacion;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;


public class MenuController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onCrearButtonClick(ActionEvent event)throws IOException {


        Navegacion.cambiarVista(event, "crear-view.fxml", "Crear persona");
    }

    @FXML
    protected void onBuscarButtonClick(ActionEvent event)throws IOException {

        Navegacion.cambiarVista(event, "buscar-view.fxml", "Buscar persona");

    }

    @FXML
    protected void onEliminarButtonClick(ActionEvent event)throws IOException {

        Navegacion.cambiarVista(event, "eliminar-view.fxml", "Eliminar persona");


    }

    @FXML
    protected void onEditarButtonClick(ActionEvent event)throws IOException {

        Navegacion.cambiarVista(event, "editar-view.fxml", "Editar persona");
    }

    @FXML
    protected void onListarButtonClick(ActionEvent event)throws IOException {

        Navegacion.cambiarVista(event, "listar-view.fxml", "Listar personas");


    }



    public void onSalirButtonClick(ActionEvent actionEvent) {
        Platform.exit();
    }


}
