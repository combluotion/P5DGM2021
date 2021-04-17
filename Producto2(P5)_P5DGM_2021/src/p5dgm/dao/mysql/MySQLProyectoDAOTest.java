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

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInsertar() throws DAOException, ParseException {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn;
			conn = DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/p5dgm2021?characterEncoding=latin1","root","root");	
			Proyecto proyecto = new Proyecto(1,"Proyecto1","Importante","Italia",new SimpleDateFormat("dd/MM/yyyy").parse("13/08/1995"),new SimpleDateFormat("dd/MM/yyyy").parse("13/08/1997")/*,financiacionAportadaFloat*/);
			ProyectoDAO proyectoDAO = new MySQLProyectoDAO(conn);
			proyectoDAO.insertar(proyecto);
			assertTrue(true);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}  
		


		
	}

	@Test
	public void testModificar() {
		fail("Not yet implemented");
	}

	@Test
	public void testEliminar() {
		fail("Not yet implemented");
	}

	@Test
	public void testObtener() {
		fail("Not yet implemented");
	}

}
