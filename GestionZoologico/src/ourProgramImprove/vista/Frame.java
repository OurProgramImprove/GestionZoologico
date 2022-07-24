package ourProgramImprove.vista;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import ourProgramImprove.vista.vistaAdmin.AdminMenu;
import ourProgramImprove.vista.vistaCliente.ClienteMenu;

public class Frame extends JFrame {

	private static final long serialVersionUID = 1325153138421582854L;
	public final int BIENVENIDA = 1;
	public final int LOGIN = 2;
	public final int REGISTRO = 3;
	public final int CONTINENTES = 4;
	/*CLIENTES*/
	public final int MENU_CLIENTE = 5;
	
	/*ADMINISTRADORES*/
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
		case CONTINENTES:
			this.setContentPane(new MapaContinentes().mostrarContinentes(this));
			break;
		/* AQUI VAN LAS VENTANAS DEL CLIENTE*/
		case MENU_CLIENTE:
			this.setContentPane(new ClienteMenu().mostrarClienteMenu(this));
			break;
			
		/* AQUI VAN LAS VENTANAS DEL ADMIN*/
		case MENU_ADMIN:
			this.setContentPane(new AdminMenu().mostrarAdminMenu(this));
			break;
		
		default:
			JOptionPane.showMessageDialog(new Frame(), "No exista la ventana a la que desea acceder");

		}

	}

}
