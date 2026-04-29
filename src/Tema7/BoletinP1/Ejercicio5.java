package Tema7.BoletinP1;

import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;
import java.util.stream.Stream;

public class Ejercicio5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        // Bucle do-while: Haz esto MIENTRAS la opción NO sea 5
        do {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Crear directorio");
            System.out.println("2. Crear fichero de texto");
            System.out.println("3. Borrar fichero de texto");
            System.out.println("4. Mostrar los ficheros de una carpeta");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");

            // Leemos el numero que has elegido
            opcion = Integer.parseInt(sc.nextLine());

            // Segun el numero, saltamos a un caso u otro
            switch (opcion) {
                case 1:
                    System.out.print("Dime el nombre de la nueva carpeta: ");
                    Path rutaDir = Paths.get("C:\\Users\\mdema\\IdeaProjects\\Programacion25-26-1DAM\\src\\Tema7\\BoletinP1", sc.nextLine());
                    try {
                        Files.createDirectory(rutaDir);
                        System.out.println("¡Carpeta creada con éxito!");
                    } catch (FileAlreadyExistsException e) {
                        System.out.println("Error: Esa carpeta ya existe.");
                    } catch (IOException e) {
                        System.out.println("Error al crear la carpeta.");
                    }
                    break;

                case 2:
                    System.out.print("Dime el nombre del nuevo archivo (ej: texto.txt): ");
                    Path rutaFich = Paths.get("C:\\Users\\mdema\\IdeaProjects\\Programacion25-26-1DAM\\src\\Tema7\\BoletinP1", sc.nextLine());
                    System.out.print("Escribe el texto que quieres meter dentro: ");
                    String texto = sc.nextLine();

                    try {
                        // Usamos CREATE_NEW para que pete si el archivo ya existe (como pide el enunciado)
                        Files.writeString(rutaFich, texto, StandardOpenOption.CREATE_NEW);
                        System.out.println("¡Archivo creado y texto guardado!");
                    } catch (FileAlreadyExistsException e) {
                        System.out.println("Error: Ya existe un archivo con ese nombre.");
                    } catch (IOException e) {
                        System.out.println("Error al crear el archivo.");
                    }
                    break;

                case 3:
                    System.out.print("Dime el nombre del archivo que quieres fulminar: ");
                    Path rutaBorrar = Paths.get(sc.nextLine());
                    try {
                        Files.delete(rutaBorrar);
                        System.out.println("¡Archivo borrado!");
                    } catch (NoSuchFileException e) {
                        System.out.println("Error: No se ha podido borrar (el archivo no existe).");
                    } catch (IOException e) {
                        System.out.println("Error: No se ha podido borrar el archivo.");
                    }
                    break;

                case 4:
                    System.out.print("Dime el nombre o ruta a la carpeta que quieres cotillear: ");
                    Path rutaCarpeta = Paths.get("C:\\Users\\mdema\\IdeaProjects\\Programacion25-26-1DAM\\src", sc.nextLine());

                    // Como Files.list abre un flujo, necesita su try-with-resources
                    try (Stream<Path> archivos = Files.list(rutaCarpeta)){
                        archivos.filter(Files::isRegularFile)
                                .sorted()
                                .forEach(archivo -> {
                                    System.out.println("- " + archivo.getFileName());
                                });
                    } catch (IOException e) {
                        System.out.println("Error al leer el archivo.");
                    }

                case 5:
                    System.out.println("¡Saliendo del programa! Hasta luego.");
                    break;

                default:
                    System.out.println("Opción incorrecta. Elige un número del 1 al 5.");
            }

        } while (opcion != 5);

        sc.close();
    }
}