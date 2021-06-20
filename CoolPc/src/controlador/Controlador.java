package controlador;

import java.awt.Color;

import javax.swing.*;

public class Controlador {
    public static int checkFildsComponentes(JTextField marca, JTextField nombre, JComboBox<String> tipo, JTextField cantidad, JTextField precio, JTextField atributo1, JTextField atributo2,JComboBox<String> certificado,JComboBox<String> disco){
        int check=1;
        try{
            if(Double.parseDouble(precio.getText())<=0){
                check=0;
            }
            if(Integer.parseInt(cantidad.getText())<=0){
                check=0;
            }
            if(marca.getText().equals("")) {
                check = 0;
            }
            if(nombre.getText().equals("")) {
                check = 0;
            }
            if(atributo1.getText().equals("")) {
                if(!tipo.getSelectedItem().equals("Fuente de alimentación")){
                    check = 0;
                }
            }else if(Integer.parseInt(atributo1.getText())<=0){
                check=0;
            }
            if(Integer.parseInt(atributo2.getText())<=0) {
                check = 0;
            }
        }catch (Exception e){
            check=0;
        }
        return check;
    }
    
    public static int checkFieldsProveedores(JTextField nombre, JTextField telefono,JTextField direccion) {
    	int check=1;
    	try {
    		if(nombre.getText().equals("")) {
    			check=0;
    		}
    		if(telefono.getText().equals("")) {
    			check=0;
    		}else if(telefono.getText().length()!=9) {
    			check=0;
    		}
    		if(direccion.getText().equals("")) {
    			check=0;
    		}
    		Integer.parseInt(telefono.getText());
    	}catch(Exception e) {
    		check=0;
    	}
    	return check;
    }

    public static int checkFieldsClientes(JTextField nombre, JTextField dni, JTextField direccion){
        int check=1;
        try{
            if(nombre.getText().equals("")){
                check=0;
            }
            if(dni.getText().equals("") || dni.getText().length()!=9){
                check=0;
            }else{
                try{
                    Integer.parseInt(dni.getText().substring(9,9));
                    check=0;
                }catch(Exception e){}
            }
            if(direccion.getText().equals("")){
                check=0;
            }
            Integer.parseInt(dni.getText().substring(0,8));
        }catch(Exception e){
            check=0;
        }
        return check;
    }

    public static int checkFieldsComponentesExistente(JComboBox<String> modelo, JComboBox<String> proveedor, JTextField cantidad){
        int check=1;
        try{
            if(modelo.getSelectedItem().toString().equals("")){
                check=0;
            }
            if(proveedor.getSelectedItem().toString().equals("")){
                check=0;
            }
            if(Integer.parseInt(cantidad.getText())<=0){
                check=0;
            }
        }catch(Exception e){
            check=0;
        }
        return check;
    }
}
