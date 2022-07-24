package ourProgramImprove.vista;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import ourProgramImprove.controlador.gestor.GestorUsuarios;
import ourProgramImprove.controlador.gestoresPojo.DaoCliente;
import ourProgramImprove.modelo.Cliente;

public class Registro {

	JPanel panelRegistro;
	private JTextField Dni;
	private JPasswordField PassUno;
	private JPasswordField PassDos;
	private JTextField Nombre;
	private JTextField PrimerApellido;
	private JTextField SegundoApellido;
	// private JDateChooser FechaNac;

	private static JLabel JLabelDni;
	private static JLabel JLabelPassUno;
	private static JLabel JLabelPassDos;
	private static JLabel JLabelNombre;
	private static JLabel JLabelPrimerApellido;
	private static JLabel JLabelSegundoApellido;
	// private static JLabel JLabelFechaNac;
	private PanelTransparente panelTransparente;

	public Registro() {

		panelTransparente = new PanelTransparente(210, 60, 550, 460);
	}

	public Container mostrarRegistro(Frame frame) {

		Cliente cliente = new Cliente();

		panelRegistro = new JPanel();
		panelRegistro.setBounds(0, 0, 1000, 650);
		// panelRegistro.setBackground(new Color(220, 197, 176));
		panelRegistro.setLayout(null);

		JLabelDni = new JLabel("DNI");
		JLabelDni.setBounds(50, 80, 500, 20);
		;
		panelTransparente.add(JLabelDni);

		JLabelNombre = new JLabel("Nombre");
		JLabelNombre.setBounds(50, 130, 180, 20);
		;
		panelTransparente.add(JLabelNombre);

		JLabelPassUno = new JLabel("Contraseña");
		JLabelPassUno.setBounds(50, 170, 180, 20);
		;
		panelTransparente.add(JLabelPassUno);

		JLabelPassDos = new JLabel("Repite Contraseña");
		JLabelPassDos.setBounds(50, 220, 180, 20);
		;
		panelTransparente.add(JLabelPassDos);

		JLabelPrimerApellido = new JLabel("Primer apellido");
		JLabelPrimerApellido.setBounds(50, 270, 180, 20);
		;
		panelTransparente.add(JLabelPrimerApellido);

		JLabelSegundoApellido = new JLabel("Segundo Apellido");
		JLabelSegundoApellido.setBounds(50, 320, 180, 20);
		;
		panelTransparente.add(JLabelSegundoApellido);

//		JLabelFechaNac = new JLabel("Fecha nacimiento");
//		JLabelFechaNac.setBounds(50, 370, 180, 20);
//		;
//		panelTransparente.add(JLabelFechaNac);
//
//		JLabelCargo = new JLabel("Cargo");
//		JLabelCargo.setBounds(50, 420, 180, 20);
//		;
//		panelTransparente.add(JLabelCargo);

		Dni = new JTextField();
		Dni.setBounds(270, 80, 200, 20);
		panelTransparente.add(Dni);

		Nombre = new JTextField();
		Nombre.setBounds(270, 130, 200, 20);
		panelTransparente.add(Nombre);

		PassUno = new JPasswordField();
		PassUno.setBounds(270, 180, 200, 20);
		panelTransparente.add(PassUno);

		PassDos = new JPasswordField();
		PassDos.setBounds(270, 230, 200, 20);
		panelTransparente.add(PassDos);

		PrimerApellido = new JTextField();
		PrimerApellido.setBounds(270, 280, 200, 20);
		panelTransparente.add(PrimerApellido);

		SegundoApellido = new JTextField();
		SegundoApellido.setBounds(270, 330, 200, 20);
		panelTransparente.add(SegundoApellido);

//		FechaNac = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
//		FechaNac.setBounds(270, 380, 200, 20);
//		FechaNac.setMaxSelectableDate(new Date());
//		FechaNac.setEnabled(false);
//		panelTransparente.add(FechaNac);

		panelTransparente.setLayout(null);
		panelTransparente.setBorder(BorderFactory.createLineBorder(Color.black, 2, true));
		panelRegistro.add(panelTransparente);

		JButton btnRegistrar = new JButton("REGISTRAR USUARIO");
		btnRegistrar.setBounds(270, 400, 200, 30);
		btnRegistrar.setForeground(Color.blue);
		btnRegistrar.setBorder(BorderFactory.createLineBorder(Color.blue, 2, false));
		btnRegistrar.addActionListener(new ActionListener() {

			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				GestorUsuarios gestorUsuario = new GestorUsuarios();
				if (Dni.getText().isBlank() == true || Nombre.getText().isBlank() == true
						|| PassUno.getText().isBlank() == true || PrimerApellido.getText().isBlank() == true
						|| SegundoApellido.getText().isBlank() == true) {

					JOptionPane.showMessageDialog(null, "Rellene todos los campos");
				} else {

					if (gestorUsuario.comprobarDni(Dni.getText().trim()) == false) {

						if (gestorUsuario.comprobarPass(PassUno.getText().trim()) == false) {

							cliente.setDni(Dni.getText().trim());
							cliente.setNombre(Nombre.getText().trim());
							cliente.setContraseña(PassUno.getText().trim());
							cliente.setApellidoUno(PrimerApellido.getText().trim());
							cliente.setApellidoDos(SegundoApellido.getText().trim());
							// cliente.setFechaNac((FechaNac).getDate());

							if (gestorUsuario.comprobarCliente(cliente) == true) {
								JOptionPane.showMessageDialog(null, " El DNI ya se encuentra registrado.");
							} else {

								DaoCliente daoCliente = new DaoCliente();

								try {
									daoCliente.insertar(cliente);
								} catch (ClassNotFoundException | IOException e1) {

									e1.printStackTrace();
								}
							}
						} else {
							JOptionPane.showMessageDialog(null, "Contraseña 8 o más caracteres.");
						}
					} else {

						JOptionPane.showMessageDialog(null, "DNI incorrecto");
					}
				}
			}

		});
		panelTransparente.add(btnRegistrar);

		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(20, 20, 100, 20);
		btnVolver.setBorder(BorderFactory.createLineBorder(Color.gray, 2, false));
		btnVolver.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.cambiarPanel(2);

			}
		});
		panelRegistro.add(btnVolver);
		return panelRegistro;
	}

}
