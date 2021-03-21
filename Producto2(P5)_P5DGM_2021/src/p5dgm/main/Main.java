package p5dgm.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import p5dgm.dao.EquipoDAO;
import p5dgm.dao.ProyectoDAO;
import p5dgm.dao.xml.XMLEquipoDAO;
import p5dgm.dao.xml.XMLProyectoDAO;

public class Main {

	public static void main(String[] args) {
		System.out.println("Buenos días P5DGM2021\n");
		ListaEquipo lista = new ListaEquipo();
		ListaProyecto listaProyecto = new ListaProyecto();
		Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
 
        while (!salir) {
 
            System.out.println("1. Registrar nuevo miembro del equipo.");
            System.out.println("2. Registrar nuevo Proyecto");
            System.out.println("3. Opcion 3");
            System.out.println("4. Salir");
 
            try {
 
                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();
 
                switch (opcion) {
                    case 1:
                        System.out.println("Has seleccionado la opcion 1");
                        EquipoDAO DAO = new XMLEquipoDAO();
                        lista = nuevoEquipo(lista);
                        DAO.insertar(lista);
                        break;
                    case 2:
                        System.out.println("Has seleccionado la opcion 2");
                        ProyectoDAO proyectoDAO = new XMLProyectoDAO();
                        listaProyecto = NuevoProyecto(listaProyecto);
                        proyectoDAO.insertar(listaProyecto);
                        break;
                    case 3:
                        System.out.println("Has seleccionado la opcion 3");
                        break;
                    case 4:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 4");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }
	}
	
	
	public static ListaEquipo nuevoEquipo(ListaEquipo lista) {
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
		lista.add(equipo);
		return lista;
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
