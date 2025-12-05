/**
 * @author ManuelPerez
 * @version 1.0
 */

package Objetos.Objetos1.Ejercicio4;

import Objetos.Objetos1.Ejercicio4.Exceptions.PExcepcion;

import java.time.LocalDate;
import java.util.Scanner;

public class Persona {
    private String nombre;
    private LocalDate fechaNacimiento;
    private int dniNoLetra;
    private char sexo;
    private float altura;
    private float peso;

    Scanner sc = new Scanner(System.in);

    public Persona() throws PExcepcion {
    }

    public int getDniNoLetra() {
        return dniNoLetra;
    }

    public String dniEntero() {
        return String.valueOf(dniNoLetra) + getLetraDni();
    }

    public char getLetraDni() {
        String letrasDni = "TRWAGMYFPDXBNJZSQVHLCKE";
        int resto = getDniNoLetra() % 23;
        return letrasDni.charAt(resto);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public double getIMC() {
        return Math.round((peso/(altura*altura))*100)/100.000000;
    }

    public void setDniNoLetra(int dniNoLetra) {
        this.dniNoLetra = dniNoLetra;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {

    }


    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public void pedirInfoUsuario() throws PExcepcion {
        System.out.println("Introduzca el nombre: ");
        nombre = sc.nextLine();
        setNombre(nombre);

        System.out.println("DNI sin letra: ");
        dniNoLetra = sc.nextInt();
        setDniNoLetra(dniNoLetra);
        sc.nextLine(); //Pa que no me salte una excepción

        System.out.println("Introduzca su fecha de nacimiento (AÑO-MES-DÍA): ");
        String fecha = sc.nextLine();
        fechaNacimiento = LocalDate.parse(fecha);

        do {
            System.out.println("Cual es tu sexo (H/M) ?");
            sexo = sc.next().toUpperCase().charAt(0);
        } while (sexo != 'H' && sexo != 'M');
        setSexo(sexo);

        System.out.println("Introduzca el peso (kg): ");
        peso = sc.nextFloat();
        setPeso(peso);

        System.out.println("Introduzca la altura (m): ");
        altura = sc.nextFloat();
        setAltura(altura);
    }


    @Override
    public String toString() {
        return "====================================" +
                "\nNombre = " + getNombre() +
                "\nFecha de Nacimiento = " + getFechaNacimiento() +
                "\nDni = " + dniEntero() +
                "\nSexo = " + getSexo() +
                "\nAltura = " + getAltura() + " m" +
                "\nPeso = " + getPeso() + " kg" +
                "\nIMC = " + getIMC() +
                "\n====================================";
    }
}
