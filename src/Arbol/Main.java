package Arbol;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		File f = new File("Arbol.txt");
		Scanner scanner = new Scanner(f);
		ABB arbol = new ABB();
		while (scanner.hasNext()) {
			int linea = scanner.nextInt();
			arbol.insertar(linea);

		}
		scanner.close();
		arbol.imprimir();
	}
}
