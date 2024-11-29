package ejerciciocreartabla;

import java.sql.Connection;
import java.sql.DriverManager;
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
		String sql = "CREATE TABLE Persona(\r\n"
				+ "	ID Int,\r\n"
				+ "    Nombre VarChar(128),\r\n"
				+ "    Apellidos VarChar(128),\r\n"
				+ "    Edad Int,\r\n"
				+ "    PRIMARY KEY (ID)\r\n"
				+ ");";
		try {
		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Establecemos la conexion
		connect = DriverManager.getConnection(DB_URL, USUARIO, CONTA);
		System.out.println("Nos hemos conectado a la BBDD");
		stmt = connect.createStatement();
		
		
		stmt.execute(use);
		stmt.execute(sql);
		
		System.out.println("Tabla creada");
		}
		catch (SQLException e) {
		//continuación codigo
		}
		finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
