package vista;
import controlador.Controlador;
import modelo.componentes.ComponentesVO;
import modelo.componentes.ComponentesDAO;
import modelo.proveedores.ProveedoresVO;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.*;

public class ComponentesView extends JFrame {
	public ComponentesView() {
		JPanel ventanaComponentes = new JPanel();
		ImageIcon icono=new ImageIcon("img/icono.png");
		this.setIconImage(icono.getImage());
		this.setTitle("CoolPC - Componentes");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		setResizable(false);
		setContentPane(ventanaComponentes);
		ventanaComponentes.setLayout(null);
		LaminaComponentes lamina = new LaminaComponentes();
		ventanaComponentes.add(lamina.panelDerecho());
		ventanaComponentes.add(lamina.panelIzquierdo());
	}

	class LaminaComponentes extends JPanel implements ActionListener, ChangeListener {
		//Arrays
		String[] componentesTipoMostrar = {"Procesador", "Tarjeta gráfica", "Placa base", "Memoria RAM", "Disco Duro", "Fuente de alimentación"};
		String[] arrayComponentesTipo = {" ","Procesador", "Tarjeta gráfica", "Placa base", "Memoria RAM", "Disco Duro", "Fuente de alimentación"};
		String[] arrayCertificado = {"80+ Bronze", "80+ Silver", "80+ Gold", "80+ Platinum"};
		String[]arrayDiscos={"SSD","HDD","SSHD"};
		ArrayList<ProveedoresVO> arrayProveedores = ComponentesDAO.mostrarProveedores();
		ArrayList<ComponentesVO> arrayComponentes = ComponentesDAO.mostrarComponentes();
		//Botones
		JButton botonSalir = new JButton("Salir");
		JButton botonSolicitar = new JButton("Solicitar");
		JButton botonMostrar = new JButton("Mostrar");
		JButton botonDevolucion = new JButton("Devolución");
		JButton ejecutarSolicitar=new JButton("Solicitar");
		JButton ejecutarDevolucion=new JButton("Devolución");
		JButton ejecutarSolicitarExistente=new JButton("Solicitar");
		//Paneles
		JPanel panelIzquierdo = new JPanel();
		JPanel panelSolicitar = new JPanel();
		JPanel panelSolicitarExistente=new JPanel();
		JPanel panelDevolucion = new JPanel();
		JPanel panelMostrar = new JPanel();
		JPanel panelDerecho = new JPanel();
		//ComboBox
		JComboBox<String> tipo = new JComboBox<>(arrayComponentesTipo);
		JComboBox<String>tipoExistente=new JComboBox<>(arrayComponentesTipo);
		JComboBox<String>listaComponentes=new JComboBox<>();
		JComboBox<String>proveedorExistente=new JComboBox<>();
		JComboBox<String>proveedor=new JComboBox<>();
		JComboBox<String>devolucionComponente=new JComboBox<>();
		JComboBox<Integer>cantidadDevolucion=new JComboBox<>();
		JComboBox<String>tipoDevolucion=new JComboBox<>(arrayComponentesTipo);
		JComboBox<String>tipoMostrar=new JComboBox<>(componentesTipoMostrar);
		JComboBox<String>tipoDiscos=new JComboBox<>(arrayDiscos);
		JComboBox<String>tipoCertificado=new JComboBox<>(arrayCertificado);
		//TextFields formularios
		JTextField nombreC = new JTextField(10);
		JTextField marca = new JTextField(10);
		JTextField precio = new JTextField(10);
		JTextField cantidad = new JTextField(10);
		JTextField atributo1 = new JTextField(15);
		JTextField atributo2 = new JTextField(15);
		JTextField cantidadExistente=new JTextField(15);
		//RadioButton
		JRadioButton nuevoComponente=new JRadioButton("Solicitar nuevo componente");
		JRadioButton componenteExistente=new JRadioButton("Solicitar componente en stock");
		ButtonGroup grupoBotones=new ButtonGroup();
		//Labels
		JLabel labelNombre=new JLabel("Modelo");
		JLabel labelMarca=new JLabel("Marca");
		JLabel labelTipo=new JLabel("Tipo");
		JLabel labelPrecio=new JLabel("Precio");
		JLabel labelSecundariaPrecio=new JLabel("€/Und");
		JLabel labelCantidad=new JLabel("Cantidad");
		JLabel labelSecundariaCantidad=new JLabel("Unidades");
		JLabel labelCantidadDevolucion=new JLabel("Cantidad");
		JLabel labelAtributo1=new JLabel();
		JLabel labelAtributo2=new JLabel();
		JLabel labelProveedores=new JLabel("Proveedor");
		JLabel labelComponenteDevolucion=new JLabel("Componente");
		JLabel labelTipoComponente=new JLabel ("Tipo");
		JLabel tituloSolicitar = new JLabel("Solicitar stock a proveedor");
		JLabel labelTipoExistente=new JLabel("Tipo");
		JLabel labelComponentes=new JLabel("Componente");
		JLabel labelProveedorexistente=new JLabel("Proveedor");
		JLabel labelCantidadExistente=new JLabel("Cantidad");
		JLabel tituloComponentes = new JLabel("Componentes");
		JLabel imagen=new JLabel();
		//Tabla
		JTable tablaComponentes=new JTable();
		DefaultTableModel modelo=new MainView.NonEditableTableModel();
		JScrollPane panelScroll =new JScrollPane();

		public Component panelDerecho() {
			panelDerecho.setBounds(201, 0, 783, 561);
			panelDerecho.setBackground(new Color(221, 235, 247));
			panelDerecho.setLayout(null);

			tituloComponentes.setBounds(10, 11, 763, 56);
			tituloComponentes.setHorizontalAlignment(SwingConstants.CENTER);
			tituloComponentes.setForeground(Color.BLACK);
			tituloComponentes.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 56));

			tituloSolicitar.setBounds(10, 100, 763, 40);
			tituloSolicitar.setHorizontalAlignment(SwingConstants.CENTER);
			tituloSolicitar.setForeground(Color.BLACK);
			tituloSolicitar.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 30));
			panelDerecho.add(tituloSolicitar);

			componenteExistente.setBounds(80, 187, 300, 30);
			componenteExistente.setBackground(new Color(221, 235, 247));
			componenteExistente.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 17));
			componenteExistente.setForeground(Color.BLACK);
			componenteExistente.addChangeListener(this);
			panelDerecho.add(componenteExistente);

			grupoBotones.add(componenteExistente);
			nuevoComponente.setBounds(430, 187, 300, 30);
			nuevoComponente.setBackground(new Color(221, 235, 247));
			nuevoComponente.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 17));
			nuevoComponente.setForeground(Color.BLACK);
			nuevoComponente.addChangeListener(this);
			grupoBotones.add(nuevoComponente);
			panelDerecho.add(nuevoComponente);
			nuevoComponente.setSelected(true);

			panelDerecho.add(tituloComponentes);
			panelDerecho.add(panelSolicitar());
			panelDerecho.add(panelDevolucion());
			panelDerecho.add(panelMostrar());
			panelDerecho.add(panelSolicitarExistente());
			panelSolicitarExistente.setVisible(false);
			panelMostrar.setVisible(false);
			panelDevolucion.setVisible(false);
			panelSolicitarExistente.setVisible(false);
			return panelDerecho;
		}

		public Component panelIzquierdo() {
			panelIzquierdo.setBounds(0, 0, 200, 561);
			panelIzquierdo.setBackground(new Color(91, 155, 213));
			panelIzquierdo.setLayout(null);

			imagen.setBounds(50, 0, 150, 150);
			imagen.setLayout(null);
			ImageIcon img=new ImageIcon("img/logo.png");
			Image imgX=img.getImage().getScaledInstance(100,100,Image.SCALE_SMOOTH);
			imagen.setIcon(new ImageIcon(imgX));
			panelIzquierdo.add(imagen);

			botonSolicitar.setBounds(10, 159, 180, 58);
			botonSolicitar.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
			botonSolicitar.setBackground(new Color(221, 235, 247));
			botonSolicitar.setForeground(Color.BLACK);
			botonSolicitar.addActionListener(this);
			panelIzquierdo.add(botonSolicitar);

			botonMostrar.setForeground(Color.BLACK);
			botonMostrar.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
			botonMostrar.setBackground(new Color(221, 235, 247));
			botonMostrar.setBounds(10, 228, 180, 58);
			botonMostrar.addActionListener(this);
			panelIzquierdo.add(botonMostrar);

			botonDevolucion.setForeground(Color.BLACK);
			botonDevolucion.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
			botonDevolucion.setBackground(new Color(221, 235, 247));
			botonDevolucion.setBounds(10, 297, 180, 58);
			botonDevolucion.addActionListener(this);
			panelIzquierdo.add(botonDevolucion);

			botonSalir.setForeground(Color.BLACK);
			botonSalir.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
			botonSalir.setBackground(new Color(221, 235, 247));
			botonSalir.setBounds(10, 478, 180, 58);
			botonSalir.addActionListener(this);
			panelIzquierdo.add(botonSalir);
			return panelIzquierdo;
		}

		public Component panelSolicitar() {
			panelSolicitar.setBounds(0, 187, 783, 370);
			panelSolicitar.setBackground(new Color(221, 235, 247));
			panelSolicitar.setLayout(null);

			nombreC.setBounds(180, 60, 200, 30);
			panelSolicitar.add(nombreC);
			labelNombre.setBounds(70, 60, 100, 30);
			labelNombre.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
			labelNombre.setForeground(Color.BLACK);
			panelSolicitar.add(labelNombre);

			marca.setBounds(180, 100, 200, 30);
			panelSolicitar.add(marca);
			labelMarca.setBounds(70, 100, 100, 30);
			labelMarca.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
			labelMarca.setForeground(Color.BLACK);
			panelSolicitar.add(labelMarca);

			tipo.setBounds(180, 140, 200, 30);
			tipo.addActionListener(this);
			panelSolicitar.add(tipo);
			labelTipo.setBounds(70, 140, 100, 30);
			labelTipo.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
			labelTipo.setForeground(Color.BLACK);
			panelSolicitar.add(labelTipo);

			precio.setBounds(180, 180, 50, 30);
			panelSolicitar.add(precio);
			labelPrecio.setBounds(70, 180, 100, 30);
			labelPrecio.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
			labelPrecio.setForeground(Color.BLACK);
			labelSecundariaPrecio.setBounds(240,180,100,30);
			labelSecundariaPrecio.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
			labelSecundariaPrecio.setForeground(Color.BLACK);
			panelSolicitar.add(labelSecundariaPrecio);
			panelSolicitar.add(labelPrecio);

			cantidad.setBounds(530, 60, 50, 30);
			panelSolicitar.add(cantidad);
			labelCantidad.setBounds(410, 60, 100, 30);
			labelCantidad.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
			labelCantidad.setForeground(Color.BLACK);
			labelSecundariaCantidad.setBounds(590, 60, 100, 30);
			labelSecundariaCantidad.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
			labelSecundariaCantidad.setForeground(Color.BLACK);
			panelSolicitar.add(labelSecundariaCantidad);
			panelSolicitar.add(labelCantidad);

			atributo1.setBounds(530, 100, 200, 30);
			panelSolicitar.add(atributo1);
			labelAtributo1.setBounds(410, 100, 150, 30);
			labelAtributo1.setText("Núcleos");
			labelAtributo1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
			labelAtributo1.setForeground(Color.BLACK);
			panelSolicitar.add(labelAtributo1);

			tipoDiscos.setBounds(530, 100, 200, 30);
			tipoDiscos.setVisible(false);
			panelSolicitar.add(tipoDiscos);

			tipoCertificado.setBounds(530, 100, 200, 30);
			tipoCertificado.setVisible(false);
			panelSolicitar.add(tipoCertificado);

			atributo2.setBounds(530, 140, 200, 30);
			panelSolicitar.add(atributo2);
			labelAtributo2.setBounds(410, 140, 150, 30);
			labelAtributo2.setText("Consumo");
			labelAtributo2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
			labelAtributo2.setForeground(Color.BLACK);
			panelSolicitar.add(labelAtributo2);

			//Se rellena el JComboBox de proveedores
			for(int i = 0; i< arrayProveedores.size(); i++){
				proveedor.addItem(arrayProveedores.get(i).getNombre());
				proveedorExistente.addItem(arrayProveedores.get(i).getNombre());
			}
			proveedor.setBounds(530,180,200,30);
			panelSolicitar.add(proveedor);
			labelProveedores.setBounds(410, 180, 150, 30);
			labelProveedores.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
			labelProveedores.setForeground(Color.BLACK);
			panelSolicitar.add(labelProveedores);

			ejecutarSolicitar.setForeground(Color.WHITE);
			ejecutarSolicitar.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
			ejecutarSolicitar.setBackground(new Color(91, 155, 213));
			ejecutarSolicitar.setBounds(280, 270, 150, 58);
			ejecutarSolicitar.addActionListener(this);
			panelSolicitar.add(ejecutarSolicitar);
			return panelSolicitar;
		}
		public Component panelSolicitarExistente(){
			panelSolicitarExistente.setBounds(0, 187, 783, 370);
			panelSolicitarExistente.setBackground(new Color(221, 235, 247));
			panelSolicitarExistente.setLayout(null);

			tipoExistente.setBounds(300, 60, 200, 30);
			tipoExistente.addActionListener(this);
			tipoExistente.add(this);
			panelSolicitarExistente.add(tipoExistente);
			labelTipoExistente.setBounds(150, 60, 200, 30);
			labelTipoExistente.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
			labelTipoExistente.setForeground(Color.BLACK);
			panelSolicitarExistente.add(labelTipoExistente);

			listaComponentes.setBounds(300, 100, 200, 30);
			panelSolicitarExistente.add(listaComponentes);
			labelComponentes.setBounds(150, 100, 200, 30);
			labelComponentes.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
			labelComponentes.setForeground(Color.BLACK);
			panelSolicitarExistente.add(labelComponentes);

			proveedorExistente.setBounds(300, 140, 200, 30);
			panelSolicitarExistente.add(proveedorExistente);
			labelProveedorexistente.setBounds(150, 140, 200, 30);
			labelProveedorexistente.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
			labelProveedorexistente.setForeground(Color.BLACK);
			panelSolicitarExistente.add(labelProveedorexistente);

			cantidadExistente.setBounds(300, 180, 200, 30);
			panelSolicitarExistente.add(cantidadExistente);
			labelCantidadExistente.setBounds(150, 180, 200, 30);
			labelCantidadExistente.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
			labelCantidadExistente.setForeground(Color.BLACK);
			panelSolicitarExistente.add(labelCantidadExistente);

			ejecutarSolicitarExistente.setForeground(Color.WHITE);
			ejecutarSolicitarExistente.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
			ejecutarSolicitarExistente.setBackground(new Color(91, 155, 213));
			ejecutarSolicitarExistente.setBounds(300, 260, 200, 58);
			ejecutarSolicitarExistente.addActionListener(this);
			panelSolicitarExistente.add(ejecutarSolicitarExistente);

			return panelSolicitarExistente;
		}

		public Component panelDevolucion(){
			panelDevolucion.setBounds(0, 90, 783, 481);
			panelDevolucion.setBackground(new Color(221, 235, 247));
			panelDevolucion.setLayout(null);

			JLabel tituloDevolucion = new JLabel("Devolver componente defectuoso");
			tituloDevolucion.setBounds(10, 20, 763, 40);
			tituloDevolucion.setHorizontalAlignment(SwingConstants.CENTER);
			tituloDevolucion.setForeground(Color.BLACK);
			tituloDevolucion.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 30));
			panelDevolucion.add(tituloDevolucion);

			tipoDevolucion.setBounds(280, 100, 200, 30);
			tipoDevolucion.addActionListener(this);
			panelDevolucion.add(tipoDevolucion);
			labelTipoComponente.setBounds(100, 100, 200, 30);
			labelTipoComponente.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
			labelTipoComponente.setForeground(Color.BLACK);
			tipoDevolucion.setVisible(false);
			panelDevolucion.add(labelTipoComponente);

			devolucionComponente.setBounds(280, 140, 200, 30);
			devolucionComponente.addActionListener(this);
			devolucionComponente.setVisible(false);
			panelDevolucion.add(devolucionComponente);

			labelComponenteDevolucion.setBounds(100, 140, 200, 30);
			labelComponenteDevolucion.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
			labelComponenteDevolucion.setForeground(Color.BLACK);
			panelDevolucion.add(labelComponenteDevolucion);

			cantidadDevolucion.setBounds(280,180,200,30);
			panelDevolucion.add(cantidadDevolucion);
			labelCantidadDevolucion.setBounds(100,180,200,30);
			labelCantidadDevolucion.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
			labelCantidadDevolucion.setForeground(Color.BLACK);
			panelDevolucion.add(labelCantidadDevolucion);

			ejecutarDevolucion.setBounds(280,350,200,58);
			ejecutarDevolucion.setForeground(Color.WHITE);
			ejecutarDevolucion.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
			ejecutarDevolucion.setBackground(new Color(91, 155, 213));
			ejecutarDevolucion.addActionListener(this);
			panelDevolucion.add(ejecutarDevolucion);

			return panelDevolucion;
		}
		public Component panelMostrar(){
			panelMostrar.setBounds(0, 90, 783, 481);
			panelMostrar.setBackground(new Color(221, 235, 247));
			panelMostrar.setLayout(null);

			JLabel tituloMostrar = new JLabel("Mostrar componentes en stock");
			tituloMostrar.setBounds(10, 20, 763, 40);
			tituloMostrar.setHorizontalAlignment(SwingConstants.CENTER);
			tituloMostrar.setForeground(Color.BLACK);
			tituloMostrar.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 30));
			panelMostrar.add(tituloMostrar);

			tipoMostrar.setBounds(280, 100, 200, 30);
			tipoMostrar.addActionListener(this);
			tipoMostrar.setVisible(false);
			panelMostrar.add(tipoMostrar);

			panelScroll.setBounds(140,140,500,200);
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
			ComponentesDAO.mostrarComponentesTabla("Procesador",modelo);

			panelScroll.setViewportView(tablaComponentes);
			panelScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			panelScroll.setVisible(false);
			panelMostrar.add(panelScroll);

			return panelMostrar;
		}

		public void actionPerformed(ActionEvent e){
			Object evento = e.getSource();
			if (evento == botonSalir) {
				MainView main = new MainView();
				main.setVisible(true);
				dispose();
			} else if (evento == botonSolicitar) {
				panelSolicitar.setVisible(true);
				panelMostrar.setVisible(false);
				panelDevolucion.setVisible(false);
				tipoDevolucion.setVisible(false);
				nuevoComponente.setVisible(true);
				panelSolicitarExistente.setVisible(false);
				componenteExistente.setVisible(true);
				tituloSolicitar.setVisible(true);
			} else if (evento == botonDevolucion) {
				panelSolicitar.setVisible(false);
				panelMostrar.setVisible(false);
				tipoDevolucion.setVisible(true);
				devolucionComponente.setVisible(true);
				panelSolicitarExistente.setVisible(false);
				panelDevolucion.setVisible(true);
				nuevoComponente.setVisible(false);
				componenteExistente.setVisible(false);
				tituloSolicitar.setVisible(false);
			} else if (evento == botonMostrar) {
				panelSolicitar.setVisible(false);
				panelMostrar.setVisible(true);
				panelDevolucion.setVisible(false);
				tipoMostrar.setVisible(true);
				panelScroll.setVisible(true);
				nuevoComponente.setVisible(false);
				panelSolicitarExistente.setVisible(false);
				componenteExistente.setVisible(false);
				tituloSolicitar.setVisible(false);
				ComponentesDAO.mostrarComponentesTabla(tipoMostrar.getSelectedItem().toString(),modelo);
				modelo.fireTableDataChanged();
			}else if(evento==ejecutarSolicitar) {
				if(Controlador.checkFildsComponentes(marca,nombreC,tipo,cantidad,precio,atributo1,atributo2,tipoCertificado,tipoDiscos)!=0) {
					if (tipo.getSelectedItem().toString().equals("Disco Duro")) {
						ComponentesDAO.insertarComponentes(nombreC.getText(), marca.getText(), tipo.getSelectedItem().toString(), Double.parseDouble(precio.getText()), Integer.parseInt(cantidad.getText()), tipoDiscos.getSelectedItem().toString(), atributo2.getText(), arrayProveedores.get(proveedor.getSelectedIndex()).getIdp());
					} else if (tipo.getSelectedItem().toString().equals("Fuente de alimentación")) {
						ComponentesDAO.insertarComponentes(nombreC.getText(), marca.getText(), tipo.getSelectedItem().toString(), Double.parseDouble(precio.getText()), Integer.parseInt(cantidad.getText()), tipoCertificado.getSelectedItem().toString(), atributo2.getText(), arrayProveedores.get(proveedor.getSelectedIndex()).getIdp());
					} else {
						ComponentesDAO.insertarComponentes(nombreC.getText(), marca.getText(), tipo.getSelectedItem().toString(), Double.parseDouble(precio.getText()), Integer.parseInt(cantidad.getText()), atributo1.getText(), atributo2.getText(), arrayProveedores.get(proveedor.getSelectedIndex()).getIdp());
					}
					nombreC.setText("");
					marca.setText("");
					precio.setText("");
					cantidad.setText("");
					atributo1.setText("");
					atributo2.setText("");
				}else{
					Mensaje error=new Mensaje("Comprueba que los datos introducidos sean correctos","Error");
					error.setVisible(true);
				}
			}else if(evento==ejecutarSolicitarExistente){
				if(Controlador.checkFieldsComponentesExistente(listaComponentes,proveedorExistente,cantidadExistente)!=0){
					ComponentesDAO.añadirComponenteExistente(listaComponentes.getSelectedItem().toString(),Integer.parseInt(cantidadExistente.getText()));
					cantidadExistente.setText("");
				}else{
					Mensaje error = new Mensaje("Comprueba que los datos sean correctos","Error");
					error.setVisible(true);
				}
			}else if(evento==tipoExistente){
				try{
					ComponentesDAO.rellenarComboBoxComponentes(listaComponentes,tipoExistente, arrayComponentes);
				}catch (Exception o){
					ComponentesDAO.rellenarComboBoxComponentes(listaComponentes,tipoExistente, arrayComponentes);
				}
			}else if(evento==tipoDevolucion) {
				try{
					ComponentesDAO.rellenarComboBoxComponentes(devolucionComponente,tipoDevolucion, arrayComponentes);
				}catch (Exception o){
					ComponentesDAO.rellenarComboBoxComponentes(devolucionComponente,tipoDevolucion, arrayComponentes);
				}
			}else if(evento==devolucionComponente){
				try{
					ComponentesDAO.setCantidad(cantidadDevolucion,devolucionComponente, arrayComponentes);
				}catch (Exception o){
					ComponentesDAO.setCantidad(cantidadDevolucion,devolucionComponente, arrayComponentes);
				}
			}else if(evento==ejecutarDevolucion){
				try {
					if(Integer.parseInt(cantidadDevolucion.getSelectedItem().toString())>0){
						ComponentesDAO.devolucion(devolucionComponente.getSelectedItem().toString(),Integer.parseInt(cantidadDevolucion.getSelectedItem().toString()));
						ComponentesDAO.setCantidad(cantidadDevolucion,devolucionComponente, arrayComponentes);
					}else{
						Mensaje error = new Mensaje("No hay stock para devolver","Error");
						error.setVisible(true);
					}
				} catch (Exception o) {
					Mensaje error = new Mensaje("El componente no ha podido ser devuelto","Error");
					error.setVisible(true);
				}
			}else if(evento==tipoMostrar){
				ComponentesDAO.mostrarComponentesTabla(tipoMostrar.getSelectedItem().toString(),modelo);
				modelo.fireTableDataChanged();
			}else if(evento==tipo) {
				switch(tipo.getSelectedItem().toString()) {
					case "Procesador":
						labelAtributo1.setText("Núcleos");
						labelAtributo2.setText("Consumo");
						tipoDiscos.setVisible(false);
						atributo1.setVisible(true);
						tipoCertificado.setVisible(false);
						break;
					case "Tarjeta gráfica":
						labelAtributo1.setText("VRAM");
						labelAtributo2.setText("Consumo");
						tipoDiscos.setVisible(false);
						atributo1.setVisible(true);
						tipoCertificado.setVisible(false);
						break;
					case "Placa base":
						labelAtributo1.setText("Socket");
						labelAtributo2.setText("Chipset");
						tipoDiscos.setVisible(false);
						atributo1.setVisible(true);
						tipoCertificado.setVisible(false);
						break;
					case "Memoria RAM":
						labelAtributo1.setText("Velocidad");
						labelAtributo2.setText("Capacidad");
						tipoDiscos.setVisible(false);
						atributo1.setVisible(true);
						tipoCertificado.setVisible(false);
						break;
					case "Disco Duro":
						labelAtributo1.setText("Tipo");
						atributo1.setVisible(false);
						tipoDiscos.setVisible(true);
						labelAtributo2.setText("Capacidad");
						tipoCertificado.setVisible(false);
						break;
					case "Fuente de alimentación":
						labelAtributo1.setText("Certificado");
						labelAtributo2.setText("Potencia");
						tipoDiscos.setVisible(false);
						atributo1.setVisible(false);
						tipoCertificado.setVisible(true);
						break;
				}
			}
		}
		public void stateChanged(ChangeEvent o){
			if(nuevoComponente.isSelected()) {
				panelSolicitar.setVisible(true);
				panelSolicitarExistente.setVisible(false);
			}else if(componenteExistente.isSelected()) {
				panelSolicitar.setVisible(false);
				panelSolicitarExistente.setVisible(true);
			}
		}
	}
}
