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
import p5dgm.main.Equipo;


public class XMLEquipoDAOTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInsertar() throws ParseException {
		Equipo equipo = new Equipo(1,"Proyecto1",new SimpleDateFormat("dd/MM/yyyy").parse("13/08/1995"),"Importante","Italia","Ripollet");
		EquipoDAO equipoDAO = new XMLEquipoDAO();
		try {
			equipoDAO.insertar(equipo);
			assertTrue(true);
		} catch (IOException e) {
			e.printStackTrace();			
			fail(e.getMessage());
		}
		
	}

	@Test
	public void testModificar() throws ParseException {
		Equipo equipo = new Equipo(1,"Proyecto1",new SimpleDateFormat("dd/MM/yyyy").parse("13/08/1995"),"Importante","Italia","Ripollet");
		EquipoDAO equipoDAO = new XMLEquipoDAO();
        try {
			equipoDAO.modificar(equipo);
			assertTrue(true);
		} catch (IOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	public void testObtener() throws IOException {
		EquipoDAO equipoDAO = new XMLEquipoDAO();	
		Equipo obtener = equipoDAO.obtener(1);
		if (obtener == null) {
			fail("Not found");
		}
		else {
			assertTrue(true);
		}
	}

	@Test
	public void testEliminar() {
        EquipoDAO DAOeliminar = new XMLEquipoDAO();
		try {
			DAOeliminar.eliminar(1);
			assertTrue(true);
		} catch (IOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
