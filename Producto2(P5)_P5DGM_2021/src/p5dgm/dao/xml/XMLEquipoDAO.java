package p5dgm.dao.xml;


import java.util.ArrayList;
import java.util.List;
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
	public void insertar(Equipo a) throws IOException {
		try {
			XMLDecoder decoder = new XMLDecoder(new FileInputStream("./equipo.xml"));
			List<Equipo> ListFromFile = (List<Equipo>) decoder.readObject();
			ListFromFile.add(a);
			decoder.close();
			XMLEncoder encoder = new XMLEncoder(new FileOutputStream("./equipo.xml"));
			encoder.writeObject(ListFromFile);
			encoder.close();
			}
		catch(IOException ex) {
			try {
				XMLEncoder encoder = new XMLEncoder(new FileOutputStream(new File("./equipo.xml")));
				List<Equipo> listForFile = new ArrayList<>();
				listForFile.add(a);
				encoder.writeObject(listForFile);
				encoder.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("MIEMBRO DE EQUIPO REGISTRADO CORRECTAMENTE.\n");	
	}

	
	@Override
	public void modificar(Equipo a) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Equipo a) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Equipo obtener(int id) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	
}
