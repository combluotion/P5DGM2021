package p5dgm.dao.mysql;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import p5dgm.dao.DAOException;
import p5dgm.dao.ProyectoDAO;
import p5dgm.main.Proyecto;

public class MySQLProyectoDAO implements ProyectoDAO{

	private Connection conn;
	
	public MySQLProyectoDAO(Connection conn) {
		
		this.conn = conn;
	}
	
	final String INSERT = "INSERT INTO proyecto (nombreProyecto,tipoProyecto,pais,fechaInicio,fechaFin)	VALUES (?,?,?,STR_TO_DATE(?, '%d/%m/%Y'),STR_TO_DATE(?, '%d/%m/%Y'))";
	final String UPDATE = "UPDATE proyecto SET nombreProyecto = ?, tipoProyecto = ?, pais = ?, fechaInicio = STR_TO_DATE(?, '%d/%m/%Y'), fechaFin = STR_TO_DATE(?, '%d/%m/%Y') WHERE Id = ?";
	final String DELETE = "DELETE FROM proyecto WHERE Id = ?";
	final String SELECT = "SELECT * FROM proyecto WHERE Id = ?";
	
	@Override
	public void insertar(Proyecto a) throws DAOException {
		 PreparedStatement stat = null;
		 ResultSet rs = null;
		 try 
		 {
			 stat = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
			 stat.setString(1, a.getNombreProyecto());
			 stat.setString(2, a.getTipoProyecto());
			 stat.setString(3, a.getPais());
			 DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			 stat.setString(4, formatter.format(a.getFechaInicio()));
			 stat.setString(5, formatter.format(a.getFechaFin()));
			 
			 if(stat.executeUpdate() == 0)
			 {throw new DAOException("Error en creación de proyecto");}
			 rs = stat.getGeneratedKeys();
             if(rs.next())
             {
                 a.setId(rs.getInt(1));
             }
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
			 if(rs != null) {
				 try {
					rs.close();
				} catch (SQLException ex) {
					throw new DAOException("Error en SQL", ex);
				}
			 }
		 }
		 }
		 }
	

	@Override
	public void modificar(Proyecto a) throws DAOException {
		 PreparedStatement stat = null;
		 try 
		 {
			 stat = conn.prepareStatement(UPDATE);
			 stat.setString(1, a.getNombreProyecto());
			 stat.setString(2, a.getTipoProyecto());
			 stat.setString(3, a.getPais());
			 DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			 stat.setString(4, formatter.format(a.getFechaInicio()));
			 stat.setString(5, formatter.format(a.getFechaFin()));
			 stat.setInt(6, a.getId());
			 
			 if(stat.executeUpdate() == 0)
			 {throw new DAOException("Error en modificación de proyecto");} 			 
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
	public void eliminar(int id) throws DAOException{
		 PreparedStatement stat = null;
		 try 
		 {
			 stat = conn.prepareStatement(DELETE);
			 stat.setInt(1, id);
			 
			 if(stat.executeUpdate() == 0)
			 {throw new DAOException("Error en eliminación de proyecto");} 			 
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
	public Proyecto obtener(int id) throws DAOException {
		PreparedStatement stat = null;
		ResultSet rs = null;
		Proyecto proyecto = null;
		try {
			stat = conn.prepareStatement(SELECT);
			stat.setInt(1, id);
			rs = stat.executeQuery();
			if(rs.next())
			{
				proyecto = convertir(rs);				
			}
			else {
				throw new DAOException("No se ha encontrado el proyecto con esa Id");
			}
			
		} catch (SQLException e) {
			throw new DAOException("Error en sql",e);
		}finally {
			if(rs != null) {
				try {
					rs.close();
				}catch(SQLException ex) {
					throw new DAOException("Error en sql", ex);
				}
			}
			if(stat != null) {
				try {
					stat.close();
				}
				catch(SQLException ex) {
					throw new DAOException("Error en sql", ex);
				}
				}
			}
		return proyecto;
		}
		
		
		
	

	public Proyecto convertir(ResultSet rs) throws SQLException{
		// String nombreProyecto, String tipoProyecto, String pais, Date fechaInicio, Date fechaFin
		String nombreProyecto = rs.getString("nombreProyecto");
		String tipoProyecto = rs.getString("tipoProyecto");
		String pais = rs.getString("pais");
		Date fechaInicio = rs.getDate("fechaInicio");
		Date fechaFin = rs.getDate("fechaFin");
		Proyecto proyecto = new Proyecto(nombreProyecto,tipoProyecto, pais, fechaInicio, fechaFin);
		proyecto.setId(rs.getInt("Id"));
		return proyecto;
	}
}
