package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Encuestadora {
	ArrayList<Encuesta> listaEncuestas = new ArrayList<>();
	ArrayList<Pregunta> listaPreguntas = new ArrayList<>();
	ArrayList<Opcion> listaOpciones = new ArrayList<>();

	public Encuestadora() {
		super();
	}

	public ArrayList<Encuesta> getListaEncuestas() {
		return listaEncuestas;
	}

	public void setListaEncuestas(ArrayList<Encuesta> listaEncuestas) {
		this.listaEncuestas = listaEncuestas;
	}

	public ArrayList<Pregunta> getListaPreguntas() {
		return listaPreguntas;
	}

	public void setListaPreguntas(ArrayList<Pregunta> listaPreguntas) {
		this.listaPreguntas = listaPreguntas;
	}

	public ArrayList<Opcion> getListaOpciones() {
		return listaOpciones;
	}

	public void setListaOpciones(ArrayList<Opcion> listaOpciones) {
		this.listaOpciones = listaOpciones;
	}

	public void crearEncuesta(Integer id_e, String nombre, Integer numMaxPersonas_e, String descripcion,
			LocalDate fechaInicio, LocalDate fechaFin, String objetivo, Integer edadMin_e, Integer edadMax_e, ArrayList<Pregunta> listaPreguntas) {
		Encuesta nueva = new Encuesta(id_e, numMaxPersonas_e, edadMin_e, edadMax_e, nombre, descripcion, objetivo, fechaInicio, fechaFin, listaPreguntas);
		listaEncuestas.add(nueva);

	}

	public void agregarPreguntaEncuesta() {
		// TODO Auto-generated method stub

	}

	public ArrayList<Opcion> getListaOpcionesPregunta(int numero) {
		ArrayList<Opcion> listaOpcionesPregunta = new ArrayList<>();
		for (Opcion opcion : listaOpciones) {
			if (opcion.getPregunta_numero() == numero) {
				listaOpcionesPregunta.add(opcion);
			}
		}
		return listaOpcionesPregunta;
	}

	public void setOpcionesPregunta(int numero, ArrayList<Opcion> lstOpcionesPregunta) {
		for (Pregunta pregunta : listaPreguntas) {
			if (pregunta.getNumero() == numero) {
				pregunta.setListaOpciones(lstOpcionesPregunta);
			}
		}
	}

	public String obtenerPregunta(int numero) {
		for (Pregunta pregunta : listaPreguntas) {
			if (pregunta.getNumero() == numero) {
				return pregunta.getTexto();
			}
		}
		return "";
	}

}
