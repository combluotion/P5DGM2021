package p5dgm.dao.xml;


import java.util.List;
import p5dgm.dao.EquipoDAO;
import p5dgm.main.Equipo;
import p5dgm.main.ListaEquipo;
import p5dgm.main.Main;
import java.beans.XMLEncoder;
import java.beans.XMLDecoder;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class XMLEquipoDAO implements EquipoDAO {

	@Override
	public void insertar(ListaEquipo a) {
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
		System.out.println("MIEMBRO DE EQUIPO REGISTRADO CORRECTAMENTE.\n");	
	}

	@Override
	public void modificar(ListaEquipo a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(ListaEquipo a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ListaEquipo obtener(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
