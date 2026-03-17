/**
 * @author ManuelPerez
 * @version 1.0
 */

package colecciones;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionsPrueba {
    static void main(String[] args) {
        Collection<String> collections = new ArrayList<>();

        collections.add("Magnolias");
        collections.add("logfp");
        collections.add("Lolita's");
        collections.add("·");
        collections.add("fastidious");


        for (String collection : collections) {
            System.out.println(collection);
        }
    }
}
