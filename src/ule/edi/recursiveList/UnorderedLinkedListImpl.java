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
		}else if(isEmpty()){
			addFirst(element);
		}else {	
			addLastRec(element,front);
		}

	}

	private void addLastRec(T element, Node<T> node) {
		Node<T> aux = new Node<T>(element);

		if(node.next == null) {
			node.next = aux;
			aux.next = null;
		}else {
			addLastRec(element, node.next);
		}
	}


	@Override
	public void addBefore(T element, T target) {
		// TODO RECURSIVO

		if(element == null || target == null) {
			throw new NullPointerException();
		}else if(!contains(target)){
			throw new NoSuchElementException();					
		}else {
			addBeforeRec(element, target, front,null);
		}


	}

	private void addBeforeRec(T element, T target, Node<T> nodeAct, Node<T> nodeAnt) {
		Node<T> aux = new Node<T>(element);

		if(target.equals(front.elem)) {
			addFirst(element);
		}else {

			if(target.equals(nodeAct.elem)) {
				nodeAnt.next = aux;
				aux.next = nodeAct;
			}else {
				addBeforeRec(element, target, nodeAct.next, nodeAct);
			}
		}

	}
	
	


}
