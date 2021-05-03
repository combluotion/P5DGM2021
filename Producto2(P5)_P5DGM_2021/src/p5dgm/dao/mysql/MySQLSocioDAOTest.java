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
import p5dgm.dao.SocioDAO;
import p5dgm.main.Socio;

public class MySQLSocioDAOTest {

	@Test
	public void testInsertar() throws DAOException, ParseException {
			MySQLDaoManager man = new MySQLDaoManager("localhost","root","root","p5dgm2021");
			Socio socio = new Socio("Pedro Martinez Soto","C/ La Union num 35","951365897","Madrid","Mensual","150.50");
			man.getSocioDAO().insertar(socio);
			assertTrue(true);
	}

	@Test
	public void testModificar() throws ParseException, DAOException {
			MySQLDaoManager man = new MySQLDaoManager("localhost","root","root","p5dgm2021");	
			Socio socio = new Socio("Pedro Martinez Soto","C/ La Union num 35","951365897","Madrid","Mensual","150.50");
			man.getSocioDAO().insertar(socio);
			socio.setNombreSocio("SocioModified");
			man.getSocioDAO().modificar(socio);
			assertTrue(true);
	}

	@Test
	public void testEliminar() throws DAOException, ParseException {
			MySQLDaoManager man = new MySQLDaoManager("localhost","root","root","p5dgm2021");
			Socio socio = new Socio("SocioAEliminar","C/ La Union num 35","951365897","Madrid","Mensual","150.50");
			man.getSocioDAO().insertar(socio);
			man.getSocioDAO().eliminar(socio.getIdSocio());
			assertTrue(true);
	}

	//@Test
	//public void testObtener() throws ParseException, DAOException {
		//	MySQLDaoManager man = new MySQLDaoManager("localhost","root","root","p5dgm2021");
			//Socio socio = new Socio("SocioAObtener","C/ La Union num 35","951365897","Madrid","Mensual","150.50");			
			//man.getSocioDAO().insertar(socio);
			//int IdAComprobar = socio.getIdSocio();
			//socio = null;
			//socio = man.getSocioDAO().obtener(IdSocioAComprobar);
			//assertTrue(socio != null && socio.getIdSocio() == IdSocioAComprobar );
	}
	



