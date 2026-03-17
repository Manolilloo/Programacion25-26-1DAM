/**
 * @author ManuelPerez
 * @version 1.0
 */

package pruebas.lambdas.h;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// --- CLASE EXTERNA ---
class Cazador {
    private String nombre;
    private String rango;
    private int nivelPoder;
    private String gremio;

    public Cazador(String nombre, String rango, int nivelPoder, String gremio) {
        this.nombre = nombre;
        this.rango = rango;
        this.nivelPoder = nivelPoder;
        this.gremio = gremio;
    }

    public String getNombre() { return nombre; }
    public String getRango() { return rango; }
    public int getNivelPoder() { return nivelPoder; }
    public String getGremio() { return gremio; }

    @Override
    public String toString() {
        return nombre + " (Rango " + rango + ")";
    }
}

public class AsociacionCazadores {
    public static void main(String[] args) {

        // --- DATOS PARA EL MAIN ---
        List<Cazador> asociacion = new ArrayList<>();
        asociacion.add(new Cazador("Sung Jinwoo", "S", 99999, "Ahjin"));
        asociacion.add(new Cazador("Yoo Jinho", "D", 150, "Ahjin"));
        asociacion.add(new Cazador("Cha Hae-In", "S", 8500, "Cazadores"));
        asociacion.add(new Cazador("Choi Jong-In", "S", 8000, "Cazadores"));
        asociacion.add(new Cazador("Baek Yoonho", "S", 8200, "Tigre Blanco"));
        asociacion.add(new Cazador("Lee Joohee", "B", 1200, "Ninguno"));

        // --- ¡Escribe aquí tus Streams! ---

        List<String> escuadron = asociacion.stream()
                .sorted((c1, c2) -> c2.getNivelPoder() - c1.getNivelPoder())
                .skip(2)
                .limit(3)
                .map(Cazador::getNombre)
                .collect(Collectors.toList());
        System.out.println("Escuadrón asignado: " + escuadron);

        Map<String, List<Cazador>> directorio = asociacion.stream()
                .collect(Collectors.groupingBy(Cazador::getGremio));

        for (Map.Entry<String, List<Cazador>> entry : directorio.entrySet()) {
            System.out.println("Gremio " + entry.getKey() + ": " + entry.getValue());
        }
    }
}