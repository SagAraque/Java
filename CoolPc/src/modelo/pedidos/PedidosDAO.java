package modelo.pedidos;

import modelo.clientes.ClientesVO;
import modelo.componentes.ComponentesDAO;
import modelo.componentes.ComponentesVO;
import modelo.conexion.Conexion;
import vista.Mensaje;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PedidosDAO {
    /**
     *
     * @param modelo Modelo o nombre del componente
     * @param componentes ArrayList con los componentes
     * @param cantidad Cantidad a añadir
     * @param tabla Modelo de la tabla
     *
     * Metodo por el cual se añade un componente a la tabla de pedidos. Se comprueba previamente si
     * el componente ya esta en la tabla, en cuyo caso solo se actualiza su cantidad.
     */
    public static void añadirComponentePedido(String modelo, ArrayList<ComponentesVO> componentes, int cantidad, DefaultTableModel tabla){
        int check=0;
        if(cantidad>0){
            //Se comprueba si el componente esta en la tabla
            for(int i=0;i<tabla.getRowCount();i++){
                if(tabla.getValueAt(i,1).toString().equals(modelo)) {
                    tabla.setValueAt(Integer.parseInt(tabla.getValueAt(i, 2).toString()) + cantidad, i, 2);
                    check = 1;
                }
            }
            //Se añade una nueva fila a la tabla
            if(check==0){
                String[] fila= new String[4];
                for(int i=0;i<componentes.size();i++){
                    if(componentes.get(i).getModelo().equalsIgnoreCase(modelo)){
                        fila[0]=componentes.get(i).getMarca();
                        fila[1]=componentes.get(i).getModelo();
                        fila[2]=String.valueOf(cantidad);
                        fila[3]=String.valueOf((componentes.get(i).getPrecio()*cantidad));
                        tabla.addRow(fila);
                        break;
                    }
                }
            }
        }else{
            Mensaje error=new Mensaje("No hay stock suficinete","Error");
            error.setVisible(true);
        }
    }

    /**
     *
     * @param modelo Modelo de la tabla
     * @param componentes Array con los componentes
     * @param DNI DNI del cliente
     *
     * Se registra el pedido en la base de datos. Para ello se obtienen los componentes de la tabla almacenando sus
     * datos en en un array bidimensional y se calcula el total del pedido.
     * Despues se registra el pedido y el contenido de este obteniendo los datos del array bidimensional y mediante
     * una consulta select para obtener el id del pedido.
     */
    public static void prepararPedido(DefaultTableModel modelo, ArrayList<ComponentesVO> componentes, String DNI){
        Object[][] fila=new Object[modelo.getRowCount()][4];
        int idC=0,idped=0;
        double total=0;
        /*Se obtienen los componentes de la tabla y se almacenan en un array bidimensional*/
        for(int i=0;i< modelo.getRowCount();i++){
            fila[i][0]=modelo.getValueAt(i,0);
            fila[i][1]=modelo.getValueAt(i,1);
            fila[i][2]=modelo.getValueAt(i,2);
            fila[i][3]=modelo.getValueAt(i,3);
            total=total+(Integer.parseInt(fila[i][2].toString())*Double.parseDouble(fila[i][3].toString()));
        }
        //Se crea el pedido en la base de datos y se obtiene su id
        try{
            Conexion.crearConexion();
            String consulta="Insert into pedidos (PTotal,DNI) values(?,?)";
            Conexion.sentencia=Conexion.conexion.prepareStatement(consulta);
            Conexion.sentencia.setDouble(1,total);
            Conexion.sentencia.setString(2,DNI);
            Conexion.sentencia.executeUpdate();
            Statement sentencia=Conexion.conexion.createStatement();
            ResultSet result= sentencia.executeQuery("Select max(IDPed) from pedidos");
            while(result.next()){
                idped= result.getInt(1);
            }
            Conexion.cerrarConexion();
        }catch(SQLException e){
            Conexion.imprimirExcepcion(e);
        }

        //Se registra el contenido del pedido en la base de datos
        for(int i=1;i<=modelo.getRowCount();i++){
            for(int x=0;x<componentes.size();x++){
                if(componentes.get(x).getModelo().equals(fila[i-1][1].toString())){
                    idC=componentes.get(x).getIdC();
                }
            }
            try{
                Conexion.crearConexion();
                String consulta="Insert into contenidoped (idped,idc,cantidad) values(?,?,?)";
                Conexion.sentencia=Conexion.conexion.prepareStatement(consulta);
                Conexion.sentencia.setInt(1,idped);
                Conexion.sentencia.setInt(2,idC);
                Conexion.sentencia.setInt(3,Integer.parseInt(fila[i-1][2].toString()));
                Conexion.sentencia.executeUpdate();
                //Se resta la cantidad al stock
                Conexion.sentencia=Conexion.conexion.prepareStatement("Update componentes set cantidad=cantidad-? where idc=?");
                Conexion.sentencia.setInt(1,Integer.parseInt(fila[i-1][2].toString()));
                Conexion.sentencia.setInt(2, idC);
                Conexion.sentencia.executeUpdate();
                Conexion.cerrarConexion();
            }catch (SQLException e){
                Conexion.imprimirExcepcion(e);
            }
        }
    }

    /**
     *
     * @return ArrayList con objetos de tipo ClientesVO
     *
     * Se almacena en un Arraylist todos los clientes de la base de datos
     */
    public static ArrayList<ClientesVO> obtenerClientes() {
    	 ArrayList<ClientesVO> clientes=new ArrayList<>();
         try{
             Conexion.crearConexion();
             Statement sentencia =Conexion.conexion.createStatement();
             ResultSet result=sentencia.executeQuery("Select * from clientes");
             while(result.next()){
                clientes.add(new ClientesVO(result.getObject(1).toString(),result.getObject(2).toString(),result.getObject(3).toString()));
             }
             Conexion.cerrarConexion();
         }catch(SQLException o){
             Mensaje error=new Mensaje("No se han podido cargar los clientes","Error");
             Conexion.imprimirExcepcion(o);
             error.setVisible(true);
         }
         return clientes;
    }

    /**
     *
     * @return ArrayList con objetos de tipo PedidosVO
     *
     * Se almacena en un Arraylist todos los pedidos de la base de datos
     */
    public static ArrayList<PedidosVO> obtenerPedidos(){
        ArrayList<PedidosVO>pedidos=new ArrayList<>();
        try{
            Conexion.crearConexion();
            Statement sentencia =Conexion.conexion.createStatement();
            ResultSet result=sentencia.executeQuery("Select * from pedidos");
            while(result.next()){
                pedidos.add(new PedidosVO(result.getInt(1),result.getDouble(2),result.getString(3)));
            }
            Conexion.cerrarConexion();
        }catch(SQLException o){
            Mensaje error=new Mensaje("El pedido no ha podido ser añadido","Error");
            Conexion.imprimirExcepcion(o);
            error.setVisible(true);
        }
        return pedidos;
    }

    /**
     *
     * @param id ID del pedido
     * @param modelo Modelo de la tabla
     *
     * Se rellena la tabla del apartado ver pedidos con los componentes del pedido seleccionado.
     * Para ello primero se solicita el id y la cantidad, creando y almacenando en un arraylist
     * objetos de tipo ComponentesVo con algunso campos null. Despues se obtiene el resto de datos
     * y se actualizan los objetos ComponentesVO para finalmente ir añadiendo las filas con estos
     * datos
     */
    public static void rellenarTablaVerPedidos(int id, DefaultTableModel modelo){
        ArrayList<ComponentesVO>componentes=new ArrayList<>();
        while (modelo.getRowCount()!=0){
            modelo.removeRow(0);
        }
        try{
            Object[] fila=new Object[3];
            Conexion.crearConexion();
            Statement sentencia =Conexion.conexion.createStatement();
            ResultSet result=sentencia.executeQuery("Select idc,cantidad from contenidoped where idped="+id);
            while(result.next()){
                componentes.add(new ComponentesVO(result.getInt(1),null,null,0,result.getInt(2),null));
            }
            for(int i=0;i<componentes.size();i++){
                sentencia =Conexion.conexion.createStatement();
                result=sentencia.executeQuery("Select marca,nombrec from componentes where idc="+componentes.get(i).getIdC());
                while (result.next()){
                    componentes.get(i).setMarca(result.getString(1));
                    componentes.get(i).setModelo(result.getString(2));
                }
                fila[0]=componentes.get(i).getMarca();
                fila[1]=componentes.get(i).getModelo();
                fila[2]=componentes.get(i).getCantidad();
                modelo.addRow(fila);
            }
            Conexion.cerrarConexion();
        }catch (SQLException e){
            Conexion.imprimirExcepcion(e);
        }
    }

    /**
     *
     * @param idped ID del pedido
     * @return Objeto de tipo ClientesVO
     *
     * Se obtiene un objeto de tipo ClienteVo con los datos del cleinte
     * que ha solicitado el pedido
     */
    public static ClientesVO obtenerClientePedido(int idped){
        ClientesVO cliente=null;
        String dniCliente="";
        try{
            Conexion.crearConexion();
            Statement sentencia =Conexion.conexion.createStatement();
            ResultSet result=sentencia.executeQuery("Select dni from pedidos where idped="+idped);
            while(result.next()){
                dniCliente=result.getString(1);
            }
            sentencia =Conexion.conexion.createStatement();
            result=sentencia.executeQuery("Select * from clientes where dni='"+dniCliente+"'");
            while(result.next()){
                cliente=(new ClientesVO(result.getString(1),result.getString(2),result.getString(3)));
            }
            Conexion.cerrarConexion();
        }catch(SQLException e){
            Conexion.imprimirExcepcion(e);
        }
        return cliente;
    }

    /**
     *
     * @param arrayComponentes ArrayList de objetos de tipo ComponentesVO
     * @param combobox ComboBox donde mostrar los componentes
     * @param tipoComponente ComboBox con los tipo de componentes
     *
     * Metodo por el cual se rellena el ComboBox de componentes
     */
    public static void rellenarComboBoxComponentes(ArrayList<ComponentesVO> arrayComponentes, JComboBox<String> combobox, JComboBox<String> tipoComponente){
        combobox.removeAllItems();
        arrayComponentes= ComponentesDAO.mostrarComponentes();
        for(int i=0;i<arrayComponentes.size();i++){
            String tipo=arrayComponentes.get(i).getTipo();
            if(tipoComponente.getSelectedItem().toString().equals(tipo)) {
                combobox.addItem(arrayComponentes.get(i).getModelo());
            }
        }
    }

    /**
     *
     * @param clientes ComboBox donde mostrar los clientes
     * @param array ArrayList de objetos de tipo ClientesVO
     *
     * Metodo por el cual se rellena el ComboBox de clientes
     */
    public static void rellenarComboBoxClientes(JComboBox<String> clientes, ArrayList<ClientesVO> array ){
        clientes.removeAllItems();
        array= PedidosDAO.obtenerClientes();
        for(int i=0;i<array.size();i++){
            clientes.addItem(array.get(i).getDNI());

        }
    }

    /**
     *
     * @param pedidos ComboBox donde mostrar los pedidos
     * @param array ArrayList de objetos de tipo PedidosVO
     *
     * Metodo por el cual se rellena el ComboBox de pedidos
     */
    public static void rellenarComboBoxPedidos(JComboBox<Integer> pedidos,ArrayList<PedidosVO> array){
        if(pedidos.getItemCount()!=0){
            pedidos.removeAllItems();
        }
        array= PedidosDAO.obtenerPedidos();
        for(int i=0;i<array.size();i++){
            pedidos.addItem(array.get(i).getID());

        }
    }

    /**
     *  @param cantidad ComboBox donde mostrar la cantidad de componentes
     * @param componentes ComboBox con todos los componentes
     * @param array ArrayList de objetos de tipo ComponentesVO
     * @return Cantidad del artículo
     */
    public static JComboBox<Integer> setCantidad(JComboBox<Integer> cantidad, JComboBox<String> componentes, ArrayList<ComponentesVO> array){
        cantidad.removeAllItems();
        String modelo=componentes.getSelectedItem().toString();
        int check=0;
        array= ComponentesDAO.mostrarComponentes();
        for(int i=0;i<array.size();i++){
            if(array.get(i).getModelo().equals(modelo)){
                for(int x=0;x<array.get(i).getCantidad();x++){
                    cantidad.addItem(x+1);
                    check=1;
                }
            }
        }
        if(check==0){
            cantidad.addItem(0);
        }
        return cantidad;
    }
}
