/**
 * @author ManuelPerez
 * @version 1.0
 */

package pruebas.colecciones_chill.ejercicio3;

import java.util.HashMap;

public class Principal {

    static void main(String[] args) {

        HashMap<String, String> agenda =  new HashMap<>();

        agenda.put("111A", "Laura");
        agenda.put("222B", "Carlos");
        agenda.put("333C", "Marta");

        System.out.println("Agenda principal: " + agenda);

        agenda.put("222B", "Carlos Alberto");

        System.out.println("EL dni de 222B pertenece ahora a : " + agenda.get("222B"));

        for (String key : agenda.keySet()) {

            System.out.println(key + "-" + agenda.get(key));
        }
    }
}
