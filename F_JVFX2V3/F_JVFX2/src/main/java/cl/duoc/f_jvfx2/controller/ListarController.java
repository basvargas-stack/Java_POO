package cl.duoc.f_jvfx2.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import cl.duoc.f_jvfx2.model.Persona;
import cl.duoc.f_jvfx2.repository.PersonaRepository;
import cl.duoc.f_jvfx2.util.Navegacion;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class ListarController implements Initializable {

    @FXML private TableView<Persona> tblPersonas;
    @FXML private TableColumn<Persona, String> colRut;
    @FXML private TableColumn<Persona, String> colNombre;
    @FXML private TableColumn<Persona, String> colApellido;
    @FXML private TableColumn<Persona, LocalDate> colFechaNacimiento;
    @FXML private TableColumn<Persona, String> colTipo;

    private final PersonaRepository repository = PersonaRepository.getInstance();

    private final ObservableList<Persona> datosTabla = FXCollections.observableArrayList();



    @FXML
    protected void onVolverButtonClick(ActionEvent event)throws IOException {


        Navegacion.cambiarVista(event, "menu-view.fxml", "Menu principal");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colRut.setCellValueFactory(new PropertyValueFactory<>("rut"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colApellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        colFechaNacimiento.setCellValueFactory(new PropertyValueFactory<>("FechaNacimiento"));
        colTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        tblPersonas.setItems(datosTabla);
        cargarPersonas();

    }

    private void cargarPersonas() {
        datosTabla.setAll(repository.ListarTodos());

    }
}
