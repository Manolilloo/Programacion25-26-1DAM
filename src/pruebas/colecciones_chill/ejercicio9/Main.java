/**
 * @author ManuelPerez
 * @version 1.0
 */

package pruebas.colecciones_chill.ejercicio9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    static void main(String[] args) {
        ArrayList<String> alumnosJava = new ArrayList<>();
        ArrayList<String> alumnosPython = new ArrayList<>();
        HashMap<String, List<String>> academia = new HashMap<>();

        alumnosJava.add("Pablo");
        alumnosJava.add("Marina");
        alumnosJava.add("Manuel");
        alumnosJava.add("Javier");

        alumnosPython.add("Nuria");
        alumnosPython.add("Candela");
        alumnosPython.add("Daniel");
        alumnosPython.add("Ana");


        academia.put("Java", alumnosJava);
        academia.put("Python", alumnosPython);

        System.out.println(academia);

        for (Map.Entry<String, List<String>> entry : academia.entrySet()) {
            System.out.println("En el curso " + entry.getKey() + " están matriculados " + entry.getValue());
        }
    }
}
