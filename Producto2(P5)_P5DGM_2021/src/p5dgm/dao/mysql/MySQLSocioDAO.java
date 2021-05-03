package p5dgm.dao.mysql;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import p5dgm.dao.DAOException;
import p5dgm.dao.SocioDAO;
import p5dgm.main.Socio;

public class MySQLSocioDAO implements SocioDAO {
	
	/*public static void main(String[]args) throws SQLException {
		MySQLConexion conexion = new MySQLConexion();
		Connection cn = null;
		
		cn = conexion.conectar();
	}*/	
	
	private Connection conn;
	
	public MySQLSocioDAO(Connection conn) {
		
		this.conn = conn;
				
	}
		
	final String INSERT = "INSERT INTO socio (nombreSocio,direccion,telefono,delegacion,tipoCuota,importeCuota)	VALUES (?,?,?,?,?,?)";
	final String UPDATE = "UPDATE socio SET nombreSocio = ?, direccion = ?, telefono = ?, delegacion = ?, tipoCuota = ?, importeCuota = ? WHERE IdSocio = ?";
	final String DELETE = "DELETE FROM socio WHERE IdSocio = ?";
	final String SELECT = "SELECT * FROM socio WHERE IdSocio = ?";
	final String GETALL = "SELECT * FROM socio";

	@Override
	public void insertar(Socio s) throws DAOException {
		 PreparedStatement stat = null;
		 ResultSet rs = null;
		 try 
		 {
			 stat = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
			 stat.setString(1, s.getNombreSocio());
			 stat.setString(2, s.getDireccion());
			 stat.setString(3, s.getTelefono());
	         stat.setString(4, s.getDelegacion());	
			 stat.setString(5, s.getTipoCuota());
			 stat.setFloat(6, s.getImporteCuota());
			 
			 if(stat.executeUpdate() == 0) {
				 throw new DAOException("Error en creación de nuevo socio");}
			 rs = stat.getGeneratedKeys();
             if(rs.next())
             {
                 s.setIdSocio(rs.getInt(1));
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
	public void modificar(Socio s) throws DAOException {
		 PreparedStatement stat = null;
		 try 
		 {
			 stat = conn.prepareStatement(UPDATE);
			 stat.setString(1, s.getNombreSocio());
			 stat.setString(2, s.getDireccion());
			 stat.setString(3, s.getTelefono());
			 stat.setString(4, s.getDelegacion());
			 stat.setString(5, s.getTipoCuota());
			 stat.setFloat(6, s.getImporteCuota());
			 stat.setInt(7, s.getIdSocio());
			 
			 if(stat.executeUpdate() == 0){
				 throw new DAOException("Error en modificación del socio");
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
		 }
	  }
		
	}


	public void eliminar(Socio s) throws DAOException{
		 PreparedStatement stat = null;
		 try 
		 {
			 stat = conn.prepareStatement(DELETE);
			 stat.setInt(1, s.getIdSocio());			 
			 if(stat.executeUpdate() == 0)
			 {throw new DAOException("Error en la eliminación del socio");} 			 
		 }
		 catch(SQLException ex) {
			 throw new DAOException("Error en SQL", ex);
		 }
		 finally {
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
	public Socio obtener(int idSocio) throws DAOException {
		   PreparedStatement stat = null;
		   ResultSet rs = null;
		   Socio s = null;
		   	try {
		   		stat = conn.prepareStatement(SELECT);
		   		stat.setInt(1, idSocio);
		   		rs = stat.executeQuery();
		   		if(rs.next()) {
				 s = convertir(rs);				
		   		}
		   		else {
		   			throw new DAOException("No se ha encontrado el socio con esa Id");
		   		}
			
		   	} catch (SQLException ex) {
		   		throw new DAOException("Error en sql",ex);
		   	} finally {
		   		if(rs != null) {
		   			try {
					rs.close();
		   			} catch(SQLException ex) {
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
		return s;
	}
		
	@Override
	public List<Socio> obtenerTodos() throws DAOException{
		PreparedStatement stat = null;
		   ResultSet rs = null;
		   List<Socio> socio = new ArrayList<>();
		   	try {
		   		stat = conn.prepareStatement(GETALL);
		   		rs = stat.executeQuery();
		   		while (rs.next()) {
		   		socio.add(convertir(rs));
		   		}
		   	} catch (SQLException ex) {
		   		throw new DAOException("Error en sql",ex);
		   	} finally {
		   		if(rs != null) {
		   			try {
					rs.close();
		   			} catch(SQLException ex) {
					throw new DAOException("Error en sql", ex);
		   			}
		   		}
		   		if(stat != null) {
		   			try {
					stat.close();
		   			} catch(SQLException ex) {
					throw new DAOException("Error en sql", ex);
				}
			}
		}
		return socio;
	
	}
		
	//funcion convertir para usar en obtener y obtener todos

	public Socio convertir(ResultSet rs) throws SQLException{
		
		//Parametros de socio: String nombreSocio, String direccion, String telefono, String delegacion, String tipoCuota, float importeCuota
		
		String nombreSocio = rs.getString("nombreSocio");
		String direccion = rs.getString("direccion");
		String telefono = rs.getString("telefono");
		String delegacion = rs.getString("delegacion");
		String tipoCuota = rs.getString("tipoCuota");
		String importeCuota = rs.getString("ImporteCuota");
		Socio socio = new Socio (nombreSocio, direccion, telefono, delegacion, tipoCuota, importeCuota);
		socio.setIdSocio(rs.getInt("IdSocio"));
		return socio;
	  }


	@Override
	public void eliminar(int id) throws DAOException, IOException {
	// TODO Auto-generated method stub
	}

}
	
 
