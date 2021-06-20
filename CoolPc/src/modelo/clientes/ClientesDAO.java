package modelo.clientes;

import modelo.conexion.Conexion;
import vista.Mensaje;

import java.sql.SQLException;

public class ClientesDAO {
    public static void registrarCliente(String nombre, String dni, String direccion){
        try{
            Conexion.crearConexion();
            String consultaComponente= "Insert into clientes values (?, ?, ?)";
            Conexion.sentencia=Conexion.conexion.prepareStatement(consultaComponente);
            Conexion.sentencia.setString(1, dni);
            Conexion.sentencia.setString(2,nombre);
            Conexion.sentencia.setString(3,direccion);
            Conexion.sentencia.executeUpdate();
            Conexion.cerrarConexion();
        }catch(SQLException e){
            if(e.getErrorCode()==1062){
                Mensaje error=new Mensaje("El cliente ya existe","Error");
                error.setVisible(true);
            }
            Conexion.imprimirExcepcion(e);
        }

    }
}
