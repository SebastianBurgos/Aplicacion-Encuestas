package model;

public class Opcion {
	private Integer id, pregunta_numero;
	private String texto;

	public Opcion(Integer id, String texto, Integer pregunta_numero) {
		super();
		this.id = id;
		this.texto = texto;
		this.pregunta_numero = pregunta_numero;
	}

	public Opcion() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Integer getPregunta_numero() {
		return pregunta_numero;
	}

	public void setPregunta_numero(Integer pregunta_numero) {
		this.pregunta_numero = pregunta_numero;
	}

	@Override
	public String toString() {
		return "Opcion [id=" + id + ", pregunta_numero=" + pregunta_numero + ", texto=" + texto + "]";
	}


}
