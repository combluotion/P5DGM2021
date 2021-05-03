package p5dgm.dao.xml;

import static org.junit.Assert.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import p5dgm.dao.DAOException;
import p5dgm.dao.EquipoDAO;
import p5dgm.dao.ProyectoDAO;
import p5dgm.main.Equipo;
import p5dgm.main.Proyecto;

public class XMLProyectoDAOTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInsertar() throws ParseException, DAOException {
		Proyecto proyecto = new Proyecto("Proyecto1","Importante","Italia",new SimpleDateFormat("dd/MM/yyyy").parse("13/08/1995"),new SimpleDateFormat("dd/MM/yyyy").parse("13/08/1997")/*,financiacionAportadaFloat*/);
		proyecto.setId(999);
		ProyectoDAO proyectoDAO = new XMLProyectoDAO();
		try {
			proyectoDAO.insertar(proyecto);
			assertTrue(true);
		} catch (DAOException e) {
			e.printStackTrace();			
			fail(e.getMessage());
		}
		
	}

	@Test
	public void testModificar() throws ParseException, DAOException {
		ProyectoDAO DAOmodificar = new XMLProyectoDAO();
        Proyecto modificar  = new Proyecto("Proyecto1Modified","Importante","Italia",new SimpleDateFormat("dd/MM/yyyy").parse("13/08/1995"),new SimpleDateFormat("dd/MM/yyyy").parse("13/08/1997")/*,financiacionAportadaFloat*/);
        modificar.setId(999);
        try {
			DAOmodificar.modificar(modificar);
			assertTrue(true);
		} catch (DAOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	public void testObtener() throws DAOException {
        ProyectoDAO daoObtenerProyecto = new XMLProyectoDAO();
		Proyecto obtener = daoObtenerProyecto.obtener(999);
		if (obtener == null) {
			fail("Not found");
		}
		else {
			assertTrue(true);
		}
	}

	@Test
	public void testEliminar() throws DAOException {
        ProyectoDAO DAOeliminar = new XMLProyectoDAO();
		try {
			DAOeliminar.eliminar(999);
			assertTrue(true);
		} catch (DAOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
