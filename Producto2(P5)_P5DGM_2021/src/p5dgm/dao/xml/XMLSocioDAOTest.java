package p5dgm.dao.xml;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import p5dgm.dao.DAOException;
import p5dgm.dao.ProyectoDAO;
import p5dgm.dao.SocioDAO;
import p5dgm.main.Proyecto;
import p5dgm.main.Socio;




public class XMLSocioDAOTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testInsertar() throws ParseException, DAOException {
		Socio socio = new Socio(1,"RAmon Gracia Serra","Calle Mayor 50","658965478","Madrid","menual",150);
		SocioDAO socioDAO = new XMLSocioDAO();
		socioDAO.insertar(socio);
		assertTrue(true);
		
	}

	@Test
	public void testModificar() throws ParseException, DAOException {
		SocioDAO DAOmodificar = new XMLSocioDAO();
        Socio modificar  = new Socio(1,"RAmon Gracia Serra","Calle Mayor 50","658965478","Madrid","trimestral",550);
        DAOmodificar.modificar(modificar);
		assertTrue(true);
	}

}