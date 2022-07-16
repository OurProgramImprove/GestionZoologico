package ourProgramImprove.modelo;

import java.util.Objects;

public class Cliente {

	private int idCliente = 0;
	private String dni = null;
	private String nombre = null;
	private String apellidoUno = null;
	private String apellidoDos = null;
	private String contraseña = null;

	public Cliente() {
		super();
	}

	public Cliente(int idCliente, String dni, String nombre, String apellidoUno, String apellidoDos,
			String contraseña) {
		super();
		this.idCliente = idCliente;
		this.dni = dni;
		this.nombre = nombre;
		this.apellidoUno = apellidoUno;
		this.apellidoDos = apellidoDos;
		this.contraseña = contraseña;
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellidoDos, apellidoUno, contraseña, dni, idCliente, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(apellidoDos, other.apellidoDos) && Objects.equals(apellidoUno, other.apellidoUno)
				&& Objects.equals(contraseña, other.contraseña) && Objects.equals(dni, other.dni)
				&& idCliente == other.idCliente && Objects.equals(nombre, other.nombre);
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoUno() {
		return apellidoUno;
	}

	public void setApellidoUno(String apellidoUno) {
		this.apellidoUno = apellidoUno;
	}

	public String getApellidoDos() {
		return apellidoDos;
	}

	public void setApellidoDos(String apellidoDos) {
		this.apellidoDos = apellidoDos;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", dni=" + dni + ", nombre=" + nombre + ", apellidoUno="
				+ apellidoUno + ", apellidoDos=" + apellidoDos + ", contraseña=" + contraseña + "]";
	}

}
