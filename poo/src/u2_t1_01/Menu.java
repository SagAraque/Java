package u2_t1_01;
import javax.swing.JOptionPane;
public class Menu {

	public static void main(String[] args) {
		int opcion=0;
		//Propiedades de las formas geométricas
		String radioS,baseS,alturaS;
		double radio,base,altura;
		//Opciones de los cuadros de diálogo
		String[] opcionesFormas= {"Círculo", "Rectángulo","Cilindro","Salir"};
		String[] opcionesOperacion= {"Area","Perímetro"};
		String[] opcionesCilindro= {"Area","Volumen"};
		
		do {
			//Se da a elegir una forma geométrica
			opcion=JOptionPane.showOptionDialog(null, "Escoja una forma geométrica", "Forma geométrica", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesFormas, null);
			//Switch que albergará las 3 formas geométricas
			switch(opcion) {
			//Círculo
			case 0:
				//Se declara el objeto circulo
				Circulo circulo=new Circulo();
				//Se solicita la operación
				opcion=JOptionPane.showOptionDialog(null, "Escoja una operación", "Operación", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesOperacion, null);
				//Se solicita el radio del círculo y se pasa a double
				radioS=JOptionPane.showInputDialog(null, "Indique el radio en metros");
				radio=Double.parseDouble(radioS);
				//Switch con las dos operaciones a realizar. En ambas se llamará al metodo pertinente
				switch(opcion) {
				//Area
				case 0:
					JOptionPane.showMessageDialog(null,"El area del círculo es de "+circulo.area(radio)+" metros cuadrados",null, JOptionPane.PLAIN_MESSAGE);
					break;
				//Perímetro
				case 1:
					JOptionPane.showMessageDialog(null,"El perímetro del círculo es de "+circulo.perimetro(radio)+" metros",null, JOptionPane.PLAIN_MESSAGE);
					break;
				}
				break;
			//Rectángulo
			case 1:
				//Se declara el objeto rectangulo
				Rectangulo rectangulo=new Rectangulo();
				//Se solicita la operación
				opcion=JOptionPane.showOptionDialog(null, "Escoja una operación", "Operación", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesOperacion, null);
				//Se solicita la base y la altura del rectangulo y se pasa a double
				baseS=JOptionPane.showInputDialog(null, "Indique la base en metros");
				alturaS=JOptionPane.showInputDialog(null, "Indique la altura en metros");
				base=Double.parseDouble(baseS);
				altura=Double.parseDouble(alturaS);
				//Switch con las dos operaciones a realizar. En ambas se llamará al metodo pertinente
				switch(opcion) {
				//Area
				case 0:
					JOptionPane.showMessageDialog(null,"El area del rectangulo es de "+rectangulo.area(base,altura)+" metros cuadrados",null, JOptionPane.PLAIN_MESSAGE);
					break;
				//Perímetro
				case 1:
					JOptionPane.showMessageDialog(null,"El perímetro del rectangulo es de "+rectangulo.perimetro(base,altura)+" metros",null, JOptionPane.PLAIN_MESSAGE);
					break;
				}
				break;
			//Cilindro
			case 2:
				//Se declara el objeto cilindro
				Cilindro cilindro=new Cilindro();
				//Se solicita la operación
				opcion=JOptionPane.showOptionDialog(null, "Escoja una operación", "Operación", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesCilindro, null);
				//Se solicita el radio y la altura del rectangulo y se pasa a double
				radioS=JOptionPane.showInputDialog(null, "Indique el radio en metros");
				alturaS=JOptionPane.showInputDialog(null, "Indique la altura en metros");
				radio=Double.parseDouble(radioS);
				altura=Double.parseDouble(alturaS);
				//Switch con las dos operaciones a realizar. En ambas se llamará al metodo pertinente
				switch(opcion) {
				//Area
				case 0:
					JOptionPane.showMessageDialog(null,"El area del cilindro es de "+cilindro.area(radio,altura)+" metros cuadrados",null, JOptionPane.PLAIN_MESSAGE);
					break;
				//Volumen
				case 1:
					JOptionPane.showMessageDialog(null,"El volumen del cilindro es de "+cilindro.volumen(radio,altura)+" metros cúbicos",null, JOptionPane.PLAIN_MESSAGE);
					break;
				}
				break;
			}
		}while(opcion!=3 && opcion!=-1);
		JOptionPane.showMessageDialog(null,"Hasta pronto",null, JOptionPane.PLAIN_MESSAGE);
	}
}
	
