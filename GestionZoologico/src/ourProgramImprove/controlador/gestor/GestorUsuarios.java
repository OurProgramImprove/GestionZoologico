package ourProgramImprove.controlador.gestor;

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

}
