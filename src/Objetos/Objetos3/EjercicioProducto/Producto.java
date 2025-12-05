/**
 * @author ManuelPerez
 * @version 1.0
 */

package Objetos.Objetos3.EjercicioProducto;

public class Producto {
    private int codigo;
    private String descripcion = "Jamon para Bermudo";
    private static double iva = 0.2;
    private double precio = 99.999;

    public Producto(double precio, int codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio * iva;
    }

    public double getCodigo() {
        return codigo;
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
                "\nCódigo del producto: " + codigo +
                "\nDescripción producto: " + descripcion;

    }
}
