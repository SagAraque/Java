package modelo.componentes;

import modelo.conexion.Conexion;
import vista.Mensaje;
import modelo.proveedores.ProveedoresVO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;

public class ComponentesDAO {
    /**
     *
     * @param nombre Nombre del componente
     * @param marca Marca del componente
     * @param tipo Familia del componente
     * @param precio Precio del componente
     * @param cantidad Cantidad a solicitar
     * @param atributo1 Valor del primer atributo
     * @param atributo2 Valor del segundo atributo
     * @param proveedor Proveedor al que se le solicita
     *
     * Se inserta un nuevo componente en la base de datos, tanto en la tabla de componentes como en la tabla de su correspondiente
     * categoría y en la tabla de entrega de componentes.
     * En caso de que algo fallase, se llamaría al método eliminarComponente para limpiar la base de datos de cualquier
     * entrada que haya sido agregada aun fallando el proceso.
     */
    public static void insertarComponentes(String nombre, String marca, String tipo, double precio, int cantidad, String atributo1, String atributo2, String proveedor) {
        Conexion.crearConexion();
        String id="";
        try{
            String consultaComponente= "Insert into componentes (nombreC,marca,precio,cantidad,tipo) values (?, ?, ?, ?,?)";
            String consulta="";
            Conexion.sentencia=Conexion.conexion.prepareStatement(consultaComponente);
            Conexion.sentencia.setString(1, nombre);
            Conexion.sentencia.setString(2, marca);
            Conexion.sentencia.setDouble(3, precio);
            Conexion.sentencia.setInt(4, cantidad);
            Conexion.sentencia.setString(5,tipo);
            Conexion.sentencia.executeUpdate();

            Statement sentencia=Conexion.conexion.createStatement();
            ResultSet result= sentencia.executeQuery("Select IDC from componentes where NombreC='"+nombre+"'");
            while(result.next()){
                id=result.getString(1);
            }
            pedidoProveedor(Integer.parseInt(id),Integer.parseInt(proveedor));
            switch (tipo){
                case "Procesador":
                    consulta="Insert into procesador values(?, ?, ?)";
                    Conexion.sentencia=Conexion.conexion.prepareStatement(consulta);
                    Conexion.sentencia.setInt(1,Integer.parseInt(id));
                    Conexion.sentencia.setInt(2,Integer.parseInt(atributo1));
                    Conexion.sentencia.setInt(3,Integer.parseInt(atributo2));
                    break;
                case "Placa base":
                    consulta="Insert into placabase values(?, ?, ?)";
                    Conexion.sentencia=Conexion.conexion.prepareStatement(consulta);
                    Conexion.sentencia.setInt(1,Integer.parseInt(id));
                    Conexion.sentencia.setString(2,atributo1);
                    Conexion.sentencia.setString(3,atributo2);
                    System.out.println("Placa base");
                    break;
                case "Tarjeta gráfica":
                    consulta="Insert into tarjetagrafica values(?, ?, ?)";
                    Conexion.sentencia=Conexion.conexion.prepareStatement(consulta);
                    Conexion.sentencia.setInt(1,Integer.parseInt(id));
                    Conexion.sentencia.setInt(2,Integer.parseInt(atributo1));
                    Conexion.sentencia.setInt(3,Integer.parseInt(atributo2));
                    break;
                case "Memoria RAM":
                    consulta="Insert into ram values(?, ?, ?)";
                    Conexion.sentencia=Conexion.conexion.prepareStatement(consulta);
                    Conexion.sentencia.setInt(1,Integer.parseInt(id));
                    Conexion.sentencia.setInt(2,Integer.parseInt(atributo1));
                    Conexion.sentencia.setInt(3,Integer.parseInt(atributo2));
                    break;
                case "Disco Duro":
                    consulta="Insert into discoduro values(?, ?, ?)";
                    Conexion.sentencia=Conexion.conexion.prepareStatement(consulta);
                    Conexion.sentencia.setInt(1,Integer.parseInt(id));
                    Conexion.sentencia.setString(2,atributo1);
                    Conexion.sentencia.setInt(3,Integer.parseInt(atributo2));
                    break;
                case "Fuente de alimentación":
                    consulta="Insert into fuentes values(?, ?, ?)";
                    Conexion.sentencia=Conexion.conexion.prepareStatement(consulta);
                    Conexion.sentencia.setInt(1,Integer.parseInt(id));
                    Conexion.sentencia.setInt(2,Integer.parseInt(atributo2));
                    Conexion.sentencia.setString(3,atributo1);
                    break;
            }
            Conexion.sentencia.executeUpdate();
            Conexion.cerrarConexion();
            Mensaje exito=new Mensaje("El componente ha sido agregado con exito","Exito");
            exito.setVisible(true);
        }catch (SQLException e){
            if(e.getErrorCode()==1062){
                Mensaje error=new Mensaje("El componente ya existe","Error");
                error.setVisible(true);
            }else{
                Mensaje error=new Mensaje("El componente no ha podido ser añadido","Error");
                eliminarcomponente(Integer.parseInt(id));
                error.setVisible(true);
            }
            Conexion.imprimirExcepcion(e);
        }
    }

    /**
     * Se almacena en un arraylist los proveedores almacenados en la base de datos
     * @return arraylist con objetos de tipo ProveedoresVO
     */
    public static ArrayList<ProveedoresVO> mostrarProveedores(){
        ArrayList<ProveedoresVO> proveedores=new ArrayList<>();
        try {
            Conexion.crearConexion();
            Statement sentencia=Conexion.conexion.createStatement();
            ResultSet result= sentencia.executeQuery("Select * from proveedores");
            while(result.next()){
                proveedores.add(new ProveedoresVO(result.getString(1),result.getString(2),result.getString(3),result.getString(4)));
            }
        }catch(SQLException o) {
            o.printStackTrace();
        }
        return proveedores;
    }

    /**
     * Se registra la entrega de componentes por parte de un proveedor en la base de datos partiendo
     * de que se conoce tanto el id del proveedor como del componente
     * @param idc id de componente
     * @param idp id de proveedor
     */
    public static void pedidoProveedor(int idc, int idp) {
        try{
            Conexion.sentencia=Conexion.conexion.prepareStatement("Insert into entregacomponentes values (?,?)");
            Conexion.sentencia.setInt(1,idc);
            Conexion.sentencia.setInt(2,idp);
            Conexion.sentencia.executeUpdate();
        }catch(Exception e){
            Mensaje error=new Mensaje("El componente no ha podido ser añadido","Error");
            Conexion.imprimirExcepcion((SQLException) e);
            error.setVisible(true);
        }
    }

    /**
     * Se almacena en un arraylist todos los componentes de la base de datos
     * @return arraylist con objetos de tipo ComponentesVO
     */
    public static ArrayList<ComponentesVO> mostrarComponentes(){
        ArrayList<ComponentesVO> componentes=new ArrayList<>();
        try {
            Conexion.crearConexion();
            Statement sentencia=Conexion.conexion.createStatement();
            ResultSet result= sentencia.executeQuery("Select * from componentes");
            while(result.next()){
                componentes.add(new ComponentesVO(result.getInt(1),result.getString(2),result.getString(3),result.getDouble(4),result.getInt(5),result.getString(6)));
            }
            Conexion.cerrarConexion();
        }catch(SQLException o) {
            o.printStackTrace();
        }
        return componentes;
    }

    /**
     * Se actualiza el modelo de la tabla, eliminando todas las filas y añadiendo nuevas
     * con el objetivo de mostrar los componentes en base a su familia
     * @param tipo Familia del componente
     * @param modelo Modelo de la tabla
     */

    public static void mostrarComponentesTabla(String tipo, DefaultTableModel modelo){
        while(modelo.getRowCount()!=0){
            modelo.removeRow(0);
        }
        try{
            Conexion.crearConexion();
            Statement sentencia=Conexion.conexion.createStatement();
            ResultSet result= sentencia.executeQuery("Select marca,nombrec,cantidad,precio,tipo from componentes");
            while(result.next()){
                Object[] fila=new Object[4];
                if(result.getString(5).equals(tipo)){
                    for(int i=0;i<4;i++){
                        fila[i]=result.getObject(i+1);
                    }
                    modelo.addRow(fila);
                }
            }
            Conexion.cerrarConexion();
        }catch(SQLException o){
            Mensaje error=new Mensaje("No se han podido cargar los componentes","Error");
            Conexion.imprimirExcepcion(o);
            error.setVisible(true);
        }
    }

    /**
     * Metodo por el cual se realizan las devoluciones de componentes, es decir, se modifica la cantidad
     * en la base de datos
     * @param modelo Nombre o modelo del componente
     * @param cantidad Cantidad a reducir en la base de datos
     */
    public static void devolucion(String modelo, int cantidad){
        try{
            Conexion.crearConexion();
            Conexion.sentencia=Conexion.conexion.prepareStatement("Update componentes set cantidad=cantidad-? where nombreC=?");
            Conexion.sentencia.setInt(1,cantidad);
            Conexion.sentencia.setString(2,modelo);
            Conexion.sentencia.executeUpdate();
            Conexion.cerrarConexion();
            Mensaje exito=new Mensaje("El componente ha sido devuelto","Exito");
            exito.setVisible(true);
            Conexion.cerrarConexion();
        }catch(Exception e){
            Mensaje error=new Mensaje("No se ha podido realizar la devolución","Error");
            Conexion.imprimirExcepcion((SQLException) e);
            error.setVisible(true);
        }
    }

    /**
     * Metodo por el cual se añade stock a un componente ya existente, es decir se modifica
     * la cantidad en la base de datos
     * @param modelo Modelo o nombre del componente
     * @param cantidad Cantidad a agregar
     */
    public static void añadirComponenteExistente(String modelo, int cantidad){
        try{
            Conexion.crearConexion();
            Conexion.sentencia=Conexion.conexion.prepareStatement("Update componentes set cantidad=cantidad+? where nombreC=?");
            Conexion.sentencia.setInt(1,cantidad);
            Conexion.sentencia.setString(2,modelo);
            Conexion.sentencia.executeUpdate();
            Conexion.cerrarConexion();
            Mensaje exito=new Mensaje("El stock ha sido agregado correctamente","Exito");
            exito.setVisible(true);
            Conexion.cerrarConexion();
        }catch(SQLException e){
            Mensaje error=new Mensaje("No se ha podido solicitar el stock","Error");
            Conexion.imprimirExcepcion(e);
            error.setVisible(true);
        }
    }

    /**
     * Se rellena un comboBox con los modelos o nombres de los componentes en base a su tipo o familia
     * @param combo ComboBox a rellenar
     * @param tipoCombo ComboBox con el tipo de componentes
     * @param componentes Arraylist de componentes
     */
    public static void rellenarComboBoxComponentes(JComboBox<String> combo, JComboBox<String> tipoCombo, ArrayList<ComponentesVO> componentes){
        combo.removeAllItems();
        componentes= ComponentesDAO.mostrarComponentes();
        for(int i=0;i<componentes.size();i++){
            String tipo=componentes.get(i).getTipo();
            if(tipoCombo.getSelectedItem().toString().equals(tipo)) {
                combo.addItem(componentes.get(i).getModelo());
            }
        }
    }

    /**
     * Se establece la cantidad de un componente disponible en un ComboBox
     * @param cantidad ComboBox a rellenar
     * @param tipoCombo ComboBox con el tipo de componentes
     * @param componentes Arraylist de componentes
     */
    public static void setCantidad(JComboBox<Integer> cantidad,JComboBox<String> tipoCombo, ArrayList<ComponentesVO> componentes){
        cantidad.removeAllItems();
        String modelo=tipoCombo.getSelectedItem().toString();
        int check=0;
        componentes= ComponentesDAO.mostrarComponentes();
        for(int i=0;i<componentes.size();i++){
            if(componentes.get(i).getModelo().equals(modelo)){
                for(int x=0;x<componentes.get(i).getCantidad();x++){
                    cantidad.addItem(x+1);
                    check=1;
                }
            }
        }
        if(check==0){
            cantidad.addItem(0);
        }
    }

    /**
     * En caso de que el metodo de inserción falle, este se encargara de eliminar
     * cualquier registro que haya quedado en la base de datos
     * @param id Id del componente a eliminar
     */
    public static void eliminarcomponente(int id){
        try{
            Conexion.sentencia=Conexion.conexion.prepareStatement("Delete from entregacomponentes where IDC=?");
            Conexion.sentencia.setInt(1,id);
            Conexion.sentencia.executeUpdate();
            Conexion.crearConexion();
            Conexion.sentencia=Conexion.conexion.prepareStatement("Delete from componentes where IDC=?");
            Conexion.sentencia.setInt(1,id);
            Conexion.sentencia.executeUpdate();
            Conexion.cerrarConexion();
        }catch (SQLException e){
            Conexion.imprimirExcepcion(e);
        }
    }
}
