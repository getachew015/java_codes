package datastruct;

public class LinkedList<E> {
	
	private Node<E> headNode;
	private int size;
	//This returns the size of the list
	public int size(){
		return size;
	}
	
	//This returns true if the List is empty
	public boolean isEmpty(){
		return headNode==null;
	}

	//Adds to the end of the list
	public boolean add(E element){
		
		add(element,size-1);
		
		return true;
	}
	
	//Adds to the index in index
	//Throws an IndexOutOfBoundsException if the index is out of bounds
	public boolean add(E element, int index){
		Node<E> temp = headNode;
		if(index>size || index<0)
			throw new IndexOutOfBoundsException();
		
		while(index>0){
			index--;
			temp = temp.getNext();
		}
		temp.setNext(new Node<E>(element,temp.getNext()));
		return true;
	}
	
	public E remove(int index){
		if(index>size || index<0)
			throw new IndexOutOfBoundsException();
		if(index==0){
			E value=headNode.getData();
			headNode = null;
			size--;			
			return value;
		}
		else{
		Node<E> temp = headNode;
		while(index>0){
			index--;
			temp = temp.getNext();
		}
		E value = temp.getData();
		temp.setNext(temp.getNext());
		size--;
		return value;}
	}
	
	//This returns the element in index E
	public E get(int index){
		Node<E> temp = headNode;
		while(index > 0){
			index--;
			temp = temp.getNext();
		}
		return temp.getData();
	}
	
	//This returns true if the two lists have the same elements in the same order
	public boolean equals(LinkedList<E> other){
		boolean b=false;
		for(int i = 0;i<=size;i++){
			b = this.get(i).equals(other.get(i));
		}
		return b;
	}
}
