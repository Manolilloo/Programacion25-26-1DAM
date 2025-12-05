/**
 * @author ManuelPerez
 * @version 1.0
 */

package Objetos.Objetos3.EjercicioMensajería;

import java.time.LocalDate;

public class Persona {
    private String nombre;
    private Mensaje[] mensajesRecibidos;
    private Mensaje[] mensajesEnviados;
    private int contadorRecibidos;
    private int contadorEnviados;
    private static final int CAPACIDAD_BUZON = 5;

    public Persona(String nombre) {
        this.nombre = nombre;
        this.mensajesRecibidos = new Mensaje[CAPACIDAD_BUZON];
        this.mensajesEnviados = new Mensaje[CAPACIDAD_BUZON];
        this.contadorRecibidos = 0;
        this.contadorEnviados = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean enviarMensaje(Mensaje mensaje) throws MensajeException {
        if (mensaje.getAsunto().isBlank()) {
            throw new MensajeException("ERROR: El mensaje debe tener asunto");
        }
        if (mensaje.getCuerpo().isBlank()) {
            throw new MensajeException("ERROR: El mensaje debe tener cuerpo");
        }
        if (mensaje.getDestinatario() == null) {
            throw new MensajeException("ERROR: El mensaje debe tener destinatario");
        }

        if (contadorEnviados >= CAPACIDAD_BUZON) {
            throw new MensajeException("ERROR: El buzón de enviados de " + this.nombre + " está lleno");
        }

        if (mensaje.getDestinatario().contadorRecibidos >= CAPACIDAD_BUZON) {
            throw new MensajeException("ERROR: El buzón de recibidos de " + mensaje.getDestinatario().getNombre() + " está lleno");
        }

        mensaje.setRemitente(this);
        mensaje.setFechaEnvio(LocalDate.now());

        this.mensajesEnviados[contadorEnviados] = mensaje;
        contadorEnviados++;

        mensaje.getDestinatario().mensajesRecibidos[mensaje.getDestinatario().contadorRecibidos] = mensaje;
        mensaje.getDestinatario().contadorRecibidos++;

        System.out.println("Mensaje enviado correctamente de " + this.nombre + " a " + mensaje.getDestinatario().getNombre());
        return true;
    }

    public boolean borrarMensajeEnviadoMasAntiguo() {
        if (contadorEnviados == 0) {
            System.out.println("ERROR: El buzón de enviados está vacío");
            return false;
        }

        // Reordenar los mensajes
        for (int i = 0; i < contadorEnviados - 1; i++) {
            mensajesEnviados[i] = mensajesEnviados[i + 1];
        }

        // Limpiar la última posición
        mensajesEnviados[contadorEnviados - 1] = null;
        contadorEnviados--;

        System.out.println("Mensaje enviado más antiguo borrado de " + this.nombre);
        return true;
    }

    public boolean borrarMensajeRecibidoMasAntiguo() {
        if (contadorRecibidos == 0) {
            System.out.println("ERROR: El buzón de recibidos está vacío");
            return false;
        }

        // Reordenar los mensajes
        for (int i = 0; i < contadorRecibidos - 1; i++) {
            mensajesRecibidos[i] = mensajesRecibidos[i + 1];
        }

        // Limpiar la última posición
        mensajesRecibidos[contadorRecibidos - 1] = null;
        contadorRecibidos--;

        System.out.println("Mensaje recibido más antiguo borrado de " + this.nombre);
        return true;
    }

    public void mostrarMensajesEnviados() {
        System.out.println("\n--- Mensajes Enviados por " + this.nombre + " (" + contadorEnviados + "/" + CAPACIDAD_BUZON + ") ---");
        for (int i = 0; i < contadorEnviados; i++) {
            System.out.println((i + 1) + ". " + mensajesEnviados[i]);
        }
    }

    public void mostrarMensajesRecibidos() {
        System.out.println("\n--- Mensajes Recibidos por " + this.nombre + " (" + contadorRecibidos + "/" + CAPACIDAD_BUZON + ") ---");
        for (int i = 0; i < contadorRecibidos; i++) {
            System.out.println((i + 1) + ". " + mensajesRecibidos[i]);
        }
    }
}


