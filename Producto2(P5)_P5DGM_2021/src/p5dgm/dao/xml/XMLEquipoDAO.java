package p5dgm.dao.xml;


import java.util.ArrayList;
import java.util.List;

import p5dgm.dao.DAOException;
import p5dgm.dao.EquipoDAO;
import p5dgm.main.Equipo;
import java.beans.XMLEncoder;
import java.beans.XMLDecoder;
import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class XMLEquipoDAO implements EquipoDAO {

	@SuppressWarnings("unchecked")
	@Override
	public void insertar(Equipo a) throws DAOException {
		try {
			//Abre XML, lo lee y lo guarda en lista, escribe el nuevo objeto y cierra el archivo
			XMLDecoder decoder = new XMLDecoder(new FileInputStream("./equipo.xml"));
			List<Equipo> ListFromFile = (List<Equipo>) decoder.readObject();
			int mockId = a.getId();
			boolean flag = false;
			for (Equipo model : ListFromFile) {
				if (mockId == model.getId()) {
					flag = true;
					break;
					}
				}
			if (flag == true) {
				System.out.print("El id introducido ya existe.");
				}
			else {
				ListFromFile.add(a);
				decoder.close();
				XMLEncoder encoder = new XMLEncoder(new FileOutputStream("./equipo.xml"));
				encoder.writeObject(ListFromFile);
				encoder.close();
				System.out.println("MIEMBRO DE EQUIPO REGISTRADO CORRECTAMENTE.\n");
				}
			}
		catch(IOException ex) {
			try {
				//Si no existe fichero XML lo crea y escribe el primer objeto en la lista y lo guarda
				XMLEncoder encoder = new XMLEncoder(new FileOutputStream(new File("./equipo.xml")));
				List<Equipo> listForFile = new ArrayList<>();
				listForFile.add(a);
				encoder.writeObject(listForFile);
				encoder.close();
				System.out.println("MIEMBRO DE EQUIPO REGISTRADO CORRECTAMENTE.\n");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	}

	
	@Override
	public void modificar(Equipo a) throws DAOException {
		try {
			//Abre XML, lo lee y elimina el objeto seleccionado y lo reemplaza por el nuevo objeto
			XMLDecoder decoder = new XMLDecoder(new FileInputStream("./equipo.xml"));
			@SuppressWarnings("unchecked")
			List<Equipo> ListFromFile = (List<Equipo>) decoder.readObject();
			int mockId = a.getId();
			int counter = 0;
			boolean flag = false;
			for (Equipo model : ListFromFile) {
				if (mockId == model.getId()) {
					ListFromFile.remove(counter);
					flag = true;
					break;
					}
				else {
					counter++;
					}
				}
			if (flag == true) {
				ListFromFile.add(a);
				decoder.close();
				XMLEncoder encoder = new XMLEncoder(new FileOutputStream("./equipo.xml"));
				encoder.writeObject(ListFromFile);
				encoder.close();
				}
			else {
				System.out.print("No existe el id seleccionado.\n");
				}
			}
		catch(IOException ex) {
			//Si no existe fichero XML lo crea y escribe el primer objeto en la lista y lo guarda
			System.out.print("No hay registros todavía");
		}
		System.out.println("MIEMBRO DE EQUIPO REGISTRADO CORRECTAMENTE.\n");	
	}
		
	

	public void eliminar(int id) throws DAOException {
		try {
			//Abre XML, lo lee y elimina el objeto seleccionado y lo reemplaza por el nuevo objeto
			XMLDecoder decoder = new XMLDecoder(new FileInputStream("./equipo.xml"));
			@SuppressWarnings("unchecked")
			List<Equipo> ListFromFile = (List<Equipo>) decoder.readObject();
			int counter = 0;
			boolean flag = false;
			for (Equipo model : ListFromFile) {
				if (id == model.getId()) {
					ListFromFile.remove(counter);
					XMLEncoder encoder = new XMLEncoder(new FileOutputStream("./equipo.xml"));
					encoder.writeObject(ListFromFile);
					encoder.close();
					flag = true;
					break;
					}
				else {
					counter++;
					}
				}
			if (flag == false) {
				System.out.print("No existe el id seleccionado.");
				}	
			}
		catch(IOException ex) {
			//Si no existe fichero XML lo crea y escribe el primer objeto en la lista y lo guarda
			System.out.print("No hay registros todavía");
		}
		System.out.println("MIEMBRO DE EQUIPO REGISTRADO CORRECTAMENTE.\n");	
	}
		
	public Equipo obtener(int id) {
		Equipo consulta = null;
		try {
			//Abre XML, lo lee y devuelve el objeto seleccionado
			XMLDecoder decoder = new XMLDecoder(new FileInputStream("./equipo.xml"));
			@SuppressWarnings("unchecked")
			List<Equipo> ListFromFile = (List<Equipo>) decoder.readObject();
			boolean flag = false;
			for (Equipo model : ListFromFile) {
				if (id == model.getId()) {
					consulta = model;
					flag = true;
					break;
					}
				}
			if (flag == false) {
				System.out.print("No existe el id seleccionado.\n");
				return null;
				}	
			}
		catch(IOException ex) {
			//Si no existe fichero XML lo crea y escribe el primer objeto en la lista y lo guarda
			System.out.print("No hay registros todavía");
			return null;
		}
		return consulta;
	}


	@Override
	public List<Equipo> obtenerTodos() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
