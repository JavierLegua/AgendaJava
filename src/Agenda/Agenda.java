package Agenda;

import java.util.Scanner;

public class Agenda {

	public static void pintarMenu() {
		System.out.println("Pulsa la tecla 1 para añadir un contacto nuevo.");
		System.out.println("Pulsa la tecla 2 para editar un contacto.");
		System.out.println("Pulsa la tecla 3 para eliminar un contacto.");
		System.out.println("Pulsa la tecla 4 para buscar un contacto.");
		System.out.println("Pulsa la tecla 5 para mostrar todos los contactos guardados.");
		System.out.println("Pulsa la tecla 6 para salir de la aplicación.");
	}

	public static void recorrerMatriz(String mContactos[][]) {

		for (int i = 0; i < mContactos.length; i++) {
			for (int j = 0; j < mContactos[i].length; j++) {
				mContactos[i][j] = "";
			}
		}
	}

	public static void guardarContacto(String mContactos[][]) {

		Scanner leer = new Scanner(System.in);
		for (int i = 0; i < mContactos.length; i++) {
			if (mContactos[i][0].equalsIgnoreCase("")) {
				System.out.println("Dime el nombre del nuevo contacto.");
				mContactos[i][0] = leer.next();
				System.out.println("Dime el número de teléfono del nuevo contacto.");
				mContactos[i][1] = leer.next();
				break;
			}
		}
	}

	public static int buscarContacto(String mContactos[][], String busqueda) {
		for (int i = 0; i < mContactos.length; i++) {
			if (mContactos[i][0].equalsIgnoreCase(busqueda) || mContactos[i][1].equalsIgnoreCase(busqueda)) {
				return i;
			}
		}
		return -1;
	}

	public static void editarContacto(String mContactos[][]) {

		Scanner leer = new Scanner(System.in);
		int pos = -1;
		String editar = "", editarNom = "", editarTel = "";
		System.out.println("¿Que contacto quieres editar?");
		editar = leer.next();
		pos = buscarContacto(mContactos, editar);
		if (pos == -1) {
			System.out.println("Contacto no encontrado");
		} else {
			System.out.println("Introduce el nombre");
			editarNom = leer.next();
			mContactos[pos][0] = editarNom;
			System.out.println("Introduce el teléfono");
			editarTel = leer.next();
			mContactos[pos][1] = editarTel;
		}

	}

	public static void eliminarContacto(String mContactos[][]) {

		Scanner leer = new Scanner(System.in);
		String borrar = "";
		System.out.println("¿Que contacto quieres borrar?");
		borrar = leer.next();
		for (int i = 0; i < mContactos.length; i++) {
			if (mContactos[i][0].equalsIgnoreCase(borrar) || mContactos[i][1].equalsIgnoreCase(borrar)) {
				mContactos[i][0] = "";
				mContactos[i][1] = "";
				System.out.println("El contacto ha sido borrado.");
			} else {
				System.out.println("No se ha encontrado el contacto introducido.");
			}
		}
	}

	public static void buscarContacto(String mContactos[][]) {
		Scanner leer = new Scanner(System.in);
		String buscar = "";
		System.out.println("¿Que contacto quieres buscar?");
		buscar = leer.next();
		for (int i = 0; i < mContactos.length; i++) {
			if (mContactos[i][0].equalsIgnoreCase(buscar) || mContactos[i][1].equalsIgnoreCase(buscar)) {
				System.out.println("El nombre es " + mContactos[i][0] + " y su teléfono es " + mContactos[i][1]);
			}
		}
	}

	public static void mostrarTodos(String mContactos[][]) {

		for (int i = 0; i < mContactos.length; i++) {
			System.out.println(mContactos[i][0] + " " + mContactos[i][1]);
		}

	}

	public static void main(String[] args) {

		String mContactos[][];
		int filas = 0, columnas = 2, num = 0;
		Scanner leer = new Scanner(System.in);
		System.out.println("Dime el número de filas que quieres.");
		filas = leer.nextInt();
		mContactos = new String[filas][2];
		recorrerMatriz(mContactos);
		mContactos[0][0] = "javier";
		mContactos[0][1] = "654";
		mContactos[1][0] = "pepe";
		mContactos[1][1] = "654546";

		System.out.println("BIENVENID@ A LA APLICACIÓN!!");

		while (num != 6) {
			// Mostrar opciones
			pintarMenu();
			num = leer.nextInt();
			// Segun depende de la opcion seleccionada
			switch (num) {
			case 1:
				guardarContacto(mContactos);
				break;
			case 2:
				editarContacto(mContactos);
				break;
			case 3:
				eliminarContacto(mContactos);
				break;
			case 4:
				buscarContacto(mContactos);
				break;
			case 5:
				mostrarTodos(mContactos);
				break;
			}
		}
		System.out.println("AGUR!!!");
	}
}