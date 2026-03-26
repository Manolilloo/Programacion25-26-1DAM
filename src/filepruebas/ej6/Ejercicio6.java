package filepruebas.ej6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author ManuelPerez
 * @version 1.0
 */

public class Ejercicio6 {
    static void main() {
        String nombreDirectorio = filepruebas.ej6.io.MiEntradaSalida.leerLinea("Introduce el nombre del  directorio \n");

        Path p = Path.of( nombreDirectorio);
        if (Files.exists(p)){
            if (Files.isDirectory(p)){
                try {
                    Files.list(p).forEach(path -> {
                        if (Files.isDirectory(path)){
                            System.out.printf("%s - directorio %n", path.getFileName());
                        }else{
                            try {
                                System.out.printf("%s %.2f kb %n", path.getFileName(),Files.size(path)/1024.0);
                            } catch (IOException e) {
                                System.out.println(e.getMessage());
                            }
                        }
                    });
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            } //TODO Hacer el else
        }else{
            System.out.println("No existe crack");
        }
    }
}

