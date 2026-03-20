/**
 * @author ManuelPerez
 * @version 1.0
 */

package filepruebas;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Ejercicio3 {
    static void main(String[] args) throws IOException {

        /*File salida = new File("./src/filepruebas/salidaEj3.txt");

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter pw = new PrintWriter(new FileWriter(salida, true))) {

            String linea;
            while ((linea = br.readLine()) != null && !linea.equalsIgnoreCase("fin")){
                pw.println(linea);


            }

        } catch (IOException e){
            System.out.println(e.getMessage());
        }*/

        //Forma 2 con java.nio

        Path salida = Path.of("./src/filepruebas/salidaEj3.txt");

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            String linea;
            while ((linea = br.readLine()) != null && !linea.equalsIgnoreCase("fin")) {
                Files.writeString(salida, linea + System.lineSeparator(),
                        StandardOpenOption.CREATE,
                        StandardOpenOption.APPEND);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
