package extendedLinkedList;

import java.util.Arrays;

/*
 * A linked list implementation of the ListInterface using inner class Node
 */

public  class LinkedList<E> implements ListInterface<E>{
	
	protected GenericNode<E> head;
	protected GenericNode<E> tail;
	protected int listsize;
	
	public LinkedList(){
		
	}
	
	public LinkedList(E element, LinkedList<E> link){
		//A constructor LinkedList with a null head and size 0
		head=null;			
		listsize=0;
	}
	
	
	@SuppressWarnings("hiding")
	class GenericNode<E>{//An inner class Node used as helper to implement the list interface
		private E data;
		private GenericNode<E> next;
		
	public GenericNode(E element){
		//Node constructor used to create new nodes when adding nodes to the list
		data=element;	
	}

 	public void setData(E element){
		data = element;
	}
	
	public E getData(){
		return data;
	}
	
	public void setNext(GenericNode<E> nextNode){
		next=nextNode;
	}
	public GenericNode<E> getNext(){
		return next;
	}

	}//close Node class

	
	public boolean isEmpty() {
		
		if((head==null) && (tail==null))
			return true;

		return false;
	}//close isEmpty

	
	public int size() {
		
		return listsize;
	}

	public boolean add(E element) {
		boolean b= false;
		GenericNode<E> tempNode= new GenericNode<E>(element);
		
		if(head==null){
			head=tempNode;
			tail=tempNode;
			b=true;
		}
		else if(head!=null){
			tail.setNext(tempNode);
			tail=tempNode;
			b=true;
		}
		
		listsize++;
		return b;
		
	}//close add
	
	public void addIndex(E element, int index)
	{//A method to add nodes at a specific index
		checkIndex(index);
		GenericNode<E> tempNode = new GenericNode<E>(element);
		GenericNode<E> currNode=head;
		int i=1;
		if(index==0){
			head=tempNode;
			head.setNext(currNode);}
		else if(index==listsize-1){
			tail.setNext(tempNode);
			tail=tempNode;
		}
		else if((index>=1) && (index<listsize-2)){
		while(i<index && currNode.getNext()!=null){
			currNode=currNode.getNext();
			i++;
		}
		tempNode.setNext(currNode.getNext());//shift the nodes after the index next to the new node
		currNode.setNext(tempNode);}//insert the new node at the index spot
		listsize++;
		}//close addIndex

	public void clear() {
		int i=0;
		GenericNode<E> currNode=head;
			while(i < listsize){//iteratively remove each node in the list
				head =null;
				currNode.getNext().setNext(null);
				i++;
			}
			tail=null;
			listsize=0;
	
	}//close clear
	
	public boolean contains(Object o) {
		int i=0; boolean b=false;
		
		GenericNode<E> currNode = head;
		//first check if tail or head contain the object this will minimize the search time
		if(head.data.equals(o))
			b=true;
		else if(tail.data.equals(o))
			b=true;
		else{
		while(i<listsize){
		//check if the given object is in the list any where between head and tail
			if(currNode.getData().equals(o)){ 
				b=true;
				break;
			}
			
			currNode=currNode.getNext();
			i++;
		}
		}
		
		return b;

	}//close contains

	
	public boolean equals(ListInterface<E> otherList) {
		Object[] otherListary=otherList.toArray();
		Object[] LinkedListary = toArray();
		
		if(Arrays.deepEquals(LinkedListary, otherListary))
			return true;
		else
			return false;
	}
	
	public E get(int index) {
		checkIndex(index);
		GenericNode<E> currNode=head;
				if(index==0)	
				currNode=head;
				else if (index==listsize)
				currNode=tail;
				else{
				int i=0;
				while(i<index){
		//iteratively move through the elements of the list till it gets the element
						currNode=currNode.getNext();
						i++;}
				}

				return currNode.getData();//return the value at the given index

	}//close get

	
	public int indexOf(Object o) {
		int i=0, j=-1;
		GenericNode<E> currNode=head;
		while(i<listsize){//Iteratively search for the given element and return the index
			if(currNode.getData().equals(o)){
				j=i;
				break; 
				}
			else{
				currNode=currNode.getNext();
				i++;}
		}
		return j;

	}//close indexof

	
	public E remove(int index) {
		checkIndex(index);
		E data=null;
		GenericNode<E> targetNode=head;
		GenericNode<E> previousNode=head;
		
			if(index==0){ 
			// case to delete head 
				if(listsize>1){
				data=targetNode.getData();
				head=head.getNext(); 
				}
				else if(listsize==1){
					data=targetNode.getData();
					head=null;
					tail=null;	
					}
				
				}
			else if((index>=1) && (index<listsize-2)){
				// case to delete a node between head and tail
				for (int j = 0; j < index-1; j++) {
					previousNode=previousNode.getNext();
				}
				
				for (int j = 0; j < index; j++) {
					targetNode=targetNode.getNext();
				}
				data=targetNode.getData();
				previousNode.setNext(targetNode.getNext());
			}
			else if(index==listsize-1){
				// case to delete tail
				for (int j = 0; j < index-1; j++) {
					previousNode=previousNode.getNext();
				}
				
				for (int j = 0; j < index; j++) {
					targetNode=targetNode.getNext();
					
				}
					data=targetNode.getData();
					tail=previousNode;
					tail.setNext(null);

			}
			
			listsize--;
			
		return data;

	}//close remove

	public E set(int index, E element) {
		checkIndex(index);
		E data=null;
		int i=0;
		GenericNode<E> currNode=head;
		if(index==0){
			data=head.getData();head.setData(element); }
		else if(index==listsize){
			data=tail.getData();tail.setData(element); }
		else{
					while(i<index){
						//change the value of the node with the element passed as parameter
						currNode=currNode.getNext();
						i++;
					}
					data=currNode.getData();
					currNode.setData(element);
		}
					return data;
	}//close set
	
	public Object[] toArray() {
		int i=0;
		Object[] elem= new Object[listsize];// create an array variable of size equal to list size
		GenericNode<E> currNode=head;
		while(i<listsize){
			elem[i]=currNode.getData();//fill in the array with the data value of the array
			currNode=currNode.getNext();
			i++;
		}
		return elem;
	}

	public void checkIndex(int index){ //check if index is within the range of the list size
		
		String message="Wrong index value inserted";
		if(index>listsize-1){
			System.out.println("Index must be between 0 and " +(listsize-1));
			throw new IndexOutOfBoundsException(message);
			
		}
	}//close checkIndex

	public void display(){
		GenericNode<E> currNode = head;
			while(currNode!=null){
			System.out.print("["+currNode.data+"] ");//display the value of the list
			currNode=currNode.getNext();
		}
	
	}//close display

}//close LinkedList class
