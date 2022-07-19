package ourProgramImprove.vista;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ourProgramImprove.controlador.gestor.GestorUsuarios;

public class Login {

	public Container mostrarLogin(Frame frame) {
		// TODO Auto-generated method stub
		JPanel login = new JPanel();
		login.setBounds(0, 0, 1000, 650);
		login.setLayout(null);

		JLabel lDni = new JLabel("DNI: ");
		lDni.setBounds(340, 200, 100, 20);
		JLabel lContraseña = new JLabel("Contraseña");
		lContraseña.setBounds(340, 260, 100, 20);

		JTextField tDni = new JTextField();
		tDni.setBounds(410, 200, 100, 20);
		JTextField tContraseña = new JTextField();
		tContraseña.setBounds(410, 260, 100, 20);

		JButton bLogin = new JButton("Login");
		bLogin.setBounds(370, 325, 100, 35);
		bLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO SEL LOGEAN ADMINS Y CLIENTES, LOS DIFERENCIA
				GestorUsuarios gestorUsuarios = new GestorUsuarios();
			}
		});

		JButton bRegistrar = new JButton("Registro");
		bRegistrar.setBounds(370, 385, 100, 35);
		bRegistrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Frame frame = new Frame();
				frame.cambiarPanel(3);
				
				tDni.setText(null);
				tContraseña.setText(null);
			}
		});
		
		login.add(lDni);
		login.add(lContraseña);
		login.add(tDni);
		login.add(tContraseña);
		login.add(bLogin);
		return login;
	}

}
