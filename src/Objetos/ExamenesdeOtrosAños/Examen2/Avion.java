/**
 * @author ManuelPerez
 * @version 1.0
 */

package Objetos.ExamenesdeOtrosAños.Examen2;

import java.time.LocalDate;

public class Avion {
    private String marca;
    private String modelo;
    private double consumo;
    private DepositoComb deposito;
    private RegistroRevisiones registro;


    public Avion(String marca, String modelo, double consumo, DepositoComb deposito, RegistroRevisiones registro) {
        this.marca = marca;
        this.modelo = modelo;
        this.consumo = consumo;
        this.deposito = deposito;
        this.registro = registro;
    }

    @Override
    public String toString() {
        return "Avion:" +
                "\nMarca='" + marca +
                "\nModelo='" + modelo +
                "\nConsumo=" + consumo +
                "\nDeposito=" + deposito +
                "\nRegistro=" + registro;
    }
}
