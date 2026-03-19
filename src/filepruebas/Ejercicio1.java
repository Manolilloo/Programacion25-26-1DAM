/**
 * @author ManuelPerez
 * @version 1.0
 */

package filepruebas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio1 {

    static void main(String[] args) {

        File f = new File("./src/filepruebas/leeme.txt");

        try (FileReader fr = new FileReader(f);
             BufferedReader br = new BufferedReader(fr)){

            int numeroLineas = 0;
            String linea;
            while ((linea = br.readLine()) != null) {
                numeroLineas++;
            }
            System.out.println("\nNumero de lineas: " + numeroLineas);
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
