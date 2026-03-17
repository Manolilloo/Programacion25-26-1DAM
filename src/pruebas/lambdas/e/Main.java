/**
 * @author ManuelPerez
 * @version 1.0
 */

package pruebas.lambdas.e;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    static void main(String[] args) {

        List<Esper> registro = new ArrayList<>();
        registro.add(new Esper("Mob", 100, false));
        registro.add(new Esper("Reigen", 1, false));
        registro.add(new Esper("Teru", 85, false));
        registro.add(new Esper("Toichiro", 95, true));

// Datos para el Ejercicio 2
        List<Atleta> club = new ArrayList<>();
        club.add(new Atleta("Musashi", 95));
        club.add(new Atleta("Mob", 15));
        club.add(new Atleta("Onigawara", 80));
        club.add(new Atleta("Goda", 98));

        System.out.println("Los que no son villanos y tienen mas de 80 de poder son: " + contarAptos(registro));

        System.out.println("Ahora los del club que tengan buena resistencia: " + club.stream().filter(a -> a.getResistencia() >= 90)
                .map(Atleta::getNombre).sorted().collect(Collectors.toList()));

    }

    public static long contarAptos(List<Esper> lista){
        return lista.stream().filter(noVillanos -> !noVillanos.isVillano()).filter(a -> a.getNivelPoder() > 80).count();
    }
}
// --- CLASES EXTERNAS ---

class Esper {
    private String nombre;
    private int nivelPoder;
    private boolean esVillano;

    public Esper(String nombre, int nivelPoder, boolean esVillano) {
        this.nombre = nombre;
        this.nivelPoder = nivelPoder;
        this.esVillano = esVillano;
    }

    public int getNivelPoder() { return nivelPoder; }
    public boolean isVillano() { return esVillano; }
}

class Atleta {
    private String nombre;
    private int resistencia;

    public Atleta(String nombre, int resistencia) {
        this.nombre = nombre;
        this.resistencia = resistencia;
    }

    public String getNombre() { return nombre; }
    public int getResistencia() { return resistencia; }
}

