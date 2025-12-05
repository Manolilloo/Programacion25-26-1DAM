/**
 * @author ManuelPerez
 * @version 1.0
 */
package Objetos.Objetos4;

import java.util.Scanner;

public class Ejercicio1 {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce una palabra: ");
        String palabra = sc.nextLine().toLowerCase();

        System.out.println("Introduce una letra que quieras comprobar si se repite: ");
        char letra = sc.nextLine().toLowerCase().charAt(0);

        contadorRepetidos(palabra, letra);
        System.out.println("La letra se ha repetido "+contadorRepetidos(palabra, letra)+" veces.");

    }

    public static int contadorRepetidos(String palabra, char letra) {
        int contador = 0;
        for (int i = 0; i < palabra.length(); i++) {
            if (palabra.charAt(i) == letra) contador++;
        }
        return contador;
    }
}

