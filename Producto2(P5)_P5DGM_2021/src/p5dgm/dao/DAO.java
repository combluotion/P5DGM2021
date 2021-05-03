package p5dgm.dao;



public interface DAO <T> {

	void insertar(T a) throws DAOException;
		

	void modificar(T a) throws DAOException;


	void eliminar(int id) throws DAOException;

	List<T>obtenerTodos() throws DAOException; 

		

	T obtener(int id) throws DAOException;

}

//Plantilla para Patron DAO