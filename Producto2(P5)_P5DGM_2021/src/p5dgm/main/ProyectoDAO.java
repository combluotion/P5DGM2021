package p5dgm.main;
import java.util.ArrayList;
import java.util.List;

public final class ProyectoDAO {

	public List<Proyecto> proyectos;
	
	public ProyectoDAO() {
		this.proyectos = new ArrayList();
	}
	
	public List<Proyecto> obtenerProyectos() {
		return new ArrayList();
	}
	public ProyectoDAO GuardarProyectos() {
		return this;
	}

}
