/**
 * @author ManuelPerez
 * @version 1.0
 */

package Objetos.Objetos3.EjercicioMensajería;

public class Main {
    public static void main(String[] args) throws MensajeException {
        // Crear personas
        Persona juan = new Persona("Juan");
        Persona maria = new Persona("Maria");
        Persona pedro = new Persona("Pedro");

        System.out.println("=== PRUEBAS BÁSICAS DE ENVÍO ===\n");

        // Prueba 1: Envío normal
        juan.enviarMensaje(new Mensaje("Hola", "¿Cómo estás?", maria));
        maria.enviarMensaje(new Mensaje("Re: Hola", "¡Bien, gracias!", juan));

        // Prueba 2: Mensaje sin asunto
        juan.enviarMensaje(new Mensaje("", "Esto no debería enviarse", maria));

        // Prueba 3: Mensaje sin cuerpo
        juan.enviarMensaje(new Mensaje("Sin cuerpo", "", maria));

        // Mostrar buzones
        juan.mostrarMensajesEnviados();
        juan.mostrarMensajesRecibidos();
        maria.mostrarMensajesEnviados();
        maria.mostrarMensajesRecibidos();

        System.out.println("\n=== PRUEBA DE LLENADO DE BUZONES ===\n");

        // Llenar el buzón de enviados de Juan
        juan.enviarMensaje(new Mensaje("Mensaje 2", "Contenido 2", maria));
        juan.enviarMensaje(new Mensaje("Mensaje 3", "Contenido 3", pedro));
        juan.enviarMensaje(new Mensaje("Mensaje 4", "Contenido 4", maria));
        juan.enviarMensaje(new Mensaje("Mensaje 5", "Contenido 5", pedro));

        juan.mostrarMensajesEnviados();

        // Intentar enviar cuando el buzón de enviados está lleno
        System.out.println("\nIntentando enviar con buzón lleno:");
        juan.enviarMensaje(new Mensaje("No debería enviarse", "Buzón lleno", maria));

        System.out.println("\n=== PRUEBA DE BORRADO Y REENVÍO ===\n");

        // Borrar mensaje más antiguo
        juan.borrarMensajeEnviadoMasAntiguo();
        juan.mostrarMensajesEnviados();

        // Ahora sí puede enviar
        juan.enviarMensaje(new Mensaje("Ahora sí", "Después de borrar", maria));
        juan.mostrarMensajesEnviados();

        System.out.println("\n=== PRUEBA DE BUZÓN DE RECIBIDOS LLENO ===\n");

        // Llenar el buzón de recibidos de Pedro
        juan.enviarMensaje(new Mensaje("A Pedro 1", "Mensaje 1", pedro));
        juan.enviarMensaje(new Mensaje("A Pedro 2", "Mensaje 2", pedro));
        maria.enviarMensaje(new Mensaje("De Maria 1", "Hola Pedro", pedro));

        pedro.mostrarMensajesRecibidos();

        // Intentar enviar cuando el buzón de recibidos del destinatario está lleno
        System.out.println("\nIntentando enviar a buzón de recibidos lleno:");
        juan.enviarMensaje(new Mensaje("No llegará", "Pedro tiene buzón lleno", pedro));

        System.out.println("\n=== PRUEBA DE BORRADO DE RECIBIDOS ===\n");

        pedro.borrarMensajeRecibidoMasAntiguo();
        pedro.mostrarMensajesRecibidos();

        // Intentar borrar de buzón vacío
        System.out.println("\nIntentando borrar de buzón vacío:");
        Persona carlos = new Persona("Carlos");
        carlos.borrarMensajeEnviadoMasAntiguo();
        carlos.borrarMensajeRecibidoMasAntiguo();
    }
}

