package ourProgramImprove.vista;

import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Bienvenida {
	
	private Frame frame = new Frame();

	public Container mostrarBienvenida(Frame frame) {
		// TODO Auto-generated method stub
		JPanel bienvenida = new JPanel();
		bienvenida.setBounds(0, 0, 10000, 650);
		bienvenida.setLayout(null);
		
		JLabel imagen = new JLabel();
		imagen.setIcon(new ImageIcon("img/entradaZoologico.jpg"));
		imagen.setBounds(0, 0, 600, 425);
		bienvenida.add(imagen);
		
		bienvenida.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				frame.cambiarPanel(2);
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		return bienvenida;
	}

}
