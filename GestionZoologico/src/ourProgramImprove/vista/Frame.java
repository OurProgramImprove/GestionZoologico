package ourProgramImprove.vista;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Frame extends JFrame {

	private static final long serialVersionUID = 1325153138421582854L;
	public final int BIENVENIDA = 1;
	public final int LOGIN = 2;
	public final int REGISTRO = 3;

	public Frame() {

		setVisible(true);
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
		/* AQUI VAN LAS VENTANAS DEL CLIENTE Y DEL ADMIN */
		default:
			JOptionPane.showMessageDialog(new Frame(), "No exista la ventana a la que desea acceder");

		}

	}

}
