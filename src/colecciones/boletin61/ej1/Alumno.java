/**
 * @author ManuelPerez
 * @version 1.0
 */

package colecciones.boletin61.ej1;

public class Alumno {

    private String nombre;
    private String DNI;

    public Alumno(String nombre, String DNI) {
        this.nombre = nombre;
        this.DNI = DNI;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "nombre='" + nombre + '\'' +
                ", DNI='" + DNI + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Alumno alumno = (Alumno) o;
        return nombre.equals(alumno.nombre) && DNI.equals(alumno.DNI);
    }

    @Override
    public int hashCode() {
        int result = nombre.hashCode();
        result = 31 * result + DNI.hashCode();
        return result;
    }
}
