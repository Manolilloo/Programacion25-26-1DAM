/**
 * @author ManuelPerez
 * @version 1.0
 */

package pruebas.colecciones_chill.ejercicio4;

import java.util.HashMap;
import java.util.Map;

public class Principal {

    static void main(String[] args) {

        HashMap<String, Integer> diccionario = new HashMap<>(); //clave = DNI ; valor = edad

        diccionario.put("34102W", 34);
        diccionario.put("27967U", 22);
        diccionario.put("34497Q", 16);
        diccionario.put("74567P", 59);


        for (Map.Entry<String, Integer> valoresYLlaves : diccionario.entrySet()) {

            String key = valoresYLlaves.getKey();
            Integer valor = valoresYLlaves.getValue();

            System.out.println("El cuidadano con DNI " + key + " tiene " + valor + " años.");
        }

    }
}

