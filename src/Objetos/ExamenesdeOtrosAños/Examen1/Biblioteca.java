/**
 * @author ManuelPerez
 * @version 1.0
 */

package Objetos.ExamenesdeOtrosAños.Examen1;

import java.util.IdentityHashMap;

public class Biblioteca {
    private static final int CAPACIDAD_MAX = 20;
    Pelicula[] pelicula;
    private int contador;

    public Biblioteca() {
        pelicula = new Pelicula[CAPACIDAD_MAX];
        contador = 0;
    }

    private void añadirPelicula(Pelicula peli) throws PeliException {
        if (contador < CAPACIDAD_MAX) {
            pelicula[contador] = peli;
            contador++;
            System.out.println("Pelicula añadida correctamente");
        } else {
            throw new PeliException("No se ha podido añadir la pelicula...");
        }
    }

    private void consultarBiblioteca() throws PeliException {
        for (int i = 0; i < CAPACIDAD_MAX; i++) {
            System.out.println(pelicula[i].getTitulo());
        }
    }

    private void buscarPeliPorEtiquetas(String etiquetaBuscada) throws PeliException {
        boolean existe = false;
        for (int i = 0; i < CAPACIDAD_MAX; i++) {
            if (pelicula[i].getEtiqueta().contains(etiquetaBuscada)) {
                existe = true;
                break;
            }
        }
        if (!existe) {
            throw new PeliException("No se ha encontrado ninguna peli con esa etiqueta.");
        }
    }

    private void buscarPeliPorTitulo(String tituloBuscado) throws PeliException {
        boolean existe = false;
        for (int i = 0; i < CAPACIDAD_MAX; i++) {
            if (pelicula[i].getTitulo().contains(tituloBuscado)) {
                existe = true;
                break;
            }
        }
        if (!existe) {
            throw new PeliException("No se ha encontrado ninguna peli con ese titulo.");
        }
    }

    private void buscarPorPresupuestoMaximo(double presupuestoMax) {
        boolean existe = false;
        for (int i = 0; i < CAPACIDAD_MAX; i++) {
            if ()
        }
    }
}