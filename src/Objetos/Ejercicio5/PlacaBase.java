/**
 * @author ManuelPerez
 * @version 1.0
 */

package Objetos.Ejercicio5;

import Objetos.Ejercicio5.Exceptions.PCEX;

import java.util.Scanner;

public class PlacaBase {

    private String marca, chipset, socket;


    public boolean compatibleSocket(Microprocesador microprocesador, Scanner sc) throws PCEX {
        if (socket.equalsIgnoreCase(microprocesador.getSocket())) return true;
        do {
            throw new PCEX("El socket debe ser el mismo en placa base y \nmicroprocesador para que sean compatibles.");
        } while (!socket.equalsIgnoreCase(microprocesador.getSocket()));
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getChipset() {
        return chipset;
    }

    public void setChipset(String chipset) {
        this.chipset = chipset;
    }

    public String getSocket() {
        return socket;
    }

    public void setSocket(String socket) {
        this.socket = socket;
    }
}
