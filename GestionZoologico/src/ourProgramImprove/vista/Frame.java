package ourProgramImprove.vista;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import ourProgramImprove.vista.vistaAdmin.AdminMenu;
import ourProgramImprove.vista.vistaCliente.ClienteMenu;
import ourProgramImprove.vista.vistaCliente.MapaContinentes;
import ourProgramImprove.vista.vistaCliente.VistaCiudades;

public class Frame extends JFrame {

	private static final long serialVersionUID = 1325153138421582854L;
	public final int BIENVENIDA = 1;
	public final int LOGIN = 2;
	public final int REGISTRO = 3;

	/* CLIENTES */
	public final int MENU_CLIENTE = 4;
	public final int CONTINENTES = 5;
	public final int CIUDADES = 7;
	/* ADMINISTRADORES */
	public final int MENU_ADMIN = 6;

	public Frame() {

		setBounds(0, 0, 1000, 650);
		setTitle("GESTION ZOOLOGICOS");
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	public void cambiarPanel(int opcion) {

		switch (opcion) {
		case BIENVENIDA:
			this.setContentPane(new Bienvenida().mostrarBienvenida(this));
			break;
		case LOGIN:
			this.setContentPane(new Login().mostrarLogin(this));
			break;
		case REGISTRO:
			this.setContentPane(new Registro().mostrarRegistro(this));
			break;
		/* AQUI VAN LAS VENTANAS DEL CLIENTE */
		case MENU_CLIENTE:
			this.setContentPane(new ClienteMenu().mostrarClienteMenu(this));
			break;
		case CONTINENTES:
			this.setContentPane(new MapaContinentes().mostrarContinentes(this));
			break;
		case CIUDADES:
			this.setContentPane(new VistaCiudades().mostrarVistaCiudades(this));
			break;
		/* AQUI VAN LAS VENTANAS DEL ADMIN */
		case MENU_ADMIN:
			this.setContentPane(new AdminMenu().mostrarAdminMenu(this));
			break;

		default:
			JOptionPane.showMessageDialog(new Frame(), "No exista la ventana a la que desea acceder");

		}

	}

}
