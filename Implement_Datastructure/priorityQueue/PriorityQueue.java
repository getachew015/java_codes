package priorityQueue;

import java.util.NoSuchElementException;
/*
 * implements a priority queue by making a little modification on the linked list created for previous project
 * Elements will be sorted based on their priority while FIFO is still considered for each priority index
 * 
 */
		

public class PriorityQueue<E>  extends LinkedList<E>{
	
	public PriorityQueue(){
		
	}
	
	
	public void addWithPriority(E element, int priority){//inserts elements in a sorted manner based upon the priority value
		checkPriority(priority);
		GenericNode<E> tempNode = new GenericNode<E>(element, priority);
		GenericNode<E> currNode=head, prevNode = null;
		int i=0;
		
		if(isEmpty()){
		head=tempNode;
		tail=tempNode;
		}
	else if((tempNode.getPriority()) >(head.getPriority())){
		head=tempNode;
		head.setNext(currNode);}
	else if((tempNode.getPriority())<=(tail.getPriority())){
		tail.setNext(tempNode);
		tail=tempNode;}
	else if(((tempNode.getPriority())<=(head.getPriority())) || ((tempNode.getPriority())>(tail.getPriority()))){
		while((i< listsize-1) && (tempNode.getPriority() <= currNode.getPriority())) {
				prevNode=currNode;
				currNode=currNode.getNext();	
					i++;	}
		
			GenericNode<E> tempNode2 =prevNode.getNext();			
			prevNode.setNext(tempNode);

			tempNode.setNext(tempNode2);		
			}
		listsize++;
	}
	public E remove(){//removes the head of the list and throws an Exception if queue is empty
		E data=null;
		if (isEmpty())
			throw new NoSuchElementException();
		else {
			if(listsize==1){data=head.getData();head=null;tail=null;}
		else{
		GenericNode<E> newHead=head.getNext();
		data=head.getData();
		head=null;
		head=newHead;}
		listsize--;}
		
		return data;
	}
	public void checkPriority(int priority){ //check priority number value
			if(priority<0){
			System.out.println("Priority number should be greater than zero");
			throw new IndexOutOfBoundsException();
		}

	}//close checkIndex
}
