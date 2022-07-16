package ourProgramImprove.modelo;

import java.sql.Time;
import java.util.Date;
import java.util.Objects;

public class Billete {

	private int idBillete = 0;
	private Date fecBillete = null;
	private Time hLlegada = null;
	private float importe = 0;
	private int idZoo = 0;

	public Billete() {
		super();
	}

	public Billete(int idBillete, Date fecBillete, Time hLlegada, float importe, int idZoo) {
		super();
		this.idBillete = idBillete;
		this.fecBillete = fecBillete;
		this.hLlegada = hLlegada;
		this.importe = importe;
		this.idZoo = idZoo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fecBillete, hLlegada, idBillete, idZoo, importe);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Billete other = (Billete) obj;
		return Objects.equals(fecBillete, other.fecBillete) && Objects.equals(hLlegada, other.hLlegada)
				&& idBillete == other.idBillete && idZoo == other.idZoo
				&& Float.floatToIntBits(importe) == Float.floatToIntBits(other.importe);
	}

	public int getIdBillete() {
		return idBillete;
	}

	public void setIdBillete(int idBillete) {
		this.idBillete = idBillete;
	}

	public Date getFecBillete() {
		return fecBillete;
	}

	public void setFecBillete(Date fecBillete) {
		this.fecBillete = fecBillete;
	}

	public Time gethLlegada() {
		return hLlegada;
	}

	public void sethLlegada(Time hLlegada) {
		this.hLlegada = hLlegada;
	}

	public float getImporte() {
		return importe;
	}

	public void setImporte(float importe) {
		this.importe = importe;
	}

	public int getIdZoo() {
		return idZoo;
	}

	public void setIdZoo(int idZoo) {
		this.idZoo = idZoo;
	}

	@Override
	public String toString() {
		return "Billete [idBillete=" + idBillete + ", fecBillete=" + fecBillete + ", hLlegada=" + hLlegada
				+ ", importe=" + importe + ", idZoo=" + idZoo + "]";
	}

}
