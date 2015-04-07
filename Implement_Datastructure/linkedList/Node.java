package datastruct;
public class Node<E> {

	private E element;
	private Node<E> next;
	
	public Node(E element, Node<E> next){
		this.element = element;
		this.next = next;
	}
	
	//This returns element
	public E getData(){
		return element;
	}
	
	//This returns the next Node
	public Node<E> getNext(){
		return next;
	}
	
	public void setNext(Node<E> node){
		next = node;
	}
}
