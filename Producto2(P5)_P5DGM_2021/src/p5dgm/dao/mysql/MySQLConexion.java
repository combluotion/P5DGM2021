package p5dgm.dao.mysql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConexion {
	
	private static final String URL = "jdbc:mysql://localhost:3306/p5dgm2021";
	private static final String USUARIO = "root";
	private static final String CLAVE = "root";
	
	public Connection conectar()throws SQLException {
		Connection MySQLConexion = null;
		
		try {
			MySQLConexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
			System.out.println("Conexion realizada con exito");
		} catch (SQLException e) {
			System.out.println("Error en la conexion");
				e.printStackTrace();
		}
		
		return MySQLConexion;
	}
	public static void main(String[]args) throws SQLException {
		MySQLConexion conexion = new MySQLConexion();
		Connection cn = null;
		
		cn = conexion.conectar();
	}
}
