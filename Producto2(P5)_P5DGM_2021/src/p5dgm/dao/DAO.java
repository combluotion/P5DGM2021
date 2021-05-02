package p5dgm.dao;

import java.io.IOException;
import p5dgm.dao.DAOException;
import java.util.List;

public interface DAO <T> {

	void insertar(T a) throws DAOException;
		
	void modificar(T a) throws DAOException, IOException;
		
	void eliminar(int id) throws DAOException, IOException;
	
	List<T>obtenerTodos() throws DAOException; 
		
	T obtener(int id) throws DAOException, IOException;
		
}

//Plantilla para Patron DAO