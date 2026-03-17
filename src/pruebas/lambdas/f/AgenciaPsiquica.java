/**
 * @author ManuelPerez
 * @version 1.0
 */

package pruebas.lambdas.f;

import java.util.ArrayList;
import java.util.List;

// --- CLASES EXTERNAS ---
class Telepata {
    private String nombre;

    public Telepata(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}

class Villano {
    private String nombre;
    private int nivelPoder;

    public Villano(String nombre, int nivelPoder) {
        this.nombre = nombre;
        this.nivelPoder = nivelPoder;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNivelPoder() {
        return nivelPoder;
    }
}

public class AgenciaPsiquica {
    public static void main(String[] args) {

        // Datos para el Ejercicio 3
        List<Telepata> clubTelepatia = new ArrayList<>();
        clubTelepatia.add(new Telepata("Kurata"));
        clubTelepatia.add(new Telepata("Inukawa"));
        clubTelepatia.add(new Telepata("Kurata")); // Duplicado intencional
        clubTelepatia.add(new Telepata("Shiratori"));
        clubTelepatia.add(new Telepata("Takenaka"));
        clubTelepatia.add(new Telepata("Inukawa")); // Duplicado intencional

        // Datos para el Ejercicio 4
        List<Villano> garra = new ArrayList<>();
        garra.add(new Villano("Koyama", 70));
        garra.add(new Villano("Sakurai", 75));
        garra.add(new Villano("Toichiro", 99));
        garra.add(new Villano("Serizawa", 90));

        // --- ¡Escribe aquí tus Streams! ---

        clubTelepatia.stream().map(Telepata::getNombre)
                .distinct()
                .sorted()
                .forEach(System.out::println);

        long poderTotal = garra.stream()
                .map(Villano::getNivelPoder)
                .reduce(0, (a, b) -> a + b);

        System.out.println(poderTotal);
    }
}
