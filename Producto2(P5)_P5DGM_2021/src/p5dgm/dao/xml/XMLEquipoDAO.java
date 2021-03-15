package p5dgm.dao.xml;

import java.util.List;

import p5dgm.dao.EquipoDAO;
import p5dgm.main.Equipo;
import java.beans.XMLEncoder;
import java.beans.XMLDecoder;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;
import java.util.Date;

public class XMLEquipoDAO implements EquipoDAO {

	@Override
	public void insertar(Equipo a) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduzca id: ");
		int id = Integer.parseInt(scan.nextLine());
		a.setId(id);
		System.out.println("Introduzca nombre y apellidos: ");
		String nombre = scan.nextLine();
		a.setNombre(nombre);
		System.out.println("Introduzca fecha de nacimiento(dd/MM/yyyy): ");
		String fecha = scan.nextLine();
		try {
			Date fechaNacimiento = new SimpleDateFormat("dd/MM/yyyy").parse(fecha);
			a.setFechaNacimiento(fechaNacimiento);
		} catch (ParseException e) {
			System.out.println("ParseException occured: formato de fecha incorrecto");
		}
		System.out.println("Introduzca direccion: ");
		String direccion = scan.nextLine();
		a.setDireccion(direccion);
		System.out.println("Introduzca telefono: ");
		String telefono = scan.nextLine();
		a.setTelefono(telefono);
		System.out.println("Introduzca delegacion: ");
		String delegacion = scan.nextLine();
		a.setDelegacion(delegacion);
		System.out.println("Introduzca id de proyecto: ");
		String proyecto = scan.nextLine();
		a.setDelegacion(proyecto);
		
		try {
			FileOutputStream fos = new FileOutputStream(new File("./equipo.xml"));
			XMLEncoder encoder = new XMLEncoder(fos);
			
			encoder.writeObject(a);
			encoder.close();
			fos.close();
			}
		catch(IOException ex) {
			ex.printStackTrace();
		}
		scan.close();
		System.out.println("MIEMBRO DE EQUIPO REGISTRADO CORRECTAMENTE.\n");
	}

	@Override
	public void modificar(Equipo a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Equipo a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Equipo> obtenerTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Equipo obtener(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
