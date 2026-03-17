/**
 * @author ManuelPerez
 * @version 1.0
 */

package pruebas.colecciones_chill.ejercicio6;

import java.util.HashMap;

public class Main {

    static void main(String[] args) {
        HashMap<Integer, String> taquillas =  new HashMap<>();

        taquillas.put(101, "Ana");
        taquillas.put(102, "Luis");
        taquillas.put(103, "Pedro");

        //El error de la misma taquilla

        taquillas.put(102, "Roberto");

        System.out.println(taquillas.get(102));

    }




}
