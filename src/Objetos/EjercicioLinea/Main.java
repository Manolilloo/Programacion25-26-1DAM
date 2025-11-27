/**
 * @author ManuelPerez
 * @version 1.0
 */

package Objetos.EjercicioLinea;

public class Main {
    static void main(String[] args) throws LineaException {
        Punto punto3 = new Punto(2, 2);
        Punto punto4 = new Punto(4, 4);
        Punto punto1 = new Punto(2, 2);
        Punto punto2 = new Punto(4, 4);
        Linea linea1 = new Linea(punto1, punto2);
        Linea linea2 = new Linea(punto3, punto4);

        if (linea1.equals(linea2)) {
            System.out.println("SoWWn iguales.");
        } else {
            System.out.println("No son iguales");
        }

        try {
            linea1.moverArriba(1);
        } catch (LineaException e) {
            System.out.println(e.getMessage());
        }

        if (linea1.equals(linea2)) {
            System.out.println("Son iguales.");
        } else {
            System.out.println("No son iguales");
        }
    }
}
