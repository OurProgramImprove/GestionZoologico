package ourProgramImprove.modelo;

import java.sql.Time;
import java.util.Objects;

public class Zoo {

	private int idZoo = 0;
	private String nombre = null;
	private int tamaño = 0;
	private Time hApertura = null;
	private Time hCierre = null;
	private float pvpEntrada = 0;
	private int ciudadZoo = 0;

	public Zoo() {
		super();
	}

	public Zoo(int idZoo, String nombre, int tamaño, Time hApertura, Time hCierre, float pvpEntrada, int ciudadZoo) {
		super();
		this.idZoo = idZoo;
		this.nombre = nombre;
		this.tamaño = tamaño;
		this.hApertura = hApertura;
		this.hCierre = hCierre;
		this.pvpEntrada = pvpEntrada;
		this.ciudadZoo = ciudadZoo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ciudadZoo, idZoo, nombre, pvpEntrada, tamaño);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Zoo other = (Zoo) obj;
		return ciudadZoo == other.ciudadZoo && idZoo == other.idZoo && Objects.equals(nombre, other.nombre)
				&& Float.floatToIntBits(pvpEntrada) == Float.floatToIntBits(other.pvpEntrada) && tamaño == other.tamaño;
	}

	public int getIdZoo() {
		return idZoo;
	}

	public void setIdZoo(int idZoo) {
		this.idZoo = idZoo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTamaño() {
		return tamaño;
	}

	public void setTamaño(int tamaño) {
		this.tamaño = tamaño;
	}

	public Time gethApertura() {
		return hApertura;
	}

	public void sethApertura(Time hApertura) {
		this.hApertura = hApertura;
	}

	public Time gethCierre() {
		return hCierre;
	}

	public void sethCierre(Time hCierre) {
		this.hCierre = hCierre;
	}

	public float getPvpEntrada() {
		return pvpEntrada;
	}

	public void setPvpEntrada(float pvpEntrada) {
		this.pvpEntrada = pvpEntrada;
	}

	public int getCiudadZoo() {
		return ciudadZoo;
	}

	public void setCiudadZoo(int ciudadZoo) {
		this.ciudadZoo = ciudadZoo;
	}

	@Override
	public String toString() {
		return "Zoo [idZoo=" + idZoo + ", nombre=" + nombre + ", tamaño=" + tamaño + ", pvpEntrada=" + pvpEntrada
				+ ", ciudadZoo=" + ciudadZoo + "]";
	}

}
