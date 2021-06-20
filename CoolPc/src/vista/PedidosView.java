package vista;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import modelo.componentes.ComponentesDAO;
import modelo.componentes.ComponentesVO;
import modelo.clientes.ClientesVO;
import modelo.pedidos.PedidosDAO;
import modelo.pedidos.PedidosVO;

public class PedidosView extends JFrame{

	public PedidosView() {
		JPanel ventanaPedidos = new JPanel();
		ImageIcon icono=new ImageIcon("img/icono.png");
		this.setIconImage(icono.getImage());
		this.setTitle("CoolPC - Pedidos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		setResizable(false);
		setContentPane(ventanaPedidos);
		ventanaPedidos.setLayout(null);
		LaminaPedidos lamina=new LaminaPedidos();
		add(lamina.panelDerecho());
		add(lamina.panelIzquierdo());
	}
	
	class LaminaPedidos extends JPanel implements ActionListener,MouseListener {
		//Arrays
		String[] componentesTipo = {"","Procesador", "Tarjeta gráfica", "Placa base", "Memoria RAM", "Disco Duro", "Fuente de alimentación"};
		ArrayList<ComponentesVO> arrayComponentes= ComponentesDAO.mostrarComponentes();
		ArrayList<ClientesVO> arrayClientes= PedidosDAO.obtenerClientes();
		ArrayList<PedidosVO>arrayPedidos=PedidosDAO.obtenerPedidos();
		//Paneles
		JPanel panelRealizarPedido = new JPanel();
		JPanel panelVerPedidos=new JPanel();
		//JComboBox
		JComboBox<String> tipoPedidos = new JComboBox<>(componentesTipo);
		JComboBox<String>componentes=new JComboBox<>();
		JComboBox<Integer>cantidad=new JComboBox<>();
		JComboBox<String>clientes=new JComboBox<>();
		JComboBox<Integer>comboBoxPedidos=new JComboBox<>();
		//Labels
		JLabel labelTipo=new JLabel("Tipo");
		JLabel labelComponente =new JLabel("Componente");
		JLabel labelCantidad=new JLabel("Cantidad");
		JLabel labelClientes=new JLabel("Cliente");
		JLabel labelClientesVerPedido=new JLabel("Cliente");
		JLabel labelNombre=new JLabel("Nombre: ");
		JLabel labelDni=new JLabel("DNI: ");
		JLabel labelDireccion=new JLabel("Direccion: ");
		JLabel labelTotal=new JLabel("Total: ");
		//Tabla
		JTable tablaComponentes=new JTable();
		DefaultTableModel modelo=new MainView.NonEditableTableModel();
		JScrollPane panelScroll =new JScrollPane();
		JTable tablaPedidos=new JTable();
		DefaultTableModel modeloPedidos=new MainView.NonEditableTableModel();
		JScrollPane panelScrollPedidos=new JScrollPane();
		//Botones
		JButton botonSalir = new JButton("Salir");
		JButton botonPreparar = new JButton("Preparar");
		JButton botonMostrar = new JButton("Mostrar");
		JButton botonAnadir =new JButton("Añadir");
		JButton nuevoCliente =new JButton("Nuevo");
		JButton realizarPedido=new JButton("Preparar");
		//Menú desplegable
		JPopupMenu menu=new JPopupMenu();
		JMenuItem menuItem=new JMenuItem("Eliminar");

		public Component panelDerecho() {
			JPanel panelDerecho = new JPanel();
			panelDerecho.setBounds(201, 0, 783, 561);
			panelDerecho.setBackground(new Color(221, 235, 247));
			panelDerecho.setLayout(null);

			JLabel tituloPedidos = new JLabel("Pedidos");
			tituloPedidos.setBounds(10, 11, 763, 56);
			tituloPedidos.setHorizontalAlignment(SwingConstants.CENTER);
			tituloPedidos.setForeground(Color.BLACK);
			tituloPedidos.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 56));
			panelDerecho.add(tituloPedidos);
			panelDerecho.add(crearPedido());
			panelDerecho.add(verPedidos());
			panelVerPedidos.setVisible(false);
			return panelDerecho;
		}
		public Component panelIzquierdo() {
			JPanel panelIzquierdo = new JPanel();
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

			botonPreparar.setBounds(10, 159, 180, 58);
			botonPreparar.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
			botonPreparar.setBackground(new Color(221, 235, 247));
			botonPreparar.setForeground(Color.BLACK);
			botonPreparar.addActionListener(this);
			panelIzquierdo.add(botonPreparar);

			botonMostrar.setForeground(Color.BLACK);
			botonMostrar.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
			botonMostrar.setBackground(new Color(221, 235, 247));
			botonMostrar.setBounds(10, 228, 180, 58);
			botonMostrar.addActionListener(this);
			panelIzquierdo.add(botonMostrar);

			botonSalir.setForeground(Color.BLACK);
			botonSalir.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
			botonSalir.setBackground(new Color(221, 235, 247));
			botonSalir.setBounds(10, 478, 180, 58);
			botonSalir.addActionListener(this);
			panelIzquierdo.add(botonSalir);
			return panelIzquierdo;
		}
		public Component crearPedido(){
			panelRealizarPedido.setBounds(0, 90, 783, 481);
			panelRealizarPedido.setBackground(new Color(221, 235, 247));
			panelRealizarPedido.setLayout(null);

			clientes.setBounds(290, 60, 200, 30);
			PedidosDAO.rellenarComboBoxClientes(clientes,arrayClientes);
			clientes.addActionListener(this);
			clientes.addMouseListener(this);
			panelRealizarPedido.add(clientes);
			labelClientes.setBounds(135, 60, 200, 30);
			labelClientes.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
			labelClientes.setForeground(Color.BLACK);
			panelRealizarPedido.add(labelClientes);

			tipoPedidos.setBounds(290, 100, 200, 30);
			tipoPedidos.addActionListener(this);
			panelRealizarPedido.add(tipoPedidos);
			labelTipo.setBounds(135, 100, 200, 30);
			labelTipo.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
			labelTipo.setForeground(Color.BLACK);
			panelRealizarPedido.add(labelTipo);

			componentes.setBounds(290, 140, 200, 30);
			PedidosDAO.rellenarComboBoxComponentes(arrayComponentes,componentes,tipoPedidos);
			componentes.addActionListener(this);
			panelRealizarPedido.add(componentes);
			labelComponente.setBounds(135, 140, 200, 30);
			labelComponente.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
			labelComponente.setForeground(Color.BLACK);
			panelRealizarPedido.add(labelComponente);

			cantidad.setBounds(290, 180, 200, 30);
			panelRealizarPedido.add(cantidad);
			labelCantidad.setBounds(135, 180, 200, 30);
			labelCantidad.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
			labelCantidad.setForeground(Color.BLACK);
			panelRealizarPedido.add(labelCantidad);

			panelScroll.setBounds(140,240,500,100);
			tablaComponentes.setEnabled(true);
			tablaComponentes.setModel(modelo);
			modelo.addColumn("Marca");
			modelo.addColumn("Modelo");
			modelo.addColumn("Cantidad");
			modelo.addColumn("Precio");
			tablaComponentes.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			tablaComponentes.getTableHeader().setReorderingAllowed(false);
			tablaComponentes.getTableHeader().setBackground(new Color(91, 155, 213));
			tablaComponentes.getTableHeader().setForeground(Color.WHITE);
			TableColumnModel columna=tablaComponentes.getColumnModel();
			columna.getColumn(1).setPreferredWidth(200);

			panelScroll.setViewportView(tablaComponentes);
			panelScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			panelRealizarPedido.add(panelScroll);

			nuevoCliente.setBounds(530,60,100,30);
			nuevoCliente.setBackground(new Color(91, 155, 213));
			nuevoCliente.setForeground(new Color(255, 255, 255));
			nuevoCliente.addActionListener(this);
			panelRealizarPedido.add(nuevoCliente);

			botonAnadir.setBounds(530,180,100,30);
			botonAnadir.setBackground(new Color(91, 155, 213));
			botonAnadir.setForeground(new Color(255, 255, 255));
			botonAnadir.addActionListener(this);
			panelRealizarPedido.add(botonAnadir);

			menuItem.addActionListener(this);
			menu.add(menuItem);
			tablaComponentes.setComponentPopupMenu(menu);
			tablaComponentes.addMouseListener(this);

			realizarPedido.setBounds(280,370,200,58);
			realizarPedido.setForeground(Color.WHITE);
			realizarPedido.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
			realizarPedido.setBackground(new Color(91, 155, 213));
			realizarPedido.addActionListener(this);
			panelRealizarPedido.add(realizarPedido);
			return panelRealizarPedido;
		}
		public Component verPedidos(){
			panelVerPedidos.setBounds(0, 90, 783, 481);
			panelVerPedidos.setBackground(new Color(221, 235, 247));
			panelVerPedidos.setLayout(null);

			JLabel tituloVerPedidos = new JLabel("Mostrar pedidos");
			tituloVerPedidos.setBounds(10, 50, 763, 40);
			tituloVerPedidos.setHorizontalAlignment(SwingConstants.CENTER);
			tituloVerPedidos.setForeground(Color.BLACK);
			tituloVerPedidos.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 30));
			panelVerPedidos.add(tituloVerPedidos);

			panelScrollPedidos.setBounds(20,140,350,200);
			tablaPedidos.setEnabled(true);
			tablaPedidos.setModel(modeloPedidos);
			modeloPedidos.addColumn("Marca");
			modeloPedidos.addColumn("Modelo");
			modeloPedidos.addColumn("Cantidad");
			tablaPedidos.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			TableColumnModel columna=tablaPedidos.getColumnModel();
			tablaPedidos.getTableHeader().setBackground(new Color(91, 155, 213));
			tablaPedidos.getTableHeader().setForeground(Color.WHITE);
			columna.getColumn(2).setMaxWidth(100);
			columna.getColumn(0).setMinWidth(90);
			tablaPedidos.getTableHeader().setReorderingAllowed(false);

			comboBoxPedidos.setBounds(290,100,200,30);
			comboBoxPedidos.addActionListener(this);
			panelVerPedidos.add(comboBoxPedidos);

			labelClientesVerPedido.setBounds(450,140,200,30);
			labelClientesVerPedido.setHorizontalAlignment(SwingConstants.CENTER);
			labelClientesVerPedido.setForeground(Color.BLACK);
			labelClientesVerPedido.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
			panelVerPedidos.add(labelClientesVerPedido);

			labelNombre.setBounds(400,180,400,30);
			labelNombre.setHorizontalAlignment(SwingConstants.LEFT);
			labelNombre.setForeground(Color.BLACK);
			labelNombre.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
			panelVerPedidos.add(labelNombre);

			labelDni.setBounds(400,220,400,30);
			labelDni.setHorizontalAlignment(SwingConstants.LEFT);
			labelDni.setForeground(Color.BLACK);
			labelDni.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
			panelVerPedidos.add(labelDni);

			labelDireccion.setBounds(400,260,400,30);
			labelDireccion.setHorizontalAlignment(SwingConstants.LEFT);
			labelDireccion.setForeground(Color.BLACK);
			labelDireccion.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
			panelVerPedidos.add(labelDireccion);

			labelTotal.setBounds(290,380,200,30);
			labelTotal.setHorizontalAlignment(SwingConstants.CENTER);
			labelTotal.setOpaque(true);
			labelTotal.setForeground(Color.WHITE);
			labelTotal.setBackground(new Color(91, 155, 213));
			labelTotal.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
			panelVerPedidos.add(labelTotal);


			panelScrollPedidos.setViewportView(tablaPedidos);
			panelScrollPedidos.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			panelVerPedidos.add(panelScrollPedidos);

			return panelVerPedidos;
		}

		public void actionPerformed(ActionEvent e){
			Object evento=e.getSource();
			if (evento==botonSalir){
				MainView main=new MainView();
				main.setVisible(true);
				dispose();
			}else if(evento==botonPreparar) {
				panelRealizarPedido.setVisible(true);
				panelVerPedidos.setVisible(true);
			}else if(evento==botonMostrar){
				panelVerPedidos.setVisible(true);
				panelRealizarPedido.setVisible(false);
				try{
					PedidosDAO.rellenarComboBoxPedidos(comboBoxPedidos,arrayPedidos);
				}catch(Exception o){
					PedidosDAO.rellenarComboBoxPedidos(comboBoxPedidos,arrayPedidos);
				}
			}else if(evento==realizarPedido){
				if(modelo.getRowCount()>0){
					//Se llama al metodo preparar pedido, a la vez que se actualizan las cantidades y la tabla
					PedidosDAO.prepararPedido(modelo,arrayComponentes,clientes.getSelectedItem().toString());
					while(modelo.getRowCount()!=0){
						modelo.removeRow(0);
					}
					PedidosDAO.setCantidad(cantidad,componentes,arrayComponentes);
					Mensaje exito=new Mensaje("Pedido realizado con exito","Exito");
					exito.setVisible(true);
				}else{
					Mensaje error=new Mensaje("No hay ningún producto seleccionado","Error");
					error.setVisible(true);
				}
			}else if(evento== tipoPedidos){
				try{
					PedidosDAO.rellenarComboBoxComponentes(arrayComponentes,componentes,tipoPedidos);
				}catch (Exception o){
					PedidosDAO.rellenarComboBoxComponentes(arrayComponentes,componentes,tipoPedidos);
				}
			}else if(evento==componentes){
				try{
					PedidosDAO.setCantidad(cantidad,componentes,arrayComponentes);
				}catch (Exception o){
					PedidosDAO.setCantidad(cantidad,componentes,arrayComponentes);
				}
			}else if(evento== botonAnadir){
				try{
					PedidosDAO.añadirComponentePedido(componentes.getSelectedItem().toString(),arrayComponentes,Integer.parseInt(cantidad.getSelectedItem().toString()),modelo);
				}catch (Exception o){
					Mensaje error=new Mensaje("Los campos están vacios","Error");
					error.setVisible(true);
				}
			}else if(evento==nuevoCliente){
				RegistrarCliente registrar=new RegistrarCliente();
				registrar.setVisible(true);
			}else if(evento==menuItem){
				if(tablaComponentes.getSelectedRowCount()!=0) {
					modelo.removeRow(tablaComponentes.getSelectedRow());
				}else{
					Mensaje error=new Mensaje("No has seleccionado ningún componentes","Error");
					error.setVisible(true);
				}
			}else if(evento==comboBoxPedidos){
				PedidosDAO.rellenarTablaVerPedidos(Integer.parseInt(comboBoxPedidos.getSelectedItem().toString()),modeloPedidos);
				ClientesVO cliente=PedidosDAO.obtenerClientePedido(Integer.parseInt(comboBoxPedidos.getSelectedItem().toString()));
				labelNombre.setText("Nombre: "+cliente.getNombre());
				labelDni.setText("DNI: "+cliente.getDNI());
				labelDireccion.setText("Dirección: "+cliente.getDireccion());
				labelTotal.setText("Total: "+arrayPedidos.get(comboBoxPedidos.getSelectedIndex()).getTotal()+"€");
			}
		}

		/**
		 * Se obtiene la posición del raton y se selecciona toda
		 * la final que hay justo esta posición
		 * @param e
		 */
		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getSource()==tablaComponentes){
				Point punto=e.getPoint();
				int fila=tablaComponentes.rowAtPoint(punto);
				tablaComponentes.setRowSelectionInterval(fila,fila);
			}

		}
		@Override
		public void mousePressed(MouseEvent e) {
			if(e.getSource()==clientes){
				arrayClientes=PedidosDAO.obtenerClientes();
				PedidosDAO.rellenarComboBoxClientes(clientes,arrayClientes);
			}
		}
		@Override
		public void mouseReleased(MouseEvent e) {}
		@Override
		public void mouseEntered(MouseEvent e) {}
		@Override
		public void mouseExited(MouseEvent e) {}
	}
}

