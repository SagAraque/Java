package vista;

import modelo.conexion.Conexion;
import vista.MainView;

import javax.swing.*;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Login extends JFrame {
	private JPasswordField contraseña;
	private final JButton botonLogin = new JButton("Iniciar sesión");

	public Login() {
		ImageIcon icono=new ImageIcon("img/icono.png");
		this.setIconImage(icono.getImage());
		this.setTitle("CoolPC - Login");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 340, 255);
		setResizable(false);
		getContentPane().setLayout(null);
		LaminaLogin lamina=new LaminaLogin();
		add(lamina.panelSuperior());
		add(lamina.panelInferior());
	}
	
	class LaminaLogin extends JPanel implements KeyListener {
		JLabel error=new JLabel("Contraseña incorrecta");
		public Component panelSuperior() {
			JPanel panelSuperior = new JPanel();
			panelSuperior.setBounds(0, 0, 324, 48);
			panelSuperior.setLayout(null);
			panelSuperior.setBackground(new Color(91, 155, 213));
			
			JLabel tituloLogin = new JLabel("Login");
			tituloLogin.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 30));
			tituloLogin.setForeground(Color.BLACK);
			tituloLogin.setHorizontalAlignment(SwingConstants.CENTER);
			tituloLogin.setBounds(0, 0, 321, 48);
			panelSuperior.add(tituloLogin);
			return panelSuperior;
		}
		
		public Component panelInferior() {
			JPanel panelInferior = new JPanel();
			panelInferior.setBounds(0, 48, 324, 168);
			panelInferior.setLayout(null);
			panelInferior.setBackground(new Color(221, 235, 247));
			
			botonLogin.setBounds(102, 99, 124, 31);
			botonLogin.setBackground(new Color(91, 155, 213));
			botonLogin.setForeground(new Color(255, 255, 255));
			botonLogin.addActionListener(this::actionPerformed);
			panelInferior.add(botonLogin);
			
			contraseña = new JPasswordField();
			contraseña.setBounds(64, 52, 201, 20);
			contraseña.setColumns(10);
			contraseña.addKeyListener(this);
			panelInferior.add(contraseña);
			
			JLabel labelContraseña = new JLabel("Contraseña");
			labelContraseña.setHorizontalAlignment(SwingConstants.CENTER);
			labelContraseña.setBounds(119, 18, 80, 23);
			panelInferior.add(labelContraseña);

			error.setHorizontalAlignment(SwingConstants.CENTER);
			error.setBounds(65, 70, 200, 23);
			error.setForeground(Color.RED);
			error.setVisible(false);
			panelInferior.add(error);
			return panelInferior;
		}
		
		public void actionPerformed(ActionEvent e){
			Object ventana=e.getSource();
			if (ventana==botonLogin){comprobarContraseña(); }
		}
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode()==KeyEvent.VK_ENTER ){comprobarContraseña(); }
		}
		public void keyReleased(KeyEvent e) {}
		public void keyTyped(KeyEvent e) {}

		public void comprobarContraseña() {
			String contraseñaTexto = new String(contraseña.getPassword());
			contraseña.setText(null);
			if (!Conexion.login(contraseñaTexto)) {
				MainView main = new MainView();
				main.setVisible(true);
				dispose();
			} else {
				error.setVisible(true);
			}
		}
	}
}
		
		
		
		
		
		
		
		
