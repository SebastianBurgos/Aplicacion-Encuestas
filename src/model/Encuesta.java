package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Encuesta {
	private Integer id, cantidad_personas_maxima, rango_edad_min, rango_edad_max;
	private String nombre, descripcion, objetivo;
	private LocalDate fecha_inicio_disponibilidad, fecha_fin_disponibilidad;
	private ArrayList<Pregunta> lista_preguntas;

	public Encuesta() {
		super();
	}

	public Encuesta(Integer id, Integer cantidad_personas_maxima, Integer rango_edad_min, Integer rango_edad_max,
			String nombre, String descripcion, String objetivo, LocalDate fecha_inicio_disponibilidad,
			LocalDate fecha_fin_disponibilidad, ArrayList<Pregunta> lista_preguntas) {
		super();
		this.id = id;
		this.cantidad_personas_maxima = cantidad_personas_maxima;
		this.rango_edad_min = rango_edad_min;
		this.rango_edad_max = rango_edad_max;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.objetivo = objetivo;
		this.fecha_inicio_disponibilidad = fecha_inicio_disponibilidad;
		this.fecha_fin_disponibilidad = fecha_fin_disponibilidad;
		this.lista_preguntas = lista_preguntas;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCantidad_personas_maxima() {
		return cantidad_personas_maxima;
	}

	public void setCantidad_personas_maxima(Integer cantidad_personas_maxima) {
		this.cantidad_personas_maxima = cantidad_personas_maxima;
	}

	public Integer getRango_edad_min() {
		return rango_edad_min;
	}

	public void setRango_edad_min(Integer rango_edad_min) {
		this.rango_edad_min = rango_edad_min;
	}

	public Integer getRango_edad_max() {
		return rango_edad_max;
	}

	public void setRango_edad_max(Integer rango_edad_max) {
		this.rango_edad_max = rango_edad_max;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public LocalDate getFecha_inicio_disponibilidad() {
		return fecha_inicio_disponibilidad;
	}

	public void setFecha_inicio_disponibilidad(LocalDate fecha_inicio_disponibilidad) {
		this.fecha_inicio_disponibilidad = fecha_inicio_disponibilidad;
	}

	public LocalDate getFecha_fin_disponibilidad() {
		return fecha_fin_disponibilidad;
	}

	public void setFecha_fin_disponibilidad(LocalDate fecha_fin_disponibilidad) {
		this.fecha_fin_disponibilidad = fecha_fin_disponibilidad;
	}

	public ArrayList<Pregunta> getLista_preguntas() {
		return lista_preguntas;
	}

	public void setLista_preguntas(ArrayList<Pregunta> lista_preguntas) {
		this.lista_preguntas = lista_preguntas;
	}

	@Override
	public String toString() {
		return "Encuesta [id=" + id + ", cantidad_personas_maxima=" + cantidad_personas_maxima + ", rango_edad_min="
				+ rango_edad_min + ", rango_edad_max=" + rango_edad_max + ", nombre=" + nombre + ", descripcion="
				+ descripcion + ", objetivo=" + objetivo + ", fecha_inicio_disponibilidad="
				+ fecha_inicio_disponibilidad + ", fecha_fin_disponibilidad=" + fecha_fin_disponibilidad + "]";
	}

}
