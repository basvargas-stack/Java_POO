package cl.duoc.f_jvfx2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.controlsfx.control.action.Action;

import java.io.IOException;

public class Navegacion {

                                    //El evento sería la acción de apretar el botón //Tambén le vamos a pasar el archivoFxml //Y también un titulo
    public  static void cambiarVista(ActionEvent event, String archvioFxml, String titulo ) throws IOException{
        Parent root = FXMLLoader.load(MantenedorApplication.class.getResource(archvioFxml)); //Creamos la ruta de l que va a obetener el archivo fxml de las views que se seleccione
        Stage stage = (Stage) ((Node)event.getSource()) //Este evento lo vaos a transformar en un stage
                .getScene()
                .getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle(titulo);
        stage.show();

    }

}
