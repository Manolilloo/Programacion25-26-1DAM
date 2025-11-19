package Objetos.Ejercicio2;

import java.sql.SQLOutput;
import java.util.MissingFormatArgumentException;
import java.util.Scanner;

public class Principal {

    static void main(String[] args) {

        Cuenta c = new Cuenta();
        Scanner sc = new Scanner(System.in);
        boolean activo = true;
        double dinero = 50;

        System.out.println("Bienvenido al cajero!");

        while (activo) {
            System.out.println("Ingresa una opción:\n\n1) RETIRAR DINERO.\n2) INGRESAR DINERO.\n3) VER OPERACIONES.\n4) Finalizar la operación.\n👇 ");

            int opcion = sc.nextInt();
            double retirar = 0;
            double ingresar = 0;

            switch (opcion) {
                case 1: //Retirar dinero. Hay que hacer que el dinero que tengo baje y el contador de los retiros aumente
                    System.out.println("¿Cuánto quieres retirar?");
                    retirar = sc.nextDouble();
                    if (dinero <= 0) {
                        System.out.println("No puedes retirar dinero porque no puedes retirar 0€.");
                    } else if (dinero > 0) {
                        dinero -= retirar;
                        System.out.println("Retiraste " + retirar + "€");
                        c.setReintegrosTotales(c.getReintegrosTotales() + 1);
                    } else if (retirar == 0) {
                        System.out.println("No puedes sacar nada, vuelve a intentar: ");
                        retirar = sc.nextDouble();
                    }
                    break;

                case 2: //Esto que he hecho son básicamente los ingresos que hace el usuario
                    System.out.println("¿Cuánto quieres ingresar?");
                    ingresar = sc.nextDouble();

                    while (ingresar < 0) {
                        System.out.println("No puedes ingresar una cantidad negativa,\nintroduce una cantidad positiva: ");
                        ingresar = sc.nextDouble();

                    }
                    while (ingresar == 0) {
                        System.out.println("No puedes ingresar 0. Vuelve a intentarlo: ");
                        ingresar = sc.nextDouble();
                    }

                    dinero += ingresar;
                    c.setIngresosTotales(c.getIngresosTotales() + 1);
                    System.out.println("Has ingresado " + ingresar + "€");
                    System.out.println();


                    break;

                case 3: //Estas son las operaciones hasta ahora
                    System.out.println("=================================================");
                    System.out.println("Saldo actual: " + dinero);
                    System.out.println("Reintegros actuales: " + c.getReintegrosTotales());
                    System.out.println("Ingresos actuales: " + c.getIngresosTotales());
                    System.out.println("=================================================");

                    break;

                case 4:     //Para salir del cajero

                    System.out.println("¿Desea salir?  (S/N)");
                    String respuesta = sc.next().toUpperCase();

                    if (respuesta.equals("S")) {
                        System.out.println("Saliendo del cajero...");
                        activo = false;
                    } else if (respuesta.equals("N")) {
                        System.out.println("Continuando con las operaciones...");
                        break;
                    } else {
                        System.out.println("Introduce el carácter válido (S -> Sí / N -> No)");
                    }
                    break;


                default:
                    System.out.println("Esta acción no es válida: ");
                    opcion = sc.nextInt();
            }
        }
    }
}
