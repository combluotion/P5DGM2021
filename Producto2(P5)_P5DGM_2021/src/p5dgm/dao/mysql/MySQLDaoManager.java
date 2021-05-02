package p5dgm.dao.mysql;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import p5dgm.dao.DAOException;
import p5dgm.dao.DAOManager;
import p5dgm.dao.EquipoDAO;
import p5dgm.dao.ProyectoDAO;
import p5dgm.dao.SocioDAO;
import p5dgm.main.Socio;

 public class MySQLDaoManager implements DAOManager {	

		private Connection conn;
		
		private EquipoDAO equipo = null;
		private ProyectoDAO proyecto = null;
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
	
	public MySQLDaoManager() {
		// TODO Auto-generated constructor stub
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
		// TODO Auto-generated method stub
	       return null;
	      
	}
		
	@Override
	public ProyectoDAO getProyectoDAO() {
	// TODO Auto-generated method stub
       return null;
	}
	
	//public static void main(String[]args) throws SQLException,DAOException {
		//MySQLDaoManager conn = new MySQLDaoManager("localhost","p5dgm2021","root","root");
		//List<Socio> socio = conn.getSocioDAO().obtenerTodos();
	//}
	
}
 
