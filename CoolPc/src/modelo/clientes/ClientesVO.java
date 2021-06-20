package modelo.clientes;

public class ClientesVO {
	String DNI;
	String nombre;
	String direccion;
	public ClientesVO(String DNI, String nombre, String direccion) {
		this.DNI=DNI;
		this.nombre=nombre;
		this.direccion=direccion;
	}

	//Metodos get clientes
	public String getDNI() {
		return this.DNI;
	}
	public String getNombre() {
		return this.nombre;
	}
	public String getDireccion() {
		return this.direccion;
	}

	//Metodos set clientes
	public void setDNI(String dni) {
		this.DNI=dni;
	}
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	public void setDireccion(String Direccion) {
		this.direccion=Direccion;
	}
}
