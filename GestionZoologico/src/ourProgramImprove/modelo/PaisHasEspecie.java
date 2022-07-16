package ourProgramImprove.modelo;

import java.util.Objects;

public class PaisHasEspecie {

	private int idPais = 0;
	private int idEspecie = 0;

	public PaisHasEspecie() {
		super();
	}

	public PaisHasEspecie(int idPais, int idEspecie) {
		super();
		this.idPais = idPais;
		this.idEspecie = idEspecie;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idEspecie, idPais);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PaisHasEspecie other = (PaisHasEspecie) obj;
		return idEspecie == other.idEspecie && idPais == other.idPais;
	}

	public int getIdPais() {
		return idPais;
	}

	public void setIdPais(int idPais) {
		this.idPais = idPais;
	}

	public int getIdEspecie() {
		return idEspecie;
	}

	public void setIdEspecie(int idEspecie) {
		this.idEspecie = idEspecie;
	}

	@Override
	public String toString() {
		return "PaisHasEspecie [idPais=" + idPais + ", idEspecie=" + idEspecie + "]";
	}

}
