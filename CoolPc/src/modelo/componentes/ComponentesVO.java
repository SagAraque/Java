package modelo.componentes;

public class ComponentesVO {
	int idC,cantidad;
	String modelo, marca,tipo;
	double precio;
	
	public ComponentesVO(int idC, String modelo, String marca, double precio, int cantidad, String categoria) {
		this.idC=idC;
		this.modelo=modelo;
		this.marca=marca;
		this.precio=precio;
		this.cantidad=cantidad;
		this.tipo=categoria;
	}
	
	//Metodos set de componentes
		public void setIdC(int idC) {
			this.idC=idC;
		}
		public void setModelo(String modelo) {
			this.modelo=modelo;
		}
		public void setMarca(String marca) {
			this.marca=marca;
		}
		public void setPrecio(double precio) {
			this.precio=precio;
		}
		public void setTipo(String tipo) {
		this.tipo=tipo;
	}
		public void setCantidad(int cantidad) {
		this.cantidad=cantidad;
	}
		
		//Metodos get de componentes
		public int getIdC() {
			return this.idC;
		}
		public String getModelo() {
			return this.modelo;
		}
		public String getMarca() {
			return this.marca;
		}
		public double getPrecio() {
			return this.precio;
		}
		public String getTipo() {
		return this.tipo;
	}
		public int getCantidad() {
		return this.cantidad;
	}
}
