package u2_t2_02;
import java.util.Scanner;
public class Menu {

	public static void main(String[] args) {
		//Se declara el scanner
		Scanner entrada=new Scanner(System.in);
		//Se declara un array de objetos con espacio para 3 de ellos
		Persona personas[]=new Persona[3];
		//Se declaran las variables y se inicializan
		String nombre=null,apellidos=null;
		int telefono=0;
		
		//Se solicitan los datos
		for(int i=1;i<4;i++) {
			//Se declara un objeto nuevo en la posición del array i-1
			personas[i-1]=new Persona();
			//Se solicita el nombre y se llama al metodo setNombre
			System.out.println("Indique el nombre de la "+i+"º persona");
			nombre=entrada.next();
			personas[i-1].setNombre(nombre);
			//Se solicitan los apellidos y se llama al metodo setApellidos
			System.out.println("Indique los apellidos de la "+i+"º persona");
			//Se utiliza otro nextLine para evitar que salte a la linea del telefono
			entrada.nextLine();
			apellidos=entrada.nextLine();
			personas[i-1].setApellidos(apellidos);
			//Se solicita el telefono y se llama al metodo setTelefono
			System.out.println("Indique el teléfono de la "+i+"º persona");
			telefono=entrada.nextInt();
			personas[i-1].setTelefono(telefono);
		}
		//Se cierra el scanner
		entrada.close();
		System.out.println("Los datos introducidos son: ");
		//Se recorre el array y se llaman a los metodos get
		for(int i=1;i<4;i++) {
			System.out.println("\n"+i+"º personas:");
			System.out.println(personas[i-1].getNombre());
			System.out.println(personas[i-1].getApellidos());
			System.out.println(personas[i-1].getTelefono());	
		}

	}

}
