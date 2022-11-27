package controller;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Pregunta;

public class MainController {
	Main main;

	ObservableList<Pregunta> listaTodasPreguntasData = FXCollections.observableArrayList();
	ObservableList<Pregunta> listaEncuestaPreguntasData = FXCollections.observableArrayList();
	List<Pregunta> listaPreguntas = new ArrayList<>();

	Pregunta preguntaTodasSelected;
	Pregunta preguntaEncuestaSelected;

	 @FXML
    private TableColumn<String, Pregunta> columnPreguntaTodas;

    @FXML
    private TextField txtMaxPersonas;

    @FXML
    private TableColumn<Integer, Pregunta> columnNumPreguntaEncuesta;

    @FXML
    private TextField txtEdadMax;

    @FXML
    private TextField txtId;

    @FXML
    private TableView<Pregunta> tablePreguntasEncuesta;

    @FXML
    private TextField txtNombre;

    @FXML
    private TableColumn<String, Pregunta> columnPreguntaEncuesta;

    @FXML
    private TableColumn<Integer, Pregunta> columnNumPreguntaTodas;

    @FXML
    private DatePicker dateFin;

    @FXML
    private TextArea txtObjetivo;

    @FXML
    private TextField txtEdadMin;

    @FXML
    private TextArea txtDescripcion;

    @FXML
    private TableView<Pregunta> tableTodasPreguntas;

    @FXML
    private DatePicker dateInicio;

	@FXML
	void initialize() {

		 this.columnNumPreguntaTodas.setCellValueFactory(new PropertyValueFactory<>("numero"));
		 this.columnPreguntaTodas.setCellValueFactory(new PropertyValueFactory<>("texto"));

		 tableTodasPreguntas.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection,newSelection)-> {
			 preguntaTodasSelected = newSelection;
		 });


		 this.columnNumPreguntaEncuesta.setCellValueFactory(new PropertyValueFactory<>("numero"));
		 this.columnPreguntaEncuesta.setCellValueFactory(new PropertyValueFactory<>("texto"));

		 tablePreguntasEncuesta.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection,newSelection)-> {
			 preguntaEncuestaSelected = newSelection;
		 });

	}

	 public void setAplicacion(Main main) {
		 this.main = main;

		 tableTodasPreguntas.getItems().clear();
		 tableTodasPreguntas.setItems(getListaPreguntasData());

	 }

	 private ObservableList<Pregunta> getListaPreguntasData() {
		 List<Pregunta> listaPreguntasTodas = new ArrayList<Pregunta>(main.obtenerPreguntasTodas());
		 listaTodasPreguntasData.addAll(listaPreguntasTodas);
		 return listaTodasPreguntasData;
	 }

	 private ObservableList<Pregunta> getListaPreguntasEncuestaData() {
		return listaEncuestaPreguntasData;
	 }

    @FXML
    void crearEncuesta(ActionEvent event) {
    	String id = txtId.getText();
    	String nombre = txtNombre.getText();
    	String numMaxPersonas = txtMaxPersonas.getText();
    	String descripcion = txtDescripcion.getText();
    	LocalDate fechaInicio = dateInicio.getValue();
    	LocalDate fechaFin = dateFin.getValue();
    	String objetivo = txtObjetivo.getText();
    	String edadMin = txtEdadMin.getText();
    	String edadMax = txtEdadMax.getText();


    	ArrayList<Pregunta> listaPreguntas = new ArrayList<>();
    	listaPreguntas.addAll(listaEncuestaPreguntasData);

    	main.crearEncuesta(id, nombre, numMaxPersonas, descripcion, fechaInicio, fechaFin, objetivo, edadMin, edadMax, listaPreguntas);

    	limpiarEncuesta();
    }

    private void limpiarEncuesta() {
		tablePreguntasEncuesta.getItems().clear();
		txtId.setText("");
    	txtNombre.setText("");
    	txtMaxPersonas.setText("");
    	txtDescripcion.setText("");
    	dateInicio.setValue(null);
    	dateFin.setValue(null);
    	txtObjetivo.setText("");
    	txtEdadMin.setText("");
    	txtEdadMax.setText("");
	}

	@FXML
    void agregarPregunta(ActionEvent event) {
    	if (preguntaTodasSelected!=null) {
    		listaEncuestaPreguntasData.add(preguntaTodasSelected);
    		actualizarTablaEncuestaPreguntas();
		}
    }

    private void actualizarTablaEncuestaPreguntas() {
		tablePreguntasEncuesta.setItems(listaEncuestaPreguntasData);
	}

	@FXML
    void eliminarPregunta(ActionEvent event) {

    }

	// Agregar elementos de una tabla a otra
	// @FXML
	// void agregarOtraTabla(ActionEvent event) {
	// this.columnNombre1.setCellValueFactory(new
	// PropertyValueFactory<>("nombre"));
	// this.columnDuracion1.setCellValueFactory(new
	// PropertyValueFactory<>("duracion"));
	// this.columnGenero1.setCellValueFactory(new
	// PropertyValueFactory<>("genero"));
	//
	// listaCancionesFavoritasData.add(cancionSeleccionada);
	// tablaCancionesFavoritas.setItems(listaCancionesFavoritasData);
	// tablaCancionesFavoritas.refresh();
	// }
}
