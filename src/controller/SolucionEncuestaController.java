package controller;

import java.util.ArrayList;
import java.util.List;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Opcion;
import model.Pregunta;

public class SolucionEncuestaController {
	Main main;
	ObservableList<Opcion> listaOpcionesData = FXCollections.observableArrayList();
	Opcion opcionSeleccionada;

	@FXML
    private Label lblNumPregunta;

	@FXML
    private TableColumn<Opcion, String> columnOpcion;

    @FXML
    private TableView<Opcion> tableOpciones;

    @FXML
    private TableColumn<Opcion, Integer> columnNumOpcion;

    @FXML
    private TextArea txtPregunta;

    @FXML
	void initialize() {

		 this.columnNumOpcion.setCellValueFactory(new PropertyValueFactory<>("id"));
		 this.columnOpcion.setCellValueFactory(new PropertyValueFactory<>("texto"));

		 tableOpciones.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection,newSelection)-> {
			 opcionSeleccionada = newSelection;
		 });
    }

    @FXML
    void elegirOpcion(ActionEvent event) {

    }

    @FXML
    void siguientePregunta(ActionEvent event) {
    	int numero = Integer.parseInt(lblNumPregunta.getText());
    	int sigNum = numero+1;
    	String sNum = String.valueOf(sigNum);
    	main.mostrarVentanaSolucionEncuesta(sNum);
    }

	public void setAplicacion(Main main, String num) {
		this.main = main;
		lblNumPregunta.setText(num);
		txtPregunta.setText("");
		tableOpciones.getItems().clear();
		tableOpciones.refresh();
		tableOpciones.setItems(getListaOpciones());
	}

	private ObservableList<Opcion> getListaOpciones() {
		int numero = Integer.parseInt(lblNumPregunta.getText());
		txtPregunta.setText(main.obtenerPregunta(numero));
		List<Opcion> listaOpciones = new ArrayList<Opcion>(main.obtenerOpcionesPregunta(numero));
	    listaOpcionesData.addAll(listaOpciones);
	    return listaOpcionesData;
	}


}
