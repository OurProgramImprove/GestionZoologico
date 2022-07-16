package ourProgramImprove.modelo;

import java.util.Objects;

public class ZooHasEspecie {

	private int id = 0;
	private int idZoo = 0;
	private int idEspecie = 0;
	private char sexo = ' ';
	private int cantidad = 0;

	public ZooHasEspecie() {
		super();
	}

	public ZooHasEspecie(int id, int idZoo, int idEspecie, char sexo, int cantidad) {
		super();
		this.id = id;
		this.idZoo = idZoo;
		this.idEspecie = idEspecie;
		this.sexo = sexo;
		this.cantidad = cantidad;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cantidad, id, idEspecie, idZoo, sexo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ZooHasEspecie other = (ZooHasEspecie) obj;
		return cantidad == other.cantidad && id == other.id && idEspecie == other.idEspecie && idZoo == other.idZoo
				&& sexo == other.sexo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdZoo() {
		return idZoo;
	}

	public void setIdZoo(int idZoo) {
		this.idZoo = idZoo;
	}

	public int getIdEspecie() {
		return idEspecie;
	}

	public void setIdEspecie(int idEspecie) {
		this.idEspecie = idEspecie;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "ZooHasEspecie [id=" + id + ", idZoo=" + idZoo + ", idEspecie=" + idEspecie + ", sexo=" + sexo
				+ ", cantidad=" + cantidad + "]";
	}

}
