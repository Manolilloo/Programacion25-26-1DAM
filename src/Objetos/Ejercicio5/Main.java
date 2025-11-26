/**
 * @author ManuelPerez
 * @version 1.0
 */

package Objetos.Ejercicio5;

import java.util.Scanner;

public class Main {
    static void main(String[] args) {


    }

    public void montarPC(Scanner scanner, PlacaBase placaBase, Microprocesador microprocesador, DiscoDuro discoDuro, Grafica grafica){
        System.out.println("Vamos a montar tu pc...");
        System.out.println();
        System.out.println("Dime la marca, el chipset y el socket de la PLACA BASE: ");
        placaBase.getMarca();
        placaBase.getChipset();
        placaBase.getSocket();
    }
}
