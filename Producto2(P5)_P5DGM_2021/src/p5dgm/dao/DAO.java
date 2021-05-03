package p5dgm.dao;

<<<<<<< HEAD
=======
import java.io.IOException;
import p5dgm.dao.DAOException;
import java.util.List;
>>>>>>> refs/remotes/origin/Mc_producto3

public interface DAO <T> {

	void insertar(T a) throws DAOException;
		
<<<<<<< HEAD
	void modificar(T a) throws DAOException;
=======
	void modificar(T a) throws DAOException, IOException;
>>>>>>> refs/remotes/origin/Mc_producto3
		
<<<<<<< HEAD
	void eliminar(int id) throws DAOException;
=======
	void eliminar(int id) throws DAOException, IOException;
	
	List<T>obtenerTodos() throws DAOException; 
>>>>>>> refs/remotes/origin/Mc_producto3
		
<<<<<<< HEAD
	T obtener(int id) throws DAOException;
=======
	T obtener(int id) throws DAOException, IOException;
>>>>>>> refs/remotes/origin/Mc_producto3
		
}

//Plantilla para Patron DAO