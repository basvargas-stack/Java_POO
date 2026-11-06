package cl.duoc.rutaactiva.controller;

import cl.duoc.rutaactiva.model.Bicicleta;
import cl.duoc.rutaactiva.model.Scooter;
import cl.duoc.rutaactiva.model.Vehiculo;
import cl.duoc.rutaactiva.repository.VehiculoRepository;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {


    @FXML private ComboBox<String> cmbTipo;
    @FXML private TextField txtCodigo;
    @FXML private TextField txtNombre;
    @FXML private TextField txtHoras;
    @FXML private TextField txtMarca;
    @FXML private CheckBox chkElectrica;
    @FXML private CheckBox chkPremiun;
    @FXML private TableView<Vehiculo> tblVehiculos;
    @FXML private TableColumn<Vehiculo, String> colTipo;
    @FXML private TableColumn<Vehiculo, String> colCodigo;
    @FXML private TableColumn<Vehiculo, String> colNombre;
    @FXML private TableColumn<Vehiculo, String> colHoras;
    @FXML private TableColumn<Vehiculo, String> colTarifa;
    @FXML private Label lblMensaje;

    private ObservableList<Vehiculo> datosTabla = FXCollections.observableArrayList();

    private final VehiculoRepository repository = new VehiculoRepository();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cmbTipo.getItems().addAll("Bicicleta", "Scooter");
        colTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        colCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colHoras.setCellValueFactory(new PropertyValueFactory<>("horas"));
        colTarifa.setCellValueFactory(celda ->
                new SimpleObjectProperty<>(celda.getValue().calcularTarifa()).asString());

        tblVehiculos.setItems(datosTabla);

        cmbTipo.setOnAction((event) -> cambiarTipo());
        cambiarTipo();

        try {
            repository.cargar();
            refrescarTabla();
            mostrarMensaje("Datos cargados correctamente", false);
        }catch (IOException e){
            mostrarMensaje("Error al cargar datos", true);
        }
    }

    public void cambiarTipo() {
        boolean bici = "Bicicleta".equals(cmbTipo.getValue());
        boolean scooter = "Scooter".equals(cmbTipo.getValue());

        txtMarca.setDisable(!bici);
        chkElectrica.setDisable(!bici);
        chkPremiun.setDisable(!scooter);
    }

    public void refrescarTabla() throws IOException {
        datosTabla.setAll(repository.listar());
    }

    public void mostrarMensaje(String mensaje, boolean error){

        lblMensaje.setText(mensaje);
        lblMensaje.setStyle(error ? "-fx-text-fill: red" : "-fx-text-fill: green");


    }





    public void onGuardarbuttonClick(ActionEvent actionEvent) {
        try {
            String tipo = cmbTipo.getValue();
            if (tipo == null){
                mostrarMensaje("El tipo no puede estar vacío", true);
                throw new IllegalArgumentException("El tipo de campo no puede ser nulo");
            }

            int horas;
            try {
                horas = Integer.parseInt(txtHoras.getText());


            }catch (NumberFormatException e){
                throw new IllegalArgumentException("El valor de horas no puede estar vacío");
            }

            Vehiculo nuevo;

            if ("Bicicleta".equals(cmbTipo.getValue())){
                nuevo = new Bicicleta(txtCodigo.getText(), txtNombre.getText(),
                        horas, txtMarca.getText(), chkElectrica.isSelected());
            } else {
                nuevo = new Scooter(txtCodigo.getText(), txtNombre.getText(),
                        horas, chkPremiun.isSelected());
            }

            repository.registrar(nuevo);
            refrescarTabla();
            mostrarMensaje("Vehiculos registrados correctamente", false);
            limpiarFormulario();


        } catch (IOException e){
            throw new IllegalArgumentException("Error al cargar datos");
        }

    }

    public void limpiarFormulario(){
        cmbTipo.getSelectionModel().clearSelection();
        txtCodigo.clear();
        txtNombre.clear();
        txtHoras.clear();
        txtMarca.clear();
        chkElectrica.setSelected(false);
        chkPremiun.setSelected(false);
    }

    public void onEliminarButtonClick(ActionEvent actionEvent) {
        Vehiculo seleccionado = tblVehiculos.getSelectionModel().getSelectedItem();

        if (seleccionado == null){
            mostrarMensaje("Debe seleccionar un vehiculo", true);
            return;
        }
        try {
            repository.eliminar(seleccionado);
            refrescarTabla();
            mostrarMensaje("Vehiculo eliminado correctamente", false);
        } catch (IOException e){
            mostrarMensaje("Error al eliminar datos", true);
        }
    }


}
