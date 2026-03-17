package colecciones.boletin61.ej2;

public class Alumno extends Persona {
	private static final int CURSO_MIN_BACH = 1, CURSO_MAX_BACH = 2;
	private static final int CURSO_MIN_CICLO = 1, CURSO_MAX_CICLO = 2;
	private static final int CURSO_MIN_ESO = 1, CURSO_MAX_ESO = 4;

	private TipoEnsennanza ensennanza;
	private int curso;

	public Alumno(String dni, String nombre, int edad, TipoEnsennanza ensennanza, int curso) throws IESException {
		super(dni, nombre, edad);
		this.ensennanza = ensennanza;
		setCurso(curso);
	}

	public TipoEnsennanza getEnsennanza() { return ensennanza; }
	public int getCurso() { return curso; }

	private void setCurso(int curso) throws IESException {
		int minCurso = 0, maxCurso = 0;
		switch (ensennanza) {
			case CICLO: minCurso = CURSO_MIN_CICLO; maxCurso = CURSO_MAX_CICLO; break;
			case BACHILLERATO: minCurso = CURSO_MIN_BACH; maxCurso = CURSO_MAX_BACH; break;
			case ESO: minCurso = CURSO_MIN_ESO; maxCurso = CURSO_MAX_ESO; break;
		}
		if (curso < minCurso || curso > maxCurso) {
			throw new IESException("Valor del curso incorrecto");
		}
		this.curso = curso;
	}

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
		return "Alumno{" + super.toString() + ", " + ensennanza + " curso " + curso + "}";
	}
}
