package p5dgm.dao.mysql;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import p5dgm.dao.DAOException;
import p5dgm.dao.ProyectoDAO;
import p5dgm.main.Proyecto;

public class MySQLProyectoDAOTest {

	@Test
	public void testInsertar() throws DAOException, ParseException {
			MySQLDaoManager man = new MySQLDaoManager();
			Proyecto proyecto = new Proyecto("Proyecto1","Importante","Italia",new SimpleDateFormat("dd/MM/yyyy").parse("13/08/1995"),new SimpleDateFormat("dd/MM/yyyy").parse("13/08/1997")/*,financiacionAportadaFloat*/);
			man.getProyectoDAO().insertar(proyecto);
			assertTrue(true);
	}

	@Test
	public void testModificar() throws ParseException, DAOException {
			MySQLDaoManager man = new MySQLDaoManager();	
			Proyecto proyecto = new Proyecto("Proyecto1","Importante","Italia",new SimpleDateFormat("dd/MM/yyyy").parse("13/08/1995"),new SimpleDateFormat("dd/MM/yyyy").parse("13/08/1997")/*,financiacionAportadaFloat*/);
			man.getProyectoDAO().insertar(proyecto);
			proyecto.setNombreProyecto("Proyecto1Modified");
			man.getProyectoDAO().modificar(proyecto);
			assertTrue(true);
	}

	@Test
	public void testEliminar() throws DAOException, ParseException {
			MySQLDaoManager man = new MySQLDaoManager();
			Proyecto proyecto = new Proyecto("ProyectoAEliminar","Importante","Italia",new SimpleDateFormat("dd/MM/yyyy").parse("13/08/1995"),new SimpleDateFormat("dd/MM/yyyy").parse("13/08/1997")/*,financiacionAportadaFloat*/);
			man.getProyectoDAO().insertar(proyecto);
			man.getProyectoDAO().eliminar(proyecto.getId());
			assertTrue(true);
	}

	@Test
	public void testObtener() throws ParseException, DAOException {
			MySQLDaoManager man = new MySQLDaoManager();
			Proyecto proyecto = new Proyecto("ProyectoAObtener","Importante","Italia",new SimpleDateFormat("dd/MM/yyyy").parse("13/08/1995"),new SimpleDateFormat("dd/MM/yyyy").parse("13/08/1997")/*,financiacionAportadaFloat*/);			
			man.getProyectoDAO().insertar(proyecto);
			int IdAComprobar = proyecto.getId();
			proyecto = null;
			proyecto = man.getProyectoDAO().obtener(IdAComprobar);
			assertTrue(proyecto != null && proyecto.getId() == IdAComprobar );
	
	}

}
