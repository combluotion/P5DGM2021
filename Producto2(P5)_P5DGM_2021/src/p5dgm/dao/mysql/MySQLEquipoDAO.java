package p5dgm.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Scanner;

import p5dgm.dao.DAOException;
import p5dgm.dao.EquipoDAO;
import p5dgm.main.Equipo;

public class MySQLEquipoDAO implements EquipoDAO{
	private Connection conn;
	
	public MySQLEquipoDAO(Connection conn) {
		this.conn = conn;
	}
	
	final String INSERT = "INSERT INTO equipo (nombre, fechaNacimiento, direccion, telefono, delegacion) VALUES (?, STR_TO_DATE(?, '%d/%m/%Y'), ?, ?, ?)";
	final String UPDATE = "UPDATE equipo SET nombre = ?, fechaNacimiento = STR_TO_DATE(?, '%d/%m/%Y'), direccion = ?, telefono = ?, delegacion = ? WHERE Id = ?";
	final String DELETE = "DELETE FROM equipo WHERE Id = ?";
	final String SELECT = "SELECT * FROM equipo WHERE Id = ?";
	
	public void insertar(Equipo a) throws DAOException {
		 PreparedStatement stat = null;
		 ResultSet rs = null;
		 try 
		 {
			 stat = conn.prepareStatement(INSERT);
			 stat.setString(1, a.getNombre());
			 DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			 stat.setString(2, formatter.format(a.getFechaNacimiento()));
			 stat.setString(3, a.getDireccion());
			 stat.setString(4, a.getTelefono());
			 stat.setString(5, a.getDelegacion());
			 
			 if(stat.executeUpdate() == 0)
			 {
				 throw new DAOException("Error en creación de proyecto");
			 }
		 }
		 catch(SQLException ex) {
			 throw new DAOException("Error en SQL", ex);
		 }
		 finally
		 {
			 if(stat != null) {
				 try 
				 {
					stat.close();
				 } 
				 catch (SQLException ex) 
				 {
					throw new DAOException("Error en SQL", ex);
				 }
				 if(rs != null) 
				 	{
					 try 
					 	{
						 rs.close();
					 	} 
				 catch (SQLException ex) 
					 {
						throw new DAOException("Error en SQL", ex);
					 }
				 }
			 }
		 }
	}
	
	public void modificar(Equipo a) throws DAOException {
		 PreparedStatement stat = null;
		 try 
		 {
			 //Introducir ID a modificar e introducir nuevos valores.
			 Scanner scan = new Scanner(System.in);
			 System.out.println("Introduzca el id a modificar: ");
			 int id = Integer.parseInt(scan.nextLine());
			 stat = conn.prepareStatement(UPDATE);
			 stat.setString(1, a.getNombre());
			 DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			 stat.setString(2, formatter.format(a.getFechaNacimiento()));
			 stat.setString(3, a.getDireccion());
			 stat.setString(4, a.getTelefono());
			 stat.setString(5, a.getDelegacion());
			 stat.setInt(6, id);
			 
			 if(stat.executeUpdate() == 0)
			 {
				 throw new DAOException("Error en modificación de proyecto");
			 } 			 
		 }
		 catch(SQLException ex) {
			 throw new DAOException("Error en SQL", ex);
		 }
		 finally {
			 if(stat != null) 
			 {
			 try {
				stat.close();
			 	} catch (SQLException ex) {
				throw new DAOException("Error en SQL", ex);
			 		}
			 	}
		 	}
		
	 }

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

	public Equipo obtener(int id) throws DAOException {
		PreparedStatement stat = null;
		ResultSet rs = null;
		Equipo equipo = null;
		try {
			stat = conn.prepareStatement(SELECT);
			stat.setInt(1, id);
			rs = stat.executeQuery();
			if(rs.next())
			{
				equipo = convertir(rs);				
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
		return equipo;
		}
		
	public Equipo convertir(ResultSet rs) throws SQLException{
		String nombre = rs.getString("nombre");
		Date fechaNacimiento = rs.getDate("fechaNacimiento");
		String direccion = rs.getString("direccion");
		String telefono = rs.getString("telefono");
		String delegacion = rs.getString("delegacion");
		Equipo equipo = new Equipo(nombre, fechaNacimiento, direccion, telefono, delegacion);
		return equipo;
	}
}