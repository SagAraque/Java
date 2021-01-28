package u2_t1_01;

public class Cilindro {
	//Método constructor
	public Cilindro() {
	}
	
	public double volumen(double radio, double altura) {
		double volumen=0;
		//Se calcula el volumen del cilindro
		volumen=Math.PI*Math.pow(radio,2)*altura;
		//Se trunca a dos decimales y se redondea 
		volumen=Math.round(volumen*100.0)/100.0;
		//Se retorna el valor del volumen
		return volumen;
	}
	
	public double area(double radio, double altura) {
		double area=0;
		//Se calcula el area del cilindro
		area=2*Math.PI*radio*(radio+altura);
		//Se trunca a dos decimales y se redondea 
		area=Math.round(area*100.0)/100.0;
		//Se retorna el valor del area
		return area;
	}
}
