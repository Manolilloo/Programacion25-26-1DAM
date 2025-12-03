/**
 * @author ManuelPerez
 * @version 1.0
 */

package Objetos.EjercicioCartas;

public class Juego {
    public static final int TAMAÑO_BARAJA = 52;

    String[] barajaCartas = {"As", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    String[] palo = {"Corazones", "Diamante", "Picas", "Tréboles"};

    private String repartirCarta(int numJugadores, int numCartas){
        for (int i = 1; i <= numJugadores ; i++) {
            for (int j = 0; i < numCartas; i++) {
                for (int k = 0; k < barajaCartas.length; k++) {


                }
            }
        }
        return "";
    }
}