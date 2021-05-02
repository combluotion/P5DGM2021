package p5dgm.main;

import java.util.List;

public class Socio {

	//Atributos
	
			public int idSocio;
			public String nombreSocio;
			public String direccion;
			public String telefono;
			public String delegacion;
			public String tipoCuota;
			public float ImporteCuota;
			
	//Metodo constructor
			
			public Socio (int idSocio, String nombreSocio, String direccion, String telefono, String delegacion,
				String tipoCuota, float ImporteCuota) {
				
				this.idSocio = idSocio;
				this.nombreSocio = nombreSocio;
				this.direccion = direccion;
				this.telefono = telefono;
				this.delegacion = delegacion;
				this.tipoCuota = tipoCuota;
				this.ImporteCuota = ImporteCuota;
		
			};
			public Socio (String nombreSocio, String direccion, String telefono, String delegacion,
					String tipoCuota, String ImporteCuota) {
					
					this.idSocio = 0;
					this.nombreSocio = nombreSocio;
					this.direccion = direccion;
					this.telefono = telefono;
					this.delegacion = delegacion;
					this.tipoCuota = tipoCuota;
					this.ImporteCuota = Float.parseFloat(ImporteCuota);
			
				};
			
			public Socio() {
				
			};
	//Metodos getters and setters
			

			public Socio(String nombre, String direccion2, String telefono2, String delegacion2, String tipoCuota2,
					float importeCuota2) {
				// TODO Auto-generated constructor stub
			}
			public int getIdSocio() {
				return idSocio;
			}

			public void setIdSocio(int idSocio) {
				this.idSocio = idSocio;
			}

			public String getNombreSocio() {
				return nombreSocio;
			}

			public void setNombreSocio(String nombreSocio) {
				this.nombreSocio = nombreSocio;
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

			public String getTipoCuota() {
				return tipoCuota;
			}

			public void setTipoCuota(String tipoCuota) {
				this.tipoCuota = tipoCuota;
			}

			public float getImporteCuota() {
				return ImporteCuota;
			}

			public void setImporteCuota(float importeCuota) {
				ImporteCuota = importeCuota;
			}
			
	}


