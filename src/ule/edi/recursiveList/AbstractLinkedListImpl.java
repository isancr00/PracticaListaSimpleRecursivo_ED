package ule.edi.recursiveList;

import java.util.Iterator;
import java.util.NoSuchElementException;

import ule.edi.exceptions.EmptyCollectionException;

public class AbstractLinkedListImpl<T> implements ListADT<T> {

	// Estructura de datos, lista simplemente enlazada
	//
	// Este es el primer nodo de la lista
	protected Node<T> front = null;

	// Clase para cada nodo en la lista
	protected  class Node<T> {

		T elem;

		Node<T> next;

		Node(T element) {
			this.elem = element;
			this.next = null;
		}

		@Override
		public String toString() {
			return "(" + elem + ")";
		}

	}

	private class IteratorImpl implements Iterator<T> {
		// TODO Implementar el iterador normal

		private Node<T> current;

		public IteratorImpl(Node<T>node) {
			// TODO Auto-generated constructor stub
			this.current = node;
		}

		@Override
		public boolean hasNext() {

			return (current != null);
		}

		@Override
		public T next() {

			if(!hasNext()) {
				throw new NoSuchElementException();
			}

			T element = current.elem;			
			current = current.next;
			return element;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}


	// Ejemplos de ejercicios de recursividad
	//



	@Override
	public String toString() {
		// TODO RECURSIVO
		//	Construye y devuelve con el formato adecuado "(A B C )" 

		StringBuffer aux = new StringBuffer();

		aux.append("(");

		if(isEmpty()) {
			aux.append("");
		}else {
			toStringRec(front,aux);
		}

		aux.append(")");		


		return aux.toString();
	}

	private void toStringRec(Node<T> node,StringBuffer aux) {
		if(node != null) {
			
			if(node.next == null) {
				aux.append(node.elem);
				aux.append(" ");
			}else {
				aux.append(node.elem);
				aux.append(" ");				
				toStringRec(node.next,aux);
			}
		}

	}


	@Override
	public boolean contains(T target) {
		// TODO RECURSIVO

		if(target == null) {
			throw new NullPointerException();
		}else if(isEmpty()) {
			return false;
		}else {
			return containsRec(target,front);
		}

	}

	private boolean containsRec(T elem,Node<T> node) {
		if(elem.equals(node.elem)) {
			return true;
		}else {
			return containsRec(elem, node.next);
		}
	}

	@Override
	public int count(T element) {
		// TODO RECURSIVO

		if(element == null) {
			throw new NullPointerException();
		}else {
			int contador = 0;
			return countRec(element,front, contador);
		}

	}

	private int countRec(T element, Node<T> node,int contador) {

		if(element.equals(node.elem)) {
			contador++;
		}else {
			contador = countRec(element, node.next,contador);
		}

		return contador;
	}


	@Override
	public T getLast() throws EmptyCollectionException {
		// TODO RECURSIVO

		if(isEmpty()) {
			throw new EmptyCollectionException("LISTA SIMPLEMENTE ENLAZADA");
		}else {
			return getLastRec(front);
		}

	}

	private T getLastRec(Node<T> node) {
		if(node.next == null) {
			return node.elem;
		}else {
			getLastRec(node.next);
		}

		return null;
	}



	@Override
	public boolean isOrdered() {
		// TODO RECURSIVO

		if(isEmpty()) {
			return true;
		}
		return isOrderedRec(front);
	}

	private boolean isOrderedRec(Node<T> node) {
		//TODO
		return false;
	}


	@Override
	public T remove(T element) throws EmptyCollectionException {
		// TODO RECURSIVO
		T elem = null;
		if(isEmpty()) {
			throw new EmptyCollectionException("Lista simplemente enlazada");
		}else if(element == null) {
			throw new NullPointerException();
		}else if(element.equals(front.elem)) {
			front = front.next;
			return front.elem;
		}else {
			elem = removeRec(element,front.next,front);
		}
		return elem;


	}

	private T removeRec(T element, Node<T> nodeActual, Node<T> nodeAnterior) {

		if(element.equals(nodeActual.elem)){

			nodeAnterior.next = nodeActual.next;					

			return nodeActual.elem;			
		}else {
			return removeRec(element,nodeActual.next,nodeActual);
		}
	}


	@Override
	public T removeLast(T element) throws EmptyCollectionException {
		// TODO RECURSIVO

		if(element == null) {
			throw new NullPointerException();
		}else if(isEmpty()) {
			throw new EmptyCollectionException("Lista simplemente enlazada");
		}else {
			return removeLastRec(element, front,null,0,0);
		}
	}


	private T removeLastRec(T element, Node<T> nodeActual,Node<T> nodeAnterior,int numeroElems,int numeroPosiciones) throws EmptyCollectionException {

		if(numeroPosiciones <= size()) {
			if(element.equals(nodeActual.elem)) {
				numeroElems++;
				numeroPosiciones++;

				if(numeroElems == getTimeElement(element, front, 0, 0)) {
					return removeRec(element, nodeActual, nodeAnterior);
				}else {
					return removeLastRec(element, nodeActual.next,nodeAnterior, numeroElems, numeroPosiciones);
				}
			}else {
				numeroPosiciones++;
				return removeLastRec(element, nodeActual.next, nodeAnterior,numeroElems, numeroPosiciones);
			}
		}
		return null;


	}


	private int getTimeElement(T element,Node<T> node,int countElem,int countPositions){

		if(countPositions <= size()) {
			if(element.equals(node.elem)) {
				countElem++;
				countPositions++;
			}else {
				countPositions++;
				return getTimeElement(element, node.next, countElem, countPositions);
			}
		}

		return countElem;

	}


	@Override
	public boolean isEmpty() {
		// TODO 
		return (front == null);
	}

	@Override
	public int size() {
		// TODO RECURSIVO
		if(isEmpty()) {
			return 0;
		}else {
			return sizeRec(front,0);
		}
	}

	private int sizeRec(Node<T> nodeAct, int tamanio) {
		if(nodeAct.next == null) {
			tamanio++;
			return tamanio;
		}else {
			tamanio++;
			return sizeRec(nodeAct.next,tamanio);
		}
	}


	@Override
	public T getFirst() throws EmptyCollectionException {
		// TODO RECURSIVO
		if(isEmpty()) {
			throw new EmptyCollectionException("LISTA SIMPLEMENTE ENLAZADA");
		}

		return front.elem;
	}

	@Override
	public String toStringFromUntil(int from, int until) {
		// TODO RECURSIVO

		StringBuffer aux = new StringBuffer();

		if(from <= 0 || until <= 0 || until<from) {
			throw new IllegalArgumentException();
		}else if(isEmpty()) {
			aux.append("()");

		}else {
			aux.append("(");
			toStringFromUntilRec(from, until, 0,front,aux);
			aux.append(")");
		}

		return aux.toString();


	}

	private String toStringFromUntilRec(int from, int until,int posicion,Node<T> nodeAct, StringBuffer aux) {
		
		if(nodeAct.next != null) {
			if(posicion == from) {
				if(posicion == until) {
					aux.append(nodeAct.elem);
					aux.append(" ");
					posicion++;
				}else {
					aux.append(nodeAct.elem);
					aux.append(" ");
					posicion++;
					aux.append(toStringFromUntilRec(from, until, posicion, nodeAct.next,aux));
				}


			}else {
				posicion++;
				aux.append(toStringFromUntilRec(from, until, posicion, nodeAct.next,aux));
			}


		}

		return aux.toString();

	}


	@Override
	public String toStringReverse() {
		// TODO RECURSIVE
		StringBuffer aux = new StringBuffer();

		if(isEmpty()) {
			aux.append("()");
		}else {
			aux.append("(");
			toStringReverseRec(front,null,aux);
			aux.append(")");
		}
		return aux.toString();
	}

	private void toStringReverseRec(Node<T> nodeAct,Node<T> nodeAnt, StringBuffer aux) {
		if(nodeAct.next == null) {
			aux.append(nodeAct.elem);
			aux.append(" ");
		}else {
			toStringReverseRec(nodeAct.next, nodeAct, aux);
			aux.append(nodeAct.elem);
			aux.append(" ");				
		}

	}


	@Override
	public int removeDuplicates() throws EmptyCollectionException {
		// TODO RECURSIVE
		// Implementar teniendo en cuenta que la lista está desordenada
		if(isEmpty()) {
			throw new EmptyCollectionException("LISTA SIMPLEMENTE ENLAZADA");
		}else {
			return removeDuplicatesRec(front);			
		}

	}

	private int removeDuplicatesRec(Node<T> nodo) {
		return 0;

	}


	@Override
	public Iterator<T> iterator() {
		// TODO 
		return new IteratorImpl(front);
	}


}
