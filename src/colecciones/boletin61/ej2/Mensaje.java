package colecciones.boletin61.ej2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Mensaje {
	private Persona remitente;
	private String texto;
	private LocalDateTime hora;

	public Mensaje(Persona remitente, String texto) {
		this.remitente = remitente;
		this.texto = texto;
		this.hora = LocalDateTime.now();
	}

	public Persona getRemitente() { return remitente; }
	public String getTexto() { return texto; }
	public LocalDateTime getHora() { return hora; }

	@Override
	public String toString() {
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM HH:mm");
		return String.format("De: %s\n  %s\n  %s\n",
				remitente.getNombre(),
				texto,           // ✅ TEXTO COMPLETO
				df.format(hora));
	}
}
