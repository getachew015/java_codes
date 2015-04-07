package datastruct;
public class Queue<E> {
	
	private Node<E> head;
	private Node<E> tail;
	private int size;
	
	//This adds the element to the end of the Queue
	public boolean push(E element){
		if(isEmpty()){
			head.setNext(new Node<E>(element,null));
			tail=head;}
		else
			tail.setNext(new Node<E>(element,null));
		size++;
		return true;
	}
	
	//This returns the element in the head of the Node and changes the head to its first child
	//This throws an EmptyQueueException if empty
	public E pop(){
		if(isEmpty())
			throw new EmptyQueueException();
		E value=head.getData();
		head = head.getNext();
		size--;
		return value;
	}
	
	//This returns the size of the Queue
	public int size(){
		return size;
	}
	
	//This returns true if the Queue is empty
	public boolean isEmpty(){
		return size==0;
	}

	//This returns true if the two queues have the same elements in the same order
	public boolean equals(Queue<E> other){
		Node<E> temp = head;
		Node<E> otherTemp = other.head;
		boolean equal = true;
		while(temp!=null){
			equal &= temp==otherTemp;
			temp=temp.getNext();
			otherTemp = otherTemp.getNext();
		}
		return equal;
	}
}
