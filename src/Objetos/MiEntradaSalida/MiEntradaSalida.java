/**
 * @author ManuelPerez
 * @version 1.0
 */

package Objetos.MiEntradaSalida;

import java.util.Scanner;

public class MiEntradaSalida {
    static Scanner scanner = new Scanner(System.in);


    public static int solicitarEntero(String mensaje) {
        int numero = 0;
        boolean activo = true;

        while (activo){
            try {
                System.out.println(mensaje);
                numero = scanner.nextInt();
                activo = false;

            } catch (NumberFormatException e) {
                System.out.println("Error: introduce un numero entero.");
            }
        }

        return numero;
    }

    public static int solicitarEnteroPositivo(String mensaje) {
        boolean activo = true;
        int numero = 0;
        while (activo){
            System.out.println(mensaje);
            try {
                numero = Integer.parseInt(scanner.nextLine());
                activo = false;
            }
            catch (NumberFormatException e){
                System.out.println("Error: Tienes que introducir\nun número entero positivo.");
            }
        }
        return numero;
    }

    public static int solicitarEnteroEnRango(String mensaje, int min, int max) {
        boolean activo = true;
        int num = 0;
        while (activo){
            System.out.println(mensaje);
            try {
                num = Integer.parseInt(scanner.nextLine());
                if (num >= min && num <= max){
                    System.out.println(num);
                }
            }
            catch (NumberFormatException e){
                System.out.println("Lo que has introducido\nno es valido.");
            }
        }
        return num;
    }

    public static char solicitarCaracter(String mensaje) {
        boolean valido = true;
        char c = 0;
        System.out.println(mensaje);
        String caracter = scanner.nextLine();
        while (valido) {
            if (caracter.length() > 0){
                c = caracter.charAt(0);
                valido = false;
            } else {
                System.out.println("Debes introducir un caracter por teclado: ");

            }

        }
    }
}
