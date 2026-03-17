/**
 * @author ManuelPerez
 * @version 1.0
 */

package pruebas.colecciones_chill.ejercicio10;

import java.util.Deque;
import java.util.LinkedList;

public class Main {

    static void main(String[] args) {

        Deque<String> puertaEmbarque = new LinkedList<>();

        puertaEmbarque.offerLast("Pasajero Turista A");
        puertaEmbarque.offerLast("Pasajero Turista B");

        //pasajero VIP

        puertaEmbarque.offerFirst("Pasajero Turista VIP");

        System.out.println(puertaEmbarque);

        for (String puerta : puertaEmbarque) {
            System.out.println("El primero que pasa es " + puerta);
        }
    }
}
