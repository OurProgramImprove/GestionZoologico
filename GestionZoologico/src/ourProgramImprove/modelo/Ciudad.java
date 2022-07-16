package ourProgramImprove.modelo;

import java.util.Objects;

public class Ciudad {

	private int idCiudad = 0;
	private String nombre = null;
	private int idPais = 0;

	public Ciudad() {
		super();
	}

	public Ciudad(int idCiudad, String nombre, int idPais) {
		super();
		this.idCiudad = idCiudad;
		this.nombre = nombre;
		this.idPais = idPais;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idCiudad, idPais, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ciudad other = (Ciudad) obj;
		return idCiudad == other.idCiudad && idPais == other.idPais && Objects.equals(nombre, other.nombre);
	}

	public int getIdCiudad() {
		return idCiudad;
	}

	public void setIdCiudad(int idCiudad) {
		this.idCiudad = idCiudad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getIdPais() {
		return idPais;
	}

	public void setIdPais(int idPais) {
		this.idPais = idPais;
	}

	@Override
	public String toString() {
		return "Ciudad [idCiudad=" + idCiudad + ", nombre=" + nombre + ", idPais=" + idPais + "]";
	}

}
