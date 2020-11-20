package Agenda;

import java.util.Scanner;

public class Agenda {
	
	public static void recorrerMatriz(String mContactos[][]) {

		for (int i = 0; i < mContactos.length; i++) {
			for(int j = 0; j < mContactos[i].length; j++) {
				mContactos[i][j] = "";
			}
		}
	}
	
	public static void guardarContacto(String mContactos[][]) {
		Scanner leer= new Scanner(System.in);
		for(int i=0;i<mContactos.length;i++) {
			if(mContactos[i][0].equalsIgnoreCase("")) {
				System.out.println("Dime el nombre del nuevo contacto.");
				mContactos[i][0]=leer.next();
				System.out.println("Dime el número de teléfono del nuevo contacto.");
				mContactos[i][1]=leer.next();
				break;
			}
		}
	}

	public static void main(String[] args) {
		
		String mContactos[][];
		int filas=0, columnas=2, num=0;
		Scanner leer=new Scanner(System.in);
		System.out.println("Dime el número de filas que quieres.");
		filas=leer.nextInt();
		mContactos=new String[filas][2];
		recorrerMatriz(mContactos);
		
		System.out.println("BIENVENID@ A LA APLICACIÓN!!");
		
		while (num!=6) {
			//Mostrar opciones
			System.out.println("Pulsa la tecla 1 para añadir un contacto nuevo.");
			System.out.println("Pulsa la tecla 2 para editar un contacto.");
			System.out.println("Pulsa la tecla 3 para eliminar un contacto.");
			System.out.println("Pulsa la tecla 4 para buscar un contacto.");
			System.out.println("Pulsa la tecla 5 para mostrar todos los contactos guardados.");
			System.out.println("Pulsa la tecla 6 para salir de la aplicación.");
			num=leer.nextInt();
			//Segun depende de la opcion seleccionada
			switch (num) {
			case 1:
				guardarContacto(mContactos);
				break;
			case 2:
				
			}
		}
	}
}