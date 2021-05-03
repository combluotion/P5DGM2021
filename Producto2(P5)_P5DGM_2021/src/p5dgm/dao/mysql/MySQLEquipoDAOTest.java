package p5dgm.dao.mysql;

import static org.junit.Assert.*;


import java.text.ParseException;
import java.text.SimpleDateFormat;


import org.junit.Test;

import p5dgm.dao.DAOException;

import p5dgm.main.Equipo;

public class MySQLEquipoDAOTest {

	@Test
	public void testInsertar() throws DAOException, ParseException {
			MySQLDaoManager man = new MySQLDaoManager();
			Equipo equipo = new Equipo("Gerard Marquez",new SimpleDateFormat("dd/MM/yyyy").parse("16/01/1996"),"Calle Mayor", "605354835", "Barcelona");
			man.getEquipoDAO().insertar(equipo);
			assertTrue(true);
	}

	@Test
	public void testModificar() throws ParseException, DAOException {
			MySQLDaoManager man = new MySQLDaoManager();	
			Equipo equipo = new Equipo("Paco Jimenez",new SimpleDateFormat("dd/MM/yyyy").parse("19/01/1986"),"Calle Menor", "68625465", "Girona");
			man.getEquipoDAO().insertar(equipo);
			equipo.setNombre("Equipo1Modified");
			man.getEquipoDAO().modificar(equipo);
			assertTrue(true);
	}

	@Test
	public void testEliminar() throws DAOException, ParseException {
			MySQLDaoManager man = new MySQLDaoManager();
			Equipo equipo = new Equipo("Gerard Marquez",new SimpleDateFormat("dd/MM/yyyy").parse("16/01/1996"),"Calle Mayor", "605354835", "Barcelona");
			man.getEquipoDAO().insertar(equipo);
			man.getEquipoDAO().eliminar(equipo.getId());
			assertTrue(true);
	}

	@Test
	public void testObtener() throws ParseException, DAOException {
			MySQLDaoManager man = new MySQLDaoManager();
			Equipo equipo = new Equipo("Paco Jimenez",new SimpleDateFormat("dd/MM/yyyy").parse("19/01/1986"),"Calle Menor", "68625465", "Girona");			
			man.getEquipoDAO().insertar(equipo);
			int IdAComprobar = equipo.getId();
			equipo = null;
			equipo = man.getEquipoDAO().obtener(IdAComprobar);
			assertTrue(equipo != null && equipo.getId() == IdAComprobar );
	
	}

}