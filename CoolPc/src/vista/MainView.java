package vista;
import javax.swing.*;
import java.awt.Color;
import java.awt.Component;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

public class MainView extends JFrame {
	JPanel ventana = new JPanel();
	public MainView() {
		ImageIcon icono=new ImageIcon("img/icono.png");
		this.setIconImage(icono.getImage());
		this.setTitle("Tienda CoolPC");
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		setContentPane(ventana);
		ventana.setLayout(null);
		Lamina panel= new Lamina();
		ventana.add(panel.panelSuperior());
		ventana.add(panel.panelInferior());
		
	}

	class Lamina extends JPanel implements ActionListener{
		JButton botonStock = new JButton("Stock");
		JButton botonProv = new JButton("Proveedores");
		JButton botonPedidos = new JButton("Pedidos");
		JButton botonSalir = new JButton("Salir");

		public Component panelSuperior(){
			JPanel panelSuperior = new JPanel();
			panelSuperior.setBackground(new Color(91, 155, 213));
			panelSuperior.setBounds(0, 0, 994, 100);
			panelSuperior.setLayout(null);
			
			JLabel tituloCoolPc = new JLabel("Tienda CoolPc");
			tituloCoolPc.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 56));
			tituloCoolPc.setBounds(10, 5, 974, 84);
			tituloCoolPc.setHorizontalAlignment(SwingConstants.CENTER);
			tituloCoolPc.setForeground(new Color(255, 255, 255));
			panelSuperior.add(tituloCoolPc);
			return panelSuperior;
		}
		
		public Component panelInferior() {
			JPanel panelInferior = new JPanel();
			panelInferior.setBackground(new Color(221, 235, 247));
			panelInferior.setBounds(0, 100, 994, 471);
			panelInferior.setLayout(null);
			botonStock.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
			botonStock.setBounds(100, 150, 200, 70);
			botonStock.setBackground(new Color(91, 155, 213));
			botonStock.setForeground(new Color(255, 255, 255));
			botonStock.addActionListener(this);
			panelInferior.add(botonStock);

			botonProv.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
			botonProv.setBounds(343, 150, 300, 70);
			botonProv.setBackground(new Color(91, 155, 213));
			botonProv.setForeground(new Color(255, 255, 255));
			botonProv.addActionListener(this);
			panelInferior.add(botonProv);

			botonPedidos.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
			botonPedidos.setBounds(684, 150, 200, 70);
			botonPedidos.setBackground(new Color(91, 155, 213));
			botonPedidos.setForeground(new Color(255, 255, 255));
			botonPedidos.addActionListener(this);
			panelInferior.add(botonPedidos);

			botonSalir.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
			botonSalir.setBounds(400, 309, 200, 70);
			botonSalir.setBackground(new Color(91, 155, 213));
			botonSalir.setForeground(new Color(255, 255, 255));
			botonSalir.addActionListener(this);
			panelInferior.add(botonSalir);
			return panelInferior;
		}

		public void actionPerformed(ActionEvent e){
			Object ventana=e.getSource();
			if (ventana==botonStock){
				ComponentesView componentes=new ComponentesView();
				componentes.setVisible(true);
				dispose();
			}else if(ventana==botonPedidos){
				PedidosView pedidos=new PedidosView();
				pedidos.setVisible(true);
				dispose();
			}else if(ventana==botonSalir) {
				System.exit(0);
			}else if(ventana==botonProv) {
				ProveedoresView proveedores=new ProveedoresView();
				proveedores.setVisible(true);
				dispose();
			}
		}
	}

	/**
	 * Clase que sobrescribe el metodo isCellEditable con el fin de evitar
	 * que el usuario pueda modificar las tablas
	 */
	public static class NonEditableTableModel extends DefaultTableModel{
		@Override
		public boolean isCellEditable(int rowIndex, int columnIndex) {
			return false;
		}
	}
}
