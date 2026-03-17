/**
 * @author ManuelPerez
 * @version 1.0
 */

package colecciones.boletin61.ej5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Diccionario {

    private Map<String, List<String>> mapa;

    public Diccionario() {
        this.mapa = new HashMap<>();
    }

    public void addPalabra(String palabra, String significado) {
        if (!mapa.containsKey(palabra)) {
            mapa.put(palabra, new ArrayList<>());
        }
        mapa.get(palabra).add(significado);
    }

    public List<String> buscarPalabra(String palabra) {
        return mapa.get(palabra);
    }

    public void borrarPalabra(String palabra) {
        mapa.remove(palabra);
    }

    public List<String> listadoPalabras(String comienzaPor) {
        List<String> resultado = new ArrayList<>();

        for (String clave : mapa.keySet()) {
            if (clave.startsWith(comienzaPor)) {
                resultado.add(clave);
            }
        }

        Collections.sort(resultado);

        return resultado;
    }
}
