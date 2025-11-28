/**
 * @author ManuelPerez
 * @version 1.0
 */

package Objetos.EjercicioProducto;


import Objetos.MiEntradaSalida.MiEntradaSalida;

import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        Producto p = new Producto(99.999, 9834934, "Jamon para Bermudo bellota 5J");
        Scanner sc = new Scanner(System.in);

        System.out.println("Estas en el Mercadona...");
        System.out.println();
        boolean activoPapi = true;

        while (activoPapi) {
            System.out.println("\n=== MENÚ ===");
            System.out.println("1. Consultar producto");
            System.out.println("2. Modificar producto");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    p.consulta();
                    break;

                case 2:
                    System.out.print("Introduce el nuevo código: ");
                    int nuevoCodigo = sc.nextInt();
                    sc.nextLine();


                    System.out.print("Introduce la nueva descripción: ");
                    String nuevaDescripcion = sc.nextLine();


                    System.out.print("Introduce el nuevo precio: ");
                    double nuevoPrecio = sc.nextDouble();
                    sc.nextLine();


                    p.modificarAtributos(nuevoCodigo, nuevaDescripcion, nuevoPrecio);
                    break;

                case 3:
                    System.out.println("Hasta luego pishita...");
                    activoPapi = false;
                    break;
                default:
                    System.out.println("Cagada monumental, vaya mierda\nde vida que tienes...");
            }
        }
    }
}
