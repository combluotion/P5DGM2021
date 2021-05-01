package p5dgm.dao.xml;

import java.util.ArrayList;
import java.util.List;
import p5dgm.dao.SocioDAO;
import p5dgm.main.Socio;
import java.beans.XMLEncoder;
import java.beans.XMLDecoder;
import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class XMLSocioDAO implements SocioDAO {

	@SuppressWarnings("unchecked")
	@Override
	public void insertar(Socio a) {
		try {
			//Abre XML, lo lee y lo guarda en lista, escribe el nuevo objeto y cierra el archivo
			XMLDecoder decoder = new XMLDecoder(new FileInputStream("./socio.xml"));
			List<Socio> ListFromFile = (List<Socio>) decoder.readObject();
			int mockId = a.getIdSocio();
			boolean flag = false;
			for (Socio model : ListFromFile) {
				if (mockId == model.getIdSocio()) {
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
				XMLEncoder encoder = new XMLEncoder(new FileOutputStream("./socio.xml"));
				encoder.writeObject(ListFromFile);
				encoder.close();
				System.out.println("SOCIO REGISTRADO CORRECTAMENTE.\n");
				}
			}
		catch(IOException ex) {
			try {
				//Si no existe fichero XML lo crea y escribe el primer objeto en la lista y lo guarda
				XMLEncoder encoder = new XMLEncoder(new FileOutputStream(new File("./socio.xml")));
				List<Socio> listForFile = new ArrayList<>();
				listForFile.add(a);
				encoder.writeObject(listForFile);
				encoder.close();
				System.out.println("SOCIO REGISTRADO CORRECTAMENTE.\n");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	}

	
	@Override
	public void modificar(Socio a) {
		try {
			//Abre XML, lo lee y elimina el objeto seleccionado y lo reemplaza por el nuevo objeto
			XMLDecoder decoder = new XMLDecoder(new FileInputStream("./socio.xml"));
			@SuppressWarnings("unchecked")
			List<Socio> ListFromFile = (List<Socio>) decoder.readObject();
			int mockId = a.getIdSocio();
			int counter = 0;
			boolean flag = false;
			for (Socio model : ListFromFile) {
				if (mockId == model.getIdSocio()) {
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
				XMLEncoder encoder = new XMLEncoder(new FileOutputStream("./socio.xml"));
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
		System.out.println("SOCIO REGISTRADO CORRECTAMENTE.\n");	
	}
		
	

	public void eliminar(int id) {
		try {
			//Abre XML, lo lee y elimina el objeto seleccionado y lo reemplaza por el nuevo objeto
			XMLDecoder decoder = new XMLDecoder(new FileInputStream("./socio.xml"));
			@SuppressWarnings("unchecked")
			List<Socio> ListFromFile = (List<Socio>) decoder.readObject();
			int counter = 0;
			boolean flag = false;
			for (Socio model : ListFromFile) {
				if (id == model.getIdSocio()) {
					ListFromFile.remove(counter);
					XMLEncoder encoder = new XMLEncoder(new FileOutputStream("./socio.xml"));
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
		System.out.println("SOCIO REGISTRADO CORRECTAMENTE.\n");	
	}
		
	public Socio obtener(int id) {
		Socio consulta = null;
		try {
			//Abre XML, lo lee y devuelve el objeto seleccionado
			XMLDecoder decoder = new XMLDecoder(new FileInputStream("./socio.xml"));
			@SuppressWarnings("unchecked")
			List<Socio> ListFromFile = (List<Socio>) decoder.readObject();
			boolean flag = false;
			for (Socio model : ListFromFile) {
				if (id == model.getIdSocio()) {
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
	
}