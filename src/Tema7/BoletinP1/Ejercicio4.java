package Tema7.BoletinP1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {
        System.out.println("Escribe lo que quieras guardar en el archivo.");
        System.out.println("Escribe 'fin' para salir.");

        Path ruta = Paths.get("C:\\Users\\mdema\\IdeaProjects\\Programacion25-26-1DAM\\src\\Tema7\\BoletinP1\\salidaEj4.txt");

        // Solo metemos el Scanner en el try porque Files.writeString abre y cierra el archivo solo
        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                String linea = sc.nextLine();

                if (linea.equalsIgnoreCase("fin")) {
                    System.out.println("¡Terminado con NIO! Hasta luego maquinon.");
                    break;
                }

                // Escribimos la linea directamente con la magia de NIO.2
                // Le sumamos un System.lineSeparator() (el Enter) para que no se peguen todas las frases en la misma linea
                Files.writeString(ruta, linea + System.lineSeparator(),
                        StandardOpenOption.CREATE,
                        StandardOpenOption.APPEND);
            }
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo: " + e.getMessage());
        }
    }
}