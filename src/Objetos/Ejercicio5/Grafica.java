/**
 * @author ManuelPerez
 * @version 1.0
 */

package Objetos.Ejercicio5;

import java.net.Socket;

public class Grafica {

    private String marca, modelo;
    private int numNucleos, memoriaGB;
    private float vEnGHz;

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getNumNucleos() {
        return numNucleos;
    }

    public void setNumNucleos(int numNucleos) {
        this.numNucleos = numNucleos;
    }

    public int getMemoriaGB() {
        return memoriaGB;
    }

    public void setMemoriaGB(int memoriaGB) {
        this.memoriaGB = memoriaGB;
    }

    public float getvEnGHz() {
        return vEnGHz;
    }

    public void setvEnGHz(float vEnGHz) {
        this.vEnGHz = vEnGHz;
    }
}
