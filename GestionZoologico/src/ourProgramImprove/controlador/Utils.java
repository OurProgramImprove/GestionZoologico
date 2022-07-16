package ourProgramImprove.controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Utils {

	/**
	 * Obtenemos la conexion a la bbdd de clase.sql
	 * la bbdd tiene datos de alumnos con un id, su nombre y su email
	 * @return
	 */
	public static Connection getConnection() {
		
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:33060/gestion_formacion_elorriet?useSSL=false", "root", "elorrieta");
		} catch (SQLException e) {
			System.out.println("ERROR de conexion");
			e.printStackTrace();
		}
		
		return con;
	}
	

}