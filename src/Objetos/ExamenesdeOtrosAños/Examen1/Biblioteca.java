/**
 * @author ManuelPerez
 * @version 1.0
 */

package Objetos.ExamenesdeOtrosAños.Examen1;

import java.util.IdentityHashMap;

public class Biblioteca {

    private static final int CAPACIDAD_MAX = 20;
    private Pelicula[] peliculas;
    private int contador;

    public Biblioteca() {
        peliculas = new Pelicula[CAPACIDAD_MAX];
        contador = 0;
    }

    // 1. Añadir película
    public void anadirPelicula(Pelicula peli) {
        if (contador < CAPACIDAD_MAX) {
            peliculas[contador] = peli;
            contador++;
            System.out.println("Película añadida correctamente.");
        } else {
            System.out.println("ERROR: La biblioteca está llena. No se pueden añadir más películas.");
        }
    }

    // 2. Consultar biblioteca (mostrar todas)
    public void consultarBiblioteca() {
        if (contador == 0) {
            System.out.println("No hay películas en la biblioteca.");
        } else {
            for (int i = 0; i < contador; i++) {
                System.out.println(peliculas[i].toString());
                System.out.println("-------------------------");
            }
        }
    }

    // 3. Buscar películas por etiquetas (muestra títulos)
    public void buscarPeliPorEtiquetas(String etiquetaBuscada) {
        boolean encontrada = false;

        for (int i = 0; i < contador; i++) {
            if (peliculas[i].getEtiquetas().contains(etiquetaBuscada)) {
                System.out.println(peliculas[i].getTitulo());
                encontrada = true;
            }
        }

        if (!encontrada) {
            System.out.println("No se encontraron películas con esa etiqueta.");
        }
    }

    // 4. Buscar película por título (mostrar todos los datos)
    public void buscarPeliPorTitulo(String tituloBuscado) {
        boolean encontrada = false;

        for (int i = 0; i < contador; i++) {
            if (peliculas[i].getTitulo().equalsIgnoreCase(tituloBuscado)) {
                System.out.println(peliculas[i].toString());
                encontrada = true;
                break;
            }
        }

        if (!encontrada) {
            System.out.println("No se encontró ninguna película con ese título.");
        }
    }

    // 5. Buscar películas con presupuesto máximo (muestra títulos)
    public void buscarPelisPorPresupuestoMaximo(double maxPresupuesto) {
        boolean alguna = false;

        for (int i = 0; i < contador; i++) {
            if (peliculas[i].getPresupuesto() <= maxPresupuesto) {
                System.out.println(peliculas[i].getTitulo());
                alguna = true;
            }
        }

        if (!alguna) {
            System.out.println("No hay películas con ese presupuesto máximo o inferior.");
        }
    }
}
