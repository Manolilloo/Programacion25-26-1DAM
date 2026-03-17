/**
 * @author ManuelPerez
 * @version 1.0
 */

package pruebas.colecciones_chill.ejercicio7;

import java.util.HashMap;
import java.util.Map;

public class Main {

    static void main(String[] args) {
        /**
         * string el nombre del producto
         * integer el valor del mismo en centimos
         */
        HashMap<String, Integer> inventario = new HashMap<>();

        inventario.put("Leche", 120);
        inventario.put("Pan", 80);
        inventario.put("Huevos", 250);


        for (String key : inventario.keySet()) {
            System.out.println(key + " - " + inventario.get(key));
        }

        System.out.println("==============");

        for (Map.Entry<String, Integer> entry : inventario.entrySet()) {
            System.out.println("Producto: " + entry.getKey() + " - " + "Precio: " + entry.getValue());
        }
    }
}
