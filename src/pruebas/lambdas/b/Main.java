/**
 * @author ManuelPerez
 * @version 1.0
 */

package pruebas.lambdas.b;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static void main(String[] args) {
        ArrayList<Empleado> empleados = new ArrayList<>();

        empleados.add(new Empleado("Juan", 2893.45));
        empleados.add(new Empleado("Maria", 7541.34));
        empleados.add(new Empleado("Pedro", 2345.21));

        mostrarRanking(empleados);

    }

    public static void mostrarRanking(List<Empleado> empleados) {

        Collections.sort(empleados, (l1, l2) -> (int) (l2.getSalario() - l1.getSalario()));
        System.out.println(empleados);

    }
}
