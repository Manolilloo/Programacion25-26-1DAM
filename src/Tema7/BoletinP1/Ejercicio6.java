/**
 * @author ManuelPerez
 * @version 1.0
 */

package Tema7.BoletinP1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.stream.Stream;

public class Ejercicio6 {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el nombre del directorio que quieras ver: ");
        String entrada = sc.nextLine();

        Path directorio = Path.of("C:\\Users\\mdema\\IdeaProjects\\Programacion25-26-1DAM\\src", entrada);

        try (Stream<Path> archivos = Files.list(directorio)) {
            //Para archivos solo
            archivos.sorted()
                    .forEach(archivo -> {
                       if (Files.isRegularFile(archivo)) {
                           try {
                               System.out.println("- " +  archivo.getFileName() + " " + Files.size(archivo)/1024 + "KB");
                           } catch (IOException e) {
                               System.out.println("Error");
                           }
                       } else if (Files.isDirectory(archivo)) {
                           System.out.println("- " +  archivo.getFileName());
                       }
                    });



        } catch (IOException e) {
            System.out.println("Error.");
        }
    }
}
