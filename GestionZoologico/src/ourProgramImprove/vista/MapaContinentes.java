package ourProgramImprove.vista;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;

import ourProgramImprove.controlador.gestoresPojo.DaoContinente;
import ourProgramImprove.modelo.Continente;
import ourProgramImprove.modelo.Pais;

public class MapaContinentes {
	private JToolBar toolBar;
	private JComboBox<String> combo;
	private JList<Continente> listaConti;
	private JList<Pais> listaPaises;

	private DefaultListModel<Continente> modeloConti;
	private DefaultListModel<Pais> modeloPais;

	private JRadioButton radioConti;
	private JRadioButton radioPaises;
	private JLabel fondo;
	private JLabel titulo;


	JPanel continentes;
	private ImageIcon fondoInicio2 = new ImageIcon("img\\mapa.png");

	public Container mostrarContinentes(Frame frame)  {

		continentes = new JPanel();
		continentes.setBounds(0, 0, 1000, 650);
		continentes.setLayout(null);

		fondo = new JLabel();
		fondo.setIcon(fondoInicio2);
		fondo.setBounds(0, 0, 1000, 650);

		titulo = new JLabel("ENCUENTRA TU ZOOLÓGICO");
		titulo.setFont(new Font("Goudy Stout", 20, 20));
		titulo.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
		titulo.setBounds(50, 50, 515, 50);

		radioConti = new JRadioButton("Mostrar Continentes");
		radioConti.setBounds(125, 200, 320, 30);
		radioConti.setFont(new Font("Goudy Stout", 10, 12));
		radioConti.setOpaque(false);

		radioPaises = new JRadioButton("Mostrar Países");
		radioPaises.setBounds(560, 200, 230, 30);
		radioPaises.setFont(new Font("Goudy Stout", 10, 12));
		radioPaises.setOpaque(false);

		listaConti = new JList<>();
		modeloConti = new DefaultListModel<Continente>();
		listaConti.setLayoutOrientation(JList.VERTICAL);
		listaConti.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaConti.setOpaque(false);
		listaConti.setBounds(175, 260, 180, 250);

		DaoContinente daoContinente = new DaoContinente();
		ArrayList<Continente> arrayContinentes = null;

		try {
			arrayContinentes = daoContinente.leerContinentes();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < arrayContinentes.size(); i++) {
			modeloConti.addElement(arrayContinentes.get(i));
		}

		listaPaises = new JList<>();
		modeloPais = new DefaultListModel<Pais>();
		listaPaises.setLayoutOrientation(JList.VERTICAL);
		listaPaises.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaPaises.setOpaque(false);
		listaPaises.setBounds(450, 260, 180, 250);

//		DaoPais daoPais = new DaoPais();
//		ArrayList<Pais> arrayPaises = null;
//
//		
//		
//		arrayPaises = daoPais.leerPaises(listaConti.getSelectedValue().getNombre());
//		
//		for (int i = 0; i < arrayPaises.size(); i++) {
//			modeloPais.addElement(arrayPaises.get(i));
//		}

		
		radioConti.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				listaConti.setModel(modeloConti);
			}
		});

		radioPaises.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {

				listaPaises.setModel(modeloPais);

			}
		});

		// JLISTTTTTTTTTTTTTTT

		JButton btnCiudades = new JButton("Ver Ciudades");
		btnCiudades.setBounds(760, 5, 120, 20);
		btnCiudades.setOpaque(true);

		toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 1000, 30);
		toolBar.setLayout(null);
		toolBar.setFloatable(false);
		toolBar.addSeparator();

		combo = new JComboBox<String>();
		combo.setBounds(10, 5, 100, 20);
		combo.addItem(" ");
		combo.addItem("Javierlerele");
		combo.addItem("Lerelejavier");
		toolBar.add(combo);

		JButton btnAtras = new JButton("Atrás");
		btnAtras.setBounds(900, 5, 70, 20);
		btnAtras.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
		toolBar.add(btnAtras);
		toolBar.add(btnCiudades);

		continentes.add(radioConti);
		continentes.add(radioPaises);
		continentes.add(listaConti);
		// continentes.add(btnCiudades);
		// siguiente.add

		continentes.add(toolBar);
		continentes.add(titulo);
		continentes.add(fondo);

		return continentes;
	}

}
