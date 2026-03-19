/**
 * @author ManuelPerez
 * @version 1.0
 */

package colecciones.boletin61.ej6;

import java.util.LinkedList;
import java.util.Queue;

public class Caja {

    private int id;
    private boolean estaAbierta;
    private Queue<Cliente> clientes;

    public Caja(int id, boolean estaAbierta, Queue<Cliente> clientes) {
        this.id = id;
        
        clientes = new LinkedList<>();
    }


}
