/**
 * @author ManuelPerez
 * @version 1.0
 */

package pruebas.lambdas.d;

import java.util.*;

public class Main {
    static void main(String[] args) {

        Map<String, Set<Medico>> hospital =  new HashMap<>();
        Set<Medico> pediatras = new HashSet<>();

        pediatras.add(new Medico("123A", "Pablito", 13));
        pediatras.add(new Medico("123A", "Pablito", 13));
        pediatras.add(new Medico("456B", "Marta", 5));

        Set<Medico> cirujanos = new HashSet<>();
        cirujanos.add(new Medico("789C", "Dra. Martínez", 25));
        cirujanos.add(new Medico("321D", "Dr. Fernández", 10));

        hospital.put("Pediatras", pediatras);
        hospital.put("Cirujanos", cirujanos);

        obtenerVeteranos(hospital);
    }

    public static void obtenerVeteranos(Map<String, Set<Medico>> hospital) {
        List<Medico> todosLosMedicos = new ArrayList<>();

        for (Set<Medico> grupomedicos: hospital.values()) {
            todosLosMedicos.addAll(grupomedicos);
        }

        Collections.sort(todosLosMedicos, (m1, m2) -> m2.getAnosExperiencia() - m1.getAnosExperiencia());

        System.out.println(todosLosMedicos);
    }
}
