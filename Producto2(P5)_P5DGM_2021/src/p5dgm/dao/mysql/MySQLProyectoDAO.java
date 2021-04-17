package p5dgm.dao.mysql;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import p5dgm.dao.DAOException;
import p5dgm.dao.ProyectoDAO;
import p5dgm.main.Proyecto;

public class MySQLProyectoDAO implements ProyectoDAO{

	private Connection conn;
	
	public MySQLProyectoDAO(Connection conn) {
		
		this.conn = conn;
	}
	
	final String INSERT = "INSERT INTO proyecto (nombreProyecto,tipoProyecto,pais,fechaInicio,fechaFin)	VALUES (?,?,?,STR_TO_DATE(?, '%d/%m/%Y'),STR_TO_DATE(?, '%d/%m/%Y'))";
	final String UPDATE = "UPDATE proyecto SET nombreProyecto = ?, tipoProyecto = ?, pais = ?, fechaInicio = ?, fechaFin = ? WHERE Id = ?";
	final String DELETE = "DELETE FROM proyecto WHERE Id = ?";
	final String SELECT = "SELECT * FROM proyecto WHERE Id = ?";
	
	@Override
	public void insertar(Proyecto a) throws DAOException {
		 PreparedStatement stat = null;
		 try 
		 {
			 stat = conn.prepareStatement(INSERT);
			 stat.setString(1, a.getNombreProyecto());
			 stat.setString(2, a.getTipoProyecto());
			 stat.setString(3, a.getPais());
			 DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			 stat.setString(4, formatter.format(a.getFechaInicio()));
			 stat.setString(5, formatter.format(a.getFechaFin()));
			 
			 if(stat.executeUpdate() == 0)
			 {throw new DAOException("Error en creación de proyecto");} 			 
		 }
		 catch(SQLException ex) {
			 throw new DAOException("Error en SQL", ex);
		 }
		 finally
		 {
			 if(stat != null) {
			 try {
				stat.close();
			} catch (SQLException ex) {
				throw new DAOException("Error en SQL", ex);
			}
			 }
		 }
		 }
	

	@Override
	public void modificar(Proyecto a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Proyecto obtener(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
