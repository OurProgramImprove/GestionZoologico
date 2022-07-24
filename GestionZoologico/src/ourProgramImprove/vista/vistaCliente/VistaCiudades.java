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

public class VistaCiudades {
	JPanel ciudades;
	JToolBar toolBar;
	public Container mostrarVistaCiudades(Frame frame) {

		ciudades = new JPanel();
		ciudades.setBounds(0, 0, 1000, 650);
		ciudades.setBackground(Color.pink);
		ciudades.setLayout(null);

		JLabel label = new JLabel("VISTA CIUDADES");
		label.setBounds(560, 200, 230, 30);
		label.setFont(new Font("Goudy Stout", 10, 12));
		label.setOpaque(false);
		ciudades.add(label);

		toolBar = new JToolBar("se mostraran las ciudades");
		toolBar.setBounds(0, 0, 1000, 30);
		toolBar.setLayout(null);
		toolBar.setFloatable(false);
		toolBar.addSeparator();

		JButton btnAtras = new JButton("Atrás");
		btnAtras.setBounds(900, 5, 70, 20);
		btnAtras.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.cambiarPanel(5);
			}
		});
		toolBar.add(btnAtras);
		ciudades.add(toolBar);
		return ciudades;
	}
	
	
	
	
	
	
	
	
	

}
