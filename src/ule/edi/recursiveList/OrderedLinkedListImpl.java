package ule.edi.recursiveList;

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
	
	private void addRec(T element, Node<T> node, Node<T> nodeAnt) {
		Node<T> aux = new Node<T> (element);
		
		if(node != null) {
			if(element.compareTo(node.elem) <= 0) {
				nodeAnt.next = aux;
				aux.next = node;
			}else if(node.next == null){
				node.next = aux;
			}else {
				addRec(element,node.next,node);
			}
			
		}
		
		
	}
	

	@Override
	public int removeDuplicates() {
  // TODO RECURSIVE 
  // Redefinir para listas ordenadas (los duplicados estarán consecutivos)
	
    return 0;
		}

	
	



	

		

}
