package ourProgramImprove.vista.vistaCliente;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import ourProgramImprove.vista.Frame;

public class ClienteMenu {

	private JToolBar toolBar;
	JPanel vistaMenuCliente;

	public Container mostrarClienteMenu(Frame frame) {

		vistaMenuCliente = new JPanel();
		vistaMenuCliente.setBounds(0, 0, 1000, 650);
		vistaMenuCliente.setBackground(Color.red);
		vistaMenuCliente.setLayout(null);

		JLabel label = new JLabel("MENU CLIENTE");
		label.setBounds(560, 200, 230, 30);
		label.setFont(new Font("Goudy Stout", 10, 12));
		label.setOpaque(false);
		vistaMenuCliente.add(label);

		toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 1000, 30);
		toolBar.setLayout(null);
		toolBar.setFloatable(false);
		toolBar.addSeparator();

		JButton btnAtras = new JButton("Atrás");
		btnAtras.setBounds(900, 5, 70, 20);
		btnAtras.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.cambiarPanel(2);
			}
		});
		toolBar.add(btnAtras);
		JButton verContinentes = new JButton("Ver Continentes");
		verContinentes.setBounds(760, 5, 120, 20);
		verContinentes.setOpaque(true);
		verContinentes.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.cambiarPanel(5);

			}
		});
		toolBar.add(verContinentes);
		vistaMenuCliente.add(toolBar);

		return vistaMenuCliente;
	}

}
