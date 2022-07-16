package ourProgramImprove.modelo;

import java.util.Objects;

public class Familia {

	private int idFamilia = 0;
	private String nombre = null;

	public Familia() {
		super();
	}

	public Familia(int idFamilia, String nombre) {
		super();
		this.idFamilia = idFamilia;
		this.nombre = nombre;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idFamilia, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Familia other = (Familia) obj;
		return idFamilia == other.idFamilia && Objects.equals(nombre, other.nombre);
	}

	public int getIdFamilia() {
		return idFamilia;
	}

	public void setIdFamilia(int idFamilia) {
		this.idFamilia = idFamilia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Familia [idFamilia=" + idFamilia + ", nombre=" + nombre + "]";
	}

}
