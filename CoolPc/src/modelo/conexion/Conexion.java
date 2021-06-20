package modelo.conexion;

import vista.Mensaje;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {
	public static Connection conexion;
	public static PreparedStatement sentencia;
	public static String contraseña;
	//Creacion de la conexion a la base de datos
	public static void crearConexion() {
		try {
			conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/tiendainformatica","root",contraseña);
		}catch(SQLException e) {
			imprimirExcepcion(e);
		}
	}
	//Cierre de la conexion a la base de datos
	public static void cerrarConexion() {
		try {
			conexion.close();
			if(sentencia!=null){
				sentencia.close();
			}
		}catch(SQLException e) {
			imprimirExcepcion(e);
		}
	}
	//Mensajes de error mostrado mediante consola
	public static void imprimirExcepcion(SQLException e) {
		e.printStackTrace();
	}

	/**
	 *
	 * @param contraseña
	 * @return true o false
	 *
	 * Metodo por el cual se realiza una conexion con la contraseña otorgada
	 * con el fin de comprobar si es correcta o no
	 */
	public static boolean login(String contraseña) {
		boolean error=false;
		Conexion.contraseña=contraseña;
		try {
			conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/tiendainformatica","root",contraseña);
		}catch(SQLException e) {
			error=true;
		}
		return error;
	}
}
