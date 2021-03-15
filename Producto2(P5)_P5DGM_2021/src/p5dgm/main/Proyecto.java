package p5dgm.main;

import java.util.Date;
import java.util.List;

public class Proyecto {

	public int id;
	public String nombreProyecto;
	public String tipoProyecto;
	public String pais;
	public Date fechaInicio;
	public Date fechaFin;
	public float financiacionAportada;
	public List<Equipo> MiembrosEquipo;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombreProyecto() {
		return nombreProyecto;
	}
	public List<Equipo> getMiembrosEquipo() {
		return MiembrosEquipo;
	}
	public void setMiembrosEquipo(List<Equipo> miembrosEquipo) {
		MiembrosEquipo = miembrosEquipo;
	}
	public void setNombreProyecto(String nombreProyecto) {
		this.nombreProyecto = nombreProyecto;
	}
	public String getTipoProyecto() {
		return tipoProyecto;
	}
	public void setTipoProyecto(String tipoProyecto) {
		this.tipoProyecto = tipoProyecto;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	public float getFinanciacionAportada() {
		return financiacionAportada;
	}
	public void setFinanciacionAportada(float financiacionAportada) {
		this.financiacionAportada = financiacionAportada;
	}

	public Proyecto GuardarProyecto() {
		return this;
	}

	public Proyecto ObtenerProyecto() {
		return this;
	}
}
