/**
 * @author ManuelPerez
 * @version 1.0
 */

package filepruebas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Ejercicio2 {
    static void main(String[] args) {

        File f = new File("./src/filepruebas/leeme.txt");

        try (FileReader fr = new FileReader(f);
             BufferedReader br = new BufferedReader(fr)){

            int numeroLineas = 0;
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.print(linea + " ");
                numeroLineas++;
            }
            System.out.println("\nNumero de lineas: " + numeroLineas);

            /**
             * Forma 2:
             *System.out.println("Habia " + br.lines().count() + " lineas");
             */


        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
