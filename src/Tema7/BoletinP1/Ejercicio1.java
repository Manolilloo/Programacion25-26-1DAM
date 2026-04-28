/**
 * @author ManuelPerez
 * @version 1.0
 */

package Tema7.BoletinP1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Ejercicio1 {
    static void main(String[] args) {
        Path ruta = Paths.get("C:\\Users\\mdema\\IdeaProjects\\Programacion25-26-1DAM\\src\\Tema7\\BoletinP1\\ejemplo.txt");

        try (Stream<String> lineas = Files.lines(ruta)) {
            long numeroLineas = lineas.count();
            System.out.println("Numero de lineas del archivo: " + numeroLineas);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
