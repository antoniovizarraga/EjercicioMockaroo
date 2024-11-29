package insertardatos;

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
		String sql = "insert into Persona (ID, Nombre, Apellidos, Edad) values (1, 'Görel', 'Ducket', 71),\r\n"
				+ "(2, 'Mélanie', 'Goulston', 14 ),\r\n"
				+ "(3, 'Kuí', 'Ruffy', 86),\r\n"
				+ "(4, 'Marie-ève', 'Lethley', 15),\r\n"
				+ "(5, 'Lóng', 'Stanning', 44),\r\n"
				+ "(6, 'Åsa', 'Prestwich', 69),\r\n"
				+ "(7, 'Laïla', 'Gosnell', 93),\r\n"
				+ "(8, 'Léandre', 'McAllen', 23),\r\n"
				+ "(9, 'Naéva', 'Coady', 62 ),\r\n"
				+ "(10, 'Mégane', 'Leftwich', 93 );";
		
		try {
			connect = DriverManager.getConnection(DB_URL, USUARIO, CONTA);
			System.out.println("Nos hemos conectado a la BBDD");
			stmt = connect.createStatement();
			
			stmt.execute(use);
			stmt.execute(sql);
			
			System.out.println("Datos insertados con éxito.");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
