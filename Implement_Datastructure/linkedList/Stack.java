package datastruct;

public class Stack<E> {

	private Node<E> top;
	int size = 0;
	
	//This returns the element in the top Node and changes the top Node to its first child
	//This throws an EmptyStackException if empty
	public E pop(){
		if(isEmpty())
			throw new EmptyStackException();
		E value = top.getData();
		top = top.getNext();
		size--;
		return value;
	}
	
	//This adds the next element to the top of the stack and returns true
	public boolean push(E next){
		top = new Node<E>(next,top);
		size++;
		return true;
	}
	
	//This returns the size of the Stack
	public int size(){
		return size;
	}
	
	//This returns true if the Stack is empty
	public boolean isEmpty(){
		return size==0;
	}
	
	//This returns true if the two stacks have the same elements in the same order
	public boolean equals(Stack<E> other){
		Node<E> temp = top;
		Node<E> otherTemp = top;
		if(this.size !=other.size)
			return this.size ==other.size;

		boolean equals = true;
		while(otherTemp!=null){
			equals = otherTemp.equals(temp);
			temp=temp.getNext();
			otherTemp=otherTemp.getNext();
		}
		return equals;
	}
}
