import java.util.Scanner;
/**
 * Clase que implementa el metodo para la simulacion de asteroides
 * @author Antonio Pacheco
 * @version 15 de abril de 2026
 */
public class Asteroides{
	public static int[] asteroides(int[] valores){
		Stack<Integer> pila = new Stack<>();
		boolean continuar = true;
		for(int i = 0; i < valores.length; i++){
			if(valores[i] > 0){
				pila.push(valores[i]);
			}
			else if(valores[i] < 0 && !pila.isEmpty() && pila.top() > 0){ //unica situacion en la que pude haber un choque
				while(!pila.isEmpty() && pila.top() > 0){
					int asteroideD = pila.pop(); //asteoride que va hacia la derecha
					int asteroideI = valores[i] * (-1); //asteroide que va hacia la izquierda
					if(asteroideD < asteroideI){
						continue;
					}
					else if(asteroideI < asteroideD){
						pila.push(asteroideD);
						break;
					}
					else{ //cuando son iguales
						break;
					}
				}
			}else{
				pila.push(valores[i]);
			}
		}//Fin de for
		int[] sobrevivientes = new int[pila.tamaño()];
		for(int i = sobrevivientes.length - 1; i >= 0; i--){ 
			sobrevivientes[i] = pila.pop();
		}
		return sobrevivientes;
		
	}//Fin de metodo asteroides


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Bienvenido al choque de asteroides");
		System.out.println("Ingresa los valores de los asteroides (ejemplo : [5, 10, -5]");
		System.out.println("Ojo los valores positivos iran hacia la derecha y los negativos hacia la izquierda");
		String valores = sc.nextLine();
		valores = valores.replace("[", "").replace("]", "");

		String[] division = valores.split(", ");
		int[] vAsteroides = new int[division.length];
		for(int i = 0; i < vAsteroides.length; i++){
			vAsteroides[i] = Integer.parseInt(division[i]);
		}	

		int[] sobrevivientes = asteroides(vAsteroides);
		System.out.println("Los sobrevivientes fueron:");
		System.out.print("[");
		for(int i = 0; i < sobrevivientes.length; i++){
			if(i == sobrevivientes.length - 1){
				System.out.print(sobrevivientes[i]);
				break;
			}
			System.out.print(sobrevivientes[i] + ", ");
		}
		System.out.print("]");
		System.out.println(); //solo para hacer un espacio en la terminal
	}
}//Fin de clase Asteroides