/**
 * @author ManuelPerez
 * @version 1.0
 */

package pruebas.colecciones_chill.ejercicio2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Principal {

    static void main(String[] args) {

        List<Cancion> playlist = new ArrayList<>();
        playlist.add(new Cancion("Mi Diablita, Hidalgo", 292));
        playlist.add(new Cancion("Bebita, Hidalgo", 125));
        playlist.add(new Cancion("Contando Lunares", 390));
        playlist.add(new Cancion("Torrente Presidente, la cancion", 294));


        Collections.sort(playlist);

        System.out.println("Canciones mal: " + playlist);

        Collections.sort(playlist, new Comparator<Cancion>() {
            @Override
            public int compare(Cancion o1, Cancion o2) {
                return Integer.compare(o2.getDuracion(), o1.getDuracion());
            }
        });

        System.out.println("Canciones por duracion: " + playlist);

    }

}
