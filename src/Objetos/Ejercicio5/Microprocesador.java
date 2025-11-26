/**
 * @author ManuelPerez
 * @version 1.0
 */

package Objetos.Ejercicio5;

public class Microprocesador {

    private String marca, modelo, socket;
    private int numNucleos;
    private float vBase;

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

    public String getSocket() {
        return socket;
    }

    public void setSocket(String socket) {
        this.socket = socket;
    }

    public int getNumNucleos() {
        return numNucleos;
    }

    public void setNumNucleos(int numNucleos) {
        this.numNucleos = numNucleos;
    }

    public float getvBase() {
        return vBase;
    }

    public void setvBase(float vBase) {
        this.vBase = vBase;
    }

    public Microprocesador(){
    }

}
