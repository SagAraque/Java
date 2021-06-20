package modelo.pedidos;

public class PedidosVO {
	int idped;
	double total;
	String cliente;
	public PedidosVO(int idped, double total, String cliente) {
		this.idped=idped;
		this.total=total;
		this.cliente=cliente;
	}

	//Metodos get de pedidos
	public int getID(){ return this.idped;}
	public double getTotal(){ return this.total;}
	public String getCliente(){ return this.cliente;}

	//Metodos get de pedidos
	public void setIdped(int id) {this.idped=id; }
	public void setTotal(double total) {
		this.total=total;
	}
	public void setCliente(String cliente) {
		this.cliente=cliente;
	}
}
