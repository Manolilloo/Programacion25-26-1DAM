/**
 * @author ManuelPerez
 * @version 1.0
 */

package colecciones.boletin61.ej1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Equipo<T> {

    private String nombre;
    private Set<T> alumnos;

    /**
     * Constructor corregido: usa el parámetro union
     */
    public Equipo(String nombre, Set<T> union) {
        this.nombre = nombre;
        this.alumnos = new HashSet<>();
        if (union != null) {
            this.alumnos.addAll(union);
        }
    }

    /**
     * Añade un alumno al equipo
     */
    public void añadirAlumno(T alumno) throws EquipoException {
        if (!alumnos.add(alumno)) {
            throw new EquipoException("No se ha podido añadir el alumno (ya existe).");
        }
    }

    /**
     * Borra un alumno del equipo
     */
    public void borrarAlumno(T alumno) throws EquipoException {
        if (!alumnos.remove(alumno)) {
            throw new EquipoException("El alumno no pertenece al equipo.");
        }
    }

    /**
     * Busca un alumno en el equipo
     */
    public T buscarAlumno(T alumno) {
        if (!alumnos.contains(alumno)) {
            return null;
        }
        return alumno;
    }

    /**
     * Devuelve lista de alumnos
     */
    public List<T> mostrarAlumnos() {
        return new ArrayList<>(alumnos);
    }

    /**
     * Une dos equipos (UNION)
     */
    public Equipo<T> unirEquipos(Equipo<T> equipo) {
        Set<T> union = new HashSet<>(alumnos);
        union.addAll(equipo.alumnos);
        return new Equipo<>(nombre + " U " + equipo.nombre, union);
    }

    /**
     * Intersección de dos equipos (elementos comunes)
     */
    public Equipo<T> interseccionEquipos(String nombreNuevo, Equipo<T> equipo2) {
        Set<T> interseccion = new HashSet<>(alumnos);
        interseccion.retainAll(equipo2.alumnos);  // ✅ Método correcto para intersección
        return new Equipo<>(nombreNuevo, interseccion);
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public Set<T> getAlumnos() {
        return new HashSet<>(alumnos);  // Devuelve copia para evitar modificación externa
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "nombre='" + nombre + '\'' +
                ", alumnos=" + alumnos +
                '}';
    }
}
