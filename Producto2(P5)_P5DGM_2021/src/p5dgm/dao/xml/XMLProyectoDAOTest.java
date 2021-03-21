/**
 * 
 */
package p5dgm.dao.xml;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import p5dgm.dao.ProyectoDAO;
import p5dgm.main.ListaProyecto;
import p5dgm.main.Proyecto;

/**
 * @author Diego Romero
 *
 */
public class XMLProyectoDAOTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws ParseException {
		//fail("Not yet implemented");
		
		ListaProyecto listaProyecto = new ListaProyecto();
		ProyectoDAO proyectoDAO = new XMLProyectoDAO();
		Proyecto proyecto = new Proyecto(1,"Proyecto1","Importante","Italia",new SimpleDateFormat("dd/MM/yyyy").parse("13/08/1995"),new SimpleDateFormat("dd/MM/yyyy").parse("13/08/1997")/*,financiacionAportadaFloat*/);
		
		
		listaProyecto.add(proyecto);
		proyectoDAO.insertar(listaProyecto);
		assertTrue(true);
	}

}
