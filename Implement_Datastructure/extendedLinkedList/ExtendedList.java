package extendedLinkedList;

/*
 * An extended linked list, add method is overridden and additional three methods are included
 * insetAscend(), insertDscend(), insertNormal() 	
 */

public class ExtendedList <E extends Comparable<E>> extends LinkedList<E> {
	private int sort;
	private boolean duplicates;

	
	public ExtendedList(int sort, boolean duplicates){
		this.sort=sort;
		this.duplicates=duplicates;

	}
	
	@Override
	public boolean add(E element){ 
		char option = 0;
		if(sort>0 && duplicates==true)
			option='A'; //insert ascending with duplicates allowed
		else if(sort>0 && duplicates==false)
			option='B'; //insert ascending with duplicates not allowed
		else if(sort<0 && duplicates==true)
			option='C';	//insert descending with duplicates allowed
		else if(sort<0 && duplicates==false)
			option='D'; //insert descending with duplicates not allowed
		else if(sort==0 && duplicates==true)
			option='E';  //insert as is with duplicates allowed
		else if(sort==0 && duplicates==false)
			option='F';  //insert as is with duplicates not allowed
	
	switch (option) {//switch through the different insert cases
		
	//Insert Ascending
		case 'A':
			insertAscend(element);
			break;
		case 'B':
			if(isEmpty())
				insertAscend(element);	
			else if(contains(element))
				return false;
			else
				insertAscend(element);
			break;
	//Insert Descending
		case 'C':
			insertDscend(element);
			break;	
		case 'D':
			if(isEmpty())
				insertDscend(element);
			else if(contains(element))
				return false;
			else
				insertDscend(element);
			break;
	//Insert in coming order
		case 'E':
			insertNormal(element);
			break;
		case 'F':
			if(isEmpty())
				insertNormal(element);
			else if(contains(element))
				return false;
			else
				insertNormal(element);
			break;
	
		default:
			
			break;
			
		}//close switch


		return true;
		
	}//close add
		
	public void insertAscend(E element){//this method inserts in ascending order 0 to n-1
		GenericNode<E> tempNode = new GenericNode<E>(element);
		GenericNode<E> currNode=head, prevNode = null;
		int i=0;
		if(isEmpty()){
			head=tempNode;
			tail=tempNode;
		}
		else if(tempNode.getData().compareTo(head.getData())<=0){
			head=tempNode;
			head.setNext(currNode);}
		else if(tempNode.getData().compareTo(tail.getData())>=0){
			tail.setNext(tempNode);
			tail=tempNode;}
		else if((tempNode.getData().compareTo(head.getData())>=0) || (tempNode.getData().compareTo(tail.getData())<=0)){
			while((i< listsize-1) && ((tempNode.getData().compareTo(currNode.getData()))>=0)) {
					prevNode=currNode;
					currNode=currNode.getNext();	
						i++;	}
			
				GenericNode<E> tempNode2 =prevNode.getNext();			
				prevNode.setNext(tempNode);

				tempNode.setNext(tempNode2);		
				}
		
			listsize++;
	}//	close insertAscend
		
	public void insertDscend(E element){//this method inserts in descending order 0 to n-1
		GenericNode<E> tempNode = new GenericNode<E>(element);
		GenericNode<E> currNode=head, prevNode = null;
		int i=0;
		if(isEmpty()){
		head=tempNode;
		tail=tempNode;
		}
	else if(tempNode.getData().compareTo(head.getData())>=0){
		head=tempNode;
		head.setNext(currNode);}
	else if(tempNode.getData().compareTo(tail.getData())<=0){
		tail.setNext(tempNode);
		tail=tempNode;}
	else if((tempNode.getData().compareTo(head.getData())<0) || (tempNode.getData().compareTo(tail.getData())>0)){
		while((i< listsize-1) && ((tempNode.getData().compareTo(currNode.getData()))<=0)) {
				prevNode=currNode;
				currNode=currNode.getNext();	
					i++;	}
		
			GenericNode<E> tempNode2 =prevNode.getNext();			
			prevNode.setNext(tempNode);

			tempNode.setNext(tempNode2);		
			}
	
		listsize++;
		
	}//	close insertDscend
	
	public void insertNormal(E element) {//this method inserts in in the order received
		
		GenericNode<E> tempNode= new GenericNode<E>(element);
		
		if(isEmpty()){
			head=tempNode;
			tail=tempNode;
		}
		else if(!isEmpty()){
			tail.setNext(tempNode);
			tail=tempNode;
		}
		listsize++;

	}//close insertNormal

}//close ExtendedList class
