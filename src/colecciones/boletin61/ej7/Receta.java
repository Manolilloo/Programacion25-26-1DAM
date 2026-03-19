/**
 * @author ManuelPerez
 * @version 1.0
 */

package colecciones.boletin61.ej7;

import java.util.*;

public class Receta {

    private String nombre;
    private int duracionMinutos;
    private Set<Ingrediente> ingredientes;
    private List<String> pasos;


    public Receta(String nombre, int duracionMinutos) {
        this.nombre = nombre;
        this.duracionMinutos = duracionMinutos;
        ingredientes = new HashSet<>();
        pasos = new LinkedList<>();
    }


    public void addPaso(String paso) {
        pasos.add(paso);
    }

    public void addPasoDetrasDe(String pasoNuevo, String pasoExistente) throws RecetaException {
        int posicionElemento = pasos.indexOf(pasoExistente);

        if (posicionElemento != -1) {
            pasos.set(posicionElemento + 1, pasoNuevo);
        } else throw new RecetaException("El paso especificado no existe");
    }

    public void addIngrediente(Ingrediente ingredienteNuevo) {
        if (!ingredientes.add(ingredienteNuevo)) {
            for (Ingrediente ingrediente : ingredientes) {
                if (ingrediente.equals(ingredienteNuevo)) {
                    ingrediente.setCantidad(ingrediente.getCantidad() + ingredienteNuevo.getCantidad());
                }
            }
        }
    }

    public void borrarIngrediente(Ingrediente ingredienteBorrar) throws RecetaException {
        if (ingredientes.remove(ingredienteBorrar)) {
            Iterator<String> iterator = pasos.iterator();
            while (iterator.hasNext()) {
                String paso = iterator.next();
                if (paso.contains(ingredienteBorrar.getNombre())) {
                    iterator.remove();
                }
            }
        } else throw new RecetaException("El ingrediente no existe");
    }
}
