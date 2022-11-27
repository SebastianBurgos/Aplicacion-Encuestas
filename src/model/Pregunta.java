package model;

import java.util.ArrayList;

public class Pregunta {
	private Integer numero;
	private String texto;
	private ArrayList<Opcion> listaOpciones;

	public Pregunta() {
		super();
	}

	public Pregunta(Integer numero, String texto, ArrayList<Opcion> listaOpciones) {
		super();
		this.numero = numero;
		this.texto = texto;
		this.listaOpciones = listaOpciones;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public ArrayList<Opcion> getListaOpciones() {
		return listaOpciones;
	}

	public void setListaOpciones(ArrayList<Opcion> listaOpciones) {
		this.listaOpciones = listaOpciones;
	}

	@Override
	public String toString() {
		return "Pregunta [numero=" + numero + ", texto=" + texto + "]";
	}

}
