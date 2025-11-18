package Objetos.Ejercicio2;

import java.util.Scanner;

public class Principal {

    static void main(String[] args) {

        Cuenta c = new Cuenta();
        Scanner sc = new Scanner(System.in);
        boolean activo = true;

        while (activo) {
            System.out.println("Bienvenido al cajero!\nIngresa una opción:\n\n1) RETIRAR DINERO.\n2) INGRESAR DINERO.\n3) VER OPERACIONES.\n4) Finalizar la operación.\n--> ");

            int opcion = sc.nextInt();
            double dinero = c.setSaldo(50);
            double retirar = 0;
            double ingresar = 0;


            switch (opcion) {
                case 1: //Retirar dinero. Hay que hacer que el dinero que tengo baje y el contador de los retiros aumente
                    System.out.println("¿Cuánto quieres retirar?");
                    retirar = sc.nextDouble();
                    if (dinero <= 0) {
                        System.out.println("No puedes retirar dinero porque no tienes.");
                    } else if (dinero > 0) {
                        dinero -= retirar;
                        System.out.println("Tienes " + dinero + " €");
                        c.setReintegrosTotales((int) (dinero -= retirar));
                    }
                    break;
                case 2:
                    System.out.println("¿Cuánto quieres ingresar?");
                    ingresar = sc.nextDouble();


                    break;
                case 3:
                    System.out.println("=================================================");
                    System.out.println("Saldo actual: " + dinero);
                    System.out.println("Reintegros actuales: " + c.getReintegrosTotales());
                    System.out.println("Ingresos actuales: " + c.getIngresosTotales());
                    System.out.println("=================================================");

                    break;
                case 4:
                    System.out.println("Hasta luego.");
                    activo = false;
                    break;

                default:
                    System.out.println("Esta acción no es válida: ");
                    opcion = sc.nextInt();
            }
        }
    }
}
