package locator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionLocator {
	private static String cadenaCon = "jdbc:mysql://localhost:3306/miagenda";
	private static String usuario = "root";
	private static String password = "root";
	public static Connection getConnection() throws SQLException {
		//cargar el driver en memoria
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(cadenaCon,usuario,password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new SQLException();
		}
		
	}

}
