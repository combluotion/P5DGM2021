package p5dgm.dao.xml;


import java.util.List;
import p5dgm.dao.ProyectoDAO;
import p5dgm.main.Proyecto;
import p5dgm.main.ListaProyecto;
import p5dgm.main.Main;
import java.beans.XMLEncoder;
import java.beans.XMLDecoder;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class XMLProyectoDAO implements ProyectoDAO {

	@Override
	public void insertar(ListaProyecto a) {
		try {
			FileOutputStream fos = new FileOutputStream(new File("./proyecto.xml"));
			XMLEncoder encoder = new XMLEncoder(fos);
			encoder.writeObject(a);
			encoder.close();
			fos.close();
			}
		catch(IOException ex) {
			ex.printStackTrace();
		}
		System.out.println("PROYECTO REGISTRADO CORRECTAMENTE.\n");	
	}

	@Override
	public void modificar(ListaProyecto a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ListaProyecto obtener(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
