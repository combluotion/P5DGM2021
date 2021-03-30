package p5dgm.dao.xml;

import static org.junit.Assert.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
	public void testInsertar() throws ParseException {
		Proyecto proyecto = new Proyecto(1,"Proyecto1","Importante","Italia",new SimpleDateFormat("dd/MM/yyyy").parse("13/08/1995"),new SimpleDateFormat("dd/MM/yyyy").parse("13/08/1997")/*,financiacionAportadaFloat*/);
		ProyectoDAO proyectoDAO = new XMLProyectoDAO();
		try {
			proyectoDAO.insertar(proyecto);
			assertTrue(true);
		} catch (IOException e) {
			e.printStackTrace();			
			fail(e.getMessage());
		}
		
	}

	@Test
	public void testModificar() throws ParseException {
		ProyectoDAO DAOmodificar = new XMLProyectoDAO();
        Proyecto modificar  = new Proyecto(1,"Proyecto1Modified","Importante","Italia",new SimpleDateFormat("dd/MM/yyyy").parse("13/08/1995"),new SimpleDateFormat("dd/MM/yyyy").parse("13/08/1997")/*,financiacionAportadaFloat*/);
        try {
			DAOmodificar.modificar(modificar);
			assertTrue(true);
		} catch (IOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	public void testObtener() throws IOException {
        ProyectoDAO daoObtenerProyecto = new XMLProyectoDAO();	
		Proyecto obtener = daoObtenerProyecto.obtener(1);
		if (obtener == null) {
			fail("Not found");
		}
		else {
			assertTrue(true);
		}
	}

	@Test
	public void testEliminar() {
        ProyectoDAO DAOeliminar = new XMLProyectoDAO();
		try {
			DAOeliminar.eliminar(1);
			assertTrue(true);
		} catch (IOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
