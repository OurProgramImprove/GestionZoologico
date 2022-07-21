package ourProgramImprove.vista;

import java.awt.Color;

import javax.swing.JPanel;

public class PanelTransparente extends JPanel{
	private static final long serialVersionUID = 1L;

	public PanelTransparente() {
		super();
		this.setOpaque(true);
		this.setBackground(new Color(0,0,0,30)); // 0 -255
		this.setBounds(0, 0, 250, 250);
	}

	/**
	 * Constructor que recibe parametros para crear paneles transparentes personalizados
	 * @param x variable que modifica la estetica del panel transparente
	 * @param y variable que modifica la estetica del panel transparente
	 * @param width variable que modifica la estetica del panel transparente
	 * @param height variable que modifica la estetica del panel transparente
	 */
	public PanelTransparente(int x, int y, int width, int height) {
		this();
		this.setBounds(x, y, width, height);
	}
}
