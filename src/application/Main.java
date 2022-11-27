package application;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import connection.DatabaseConnection;
import controller.MainController;
import controller.SolucionEncuestaController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import model.Encuestadora;
import model.Opcion;
import model.Pregunta;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public class Main extends Application {

	private Stage primaryStage;
	private static Encuestadora encuestadora = new Encuestadora();
	private static DatabaseConnection conexion  = new DatabaseConnection();

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Aplicacion");
//		mostrarVentanaMain();
		mostrarVentanaSolucionEncuesta("1");
	}

	public static void main(String[] args) {
        conexion.conectar();
        cargarDatosEncuestadora();
		launch(args);
	}

	private static void cargarDatosEncuestadora() {
		encuestadora.setListaPreguntas(conexion.listaPreguntas());
		encuestadora.setListaOpciones(conexion.listaOpciones());
	}

	private void mostrarVentanaMain() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/view/MainView.fxml"));
			AnchorPane rootLayout = (AnchorPane) loader.load();
			MainController mainController = loader.getController();
			mainController.setAplicacion(this);

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void mostrarVentanaSolucionEncuesta(String num) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/view/SolucionEncuestaView.fxml"));
			AnchorPane rootLayout = (AnchorPane) loader.load();
			SolucionEncuestaController solucionEncuestaController = loader.getController();
			solucionEncuestaController.setAplicacion(this, num);

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<Pregunta> obtenerPreguntasTodas() {
		return encuestadora.getListaPreguntas();
	}

	public void crearEncuesta(String id, String nombre, String numMaxPersonas, String descripcion,
			LocalDate fechaInicio, LocalDate fechaFin, String objetivo, String edadMin, String edadMax, ArrayList<Pregunta> listaPreguntas) {
		Integer id_e = Integer.valueOf(id);
		Integer numMaxPersonas_e = Integer.valueOf(id);
		Integer edadMin_e = Integer.valueOf(id);
		Integer edadMax_e = Integer.valueOf(id);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YY");
    	String fechaInicioE = formatter.format(fechaInicio);
    	String fechaFinE = formatter.format(fechaInicio);
		conexion.crearEncuesta(id_e, nombre, numMaxPersonas_e, descripcion, fechaInicioE, fechaFinE, objetivo, edadMin_e, edadMax_e, listaPreguntas);
		encuestadora.crearEncuesta(id_e, nombre, numMaxPersonas_e, descripcion, fechaInicio, fechaFin, objetivo, edadMin_e, edadMax_e, listaPreguntas);
	}

	public void agregarPreguntaEncuesta(Pregunta preguntaTodasSelected) {
		encuestadora.agregarPreguntaEncuesta();
	}

	public ArrayList<Opcion> obtenerOpcionesPregunta(int numero) {
		ArrayList<Opcion> lstOpcionesPregunta = encuestadora.getListaOpcionesPregunta(numero);
		encuestadora.setOpcionesPregunta(numero,lstOpcionesPregunta);
		return lstOpcionesPregunta;
	}

	public String obtenerPregunta(int numero) {
		return encuestadora.obtenerPregunta(numero);
	}

}
