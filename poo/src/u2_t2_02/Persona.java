package u2_t2_02;

public class Persona {
	//Se declaran private las variables de la clase
	private String nombre;
	private String apellidos;
	private int telefono;
	//Metodo constructor. Se inicializan las variables
	public Persona() {
		nombre=null;
		apellidos=null;
		telefono=0;
	}
	//Se crean los metodos set para dar valor a las variables
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	public void setApellidos(String apellidos) {
		this.apellidos=apellidos;
	}
	public void setTelefono(int telefono) {
		this.telefono=telefono;
	}
	
	//Se crean los metodos get para devolver los valores de las variables
	public String getNombre() {
		return nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public int getTelefono() {
		return telefono;
	}
}
