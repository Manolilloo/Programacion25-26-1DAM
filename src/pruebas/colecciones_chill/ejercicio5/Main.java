/**
 * @author ManuelPerez
 * @version 1.0
 */

package pruebas.colecciones_chill.ejercicio5;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static void main(String[] args) {

        Queue<String> documentos =  new LinkedList<>();

        documentos.add("Doc1");
        documentos.add("Doc2");
        documentos.add("Doc3");

        while (!documentos.isEmpty()) {
            String documento = documentos.poll();

            System.out.println("Imprimiendo: "  + documento);
        }
    }
}
