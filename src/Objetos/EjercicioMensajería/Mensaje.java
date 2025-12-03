package Objetos.EjercicioMensajería;

import java.time.LocalDate;

public class Mensaje {
    private String asunto;
    private String cuerpo;
    private LocalDate fechaEnvio;
    private Persona remitente;
    private Persona destinatario;

    public Mensaje(String asunto, String cuerpo, Persona destinatario) {
        this.asunto = asunto;
        this.cuerpo = cuerpo;
        this.destinatario = destinatario;
    }

    public String getAsunto() {
        return asunto;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public LocalDate getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(LocalDate fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public Persona getRemitente() {
        return remitente;
    }

    public void setRemitente(Persona remitente) {
        this.remitente = remitente;
    }

    public Persona getDestinatario() {
        return destinatario;
    }

    @Override
    public String toString() {
        return "Mensaje{" +
                "asunto='" + asunto + '\'' +
                ", cuerpo='" + cuerpo + '\'' +
                ", fechaEnvio=" + fechaEnvio +
                ", remitente=" + (remitente != null ? remitente.getNombre() : "null") +
                ", destinatario=" + (destinatario != null ? destinatario.getNombre() : "null") +
                '}';
    }
}
