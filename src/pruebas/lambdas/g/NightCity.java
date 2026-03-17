/**
 * @author ManuelPerez
 * @version 1.0
 */

package pruebas.lambdas.g;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// --- CLASES EXTERNAS ---
class Edgerunner {
    private String nombre;
    private int implantesActuales;
    private int toleranciaCibernetica;

    public Edgerunner(String nombre, int implantesActuales, int toleranciaCibernetica) {
        this.nombre = nombre;
        this.implantesActuales = implantesActuales;
        this.toleranciaCibernetica = toleranciaCibernetica;
    }

    public String getNombre() {
        return nombre;
    }

    public int getImplantesActuales() {
        return implantesActuales;
    }

    public int getToleranciaCibernetica() {
        return toleranciaCibernetica;
    }
}

class ArchivoArasaka {
    private String nombreDoc;
    private int nivelSeguridad;
    private int valorEurodolares;

    public ArchivoArasaka(String nombreDoc, int nivelSeguridad, int valorEurodolares) {
        this.nombreDoc = nombreDoc;
        this.nivelSeguridad = nivelSeguridad;
        this.valorEurodolares = valorEurodolares;
    }

    public String getNombreDoc() {
        return nombreDoc;
    }

    public int getNivelSeguridad() {
        return nivelSeguridad;
    }

    public int getValorEurodolares() {
        return valorEurodolares;
    }
}

public class NightCity {
    public static void main(String[] args) {

        // Datos para el Ejercicio 1
        List<Edgerunner> equipo = new ArrayList<>();
        equipo.add(new Edgerunner("David", 12, 15));
        equipo.add(new Edgerunner("Maine", 25, 20)); // ¡Peligro!
        equipo.add(new Edgerunner("Lucy", 3, 10));
        equipo.add(new Edgerunner("Rebecca", 8, 12));

        // Datos para el Ejercicio 2
        List<ArchivoArasaka> servidor = new ArrayList<>();
        servidor.add(new ArchivoArasaka("Planos_Relic", 10, 50000));
        servidor.add(new ArchivoArasaka("Rutas_Patrulla", 3, 2000));
        servidor.add(new ArchivoArasaka("Cuentas_Bancarias", 8, 150000));
        servidor.add(new ArchivoArasaka("Planos_Relic", 10, 50000)); // Duplicado en el sistema
        servidor.add(new ArchivoArasaka("Diario_CEO", 9, 75000));

        // --- ¡Escribe aquí tus Streams! ---

        boolean peligroCritico = equipo.stream()
                .anyMatch(a -> a.getImplantesActuales() > a.getToleranciaCibernetica());

        System.out.println("Hay riesgo de cyberpsicosis en el team? " + peligroCritico);

        boolean equipoCibernetico = equipo.stream()
                .allMatch(a -> a.getImplantesActuales() >= 1);

        System.out.println("¿Todos tienen implante? " + equipoCibernetico);

        Edgerunner masResistente = equipo.stream()
                .max((e1, e2) -> e1.getToleranciaCibernetica() - e2.getToleranciaCibernetica())
                .get();
        System.out.println("El miembro más tolerante al cromo es: " + masResistente.getNombre()); // Maine

        //EJ2

        List<String> nombresArchivosValiosos = servidor.stream()
                .filter(a -> a.getNivelSeguridad() >= 8)
                .map(ArchivoArasaka::getNombreDoc)
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        System.out.println("Archivos hackeados: " + nombresArchivosValiosos);

        int botinTotal = servidor.stream()
                .filter(a -> a.getNivelSeguridad() >= 8)
                .map(ArchivoArasaka::getValorEurodolares)
                .distinct()
                .reduce(0, (a, b) -> a + b);

        System.out.println("Botín estimado: " + botinTotal + " Eurodólares");

    }


}