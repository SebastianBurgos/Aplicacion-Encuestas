package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import model.Opcion;
import model.Pregunta;

public class DatabaseConnection {

    private final String stringConexion = "jdbc:oracle:thin:@localhost:1521:xe";
    private String driver = "oracle.jdbc.driver.OracleDriver";
    private Connection cx;
    private String usr = "PROYECTO_ENCUESTAS";
    private String passwd = "1234";
    private Statement statement;
    private ResultSet resultSet;

    public DatabaseConnection(){

    }

    public Connection conectar(){
        try{
            Class.forName(driver);
            cx = DriverManager.getConnection(stringConexion, usr, passwd);
            System.out.println("SE HA LEVANTADO LA CONEXION A LA BASE DE DATOS");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("NO SE HA LEVANTADO LA CONEXION A LA BASE DE DATOS");
        }
        return cx;
    }

	public ArrayList<Pregunta> listaPreguntas(){
    	ArrayList<Pregunta> listaPreguntas = new ArrayList<>();
    	Pregunta pregunta = new Pregunta();

		try {
			statement = cx.createStatement();
			//consulta básica
			resultSet = statement.executeQuery("SELECT * FROM PREGUNTA");

			//recorrer la consulta
			while (resultSet.next()) {
				pregunta.setNumero(resultSet.getInt("NUMERO"));
				pregunta.setTexto(resultSet.getString("TEXTO"));
				listaPreguntas.add(pregunta);
				pregunta = new Pregunta();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listaPreguntas;
    }

	public void crearEncuesta(Integer id_e, String nombre, Integer numMaxPersonas_e, String descripcion,
			String fechaInicioE, String fechaFinE, String objetivo, Integer edadMin_e, Integer edadMax_e,
			ArrayList<Pregunta> listaPreguntas) {

			String date1 = fechaInicioE.toString();
			System.out.println(date1);

			try {
				statement.executeQuery("INSERT INTO ENCUESTA (ID,NOMBRE,DESCRIPCION,FECHA_INICIO_DISPONIBILIDAD,"
						+ "FECHA_FIN_DISPONIBILIDAD,CANTIDAD_PERSONAS_MAXIMA,OBJETIVO,RANGO_EDAD_MINIMO,"
						+ "RANGO_EDAD_MAXIMO,SUBCATEGORIA_ID,GENERO_OBJETIVO_ID) values "
						+ "('"+id_e+"','"+nombre+"','"+descripcion+"',to_date('"+fechaInicioE+"','DD/MM/RR'),to_date('"+fechaFinE+"','DD/MM/RR'),'"+numMaxPersonas_e+"','"+objetivo+"','"+edadMin_e+"','"+edadMax_e+"','1','1')");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	public ArrayList<Opcion> listaOpciones() {
		ArrayList<Opcion> listaOpciones = new ArrayList<>();
    	Opcion opcion = new Opcion();

		try {
			statement = cx.createStatement();
			//consulta básica
			resultSet = statement.executeQuery("SELECT * FROM OPCION");

			//recorrer la consulta
			while (resultSet.next()) {
				opcion.setId(resultSet.getInt("ID"));
				opcion.setTexto(resultSet.getString("TEXTO"));
				opcion.setPregunta_numero(resultSet.getInt("PREGUNTA_numero"));
				listaOpciones.add(opcion);
				System.out.println(opcion);
				opcion = new Opcion();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listaOpciones;
	}
}
