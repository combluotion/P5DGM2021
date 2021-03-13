package p5dgm.main;


import java.util.Date;

public class Proyecto {

	public int idProyecto;
	public String nombreProyecto;
	public String tipoProyecto;
	public String pais;
	public Date fechaInicio;
	public Date fechaFin;
	public float financiacionAportada;
	
	
	public int getIdProyecto() {
		return idProyecto;
	}
	public void setIdProyecto(int idProyecto) {
		this.idProyecto = idProyecto;
	}
	public String getNombreProyecto() {
		return nombreProyecto;
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
