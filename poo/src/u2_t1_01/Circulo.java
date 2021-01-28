package u2_t1_01;

public class Circulo {
	//Método constructor
	public Circulo() {
	}
	
	public double perimetro(double radio) {
		double perimetro=0;
		//Se calcula el perímetro del círculo
		perimetro=2*Math.PI*radio;
		//Se trunca a dos decimales y a su vez se redondea
		perimetro=Math.round(perimetro*100.0)/100.0;
		//Se retorna el valor del perimetro
		return perimetro;
	}
	
	public double area(double radio) {
		double area=0;
		//Se calcula el area del círculo
		area=Math.PI*Math.pow(radio,2);
		//Se trunca a dos decimales y a su vez se redondea
		area=Math.round(area*100.0)/100.0;
		//Se retorna el valor del area
		return area;
	}

}
