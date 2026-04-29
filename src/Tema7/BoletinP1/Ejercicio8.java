/**
 * @author ManuelPerez
 * @version 1.0
 */

package Tema7.BoletinP1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

public class Ejercicio8 {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Dime la ruta que vamos a usar partiendo del src: ");
        Path ruta = Path.of("C:\\Users\\mdema\\IdeaProjects\\Programacion25-26-1DAM\\src",
                sc.nextLine());

        if (!Files.exists(ruta) || !Files.isDirectory(ruta)) {
            System.err.println("El archivo no existe o no es un fichero" +
                    "de texto");
            return;
        }

        boolean formatoCorrecto = true;
        int numeroLinea= 1;

        try(Stream<String> lineas = Files.lines(ruta)) {
            for (String linea: (Iterable<String>) lineas::iterator) {

                String[] partes = linea.split(" ");

                if (partes.length != 4){
                    System.out.println("Fallo en la linea "+numeroLinea +
                            ": No tiene exactamente 4 palabras");
                    formatoCorrecto = false;
                } else {
                    String nombre = partes[0];
                    String apellido1 = partes[1];
                    String apellido2 = partes[2];


                }
            }



        } catch (IOException e) {
            System.out.println("Error");
        }


    }
    private static boolean esValidoTexto(String texto) {
        if (texto.length() < 2) return false;

        // El bucle comprueba letra a letra que no haya números ni símbolos raros
        for (char c : texto.toCharArray()) {
            if (!Character.isLetter(c)) {
                return false;
            }
        }
        return true;
    }
}
