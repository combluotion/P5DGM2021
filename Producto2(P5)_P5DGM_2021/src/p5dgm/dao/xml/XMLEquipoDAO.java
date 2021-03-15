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

public class XMLEquipoDAO implements EquipoDAO {

	@Override
	public void insertar(Equipo a) {
		
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
