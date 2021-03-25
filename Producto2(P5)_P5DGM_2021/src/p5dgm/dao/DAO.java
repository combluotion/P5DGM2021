package p5dgm.dao;

import java.io.IOException;

public interface DAO <T> {

	void insertar(T a) throws IOException;
		
	void modificar(T a) throws IOException;
		
	void eliminar(int id) throws IOException;
		
	T obtener(int id) throws IOException;
		
}