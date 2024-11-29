package ejerciciosconsulta;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Principal {

	public static void main(String[] args) {
		
		Statement stmt = null;
		Connection connect = null;
		// JDBC driver name and database URL
		String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		final String DB_URL = "jdbc:mysql://dns11036.phdns11.es/ad2425_avizarraga";
		String USUARIO = "avizarraga";
		String CONTA = "12345";
		
		String use = "use ad2425_avizarraga;";
		String sql = "SELECT * FROM Persona ORDER BY Edad DESC;";
		
		
		ResultSet resultado = null;
		
		try {
			connect = DriverManager.getConnection(DB_URL, USUARIO, CONTA);
			System.out.println("Nos hemos conectado a la BBDD");
			
			//Paso 1 establecer conexión + pasar la consulta
			PreparedStatement stat = connect.prepareStatement(sql);
			
			//Paso 2. Definir resultSet y ejecutar la consulta
			resultado = stat.executeQuery();
			
			//Paso 3. Imprimir el resultado
			while(resultado.next()) {
			System.out.println();
			System.out.println("Id: " + resultado.getInt(1));
			System.out.println("Nombre: " + resultado.getString(2));
			System.out.println("Apellidos: " + resultado.getString(3));
			System.out.println("Edad: " + resultado.getInt(4));
			System.out.println();
			System.out.println("----------");
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			
			try {
				//Paso 4: Cerramos los objetos que usamos para realizar la
				// conexión y obtener resultado
				resultado.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		
		

	}

}
