/**
 * @author ManuelPerez
 * @version 1.0
 */

package Tema7.BoletinP1;

import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;
import java.util.stream.Stream;

public class Ejercicio7 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n=== MENÚ BUSCADOR ===");
            System.out.println("1. Listar directorio completo");
            System.out.println("2. Buscar ficheros que empiecen por una palabra");
            System.out.println("3. Buscar ficheros por extensión (ej: .txt)");
            System.out.println("4. Buscar un archivo exacto");
            System.out.println("5. Buscar un archivo recursivamente (en subcarpetas)");
            System.out.println("6. Salir");
            System.out.print("Elige opción: ");
            opcion = Integer.parseInt(sc.nextLine());

            if (opcion >= 1 && opcion <= 5) {
                System.out.print("Dime la ruta de la carpeta (ej: src/Tema7/BoletinP1): ");
                String rutaTxt = sc.nextLine();
                // Usamos una ruta relativa base o la absoluta si la pones entera
                Path directorio = Paths.get("C:\\Users\\mdema\\IdeaProjects\\Programacion25-26-1DAM\\src", rutaTxt);

                if (!Files.exists(directorio) || !Files.isReadable(directorio)) {
                    System.out.println("Error: El directorio no existe o no tienes permisos.");
                    continue; // Vuelve al inicio del bucle
                }

                switch (opcion) {
                    case 1:
                        listarDirectorio(directorio);
                        break;
                    case 2:
                        System.out.print("Dime por qué palabra deben empezar: ");
                        buscarPorComienzo(directorio, sc.nextLine());
                        break;
                    case 3:
                        System.out.print("Dime qué extensión buscas (ej: .java): ");
                        buscarPorExtension(directorio, sc.nextLine());
                        break;
                    case 4:
                        System.out.print("Dime el nombre exacto del archivo: ");
                        buscarArchivoExacto(directorio, sc.nextLine());
                        break;
                    case 5:
                        System.out.print("Dime el nombre exacto del archivo (búsqueda profunda): ");
                        buscarRecursivo(directorio, sc.nextLine());
                        break;
                }
            }
        } while (opcion != 6);

        System.out.println("¡Saliendo del buscador!");
        sc.close();
    }

    // --- MÉTODOS DE CADA OPCIÓN ---

    // Opción 1: ¡Es tu ejercicio 6!
    private static void listarDirectorio(Path dir) {
        try (Stream<Path> archivos = Files.list(dir)) {
            archivos.sorted().forEach(a -> {
                if (Files.isRegularFile(a)) {
                    try {
                        System.out.println("[Archivo] " + a.getFileName() + " (" + Files.size(a) / 1024 + " KB)");
                    } catch (IOException e) {
                        System.out.println("Error pesando " + a.getFileName());
                    }
                } else if (Files.isDirectory(a)) {
                    System.out.println("[Carpeta] " + a.getFileName());
                }
            });
        } catch (IOException e) {
            System.out.println("Error leyendo directorio.");
        }
    }

    // Opción 2: Comienzan por palabra
    private static void buscarPorComienzo(Path dir, String prefijo) {
        try (Stream<Path> archivos = Files.list(dir)) {
            archivos.filter(Files::isRegularFile)
                    // La magia: convertimos a String el nombre y usamos startsWith()
                    .filter(a -> a.getFileName().toString().startsWith(prefijo))
                    .forEach(a -> System.out.println("Encontrado: " + a.getFileName()));
        } catch (IOException e) {
            System.out.println("Error.");
        }
    }

    // Opción 3: Extensión
    private static void buscarPorExtension(Path dir, String extension) {
        try (Stream<Path> archivos = Files.list(dir)) {
            archivos.filter(Files::isRegularFile)
                    // La magia 2: usamos endsWith()
                    .filter(a -> a.getFileName().toString().endsWith(extension))
                    .forEach(a -> System.out.println("Encontrado: " + a.getFileName()));
        } catch (IOException e) {
            System.out.println("Error.");
        }
    }

    // Opción 4: Archivo exacto
    private static void buscarArchivoExacto(Path dir, String nombreExacto) {
        try (Stream<Path> archivos = Files.list(dir)) {
            archivos.filter(Files::isRegularFile)
                    // La magia 3: usamos equals()
                    .filter(a -> a.getFileName().toString().equals(nombreExacto))
                    .forEach(a -> {
                        try {
                            // Imprimimos la ruta completa (toAbsolutePath) y el peso
                            System.out.println("¡Lo tengo! Ruta: " + a.toAbsolutePath() + " | Peso: " + Files.size(a) / 1024 + " KB");
                        } catch (IOException e) {
                            System.out.println("Error pesando.");
                        }
                    });
        } catch (IOException e) {
            System.out.println("Error.");
        }
    }

    // Opción 5: Recursivo
    private static void buscarRecursivo(Path dir, String nombreExacto) {
        // AQUÍ ESTÁ EL TRUCO: Usamos walk() en vez de list() para entrar en subcarpetas
        try (Stream<Path> arbol = Files.walk(dir)) {
            arbol.filter(Files::isRegularFile)
                    .filter(a -> a.getFileName().toString().equals(nombreExacto))
                    .forEach(a -> System.out.println("¡Encontrado! Ruta: " + a.toAbsolutePath()));
        } catch (IOException e) {
            System.out.println("Error en búsqueda recursiva.");
        }
    }
}