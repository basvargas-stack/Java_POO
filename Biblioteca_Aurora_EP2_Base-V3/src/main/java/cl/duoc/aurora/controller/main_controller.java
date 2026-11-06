package cl.duoc.aurora.controller;

import cl.duoc.aurora.model.Libro;
import cl.duoc.aurora.model.Material;
import cl.duoc.aurora.model.Revista;
import cl.duoc.aurora.repository.MaterialRepository;

import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class main_controller implements Initializable {

    //Registrar
    @FXML private ComboBox<String> cmbTipo;
    @FXML private TextField txtCodigo;
    @FXML private TextField txtTitulo;
    @FXML private TextField txtDias;
    @FXML private TextField txtAutor;
    @FXML private Checkbox chkEspecial;
    @FXML private Checkbox chkNovedad;

    //Tabla
    @FXML private TableView<Material> tblMateriales;
    @FXML private TableColumn<Material, String> colTipo;
    @FXML private TableColumn<Material, String> colCodigo;
    @FXML private TableColumn<Material, String> colTitulo;
    @FXML private TableColumn<Material, String> colDias;
    @FXML private TableColumn<Material, String> colTarifa;

    //Mensaje
    @FXML private Label lblMensaje;

    private final MaterialRepository repository = new MaterialRepository();

    private final ObservableList<Material> ListaMateriales = FXCollections.observableArrayList();







    public void onGuardarButtonClick (ActionEvent event) throws IOException {

        try{
            String tipo = cmbTipo.getValue();

            if (tipo == null){
                throw new Exception("Debe seleccionar un tipo");
            }

            String codigo = txtCodigo.getText();
            String titulo = txtTitulo.getText();
            try {
                int dias = Integer.parseInt(txtDias.getText());
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Debe ingresar un valor numerico");
            }
            int dias = Integer.parseInt(txtDias.getText());


            Material material;

            if ("Libro".equals(tipo)){
                material = new Libro(codigo, titulo, dias, txtAutor.getText(),chkEspecial.is );
            } else {
                material = new Revista(codigo, titulo, dias, );
            }

            repository.registrar(material);

            ListaMateriales.setAll(repository.listar());

            mostrarMensaje("Registro creado correctamente.", false);

            limpiarFormulario();


        }catch (Exception e){
            mostrarMensaje("Error al registrar el registro.", true);

        }




    }


    private void limpiarFormulario(){
        txtCodigo.clear();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cmbTipo.getItems().addAll("Revista", "Libro");
        try {
            repository.cargar();
        } catch (Exception e) {
            throw new  RuntimeException("Error al cargar datos de libros", e);
        }

        colTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        colCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        colTitulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        colDias.setCellValueFactory(new PropertyValueFactory<>("dias"));
        //colTarifa.setCellValueFactory(new PropertyValueFactory<>("tarifa"));

        colTarifa.setCellValueFactory(datos -> new SimpleObjectProperty<>(datos.getValue().calcularTarifa()).asString());


        tblMateriales.setItems(ListaMateriales);

        cmbTipo.setOnAction(event -> cambiarTipo());

        txtAutor.setVisible(true);
        chkEspecial.setVisible(true);
        chkNovedad.setVisible(true);

        try{
            ListaMateriales.setAll(repository.listar());
            mostrarMensaje("Materiales cargados correctamente.", false);
        } catch (RuntimeException e){
            mostrarMensaje(e.getMessage(), true);
        }
    }


    private void cambiarTipo() {
        String tipo = cmbTipo.getValue();
        boolean esLibro = "Libro".equals(tipo);
        boolean esRevista = "Revista".equals(tipo);

        txtAutor.setDisable(!esLibro);
        chkEspecial.setVisible(!esLibro);
        chkNovedad.setVisible(!esRevista);

    }

    private void mostrarMensaje(String mensaje, boolean error) {
        lblMensaje.setText(mensaje);
    }



    public void onEliminarButtonClick(ActionEvent actionEvent) {
        Material seleccionado = tblMateriales.getSelectionModel().getSelectedItem();

        if (seleccionado == null) {
            mostrarMensaje("Seleccione el registro.", true);
            return;
        }
        try {
            repository.Eliminar(seleccionado);
            ListaMateriales.setAll(repository.listar());
            mostrarMensaje("Materiales cargados correctamente.", false);

        } catch (Exception e) {
            throw new IllegalArgumentException("Error al cargar datos de libros", e);
        }

    }
}
