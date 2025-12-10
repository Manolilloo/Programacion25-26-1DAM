/**
 * @author ManuelPerez
 * @version 1.0
 */

package Objetos.ExamenesdeOtrosAños.Examen1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Biblioteca biblio = new Biblioteca();
        int opcion;

        do {
            System.out.println("===== MENÚ BIBLIOTECA PELÍCULAS =====");
            System.out.println("1. Añadir nueva película");
            System.out.println("2. Consultar biblioteca");
            System.out.println("3. Buscar películas por etiquetas");
            System.out.println("4. Buscar película por título");
            System.out.println("5. Buscar películas por presupuesto máximo");
            System.out.println("6. Salir");
            System.out.print("Elige una opción: ");

            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1:
                    // Añadir nueva película
                    System.out.print("Título: ");
                    String titulo = sc.nextLine();

                    System.out.print("Año de estreno: ");
                    int año = Integer.parseInt(sc.nextLine());

                    System.out.print("Director: ");
                    String director = sc.nextLine();

                    System.out.print("Presupuesto (millones): ");
                    double presupuesto = Double.parseDouble(sc.nextLine());

                    System.out.print("Recaudación (millones): ");
                    double recaudacion = Double.parseDouble(sc.nextLine());

                    System.out.print("Sinopsis: ");
                    String sinopsis = sc.nextLine();

                    System.out.print("Etiquetas (separadas por comas): ");
                    String etiquetas = sc.nextLine();

                    // Calcular valoración (método estático en Pelicula)
                    double valoracion = Pelicula.calcularValoracion(presupuesto, recaudacion);

                    Pelicula p = new Pelicula(titulo, año, director, presupuesto, recaudacion, sinopsis, etiquetas, valoracion);
                    biblio.anadirPelicula(p);
                    break;

                case 2:
                    // Consultar biblioteca
                    biblio.consultarBiblioteca();
                    break;

                case 3:
                    // Buscar por etiquetas
                    System.out.print("Introduce la etiqueta a buscar: ");
                    String etiquetaBuscada = sc.nextLine();
                    biblio.buscarPeliPorEtiquetas(etiquetaBuscada);
                    break;

                case 4:
                    // Buscar por título
                    System.out.print("Introduce el título exacto: ");
                    String tituloBuscado = sc.nextLine();
                    biblio.buscarPeliPorTitulo(tituloBuscado);
                    break;

                case 5:
                    // Buscar por presupuesto máximo
                    System.out.print("Introduce el presupuesto máximo (millones): ");
                    double maxPresupuesto = Double.parseDouble(sc.nextLine());
                    biblio.buscarPelisPorPresupuestoMaximo(maxPresupuesto);
                    break;

                case 6:
                    System.out.println("Saliendo de la aplicación...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

            System.out.println();

        } while (opcion != 6);

        sc.close();
    }
}