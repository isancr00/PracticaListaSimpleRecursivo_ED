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
		Node<T> node = front;
		
		aux.append("(");
		
		if(isEmpty()) {
			aux.append("");
		}else {
			aux.append(toStringRec(front));
		}
		
		aux.append(")");		
		
		
		return aux.toString();
	}
	
	private String toStringRec(Node<T> node) {
		StringBuffer aux = new StringBuffer();
		
		if(node != null) {
			if(node.next == null) {
				aux.append(node.elem);
			}else {
				toStringRec(node.next);
			}
		}
		
		return aux.toString();
	}
	
	
	@Override
	public boolean contains(T target) {
		// TODO RECURSIVO
				
		if(target == null) {
			throw new NullPointerException();
		}else {
			return containsRec(target,front);
		}
		
	}

	
	private boolean containsRec(T elem,Node<T> node) {
		if(elem == null || node == null) {
			throw new NullPointerException();
		}else {
			return elem.equals(node.elem) && containsRec(elem, node.next);
		}
	}
	
  @Override
	public int count(T element) {
	// TODO RECURSIVO
	  if(element == null) {
		  throw new NullPointerException();
	  }else {
		  return countRec(element,front);
	  }
		
	}
  
  private int countRec(T element, Node<T> node) {
	  int contador = 0;
	  
	  if(element.equals(node.elem)) {
		  contador++;
	  }else {
		  contador = countRec(element, node.next);
	  }
	  
	  return contador;
  }


	@Override
	public T getLast() throws EmptyCollectionException {
		// TODO RECURSIVO
		
		return null;
	}


	
	@Override
	public boolean isOrdered() {
     // TODO RECURSIVO
		return false;
	}

	
	@Override
	public T remove(T element) throws EmptyCollectionException {
    // TODO RECURSIVO
		return null;
		
	}


	@Override
	public T removeLast(T element) throws EmptyCollectionException {
     // TODO RECURSIVO
		return null;
	}


	@Override
	public boolean isEmpty() {
		// TODO 
		return false;
	}

	@Override
	public int size() {
		// TODO RECURSIVO
		return 0;
	}

	@Override
	public T getFirst() throws EmptyCollectionException {
		// TODO RECURSIVO
		return null;
	}

	@Override
	public String toStringFromUntil(int from, int until) {
		// TODO RECURSIVO
		
		return null;
		
	}


	@Override
	public String toStringReverse() {
		// TODO RECURSIVE
		return null;
	}
	

	@Override
	public int removeDuplicates() {
		// TODO RECURSIVE
		// Implementar teniendo en cuenta que la lista está desordenada
		return 0;
	
	}

	
	@Override
	public Iterator<T> iterator() {
		// TODO 
		return null;
	}


}
