package vista;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import controlador.Controlador;
import modelo.proveedores.ProveedoresDAO;

public class ProveedoresView extends JFrame {

	public ProveedoresView() {
		JPanel ventanaComponentes = new JPanel();
		ImageIcon icono=new ImageIcon("img/icono.png");
		this.setIconImage(icono.getImage());
		this.setTitle("CoolPC - Proveedores");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		setResizable(false);
		setContentPane(ventanaComponentes);
		ventanaComponentes.setLayout(null);
		LaminaComponentes lamina=new LaminaComponentes();
		add(lamina.panelDerecho());
		add(lamina.panelIzquierdo());
	}
	
	class LaminaComponentes extends JPanel implements ActionListener, MouseListener {
		//Paneles
		JPanel panelRegistrar = new JPanel();
		JPanel panelMostrar=new JPanel();
		JPanel panelDerecho = new JPanel();
		JPanel panelIzquierdo = new JPanel();
		//Botones
		JButton ejecutarRegistro=new JButton("Registrar");
		JButton botonSalir = new JButton("Salir");
		JButton botonMostrar = new JButton("Mostrar");
		JButton botonRegistrar = new JButton("Registrar");
		//TextFields
		JTextField nombreP = new JTextField(10);
		JTextField tlfo = new JTextField(10);
		JTextField direccion = new JTextField(10);
		//Labels
		JLabel labelNombre=new JLabel("Nombre");
		JLabel labelTlfo=new JLabel("Teléfono");
		JLabel labelDireccion=new JLabel("Dirección");
		//Tabla
		JTable tablaProveedores=new JTable();
		DefaultTableModel modeloProveedores =new MainView.NonEditableTableModel();
		JScrollPane panelScrollProveedores =new JScrollPane();
		//Menu popup
		JPopupMenu menu=new JPopupMenu();
		JMenuItem menuItem=new JMenuItem("Eliminar");

		public Component panelDerecho() {
			panelDerecho.setBounds(201, 0, 783, 561);
			panelDerecho.setBackground(new Color(221, 235, 247));
			panelDerecho.setLayout(null);
			
			JLabel tituloComponentes = new JLabel("Proveedores");
			tituloComponentes.setBounds(10, 11, 763, 56);
			tituloComponentes.setHorizontalAlignment(SwingConstants.CENTER);
			tituloComponentes.setForeground(Color.BLACK);
			tituloComponentes.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 56));
			panelDerecho.add(tituloComponentes);
			panelDerecho.add(panelRegistrar());
			panelDerecho.add(panelMostrar());
			panelMostrar.setVisible(false);
			return panelDerecho;
		}
		public Component panelIzquierdo() {
			panelIzquierdo.setBounds(0, 0, 200, 561);
			panelIzquierdo.setBackground(new Color(91, 155, 213));
			panelIzquierdo.setLayout(null);

			JLabel imagen=new JLabel();
			imagen.setBounds(50, 0, 150, 150);
			imagen.setLayout(null);
			ImageIcon img=new ImageIcon("img/logo.png");
			Image imgX=img.getImage().getScaledInstance(100,100,Image.SCALE_SMOOTH);
			imagen.setIcon(new ImageIcon(imgX));
			panelIzquierdo.add(imagen);

			botonMostrar.setForeground(Color.BLACK);
			botonMostrar.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
			botonMostrar.setBackground(new Color(221, 235, 247));
			botonMostrar.setBounds(10, 160, 180, 58);
			botonMostrar.addActionListener(this);
			panelIzquierdo.add(botonMostrar);

			botonRegistrar.setForeground(Color.BLACK);
			botonRegistrar.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
			botonRegistrar.setBackground(new Color(221, 235, 247));
			botonRegistrar.setBounds(10, 230, 180, 58);
			botonRegistrar.addActionListener(this);
			panelIzquierdo.add(botonRegistrar);

			botonSalir.setForeground(Color.BLACK);
			botonSalir.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
			botonSalir.setBackground(new Color(221, 235, 247));
			botonSalir.setBounds(10, 478, 180, 58);
			botonSalir.addActionListener(this);
			panelIzquierdo.add(botonSalir);
			return panelIzquierdo;
		}
		public Component panelRegistrar() {
			panelRegistrar.setBounds(0, 90, 783, 481);
			panelRegistrar.setBackground(new Color(221, 235, 247));
			panelRegistrar.setLayout(null);

			JLabel tituloRegistrar = new JLabel("Registrar proveedor");
			tituloRegistrar.setBounds(10, 20, 763, 40);
			tituloRegistrar.setHorizontalAlignment(SwingConstants.CENTER);
			tituloRegistrar.setForeground(Color.BLACK);
			tituloRegistrar.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 30));
			panelRegistrar.add(tituloRegistrar);

			nombreP.setBounds(280, 100, 200, 30);
			panelRegistrar.add(nombreP);
			labelNombre.setBounds(150, 100, 100, 30);
			labelNombre.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
			labelNombre.setForeground(Color.BLACK);
			panelRegistrar.add(labelNombre);

			tlfo.setBounds(280, 140, 200, 30);
			panelRegistrar.add(tlfo);
			labelTlfo.setBounds(150, 140, 100, 30);
			labelTlfo.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
			labelTlfo.setForeground(Color.BLACK);
			panelRegistrar.add(labelTlfo);

			direccion.setBounds(280, 180, 200, 30);
			panelRegistrar.add(direccion);
			labelDireccion.setBounds(150, 180, 100, 30);
			labelDireccion.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
			labelDireccion.setForeground(Color.BLACK);
			panelRegistrar.add(labelDireccion);

			ejecutarRegistro.setForeground(Color.WHITE);
			ejecutarRegistro.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
			ejecutarRegistro.setBackground(new Color(91, 155, 213));
			ejecutarRegistro.setBounds(280, 350, 200, 58);
			ejecutarRegistro.addActionListener(this);
			panelRegistrar.add(ejecutarRegistro);
			return panelRegistrar;
		}

		public Component panelMostrar(){
			panelMostrar.setBounds(0, 90, 783, 481);
			panelMostrar.setBackground(new Color(221, 235, 247));
			panelMostrar.setLayout(null);

			JLabel tituloMostrar = new JLabel("Mostrar proveedores");
			tituloMostrar.setBounds(10, 20, 763, 40);
			tituloMostrar.setHorizontalAlignment(SwingConstants.CENTER);
			tituloMostrar.setForeground(Color.BLACK);
			tituloMostrar.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 30));
			panelMostrar.add(tituloMostrar);

			panelScrollProveedores.setBounds(140,140,500,200);
			tablaProveedores.setEnabled(true);
			tablaProveedores.setModel(modeloProveedores);
			modeloProveedores.addColumn("Nombre");
			modeloProveedores.addColumn("Telefono");
			modeloProveedores.addColumn("Dirección");
			tablaProveedores.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			tablaProveedores.getTableHeader().setReorderingAllowed(false);
			tablaProveedores.getTableHeader().setBackground(new Color(91, 155, 213));
			tablaProveedores.getTableHeader().setForeground(Color.WHITE);
			TableColumnModel columna=tablaProveedores.getColumnModel();
			columna.getColumn(0).setPreferredWidth(200);
			columna.getColumn(2).setPreferredWidth(200);

			panelScrollProveedores.setViewportView(tablaProveedores);
			panelScrollProveedores.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			panelMostrar.add(panelScrollProveedores);

			menuItem.addActionListener(this);
			menu.add(menuItem);
			tablaProveedores.setComponentPopupMenu(menu);
			tablaProveedores.addMouseListener(this);
			return panelMostrar;
		}

		public void actionPerformed(ActionEvent e){
			Object evento=e.getSource();
			if (evento==botonSalir){
				MainView main=new MainView();
				main.setVisible(true);
				dispose();
			}else if(evento==botonRegistrar) {
				panelRegistrar.setVisible(true);
				panelMostrar.setVisible(false);
			}else if(evento==botonMostrar){
				panelRegistrar.setVisible(false);
				panelMostrar.setVisible(true);
				ProveedoresDAO.rellenarTablaProveedores(modeloProveedores);
			}else if(evento==ejecutarRegistro){
				if(Controlador.checkFieldsProveedores(nombreP, tlfo, direccion)!=0) {
					ProveedoresDAO.registrarProveedor(nombreP.getText(),tlfo.getText(),direccion.getText());
				}else {
					Mensaje error=new Mensaje("Comprueba que los datos introducidos sean correctos","Error");
					error.setVisible(true);
				}
				
			}else if(evento==menuItem){
				if(tablaProveedores.getSelectedRowCount()!=0) {
					ProveedoresDAO.eliminarProveedor(modeloProveedores, tablaProveedores.getSelectedRow());
					ProveedoresDAO.rellenarTablaProveedores(modeloProveedores);
				}else{
					Mensaje error=new Mensaje("No has seleccionado ningún proveedor","Error");
					error.setVisible(true);
				}

			}
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			Point punto=e.getPoint();
			int fila=tablaProveedores.rowAtPoint(punto);
			tablaProveedores.setRowSelectionInterval(fila,fila);
		}
		@Override
		public void mousePressed(MouseEvent e) {}
		@Override
		public void mouseReleased(MouseEvent e) {}
		@Override
		public void mouseEntered(MouseEvent e) {}
		@Override
		public void mouseExited(MouseEvent e) {}
	}
}
