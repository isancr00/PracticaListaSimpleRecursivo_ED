package ule.edi.recursiveList;

import ule.edi.exceptions.EmptyCollectionException;

public class OrderedLinkedListImpl<T extends Comparable<? super T>> extends
AbstractLinkedListImpl<T> implements OrderedListADT<T> {

	public OrderedLinkedListImpl() {
		// Vacía
	}

	public OrderedLinkedListImpl(T... v) {
		// Añade todos los elementos del array 'v'
		for (T Vi : v) {
			add(Vi);
		}
	}




	@Override
	public void add(T element) {
		//TODO RECURSIVO

		if(element == null) {
			throw new NullPointerException();
		}if(isEmpty() || element.compareTo(front.elem) <= 0 ) {
			Node<T> aux = new Node<T> (element);
			aux.next = front;
			front = aux;
		}else if(size() == 1){
			Node<T> aux = new Node<T> (element);
			front.next = aux;

		}else {
			addRec(element, front, null);			
		}

	}

	private void addRec(T element, Node<T> nodeAct, Node<T> nodeAnt) {
		Node<T> aux = new Node<T> (element);

		if(element.compareTo(nodeAct.elem) <= 0) {
			nodeAnt.next = aux;
			aux.next = nodeAct;
		}else if(nodeAct.next == null){
			nodeAct.next = aux;
		}else {
			addRec(element,nodeAct.next,nodeAct);
		}




	}


	@Override
	public int removeDuplicates() throws EmptyCollectionException {
		// TODO RECURSIVE 
		// Redefinir para listas ordenadas (los duplicados estarán consecutivos)
		int contador = 0;

		if(isEmpty()) {
			throw new EmptyCollectionException("LISTA SIMPLEMENTE ORDENADA");
		}else {
			contador = removeDuplicatesRec(front);
		}

		return contador;

	}

	private int removeDuplicatesRec (Node<T> nodeAct) {
		// TODO Auto-generated method stub

		if(nodeAct.next != null) {
			if(nodeAct.elem.equals(nodeAct.next.elem)) {
				nodeAct.next = nodeAct.next.next;
				return 1+removeDuplicatesRec(nodeAct);
			}else {
				return removeDuplicatesRec(nodeAct.next);
			}


		}

		return 0;

	}









}
