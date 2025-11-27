/**
 * @author ManuelPerez
 * @version 1.0
 */

package Objetos.EjercicioProducto;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.random.RandomGenerator;

public class Producto {
    private int CODIGO;
    private String descripcion = "Jamon para Bermudo";
    private static double iva = 0.2;
    private double precio = 99.999;

    public Producto(double precio, int CODIGO, String descripcion) {
        this.CODIGO = CODIGO;
        this.descripcion = descripcion;
        this.precio = precio * iva;
    }

    public double getCODIGO() {
        return CODIGO;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void consulta() {
        System.out.println(toString());
    }


    public void modificarAtributos(int CODIGO, String descripcion, double precio) {
        System.out.println("El nuevo código es: " + CODIGO + "\nLa nueva descripción es: " + descripcion + "\nEl nuevo precio es: " + precio);
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio, double iva) {
        this.precio = precio * iva;
    }

    @Override
    public String toString() {
        return "====Producto====" +
                "\nPrecio: " + precio + "€" +
                "\nCódigo del producto: " + CODIGO +
                "\nDescripción producto: " + descripcion;

    }
}
