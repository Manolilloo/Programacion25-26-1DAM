/**
 * @author ManuelPerez
 * @version 1.0
 */

package filepruebas;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;

public class Ejercicio2nio {

    static void main(String[] args) throws IOException {
        Path p = Path.of("./src/filepruebas/leeme.txt");

        try {
            System.out.println(Files.lines(p).collect(Collectors.joining(" ")));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
