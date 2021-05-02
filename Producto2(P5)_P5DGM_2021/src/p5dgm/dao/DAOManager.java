package p5dgm.dao;

public interface DAOManager {
	
	EquipoDAO getEquipoDAO();
	
	ProyectoDAO getProyectoDAO();
	
	SocioDAO getSocioDAO();

}

//Esta es nuestra clase factory