package ourProgramImprove.modelo;

import java.util.Objects;

public class Pais {

	private int idPais = 0;
	private String nombre = null;
	private int idContinente = 0;

	public Pais() {
		super();
	}

	public Pais(int idPais, String nombre, int idContinente) {
		super();
		this.idPais = idPais;
		this.nombre = nombre;
		this.idContinente = idContinente;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idContinente, idPais, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pais other = (Pais) obj;
		return idContinente == other.idContinente && idPais == other.idPais && Objects.equals(nombre, other.nombre);
	}

	public int getIdPais() {
		return idPais;
	}

	public void setIdPais(int idPais) {
		this.idPais = idPais;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getIdContinente() {
		return idContinente;
	}

	public void setIdContinente(int idContinente) {
		this.idContinente = idContinente;
	}

	@Override
	public String toString() {
		return "Pais [idPais=" + idPais + ", nombre=" + nombre + ", idContinente=" + idContinente + "]";
	}

}
