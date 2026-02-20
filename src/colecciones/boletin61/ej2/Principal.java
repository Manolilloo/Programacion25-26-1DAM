package colecciones.boletin61.ej2;

public class Principal {
	public static void main(String[] args) {
		try {
			System.out.println("=== SISTEMA DE MENSAJES IES ===\n");

			Profesor pepe = new Profesor("11", "Pepe García", 35);
			Profesor pepa = new Profesor("12", "Pepa López", 32);
			Alumno paco = new Alumno("234", "Paco Martínez", 17, TipoEnsennanza.ESO, 3);
			Alumno bartolo = new Alumno("134", "Bartolo Ruiz", 16, TipoEnsennanza.CICLO, 2);
			Alumno ana = new Alumno("456", "Ana Torres", 18, TipoEnsennanza.BACHILLERATO, 1);

			pepe.enviarCorreo("Bienvenido al curso Paco", paco);
			pepa.enviarCorreo("Hola Bartolo - Tarea Linux", bartolo);
			paco.enviarCorreo("Hola profe, duda con Docker", pepe);
			bartolo.enviarCorreo("Gracias Pepa por la ayuda SQL", pepa);
			ana.enviarCorreo("Buenas Pepe, consulta Java testing", pepe);

			pepe.enviarCorreo("REUNION URGENTE - 16:00", pepa);
			pepa.enviarCorreo("Confirmado, nos vemos Pepe", pepe);

			paco.enviarCorreo("Profe he terminado el map de Fortnite", pepe);
			bartolo.enviarCorreo("He debuggeado el container Docker", pepa);
			ana.enviarCorreo("Pregunta sobre JUnit y Mockito", pepe);

			System.out.println("PROFESORES:");
			System.out.println("Pepe:\n" + pepe.mostrarMensajesOrdenados());
			System.out.println("Pepa:\n" + pepa.mostrarMensajes());

			System.out.println("\nALUMNOS:");
			System.out.println("Paco:\n" + paco.mostrarMensajesOrdenados());
			System.out.println("Bartolo:\n" + bartolo.mostrarMensajes());
			System.out.println("Ana:\n" + ana.mostrarMensajes());

			System.out.println("\nBUSQUEDAS:");
			System.out.println("Docker en TODOS:\n" + pepe.buscarMensajesConTexto("Docker"));
			System.out.println("Java en Pepe:\n" + pepe.buscarMensajesConTexto("Java"));

			System.out.println("\nBORRAR:");
			pepe.borrarMensaje(1);
			System.out.println("Pepe tras borrar 1er mensaje:\n" + pepe.mostrarMensajes());

		} catch (Exception e) {
			System.out.println("ERROR: " + e.getMessage());
		}
	}
}
