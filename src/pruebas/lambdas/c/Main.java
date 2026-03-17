/**
 * @author ManuelPerez
 * @version 1.0
 */

package pruebas.lambdas.c;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static void main(String[] args) {

        HashMap<String, Libro>  libros = new HashMap<>();

        libros.put("111A", new Libro("111A", "El Hobbit", 300));
        libros.put("222B", new Libro("222B", "Las Cronicas de Narnia", 678));
        libros.put("333C", new Libro("333C", "Harry Potter y el Caliz de Fuego", 234));

        librosMasLargos(libros);
    }

    public static void librosMasLargos(Map<String, Libro> libros) {
        ArrayList<Libro> librosMasLargos = new ArrayList<>(libros.values());
        Collections.sort(librosMasLargos,  (l1, l2) -> l2.getPaginas() - l1.getPaginas());
        System.out.println("Libros ordenados de mayor numero de paginas al que menos tenga: \n============================================================" +
                librosMasLargos);
    }
}
