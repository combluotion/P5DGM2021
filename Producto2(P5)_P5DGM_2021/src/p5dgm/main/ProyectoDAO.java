package p5dgm.main;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;


public final class ProyectoDAO {

	public List<Proyecto> proyectos;
	
	public ProyectoDAO() {
		this.proyectos = new ArrayList();
	}
	
	public List<Proyecto> obtenerProyectos() {
		return new ArrayList();
	}
	public ProyectoDAO GuardarProyectos() throws FileNotFoundException, JAXBException  {
     
	            if(this.proyectos != null){
	            FileOutputStream file = new FileOutputStream("proyectos.xml", false);
	            JAXBContext jaxbContext = JAXBContext.newInstance(ProyectoDAO.class);
	            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
	            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	            jaxbMarshaller.marshal(this, file); 
	        }
	        
	        System.out.println("Entidades guardadas.");

	        return this;
	        
	           
	}

}
