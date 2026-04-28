/**
 * @author ManuelPerez
 * @version 1.0
 */

package Tema7.BoletinP1;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Calendar.AM;

public class Ejercicio2 {
    static void main(String[] args) {
        try  {
            List<String> lineas = Files.readAllLines(Paths.get("C:\\Users\\mdema\\IdeaProjects\\Programacion25-26-1DAM\\src\\Tema7\\BoletinP1\\ejemplo.txt"));

            String cadenaJunta = String.join(" ", lineas);

            System.out.println(cadenaJunta);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
