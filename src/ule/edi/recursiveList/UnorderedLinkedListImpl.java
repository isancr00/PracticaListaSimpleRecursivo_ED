package ule.edi.recursiveList;

import java.util.NoSuchElementException;


public class UnorderedLinkedListImpl<T> extends AbstractLinkedListImpl<T> implements UnorderedListADT<T> {

	public UnorderedLinkedListImpl() {
		//	Vacía
	}
	
	public UnorderedLinkedListImpl(T ... v) {
		//	Añadir en el mismo orden que en 'v'
		for (T Vi : v) {
			addLast(Vi);
		}
	}
	
	@Override
	public void addFirst(T element) {
     //TODO
		if(element == null) {
			throw new NullPointerException();
		}else {
			Node<T> aux = new Node<T>(element);
			
			aux.next = front;
			front = aux;
		}
	}
	
	
	@Override
	public void addLast(T element) {
		// TODO RECURSIVO
		
		if(element == null) {
			throw new NullPointerException();
		}else {
			
		}
	
	}	

	
	@Override
	public void addBefore(T element, T target) {
		// TODO RECURSIVO
			
			
	}

		
}
