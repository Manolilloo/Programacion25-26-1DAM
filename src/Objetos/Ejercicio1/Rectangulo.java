package Objetos.Ejercicio1;

public class Rectangulo {
    private double longitud;
    private double ancho;

    public Rectangulo(){
        longitud = 1;
        ancho = 1;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        if (longitud > 0 && longitud < 20) {
            this.longitud = longitud;
        } else {
            System.out.println("Error. Numero no válido");
        }
    }

    public double getAncho() {
        return ancho;
    }

    public void setAncho(double ancho) {
        if (ancho > 0 && ancho < 20) {
            this.ancho = ancho;
        } else {
            System.out.println("Error. Número no válido");
        }
    }

    public double calcularPerimetro() {
        return 2 * (longitud + ancho);
    }

    public double calcularArea() {
        return longitud * ancho;
    }
}