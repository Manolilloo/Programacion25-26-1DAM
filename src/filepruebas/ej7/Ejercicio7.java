package filepruebas.ej7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * @author ManuelPerez
 * @version 1.0
 */

public class Ejercicio7 {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Opción 1: Listar directorio");
                    break;
                case 2:
                    System.out.println("Opción 2: Listar con prefijo");
                    opcion2();
                    break;
                case 3:
                    System.out.println("Opción 3: Listar por extensión");
                    break;
                case 4:
                    System.out.println("Opción 4: Buscar archivo simple");
                    break;
                case 5:
                    System.out.println("Opción 5: Buscar recursivo");
                    break;
                case 6:
                    System.out.println("¡Saliendo del programa!");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
            System.out.println();
        } while (opcion != 6);
    }

    private static void mostrarMenu() {
        System.out.println("\n=== MENÚ DE GESTIÓN DE DIRECTORIOS ===");
        System.out.println("1. Listar directorio");
        System.out.println("2. Listar directorio y buscar ficheros que comiencen por una palabra");
        System.out.println("3. Listar archivos con cierta extensión de un directorio");
        System.out.println("4. Buscar un archivo en un directorio");
        System.out.println("5. Buscar recursivamente un archivo en un directorio");
        System.out.println("6. Salir");
        System.out.println("=====================================");
    }


    public static void opcion2() {
        System.out.println("Introduce el directorio: \n");
        Path p = Path.of(scanner.nextLine());

        System.out.println("Introduce por cuál palabra quieres buscar: ");
        String palabraABuscar = scanner.nextLine();

        if (Files.isDirectory(p)) {
            try (Stream<Path> ficheros = Files.list(p)) {
                ficheros.filter(path -> path.getFileName().toString().toLowerCase().startsWith(palabraABuscar))
                        .forEach(path -> {
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
        }
    }
}

