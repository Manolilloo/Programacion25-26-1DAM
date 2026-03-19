/**
 * @author ManuelPerez
 * @version 1.0
 */

package colecciones.boletin61.ej6;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int opcion = 0;

        do {
            System.out.println("== Selecciona una opcion: ==");
            System.out.println("1. Abrir caja");
            System.out.println("2. Cerrar caja");
            System.out.println("3. Nuevo cliente");
            System.out.println("4. Atender cliente");
            System.out.println("5. Salir");

            switch (opcion) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    opcion = 7;
                    break;
            }


        } while (opcion <= 5);

    }
}
