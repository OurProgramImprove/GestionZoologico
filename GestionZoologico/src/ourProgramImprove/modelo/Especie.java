package ourProgramImprove.modelo;

import java.util.Objects;

public class Especie {

	private int idEspecie = 0;
	private String nombreVulgar = null;
	private String nombreCientifico = null;
	/*EN MySQL EXTINCION ES TINYINT, COJE VALOR 0 (FALSTE) VALOR 1 (TRUE)*/
	private int extincion = 0;
	private String animal = null;
	private int idFamilia = 0;

	public Especie() {
		super();
	}

	public Especie(int idEspecie, String nombreVulgar, String nombreCientifico, int extincion, String animal,
			int idFamilia) {
		super();
		this.idEspecie = idEspecie;
		this.nombreVulgar = nombreVulgar;
		this.nombreCientifico = nombreCientifico;
		this.extincion = extincion;
		this.animal = animal;
		this.idFamilia = idFamilia;
	}

	@Override
	public int hashCode() {
		return Objects.hash(animal, extincion, idEspecie, idFamilia, nombreCientifico, nombreVulgar);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Especie other = (Especie) obj;
		return Objects.equals(animal, other.animal) && extincion == other.extincion && idEspecie == other.idEspecie
				&& idFamilia == other.idFamilia && Objects.equals(nombreCientifico, other.nombreCientifico)
				&& Objects.equals(nombreVulgar, other.nombreVulgar);
	}

	public int getIdEspecie() {
		return idEspecie;
	}

	public void setIdEspecie(int idEspecie) {
		this.idEspecie = idEspecie;
	}

	public String getNombreVulgar() {
		return nombreVulgar;
	}

	public void setNombreVulgar(String nombreVulgar) {
		this.nombreVulgar = nombreVulgar;
	}

	public String getNombreCientifico() {
		return nombreCientifico;
	}

	public void setNombreCientifico(String nombreCientifico) {
		this.nombreCientifico = nombreCientifico;
	}

	public int getExtincion() {
		return extincion;
	}

	public void setExtincion(int extincion) {
		this.extincion = extincion;
	}

	public String getAnimal() {
		return animal;
	}

	public void setAnimal(String animal) {
		this.animal = animal;
	}

	public int getIdFamilia() {
		return idFamilia;
	}

	public void setIdFamilia(int idFamilia) {
		this.idFamilia = idFamilia;
	}

	@Override
	public String toString() {
		return "Especie [idEspecie=" + idEspecie + ", nombreVulgar=" + nombreVulgar + ", nombreCientifico="
				+ nombreCientifico + ", extincion=" + extincion + ", animal=" + animal + ", idFamilia=" + idFamilia
				+ "]";
	}

}
