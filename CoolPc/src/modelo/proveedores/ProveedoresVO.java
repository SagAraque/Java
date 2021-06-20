package modelo.proveedores;

public class ProveedoresVO {
	String idP,nombre, tlfo, direccion;
	
	public ProveedoresVO(String idP, String nombre, String tlfo, String direccion) {
		this.idP=idP;
		this.nombre=nombre;
		this.tlfo=tlfo;
		this.direccion=direccion;
	}

	//Metodos set de proveedores
	public void setIdP(String idP) {
		this.idP=idP;
	}
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	public void setTlfo(String tlfo) {
		this.tlfo=tlfo;
	}
	public void setDireccion(String direccion) {
		this.direccion=direccion;
	}
	
	//Metodos get de proveedores
	public String getIdp() {
		return this.idP;
	}
	public String getNombre() {
		return this.nombre;
	}
	public String getTlfo() {
		return this.tlfo;
	}
	public String getDireccion() {
		return this.direccion;
	}
}
