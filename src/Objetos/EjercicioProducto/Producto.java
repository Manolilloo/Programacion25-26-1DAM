/**
 * @author ManuelPerez
 * @version 1.0
 */

package Objetos.EjercicioProducto;

import java.util.Random;
import java.util.random.RandomGenerator;

public class Producto {
    private int CODIGO = 123129;
    private String descripcion = "Jamon para Bermudo";
    private static double iva;
    private double precio = 999.999;

    public Producto(double precio, int CODIGO, String descripcion, double iva) {
        this.CODIGO = CODIGO;
        this.descripcion = descripcion;
        this.precio = precio;
        this.iva = 0.2;
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
        System.out.println("El nuevo código es: " + CODIGO + "\nLa nueva descripción es: " + descripcion +"\nEl nuevo precio es: "+precio);
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
        return "Producto{" +
                "CODIGO=" + CODIGO +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                '}';
    }
}
