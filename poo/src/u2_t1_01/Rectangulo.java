package u2_t1_01;

public class Rectangulo {
	//Método constructor
	public Rectangulo() {
	}
	
	public double perimetro(double base, double altura) {
		double perimetro=0;
		//Se calcula el perímetro del rectángulo
		perimetro=(base*2)+(altura*2);
		//Se trunca a dos decimales y a su vez se redondea
		perimetro=Math.round(perimetro*100.0)/100.0;
		//Se retorna el valor del perímetro
		return perimetro;
	}
	
	public double area(double base, double altura) {
		double area=0;
		//Se calcula el area del rectángulo
		area=base*altura;
		//Se trunca a dos decimales y a su vez se redondea
		area=Math.round(area*100.0)/100.0;
		//Se retorna el valor del area
		return area;
	}
}
