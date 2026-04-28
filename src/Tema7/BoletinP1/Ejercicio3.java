/**
 * @author ManuelPerez
 * @version 1.0
 */

package Tema7.BoletinP1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Ejercicio3 {
    static void main(String[] args) {
        System.out.println("Escribe lo que quieras guardar en el archivo.");
        System.out.println("Escribe 'fin' para salir.");

        try (Scanner sc = new Scanner(System.in);
             FileWriter fw = new FileWriter("C:\\Users\\mdema\\IdeaProjects\\Programacion25-26-1DAM\\src\\Tema7\\BoletinP1\\salidaEj3.txt", true);
             PrintWriter pw = new PrintWriter(fw)) {


            while (true) {
                String linea = sc.nextLine();

                if (linea.equalsIgnoreCase("fin")) {
                    System.out.println("Hasta luego maquinon!");
                    break;
                }

                pw.println(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo." +  e.getMessage());
        }


    }
}
