/**
 * @author ManuelPerez
 * @version 1.0
 */

package pruebas.lambdas.a;

import java.util.ArrayList;
import java.util.Collections;

public class a {

    static void main(String[] args) {

        ArrayList<String> luchadores = new ArrayList<>();

        luchadores.add("Ryu");
        luchadores.add("Chun-Li");
        luchadores.add("Ken");
        luchadores.add("Dhalsim");

        Collections.sort(luchadores, (l1, l2) -> l1.length() - l2.length());
        System.out.println(luchadores);
    }
}
