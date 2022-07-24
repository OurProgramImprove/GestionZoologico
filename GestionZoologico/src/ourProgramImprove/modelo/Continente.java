package ourProgramImprove.modelo;

import java.util.Objects;

public class Continente {

	private int idContinente = 0;
	private String nombre = null;

	public Continente() {
		super();
	}

	public Continente(int idContinente, String nombre) {
		super();
		this.idContinente = idContinente;
		this.nombre = nombre;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idContinente, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Continente other = (Continente) obj;
		return idContinente == other.idContinente && Objects.equals(nombre, other.nombre);
	}

	public int getIdContinente() {
		return idContinente;
	}

	public void setIdContinente(int idContinente) {
		this.idContinente = idContinente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		// return "Continente [idContinente=" + idContinente + ", nombre=" + nombre +
		// "]";
		return nombre + "       " + idContinente;
	}

}
