package p5dgm.main;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import p5dgm.dao.EquipoDAO;
import p5dgm.dao.ProyectoDAO;
import p5dgm.dao.xml.XMLEquipoDAO;
import p5dgm.dao.xml.XMLProyectoDAO;

public class Main {

	public static void main(String[] args) throws IOException {
		System.out.println("Buenos dias P5DGM2021\n");
		Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
 
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
                opcion = sn.nextInt();
 
                switch (opcion) {
                    case 1:
                        System.out.println("Has seleccionado la opcion 1");
                        EquipoDAO DAOnuevo = new XMLEquipoDAO();
                        Equipo nuevo = nuevoEquipo();
                        DAOnuevo.insertar(nuevo);
                        break;
                       
                    case 2:
                        System.out.println("Has seleccionado la opcion 2");
                        EquipoDAO DAOmodificar = new XMLEquipoDAO();
                        Equipo modificar  = modificarEquipo();
                        DAOmodificar.modificar(modificar);
                        break;
                    case 3:
                    	System.out.println("Has seleccionado la opcion 3\n");
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
                    case 4:
                    	System.out.println("Has seleccionado la opcion 3");
                        EquipoDAO DAOeliminar = new XMLEquipoDAO();
                        Scanner scanEliminarEquipo = new Scanner(System.in);
                		System.out.println("Introduzca el id a eliminar: ");
                		int idEquipoEliminar = Integer.parseInt(scanEliminarEquipo.nextLine());	
                		DAOeliminar.eliminar(idEquipoEliminar);
                        break;
                    		
                    /*
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                    */
                    case 13:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo numeros entre 1 y 4");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un nï¿½mero");
                sn.next();
            }
        }
	}
	
	
	public static Equipo nuevoEquipo() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduzca id: ");
		int id = Integer.parseInt(scan.nextLine());
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
		Equipo equipo = new Equipo(id, nombre, fechaNacimiento, direccion, telefono, delegacion);
		return equipo;
	}
	
	public static Equipo modificarEquipo() {
		//Introducir ID a modificar e introducir nuevos valores.
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduzca el id a modificar: ");
		int id = Integer.parseInt(scan.nextLine());
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
		/*System.out.println("Introduzca id de proyecto: ");
		String proyecto = scan.nextLine();*/
		Equipo equipo = new Equipo(id, nombre, fechaNacimiento, direccion, telefono, delegacion);
		return equipo;
	}
	
	
	public static ListaProyecto NuevoProyecto(ListaProyecto listaProyecto) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduzca id: ");
		int id = Integer.parseInt(scan.nextLine());
		System.out.println("Introduzca nombre del proyecto");
		String nombre = scan.nextLine();
		System.out.println("Introduzca tipo del proyecto");
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
		Proyecto proyecto = new Proyecto(id,nombre,tipo,pais,fechaInicioDate,fechaFinDate/*,financiacionAportadaFloat*/);
		listaProyecto.add(proyecto);
		return listaProyecto;
	}
}
