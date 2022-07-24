package ourProgramImprove.controlador.gestor;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import ourProgramImprove.controlador.gestoresPojo.DaoCliente;
import ourProgramImprove.modelo.Cliente;

public class GestorUsuarios {

	public boolean esAdmin(String dni) {
		boolean ret = false;
		String admins[] = { "11111111P", "22222222P", "33333333P" };

		for (int i = 0; i < admins.length; i++) {
			if (dni.equals(admins[i]))
				ret = true;
		}
		return ret;
	}

	public boolean comprobarDni(String dni) {

		boolean error = false;

		char[] abecedario = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'Ñ', 'O', 'P', 'Q',
				'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

		if (dni.length() == 9) {

			for (int i = 0; i < dni.length(); i++) {
				if ((Character.isDigit(dni.charAt(i)) == true) && (i < 8)) {
					error = false;
				} else if (i == 8) {
					break;
				} else {
					error = true;
				}
			}

			if (error == false) {

				for (int j = 0; j < abecedario.length; j++) {

					if (Character.toUpperCase(dni.charAt(8)) == abecedario[j]) {
						error = false;
						break;
					} else {
						error = true;
					}
				}
			}
		} else {

			error = true;
		}

		return error;
	}

	public boolean comprobarPass(String pass) {

		boolean error = false;
		int passLenght = pass.length();
		if (passLenght < 8) {
			error = true;
		}
		return error;
	}

	public boolean comprobarCliente(Cliente clientePantalla) {

		DaoCliente daoCliente = new DaoCliente();
		Boolean existe = false;
		ArrayList<Cliente> arrayListUsuario = new ArrayList<Cliente>();
		try {
			arrayListUsuario = daoCliente.listarUsuarios();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "ClassNotFound");
		}

		for (int i = 0; i < arrayListUsuario.size(); i++) {
			Cliente cliente = arrayListUsuario.get(i);
			if (clientePantalla.getDni().equals(cliente.getDni())) {

				existe = true;
				break;
			}
		}

		return existe;

	}
}
