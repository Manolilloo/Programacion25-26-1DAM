package Objetos.Ejercicio2;

import java.util.Scanner;

public class Principal {

    static void main(String[] args) {

        Cuenta cuenta = new Cuenta();
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido al cajero Suso!\nIngresa una opción:\n\nRETIRAR DINERO.\nINGRESAR DINERO.\nVER SALDO ACTUAL.\n\n--> ");
        System.out.println();

        String opcion = sc.nextLine().toUpperCase();
        double dinero = cuenta.getSaldoInicial(300);

        System.out.println(dinero);

        switch (opcion){
            case "RETIRAR DINERO":

        }
    }
}
