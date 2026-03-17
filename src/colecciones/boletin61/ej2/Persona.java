package colecciones.boletin61.ej2;

import java.util.LinkedList;

public abstract class Persona {
	private static final int EDAD_MINIMA = 12;

	protected String dni;
	protected String nombre;
	protected int edad;
	protected LinkedList<Mensaje> mensajes;

	public Persona(String dni, String nombre, int edad) throws IESException {
		this.dni = dni;
		this.nombre = nombre;
		this.mensajes = new LinkedList<>();  // ✅ INICIALIZADO SIEMPRE
		setEdad(edad);
	}

	public int getEdad() { return edad; }
	public String getNombre() { return nombre; }
	public String getDni() { return dni; }

	private void setEdad(int edad) throws IESException {
		if (edad < EDAD_MINIMA) {
			throw new IESException("La edad mínima es de " + EDAD_MINIMA);
		}
		this.edad = edad;
	}

	public void enviarCorreo(String msg, Persona personaDestinatario) throws IESException {
		Mensaje mensaje = new Mensaje(this, msg);
		personaDestinatario.mensajes.add(mensaje);
	}

	public String mostrarMensajes() throws IESException {
		if (mensajes.isEmpty()) return "No hay mensajes";
		StringBuilder sb = new StringBuilder("Mensajes:\n");
		for (int i = 0; i < mensajes.size(); i++) {
			sb.append(i + 1).append(". ").append(mensajes.get(i)).append("\n");
		}
		return sb.toString();
	}

	public void borrarMensaje(int numeroMensaje) throws IESException {
		if (numeroMensaje < 1 || numeroMensaje > mensajes.size()) {
			throw new IESException("Número inválido (1-" + mensajes.size() + ")");
		}
		mensajes.remove(numeroMensaje - 1);
	}

	public String mostrarMensajesOrdenados() throws IESException {
		if (mensajes.isEmpty()) return "No hay mensajes";
		LinkedList<Mensaje> copia = new LinkedList<>(mensajes);
		copia.sort((m1, m2) -> m1.getHora().compareTo(m2.getHora()));
		StringBuilder sb = new StringBuilder("Mensajes ordenados:\n");
		for (int i = 0; i < copia.size(); i++) {
			sb.append(i + 1).append(". ").append(copia.get(i)).append("\n");
		}
		return sb.toString();
	}

	public String buscarMensajesConTexto(String texto) throws IESException {
		StringBuilder sb = new StringBuilder("Con '" + texto + "':\n");
		boolean encontrado = false;
		for (int i = 0; i < mensajes.size(); i++) {
			if (mensajes.get(i).getTexto().toLowerCase().contains(texto.toLowerCase())) {
				sb.append(i + 1).append(". ").append(mensajes.get(i)).append("\n");
				encontrado = true;
			}
		}
		return encontrado ? sb.toString() : "No encontrados";
	}

	@Override
	public String toString() {
		return String.format("Persona{dni='%s', nombre='%s', edad=%d}", dni, nombre, edad);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		Persona other = (Persona) obj;
		return dni != null ? dni.equals(other.dni) : other.dni == null;
	}

	@Override
	public int hashCode() {
		return dni != null ? dni.hashCode() : 0;
	}
}
