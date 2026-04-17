import java.util.EmptyStackException;
import java.util.Iterator;
/**
 * Implementacion de una pila usando listas
 * @author Antonio Pacheco
 * @version 16 de abril 2026
 */
public class Stack<T> implements TDAStack<T>{
	private class Node{
		T dato;
		Node siguiente;

		public Node(T dato){
			this.dato = dato;
			this.siguiente = null;
		}
	}

	Node tope;
	int tamaño;

	public Stack(){
		tope = null;
		tamaño = 0;
	}

	@Override
	public void push(T e){
		if(isEmpty()){
			tope = new Node(e);
			tamaño++;
		}else{
			Node aux = tope;
			tope = new Node(e);
			tope.siguiente = aux;
			tamaño++;
		}
	}

	@Override
	public T pop() throws EmptyStackException{
		if(isEmpty()){
			throw new EmptyStackException();
		}
		Node aux = tope;
		tope = tope.siguiente;
		tamaño--;
		return aux.dato;
	}

	@Override
	public T top() throws EmptyStackException{
		if(isEmpty()){
			throw new EmptyStackException();
		}
		return tope.dato;
	}

	@Override
	public boolean isEmpty(){
		return tope == null;
	}

	@Override
	public void clear(){
		tope = null;
	}

	/**
	 * Metodo auxiliar para devolver el tamaño de la pila
	 * @return int
	 */
	public int tamaño(){
		return tamaño;
	}

}