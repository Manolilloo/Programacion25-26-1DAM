package pruebas.colecciones_chill.ejercicio1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TiendaFriki {
    public static void main(String[] args) {

        List<Videojuego> catalogo = new ArrayList<>();
        catalogo.add(new Videojuego("Zelda", 100));
        catalogo.add(new Videojuego("Gollum", 30));
        catalogo.add(new Videojuego("Cyberpunk", 85));

        System.out.println("1. Orden de llegada: " + catalogo);

        // --- ORDEN NATURAL (Comparable) ---
        // Al llamar a sort, Java busca automáticamente el método compareTo[cite: 255, 269].
        Collections.sort(catalogo);
        System.out.println("2. Orden por Puntuación (Natural): " + catalogo);
        // Resultado: [Gollum (30), Cyberpunk (85), Zelda (100)]


        // --- ÁRBITRO EXTERNO (Comparator) ---
        // Le pasamos la lista Y ADEMÁS un árbitro con las nuevas reglas[cite: 271, 272, 346].
        Collections.sort(catalogo, new Comparator<Videojuego>() {
            @Override
            public int compare(Videojuego o1, Videojuego o2) {
                return o2.getTitulo().compareTo(o1.getTitulo());
            }
        });

        System.out.println("3. Orden Alfabético (Comparator): " + catalogo);
        // Resultado: [Cyberpunk (85), Gollum (30), Zelda (100)]
    }
}