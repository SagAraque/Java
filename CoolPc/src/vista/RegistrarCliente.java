package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import controlador.Controlador;
import modelo.clientes.ClientesDAO;
import modelo.pedidos.PedidosDAO;
import vista.Mensaje.LaminaMensaje;

public class RegistrarCliente extends JFrame {
	private JPanel contentPane;
    public RegistrarCliente() {
		ImageIcon icono=new ImageIcon("img/icono.png");
		this.setIconImage(icono.getImage());
		this.setTitle("CoolPC - Clientes");
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 400, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        LaminaClientes lamina=new LaminaClientes();
        add(lamina.panelSuperior());
        add(lamina.panelInferior());
    }
    
    class LaminaClientes extends JPanel implements ActionListener{
    	JPanel panelSuperior=new JPanel();
    	JPanel panelInferior=new JPanel();
    	JLabel tituloClientes=new JLabel("Registrar cliente");
    	JLabel labelNombre=new JLabel("Nombre");
    	JLabel labelDni=new JLabel("DNI");
    	JLabel labelDireccion=new JLabel("Direccion");
    	JTextField nombre=new JTextField();
    	JTextField dni=new JTextField();
    	JTextField direccion=new JTextField();
    	JButton boton=new JButton("Registrar");
    	
    	public Component panelSuperior() {
    		panelSuperior.setBounds(0,0,400,100);
    		panelSuperior.setLayout(new BorderLayout(0, 0));
            panelSuperior.setBackground(new Color(91, 155, 213));
            
            tituloClientes.setBounds(0,0,400,100);
            tituloClientes.setHorizontalAlignment(SwingConstants.CENTER);
            tituloClientes.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 30));
            tituloClientes.setForeground(Color.WHITE);
            panelSuperior.add(tituloClientes);
            
    		return panelSuperior;
    	}
    	
    	public Component panelInferior() {
    		panelInferior.setBounds(0, 80, 400, 400);
    		panelInferior.setLayout(null);
    		panelInferior.setBackground(new Color(221, 235, 247));
    		
    		labelNombre.setBounds(0,50,400,20);
    		labelNombre.setHorizontalAlignment(SwingConstants.CENTER);
    		labelNombre.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
    		labelNombre.setForeground(Color.black);
    		panelInferior.add(labelNombre);
    		nombre.setBounds(100,80,200,30);
    		panelInferior.add(nombre);
    		
    		labelDni.setBounds(0,130,400,20);
    		labelDni.setHorizontalAlignment(SwingConstants.CENTER);
    		labelDni.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
    		labelDni.setForeground(Color.black);
    		panelInferior.add(labelDni);
    		dni.setBounds(100,160,200,30);
    		panelInferior.add(dni);
    		
    		labelDireccion.setBounds(0,210,400,20);
    		labelDireccion.setHorizontalAlignment(SwingConstants.CENTER);
    		labelDireccion.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
    		labelDireccion.setForeground(Color.black);
    		panelInferior.add(labelDireccion);
    		direccion.setBounds(100,240,200,30);
    		panelInferior.add(direccion);
    		
    		boton.setBounds(125, 320, 150, 30);
            boton.setForeground(Color.WHITE);
            boton.setBackground(new Color(91, 155, 213));
            boton.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
            boton.addActionListener(this);
            panelInferior.add(boton);

    		return panelInferior;
    	}

		@Override
		public void actionPerformed(ActionEvent e) {
			Object evento=e.getSource();
			if(evento==boton){
				if(Controlador.checkFieldsClientes(nombre,dni,direccion)!=0){
					ClientesDAO.registrarCliente(nombre.getText(),dni.getText(),direccion.getText());
					dispose();
				}else{
					Mensaje error=new Mensaje("Comprueba que los datos introducidos sean correctos","Error");
					error.setVisible(true);
				}
			}
			
		}
    }
}
