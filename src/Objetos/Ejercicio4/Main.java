/**
 * @author ManuelPerez
 * @version 1.0
 */

package Objetos.Ejercicio4;

import Objetos.Ejercicio4.Exceptions.PExcepcion;

import java.util.Scanner;

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
