/**
 * @author ManuelPerez
 * @version 1.0
 */

package colecciones.boletin61.ej1;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== DEMO CLASE EQUIPO<Alumno> ===\n");

        // Crear alumnos
        Alumno ana = new Alumno("Ana García", "12345678A");
        Alumno luis = new Alumno("Luis Pérez", "87654321B");
        Alumno pedro = new Alumno("Pedro López", "11223344C");
        Alumno ana2 = new Alumno("Ana García", "12345678A"); // Duplicado

        // Equipo 1
        Set<Alumno> alumnos1 = new HashSet<>();
        alumnos1.add(ana);
        alumnos1.add(luis);
        Equipo<Alumno> equipo1 = new Equipo<>("Equipo ROJO", alumnos1);

        // Equipo 2
        Set<Alumno> alumnos2 = new HashSet<>();
        alumnos2.add(luis);
        alumnos2.add(pedro);
        Equipo<Alumno> equipo2 = new Equipo<>("Equipo AZUL", alumnos2);

        // === MOSTRAR ALUMNOS ===
        System.out.println("Equipo ROJO:");
        mostrarAlumnos(equipo1);

        System.out.println("\nEquipo AZUL:");
        mostrarAlumnos(equipo2);

        // === AÑADIR ALUMNO ===
        System.out.println("\n--- AÑADIENDO alumnos ---");
        try {
            equipo1.añadirAlumno(pedro);           // ✅ Nuevo
            System.out.println("Pedro añadido a ROJO ✓");

            equipo1.añadirAlumno(ana2);            // ❌ Duplicado
        } catch (EquipoException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // === BUSCAR ALUMNO ===
        System.out.println("\n--- BUSCANDO alumnos ---");
        Alumno encontrado = equipo1.buscarAlumno(luis);
        System.out.println("Luis encontrado: " + encontrado);

        // === BORRAR ALUMNO ===
        System.out.println("\n--- BORRANDO Luis ---");
        try {
            equipo1.borrarAlumno(luis);
            System.out.println("Luis borrado ✓");
        } catch (EquipoException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // === UNIÓN DE EQUIPOS ===
        System.out.println("\n--- UNIÓN DE EQUIPOS ---");
        Equipo<Alumno> union = equipo1.unirEquipos(equipo2);
        mostrarAlumnos(union);

        // === INTERSECCIÓN DE EQUIPOS ===
        System.out.println("\n--- INTERSECCIÓN (alumnos comunes) ---");
        Equipo<Alumno> comunes = equipo1.interseccionEquipos("COMUNES", equipo2);
        mostrarAlumnos(comunes);

        System.out.println("\n=== FIN DEMO ✓ ===");
    }

    private static void mostrarAlumnos(Equipo<Alumno> equipo) {
        List<Alumno> lista = equipo.mostrarAlumnos();
        System.out.println(equipo);
        lista.forEach(alumno -> System.out.println("  → " + alumno));
        System.out.println();
    }
}

