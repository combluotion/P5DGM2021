package p5dgm.dao.xml;

import static org.junit.Assert.*;

import java.io.IOException;
import p5dgm.dao.DAOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import p5dgm.dao.DAOException;
import p5dgm.dao.EquipoDAO;
import p5dgm.main.Equipo;


public class XMLEquipoDAOTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

		equipoDAO.insertar(equipo);
		assertTrue(true);
		
	}

	@Test
	public void testModificar() throws ParseException, DAOException {
<<<<<<< HEAD
		Equipo equipo = new Equipo("Proyecto1",new SimpleDateFormat("dd/MM/yyyy").parse("13/08/1995"),"Importante","Italia","Ripollet");
=======
		Equipo equipo = new Equipo(1,"Proyecto1",new SimpleDateFormat("dd/MM/yyyy").parse("13/08/1995"),"Importante","Italia","Ripollet");
>>>>>>> refs/remotes/origin/Mc_producto3
		EquipoDAO equipoDAO = new XMLEquipoDAO();
<<<<<<< HEAD
        equipoDAO.modificar(equipo);
		assertTrue(true);
=======
     	equipoDAO.modificar(equipo);
		assertTrue(true);
		
>>>>>>> refs/remotes/origin/Mc_producto3
	}

	@Test
	public void testObtener() throws IOException, DAOException {
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
	public void testEliminar() throws DAOException {
        EquipoDAO DAOeliminar = new XMLEquipoDAO();
		DAOeliminar.eliminar(1);
		assertTrue(true);
<<<<<<< HEAD
=======
		
>>>>>>> refs/remotes/origin/Mc_producto3
	}

}