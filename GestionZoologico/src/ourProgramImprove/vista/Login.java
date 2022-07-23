package ourProgramImprove.vista;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ourProgramImprove.controlador.gestor.GestorUsuarios;
import ourProgramImprove.controlador.gestoresPojo.DaoCliente;
import ourProgramImprove.modelo.Cliente;

public class Login {

	public Container mostrarLogin(Frame frame) {
		// TODO Auto-generated method stub
		JPanel login = new JPanel();
		login.setBounds(0, 0, 1000, 650);
		login.setLayout(null);
		
		JLabel lError = new JLabel();
		lError.setBounds(500, 370, 400, 20);
		lError.setForeground(Color.RED);

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
				DaoCliente todosLosEmpleados = new DaoCliente();
				
				if(tDni.getText().length() == 0 || tContraseña.getText().length() == 0) {
					lError.setText("No se ha insertado texto en el campo");
				} else {
					ArrayList<Cliente> usuarios = todosLosEmpleados.listarUsuarios(); 
					if(usuarios != null) {
						for(Cliente cliente : usuarios) {
							if(!gestorUsuarios.esAdmin(tDni.getText())) {
								if(cliente.getDni().equalsIgnoreCase(tDni.getText()) &&
										cliente.getContraseña().equals(tContraseña.getText())) {
									/*CAMBIAR A PANEL MENU CLIENTE*/
									frame.cambiarPanel(frame.BIENVENIDA);
									JOptionPane.showMessageDialog(new Frame(), "Eres Cliente");
								}else {
									lError.setText("DNI o contraseña incorrectos");
								}
							} else {
								if(cliente.getDni().equalsIgnoreCase(tDni.getText()) &&
										cliente.getContraseña().equals(tContraseña.getText())) {
									/*CAMBIAR A PANEL MENU ADMIN*/
									frame.cambiarPanel(1);
									JOptionPane.showMessageDialog(new Frame(), "Eres admin");
								}else {
									lError.setText("¿Eres admin y no te acuerdas de tu contraseña?   ..............");
								}
							}
						}
					} else {
						lError.setText("No hay usuarios en la BBDD");
					}
				}
			}
		});

		JButton bRegistrar = new JButton("Registro");
		bRegistrar.setBounds(370, 385, 100, 35);
		bRegistrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

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
		login.add(bRegistrar);
		login.add(lError);
		return login;
	}

}
