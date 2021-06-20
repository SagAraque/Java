package modelo.proveedores;

import modelo.conexion.Conexion;
import vista.Mensaje;

import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProveedoresDAO {
	/**
	 *
	 * @param nombre Nombre del proveedor
	 * @param tlfo Telefono del proveedor
	 * @param direccion Direccion del proveedor
	 *
	 * Se inserta un nuevo proveedor en la base de datos
	 */
	public static void registrarProveedor(String nombre, String tlfo, String direccion) {
		try{
			Conexion.crearConexion();
			String consulta="Insert into proveedores (NombreP,Tlfo,Direccion) values(?,?,?)";
			Conexion.sentencia=Conexion.conexion.prepareStatement(consulta);
			Conexion.sentencia.setString(1,nombre);
			Conexion.sentencia.setString(2,tlfo);
			Conexion.sentencia.setString(3,direccion);
			Conexion.sentencia.executeUpdate();
			Conexion.cerrarConexion();
			Mensaje exito=new Mensaje("El proveedor ha sido agregado","Exito");
			exito.setVisible(true);
		}catch(SQLException e){
			if(e.getErrorCode()==1062){
				Mensaje error=new Mensaje("El proveedor ya existe","Error");
				error.setVisible(true);
			}else{
				Mensaje error=new Mensaje("El proveedor no ha podido ser añadido","Error");
				error.setVisible(true);
			}
			Conexion.imprimirExcepcion(e);
		}
	}

	/**
	 *
	 * @param modelo Modelo de tabla
	 *
	 * Metodo por el cual se actualiza un modelo de tabla añadiendo filas
	 * con información de lso proveedores
	 */
	public static void rellenarTablaProveedores(DefaultTableModel modelo) {
		while(modelo.getRowCount()!=0){
			modelo.removeRow(0);
		}
		try{
			Conexion.crearConexion();
			Statement sentencia=Conexion.conexion.createStatement();
			ResultSet result= sentencia.executeQuery("Select nombreP,tlfo,direccion from proveedores");
			while(result.next()){
				Object[] fila=new Object[4];
				for(int i=0;i<3;i++){
					fila[i]=result.getObject(i+1);
				}
				modelo.addRow(fila);
			}
			Conexion.cerrarConexion();
		}catch(SQLException o){
			Mensaje error=new Mensaje("No se han podido cargar los proveedores","Error");
			Conexion.imprimirExcepcion(o);
			error.setVisible(true);
		}
	}

	/**
	 *
	 * @param modelo Modelo de la tabla
	 * @param fila Fila del proveedor
	 *
	 * Se elimina un proveedor de la base de datos por su nombre y de la tabla de proveedores. El
	 * nombre se extrae del numero de la fila donde se encuentra dentro de la tabla
	 */
	public static void eliminarProveedor(DefaultTableModel modelo, int fila){
		try{
			String nombre="'"+modelo.getValueAt(fila,0).toString()+"'";
			int id=0;
			Conexion.crearConexion();
			Statement sentencia=Conexion.conexion.createStatement();
			ResultSet result= sentencia.executeQuery("Select idp from proveedores where nombreP="+nombre);
			while(result.next()){
				id=result.getInt(1);
			}

			Conexion.sentencia=Conexion.conexion.prepareStatement("Delete from entregacomponentes where idp=?;");
			Conexion.sentencia.setInt(1,id);
			Conexion.sentencia.executeUpdate();
			Conexion.sentencia=Conexion.conexion.prepareStatement("Delete from proveedores where idp=?");
			Conexion.sentencia.setInt(1,id);
			Conexion.sentencia.executeUpdate();
			Conexion.cerrarConexion();
		}catch(SQLException e){
			Mensaje error=new Mensaje("No se ha podido eliminar el proveedor","Error");
			Conexion.imprimirExcepcion(e);
			error.setVisible(true);
		}
	}
}
