package p5dgm.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import p5dgm.main.Equipo;
import p5dgm.dao.EquipoDAO;
import p5dgm.dao.xml.XMLEquipoDAO;

public class Main {

	public static void main(String[] args) {
		System.out.println("Buenos días P5DGM2021\n");
		Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
 
        while (!salir) {
 
            System.out.println("1. Opcion 1");
            System.out.println("2. Opcion 2");
            System.out.println("3. Opcion 3");
            System.out.println("4. Salir");
 
            try {
 
                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();
 
                switch (opcion) {
                    case 1:
                        System.out.println("Has seleccionado la opcion 1");
                        nuevoEquipo();
                        break;
                    case 2:
                        System.out.println("Has seleccionado la opcion 2");
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
	
	
	public static void nuevoEquipo() {
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
		EquipoDAO DAO = new XMLEquipoDAO();
		DAO.insertar(new Equipo(id, nombre, fechaNacimiento, direccion, telefono, delegacion));
	}
}
