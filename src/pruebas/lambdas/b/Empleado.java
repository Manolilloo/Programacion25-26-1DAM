/**
 * @author ManuelPerez
 * @version 1.0
 */

package pruebas.lambdas.b;

public class Empleado {

    private String nombre;
    private double salario;

    public String getNombre() {
        return nombre;
    }

    public double getSalario() {
        return salario;
    }

    public Empleado(String nombre, double salario) {
        this.nombre = nombre;
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre +
        "\n" + ", Salario: " + salario;
    }
}
