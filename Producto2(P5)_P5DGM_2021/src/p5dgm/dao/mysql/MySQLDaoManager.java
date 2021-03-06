package p5dgm.dao.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import p5dgm.dao.DAOManager;
import p5dgm.dao.EquipoDAO;
import p5dgm.dao.ProyectoDAO;

public class MySQLDaoManager implements DAOManager{

	private Connection conn;
	private ProyectoDAO proyecto = null;
	private EquipoDAO equipo = null;
	private SocioDAO socio = null;
	
	public MySQLDaoManager(String host, String username, String password, String database) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(  
			"jdbc:mysql://"+host+":3306/"+database+"?characterEncoding=latin1",username,password);
		}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  			
	}
	
	@Override
	public ProyectoDAO getProyectoDAO() {
		if(proyecto == null)
		{
		proyecto = new MySQLProyectoDAO(conn);
		
		}
		return proyecto;
	}
	
	@Override
	public SocioDAO getSocioDAO() {
		if(socio == null)
		{
		socio = new MySQLSocioDAO(conn);
		}
		return socio;
	}
	
	@Override
	public EquipoDAO getEquipoDAO() {
		if(conn == null) {
			System.out.println("NO VA");		}
		if(equipo == null)
		{
		equipo = new MySQLEquipoDAO(conn);
		}
		return equipo;
	}

}
