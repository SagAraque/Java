package vista;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Mensaje extends JFrame {

    private JPanel contentPane;
    private String mensajeVentana;
    private String tituloVentana;
    public Mensaje(String mensaje,String titulo) {
        ImageIcon icono=new ImageIcon("img/icono.png");
        this.setIconImage(icono.getImage());
        this.setTitle("CoolPC - Mensaje");
        mensajeVentana=mensaje;
        tituloVentana=titulo;
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 600, 189);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        LaminaMensaje laminas = new LaminaMensaje();
        contentPane.add(laminas.panelSuperior());
        contentPane.add(laminas.panelInferior());
    }

    class LaminaMensaje extends JPanel implements ActionListener {
        JButton boton = new JButton("Aceptar");
        public Component panelSuperior() {
            JPanel panelSuperior = new JPanel();
            panelSuperior.setBounds(0, 0, 584, 50);
            panelSuperior.setLayout(new BorderLayout(0, 0));
            panelSuperior.setBackground(new Color(91, 155, 213));

            JLabel titulo = new JLabel(tituloVentana);
            titulo.setHorizontalAlignment(SwingConstants.CENTER);
            titulo.setForeground(Color.WHITE);
            titulo.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 30));
            panelSuperior.add(titulo, BorderLayout.CENTER);

            return panelSuperior;
        }

        public Component panelInferior() {
            JPanel panelInferior = new JPanel();
            panelInferior.setBounds(0, 50, 584, 100);
            panelInferior.setLayout(null);
            panelInferior.setBackground(new Color(221, 235, 247));

            JLabel error = new JLabel(mensajeVentana);
            error.setBounds(0, 0, 584, 50);
            error.setHorizontalAlignment(SwingConstants.CENTER);
            error.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
            panelInferior.add(error);


            boton.setBounds(242, 60, 100, 30);
            boton.setForeground(Color.WHITE);
            boton.setBackground(new Color(91, 155, 213));
            boton.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 11));
            boton.addActionListener(this);
            panelInferior.add(boton);

            return panelInferior;
        }

        public void actionPerformed(ActionEvent e){
            Object evento=e.getSource();
            if(evento==boton){
                dispose();
            }
        }
    }
}

