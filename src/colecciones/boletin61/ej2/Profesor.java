package colecciones.boletin61.ej2;

public class Profesor extends Persona {
	private int antiguedad;

	public Profesor(String dni, String nombre, int edad) throws IESException {
		super(dni, nombre, edad);
		this.antiguedad = 0;
	}

	public Profesor(String dni, String nombre, int edad, int antiguedad) throws IESException {
		super(dni, nombre, edad);
		setAntiguedad(antiguedad);
	}

	public int getAntiguedad() { return antiguedad; }

	private void setAntiguedad(int antiguedad) throws IESException {
		if (antiguedad < 0) {
			throw new IESException("Antigüedad incorrecta");
		}
		this.antiguedad = antiguedad;
	}

	public void incrementarAntiguedad() { this.antiguedad++; }

	// ✅ EQUALS Y HASHCODE OBLIGATORIOS
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);  // ✅ Usa DNI de Persona
	}

	@Override
	public int hashCode() {
		return super.hashCode();   // ✅ Usa DNI de Persona
	}

	@Override
	public String toString() {
		return "Profesor{" + super.toString() + ", antiguedad=" + antiguedad + " años}";
	}
}
