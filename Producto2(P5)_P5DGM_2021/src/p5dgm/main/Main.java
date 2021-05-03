package p5dgm.main;

import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import p5dgm.dao.DAOException;
import p5dgm.dao.EquipoDAO;
import p5dgm.dao.ProyectoDAO;
import p5dgm.dao.SocioDAO;
import p5dgm.dao.mysql.MySQLDaoManager;
import p5dgm.dao.xml.XMLEquipoDAO;
import p5dgm.dao.xml.XMLProyectoDAO;
import p5dgm.dao.xml.XMLSocioDAO;

public class Main {

	public static void main(String[] args) throws DAOException {
		System.out.println("Buenos dias P5DGM2021\n");
		MySQLDaoManager man = new MySQLDaoManager();
		Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion1, opcion2; //Guardaremos la opcion del usuario
 
        while (!salir) {
 
            System.out.println("1. Registrar nuevo miembro del equipo.");
            System.out.println("2. Modificar miembro del equipo");
            System.out.println("3. Obtener miembro equipo");
            System.out.println("4. Eliminar miembro equipo");
            System.out.println("5. Registrar nuevo proyecto.");
            System.out.println("6. Modificar proyecto");
            System.out.println("7. Obtener proyecto");
            System.out.println("8. Eliminar proyecto");
            System.out.println("9. Registrar nuevo socio.");
            System.out.println("10. Modificar socio");
            System.out.println("11. Obtener socio");
            System.out.println("12. Eliminar socio");
            System.out.println("13. Salir");
 			
            try {
 
                System.out.println("Escribe una de las opciones");
                opcion1 = sn.nextInt();
 
                switch (opcion1) {
                    case 1:
                        System.out.println("1.SQL\n2.XML");
                        opcion2 = sn.nextInt();
                        if(opcion2 == 1) {
                        	Equipo nuevo = nuevoEquipo();
                            man.getEquipoDAO().insertar(nuevo);
                            break;
                        }
                        if(opcion2 == 2 ) {
                        	EquipoDAO DAOnuevo = new XMLEquipoDAO();
                            Equipo nuevo = nuevoEquipo();
                            DAOnuevo.insertar(nuevo);
                            break;
                        }
                        break;
                       
                    case 2:
                        System.out.println("Has seleccionado la opcion 2");
                        System.out.println("1.SQL\n2.XML");
                        opcion2 = sn.nextInt();
                        if(opcion2 == 1) {
                        	Equipo modificar = modificarEquipo();
                            man.getEquipoDAO().modificar(modificar);
                            break; 
                        }
                        if(opcion2 == 2 ) {
                        	 EquipoDAO DAOmodificar = new XMLEquipoDAO();
                             Equipo modificar  = modificarEquipo();
                             DAOmodificar.modificar(modificar);
                             break;
                        }
                        break;
                       
                    case 3:
                    	System.out.println("Has seleccionado la opcion 3\n");
                    	System.out.println("1.SQL\n2.XML");
                    	opcion2 = sn.nextInt();
                        if(opcion2 == 1) {
                        	Scanner scanObtenerEquiposql = new Scanner(System.in);
                            System.out.println("Introduzca el id a obtener: ");
                            int idEquipoObtenersql = Integer.parseInt(scanObtenerEquiposql.nextLine());
                            Equipo obtenersql = man.getEquipoDAO().obtener(idEquipoObtenersql);
                            if (obtenersql == null) {
                    			break;
                    		}
                    		else {
                    			System.out.println("\nId: " + obtenersql.getId() + "\nNombre: " + obtenersql.getNombre() + "\nFecha de nacimiento: " + obtenersql.getFechaNacimiento());
                        		System.out.println("Telefono: " + obtenersql.getTelefono() + "\nDireccion: " + obtenersql.getDireccion() + "\nDelegación: " + obtenersql.getDelegacion() +"\n");
                                break;
                    		}	 
                        }
                        if(opcion2 == 2 ) {
                        	EquipoDAO daoObtenerEquipo = new XMLEquipoDAO();
                            Scanner scanObtenerEquipo = new Scanner(System.in);
                            System.out.println("Introduzca el id a obtener: ");
                    		int idEquipoObtener = Integer.parseInt(scanObtenerEquipo.nextLine());	
                    		Equipo obtener = daoObtenerEquipo.obtener(idEquipoObtener);
                    		if (obtener == null) {
                    			break;
                    		}
                    		else {
                    			System.out.println("\nId: " + obtener.getId() + "\nNombre: " + obtener.getNombre() + "\nFecha de nacimiento: " + obtener.getFechaNacimiento());
                        		System.out.println("Telefono: " + obtener.getTelefono() + "\nDireccion: " + obtener.getDireccion() + "\nDelegación: " + obtener.getDelegacion() +"\n");
                                break;
                    		}
                        }
                        break;
                        
                            
                    case 4:
                    	System.out.println("Has seleccionado la opcion 4");
                    	System.out.println("1.SQL\n2.XML");
                    	opcion2 = sn.nextInt();
                        if(opcion2 == 1) {
                        	Scanner scanEliminarEquipo = new Scanner(System.in);
                    		System.out.println("Introduzca el id a eliminar: ");
                    		int idEquipoEliminar = Integer.parseInt(scanEliminarEquipo.nextLine());
                            man.getEquipoDAO().eliminar(idEquipoEliminar);
                            break;
                        }
                        if(opcion2 == 2 ) {
                            EquipoDAO DAOeliminar = new XMLEquipoDAO();
                            Scanner scanEliminarEquipo = new Scanner(System.in);
                    		System.out.println("Introduzca el id a eliminar: ");
                    		int idEquipoEliminar = Integer.parseInt(scanEliminarEquipo.nextLine());	
                    		DAOeliminar.eliminar(idEquipoEliminar);
                            break;
                        }
                        
                    /*	
                    case 5:
                    	System.out.println("Has seleccionado la opcion 5\n");
                        ProyectoDAO DAOnuevoP = new XMLProyectoDAO();
                        Proyecto nuevoP = NuevoProyecto();
                        DAOnuevoP.insertar(nuevoP);
                        break;
                    case 6:
                    	System.out.println("Has seleccionado la opcion 6\n");
                    	ProyectoDAO DAOmodificarP = new XMLProyectoDAO();
                        Proyecto modificarP  = ModificarProyecto();
                        DAOmodificarP.modificar(modificarP);
                        break;
                    case 7:
                    	System.out.println("Has seleccionado la opcion 7\n");
                    	ProyectoDAO daoObtenerProyecto = new XMLProyectoDAO();
                        Scanner scanObtenerProyecto = new Scanner(System.in);
                        System.out.println("Introduzca el id a obtener: ");
                		int idProyectoObtener = Integer.parseInt(scanObtenerProyecto.nextLine());	
                		Proyecto obtenerProyecto = daoObtenerProyecto.obtener(idProyectoObtener);
                		if (obtenerProyecto == null) {
                			break;
                		}
                		else {
                			System.out.println("\nId: " + obtenerProyecto.getId() + "\nNombre: " + obtenerProyecto.getNombreProyecto() + "\nTipo Proyecto: " + obtenerProyecto.getTipoProyecto());
                    		System.out.println("\nPais: " + obtenerProyecto.getPais() + "\nFecha Inicio: " + obtenerProyecto.getFechaInicio() + "\nFecha Fin: " + obtenerProyecto.getFechaFin() +"\n");
                            break;
                		}
                    case 8:
                    	System.out.println("Has seleccionado la opcion 8");
                    	ProyectoDAO DAOeliminarP = new XMLProyectoDAO();
                        Scanner scanEliminarProyecto = new Scanner(System.in);
                		System.out.println("Introduzca el id a eliminar: ");
                		int idProyectoEliminar = Integer.parseInt(scanEliminarProyecto.nextLine());	
                		DAOeliminarP.eliminar(idProyectoEliminar);
                        break;
                    */
                    case 9:
                        System.out.println("Has seleccionado la opcion 9");
                        System.out.println("1.SQL\n2.XML");
                        opcion2 = sn.nextInt();
                        if(opcion2 == 1) {
                        	Socio nuevo = nuevoSocio();
                            man.getSocioDAO().insertar(nuevo);
                            break;
                        }
                        if(opcion2 == 2 ) {
                        SocioDAO DAOnuevoS = new XMLSocioDAO();
                        Socio nuevoS = nuevoSocio();
                        DAOnuevoS.insertar(nuevoS);
                        break;
                        }
                       break;
                       
                    case 10:
                        System.out.println("Has seleccionado la opcion 10");
                        System.out.println("1.SQL\n2.XML");
                        opcion2 = sn.nextInt();
                        if(opcion2 == 1) {
                        	Socio modificar = modificarSocio();
                            man.getSocioDAO().modificar(modificar);
                            break; 
                        }
                        if(opcion2 == 2 ) {
                        SocioDAO DAOmodificarS = new XMLSocioDAO();
                        Socio modificarS  = modificarSocio();
                        DAOmodificarS.modificar(modificarS);
                        break;
                        }
                        break;
                        
                    case 11:
                    	System.out.println("Has seleccionado la opcion 11");
                    	System.out.println("1.SQL\n2.XML");
                    	opcion2 = sn.nextInt();
                        if(opcion2 == 1) {
                        	Scanner scanObtenerSociosql = new Scanner(System.in);
                            System.out.println("Introduzca el id a obtener: ");
                            int idSocioObtenersql = Integer.parseInt(scanObtenerSociosql.nextLine());
                            Socio obtenersql = man.getSocioDAO().obtener(idSocioObtenersql);
                            if (obtenersql == null) {
                    			break;
                    		}
                    		else {
                    			System.out.println("\nId: " + obtenersql.getIdSocio() + "\nNombre: " + obtenersql.getNombreSocio());
                        		System.out.println("\nDireccion: " + obtenersql.getDireccion()+"Telefono: " + obtenersql.getTelefono() + "\nDelegación: " + obtenersql.getDelegacion());
                        		System.out.println("\nTipoCuota: " + obtenersql.getTipoCuota()+"ImporteCuota: " + obtenersql.getImporteCuota() + "\n");
                                break;
                    		}	 
                        }
                        if(opcion2 == 2 ) {
                        SocioDAO daoObtenerSocio = new XMLSocioDAO();
                        Scanner scanObtenerSocio = new Scanner(System.in);
                        System.out.println("Introduzca el id a obtener: ");
                		int idSocioObtener = Integer.parseInt(scanObtenerSocio.nextLine());	
                		Socio obtenerS = daoObtenerSocio.obtener(idSocioObtener);
                		if (obtenerS == null) {
                			break;
                		}
                		else {
                			System.out.println("\nIdSocio: " + obtenerS.getIdSocio() + "\nNombre: " + obtenerS.getNombreSocio() + "\n"
                					+ "Direccion: " + obtenerS.getDireccion());
                    		System.out.println("Telefono: " + obtenerS.getTelefono() + "\nTipo de Cuota: " + obtenerS.getTipoCuota() + "\nImporte de la cuota: " + obtenerS.getImporteCuota() +"\n");
                            break;
                		}
                	}
                    break;
                    
                    case 12:
                    	System.out.println("Has seleccionado la opcion 12");
                    	System.out.println("1.SQL\n2.XML");
                    	opcion2 = sn.nextInt();
                        if(opcion2 == 1) {
                        	Scanner scanEliminarSocio = new Scanner(System.in);
                    		System.out.println("Introduzca el id a eliminar: ");
                    		int idSocioEliminar = Integer.parseInt(scanEliminarSocio.nextLine());
                            man.getSocioDAO().eliminar(idSocioEliminar);
                            break;
                        }
                        if(opcion2 == 2 ) {
                        SocioDAO DAOeliminarS = new XMLSocioDAO();
                        Scanner scanEliminarSocio = new Scanner(System.in);
                		System.out.println("Introduzca el id a eliminar: ");
                		int idSocioEliminar = Integer.parseInt(scanEliminarSocio.nextLine());	
                		DAOeliminarS.eliminar(idSocioEliminar);
                        break;
                        }
                    case 13:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo numeros entre 1 y 12");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un nï¿½mero");
                sn.next();
            } catch (DAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
	}
	
	//FUNCIONES EQUIPO
	public static Equipo nuevoEquipo() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduzca nombre y apellidos: ");
		String nombre = scan.nextLine();
		System.out.println("Introduzca fecha de nacimiento(dd/MM/yyyy): ");
		String fecha = scan.nextLine();
		Date fechaNacimiento = null;
		try {
			fechaNacimiento = new SimpleDateFormat("dd/MM/yyyy").parse(fecha);
		} 
		catch (ParseException e) {
			System.out.println("ParseException occured: formato de fecha incorrecto");
		}
		System.out.println("Introduzca direccion: ");
		String direccion = scan.nextLine();
		System.out.println("Introduzca telefono: ");
		String telefono = scan.nextLine();
		System.out.println("Introduzca delegacion: ");
		String delegacion = scan.nextLine();
		/*System.out.println("Introduzca id de proyecto: ");
		String proyecto = scan.nextLine();*/
		Equipo equipo = new Equipo(nombre, fechaNacimiento, direccion, telefono, delegacion);
		return equipo;
	}
	
	
	public static Equipo modificarEquipo() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduzca nuevos nombre y apellidos: ");
		String nombre = scan.nextLine();
		System.out.println("Introduzca nueva fecha de nacimiento(dd/MM/yyyy): ");
		String fecha = scan.nextLine();
		Date fechaNacimiento = null;
		try {
			fechaNacimiento = new SimpleDateFormat("dd/MM/yyyy").parse(fecha);
		} 
		catch (ParseException e) {
			System.out.println("ParseException occured: formato de fecha incorrecto");
		}
		System.out.println("Introduzca nueva direccion: ");
		String direccion = scan.nextLine();
		System.out.println("Introduzca nuevo telefono: ");
		String telefono = scan.nextLine();
		System.out.println("Introduzca nueva delegacion: ");
		String delegacion = scan.nextLine();
		Equipo equipo = new Equipo(nombre, fechaNacimiento, direccion, telefono, delegacion);
		return equipo;
	}
	

	
	//FUNCIONES PROYECTO
	public static Proyecto NuevoProyecto() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduzca id: ");
		int id = Integer.parseInt(scan.nextLine());
		System.out.println("Introduzca nombre del proyecto: ");
		String nombre = scan.nextLine();
		System.out.println("Introduzca tipo del proyecto: ");
		String tipo = scan.nextLine();
		System.out.println("Introduzca Pais: ");
		String pais = scan.nextLine();
		System.out.println("Introduzca fecha de inicio (dd/MM/yyyy): ");
		String fechaInicio = scan.nextLine();
		System.out.println("Introduzca fecha de fin (dd/MM/yyyy): ");
		String fechaFin = scan.nextLine();
		Date fechaInicioDate = null;
		Date fechaFinDate = null;
		try {
			fechaInicioDate = new SimpleDateFormat("dd/MM/yyyy").parse(fechaInicio);
			fechaFinDate = new SimpleDateFormat("dd/MM/yyyy").parse(fechaFin);
		} 
		catch (ParseException e) {
			System.out.println("ParseException occured: formato de fecha incorrecto");
		}
		System.out.println("Introduzca financiacion aportada: ");
		String financiacionAportada = scan.nextLine();
		float financiacionAportadaFloat = 0;
		try {
			financiacionAportadaFloat = Float.parseFloat(financiacionAportada);
		}
		catch(NumberFormatException e)
		{
			System.out.println("NumberFormatException occured: " + e.getMessage());
		}		
		Proyecto proyecto = new Proyecto(nombre,tipo,pais,fechaInicioDate,fechaFinDate/*,financiacionAportadaFloat*/);
		proyecto.setId(id);
		//listaProyecto.add(proyecto);
		return proyecto;
	}
	public static Proyecto ModificarProyecto() 
	{
		//Introducir ID a modificar e introducir nuevos valores.
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduzca el id a modificar: ");
		int id = Integer.parseInt(scan.nextLine());
		System.out.println("Introduzca nombre del proyecto: ");
		String nombre = scan.nextLine();
		System.out.println("Introduzca tipo del proyecto: ");
		String tipo = scan.nextLine();
		System.out.println("Introduzca Pais: ");
		String pais = scan.nextLine();
		System.out.println("Introduzca fecha de inicio (dd/MM/yyyy): ");
		String fechaInicio = scan.nextLine();
		System.out.println("Introduzca fecha de fin (dd/MM/yyyy): ");
		String fechaFin = scan.nextLine();
		Date fechaInicioDate = null;
		Date fechaFinDate = null;
		try {
			fechaInicioDate = new SimpleDateFormat("dd/MM/yyyy").parse(fechaInicio);
			fechaFinDate = new SimpleDateFormat("dd/MM/yyyy").parse(fechaFin);
		} 
		catch (ParseException e) {
			System.out.println("ParseException occured: formato de fecha incorrecto");
		}
		System.out.println("Introduzca financiacion aportada: ");
		String financiacionAportada = scan.nextLine();
		float financiacionAportadaFloat = 0;
		try {
			financiacionAportadaFloat = Float.parseFloat(financiacionAportada);
		}
		catch(NumberFormatException e)
		{
			System.out.println("NumberFormatException occured: " + e.getMessage());
		}		
		Proyecto proyecto = new Proyecto(nombre,tipo,pais,fechaInicioDate,fechaFinDate/*,financiacionAportadaFloat*/);
		proyecto.setId(id);
		//listaProyecto.add(proyecto);
		return proyecto;
	}
	//FUNCIONES SOCIO
	
	public static Socio nuevoSocio() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduzca nombre y apellidos:\n ");
		String nombre = scan.nextLine();
		System.out.println("Introduzca la dirección: ");
		String direccion = scan.nextLine();
		System.out.println("Introduzca telefono: ");
		String telefono = scan.nextLine();
		System.out.println("Introduzca delegacion: ");
		String delegacion = scan.nextLine();
		System.out.println("Introduzca el tipo de cuota: ");
		String tipoCuota = scan.nextLine();
		System.out.println("Introduzca el importe de la cuota:");
		float ImporteCuota = scan.nextFloat();
	
		Socio socio = new Socio(nombre, direccion, telefono, delegacion, tipoCuota, ImporteCuota);
		return socio;
	}
	
	public static Socio modificarSocio() {
		//Introducir ID a modificar e introducir nuevos valores.
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduzca el id a modificar: ");
		int idSocio = Integer.parseInt(scan.nextLine());
		System.out.println("Introduzca nuevo nombre y apellidos: ");
		String nombre = scan.nextLine();
		System.out.println("Introduzca nueva direccion: ");
		String direccion = scan.nextLine();
		System.out.println("Introduzca nuevo telefono: ");
		String telefono = scan.nextLine();
		System.out.println("Introduzca nueva delegacion: ");
		String delegacion = scan.nextLine();
		System.out.println("Introduzca el tipo de cuota: ");
		String tipoCuota = scan.nextLine();
		System.out.println("Introduzca el importe de la cuota: ");
		float ImporteCuota = scan.nextFloat();
		Socio socio = new Socio(idSocio, nombre, direccion, telefono, delegacion, tipoCuota, ImporteCuota);
		return socio;
	}	
}