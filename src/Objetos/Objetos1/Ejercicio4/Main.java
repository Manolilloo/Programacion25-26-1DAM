/**
 * @author ManuelPerez
 * @version 1.0
 */

package Objetos.Objetos1.Ejercicio4;

import Objetos.Objetos1.Ejercicio4.Exceptions.PExcepcion;

public class Main {
    public static void main(String[] args) throws PExcepcion {
        Persona p = new Persona();

        try {
            p.pedirInfoUsuario();
            System.out.println(p);
        } catch (PExcepcion e) {
            System.out.println(e.getMessage());
        }
    }
}
