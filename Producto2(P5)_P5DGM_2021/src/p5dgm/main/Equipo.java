package p5dgm.main;

import java.util.Date;

public class Equipo {

	public int id;
	public String nombre;
	public Date fechaNacimiento;
	public String direccion;
	public String telefono;
	public String delegacion;
	
	
	/*public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}*/
	

	public Equipo (String nombre, Date fechaNacimiento, String direccion,
			String telefono, String delegacion) {
<<<<<<< HEAD
=======
		
>>>>>>> refs/remotes/origin/Mc_producto3
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.direccion = direccion;
		this.telefono = telefono;
		this.delegacion = delegacion;
	}
	
	public Equipo() {
		
	};

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDelegacion() {
		return delegacion;
	}
	public void setDelegacion(String delegacion) {
		this.delegacion = delegacion;
	}
	
	
}