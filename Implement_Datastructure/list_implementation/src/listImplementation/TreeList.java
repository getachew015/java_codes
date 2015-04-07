package listImplementation;

import java.util.Arrays;
import java.util.LinkedList;


public class TreeList<E extends Comparable <E>> implements ListInterface<E> {
	
		
		@SuppressWarnings("hiding")
		private class BSTNode<E>{
			private E element;
			private BSTNode<E> rightChild;
			private BSTNode<E> leftChild;

			public BSTNode (E element){
				this.element=element;
				leftChild=null;
				rightChild=null;
			}
			public void setLeft(BSTNode<E> node){
				leftChild=node;
			}
			public void setRight(BSTNode<E> node){
				rightChild=node;
			}
			
			public BSTNode<E> getRight(){
				return rightChild;
			}
			public BSTNode<E> getLeft(){
				return leftChild;
			}

			public E getData(){
				return element;
			}
		}//close BSTNode

		private BSTNode<E> root;
		private int treeSize=0;
		private LinkedList<E> list = new LinkedList<E>();

	public TreeList(){

		root=null;
	
	}
	public boolean isEmpty() {
		//check if root contains any data and if it is pointing to any thing 
		return (root==null);
	}
	
	public int size() {
		//return the current number of nodes as the size of the treeList 
		return treeSize;
	}


	public boolean add(E element) {
		BSTNode<E> newNode=new BSTNode<E>(element);
		BSTNode<E> prevNode = null,currNode=root;
		boolean b=false;
		if(root==null){
			root=newNode;
			b=true;
			treeSize++;
		}
		else if(element.compareTo(root.getData())<0){
			root=newNode;
			root.setRight(currNode);
			b=true;
			treeSize++;
		}
		else{
			if(root.getRight()==null){
				root.setRight(newNode);
				b=true;
				treeSize++;}
			else{
				currNode=root.getRight();
				
				while(true){
					prevNode=currNode;
					if(element.compareTo(currNode.getData())<0){
						currNode=currNode.getLeft();
						if(currNode==null){
							prevNode.setLeft(newNode);
							treeSize++;
							return true;}}
					else{
						currNode=currNode.getRight();
						if(currNode==null){
							prevNode.setRight(newNode);
							treeSize++;
							return true;}
					}
				}//close while
			} 
		}
		return b;
	}

	public void clear() {
		//this would remove root and all its pointers to the rest of the tree and then the rest of the tree would be garbage collected
		root.setLeft(null);
		root.setRight(null);
		root=null;
	}

	public boolean contains(Object o) {
		@SuppressWarnings("unchecked")
		E chkelement=(E) o;
		BSTNode<E> currNode=root;
		//iterate through each part of the node till the object passed to the method is located in the tree
		while(!chkelement.equals(currNode.getData())){
			if(chkelement.compareTo(currNode.getData())<0){
				currNode=currNode.getLeft();
			}else 
				currNode=currNode.getRight();
			if(currNode==null)
				return false;
		}
		return true;
	}
	
	public boolean equals(ListInterface<E> otherList) {
		/*Assign the the treeList's array value to an array and
		 * compare the two arrays
		 */

		if(treeSize!=otherList.size())
			return false;
		else
			return Arrays.deepEquals(toArray(), otherList.toArray());
		}

	public E get(int index) {
		/*check if the index is valid and call addTOlist function 
		 * which adds the treeList elements in a pre-order traversal
		 */
		checkIndex(index);
		list.clear();
		addToList(root);
		return list.get(index);


	}
	
	public int indexOf(Object o) {
		@SuppressWarnings("unchecked")
		E chkelement=(E) o;
		BSTNode<E> currNode=root; int index=0;
		while(!chkelement.equals(currNode.getData())){
			if(chkelement.compareTo(currNode.getData())<0){
				currNode=currNode.getLeft();
			}else {
				currNode=currNode.getRight();}
				index++;
			if(currNode==null)
				index=0;
		}
		return index;
	}

	public E remove(int index) {
		/*case-1 delete root
		 * case-2 delete node from left subtree
		 * case-3 delete node from right subtree. case-2 and case-3 will be handled with one case 
		 */
		checkIndex(index);//first check index validity
		list.clear();
		BSTNode<E> takeOverNode=null, newLeftNode=null, currNode=root, parentNode=null;
		boolean leftSubTreeNode=false;
		E removedObject=null;
		if(index==0){
			//case-1 deleting the root of the tree
			removedObject = root.getData();
			if(treeSize==1)
				root=null;
			else{
				if(root.getRight()!=null){
					takeOverNode=root.getRight(); }
				else
					takeOverNode=root.getLeft();
				newLeftNode=root.getLeft();
				root=null;
				root=takeOverNode;
				root.setRight(takeOverNode.getRight());
				if(newLeftNode==null)
					root.setLeft(takeOverNode.getLeft());
				else
					root.setLeft(newLeftNode);
			}

			}//end case-1
		//case-2 and case-3 identify if the node is in the right or left subtree 
		else {
		removedObject = get(index);

		while(!removedObject.equals(currNode.getData())){
			parentNode=currNode;
			if(removedObject.compareTo(currNode.getData())<0){
				leftSubTreeNode=true;
				currNode=currNode.getLeft();}
			else
				currNode=currNode.getRight();
		}
		if(currNode.getRight()!=null)
			takeOverNode=currNode.getRight(); 
		else
			takeOverNode=currNode.getLeft();
		if(leftSubTreeNode){
			parentNode.setLeft(takeOverNode);
//			takeOverNode.setLeft(currNode.getLeft());
//			takeOverNode.setRight(takeOverNode.getRight());
			currNode=null;
		}
		else{
			parentNode.setRight(takeOverNode);
			takeOverNode.setLeft(currNode.getLeft());
			currNode=null;
		}
		
		}
		addToTree();
		return removedObject;
	}//close remove

	public E set(int index, E element) {
		//check if index is valid and remove the element at the desired index and finally add the element to the treeList
		E replacedElement=null;
		checkIndex(index);
		replacedElement=get(index);
		remove(index);
		add(element);
		return replacedElement;
	}

	public Object[] toArray() {
		/*check if the tree is empty and return null if so; else call addToList 
		and use the toArray method of built-in LinkedlIst. Elements will be inserted in sorted manner in the array*/
		if(isEmpty())
			return null;
		else
			list.clear();
			addToList(root);
			Object[] array = list.toArray();
		return array;
	}

	public void display(){
		display(root);
	}

	public void addToList(BSTNode<E> node){
		
			if(node!=null){
			list.add(node.getData());
			addToList(node.getLeft());
			addToList(node.getRight());
			}
			
	}
	
	@SuppressWarnings("unchecked")
	public void addToTree(){
	
		addToList(root);
		LinkedList<E> list2 = new LinkedList<E>();
		list2=list;
		clear();
		Object[] obj= list2.toArray();
		for (Object object : obj) {
			add((E)object);
		}

}
	public void display(BSTNode<E> node){

			if(node!=null){
			display(node.getLeft());
			System.out.print(" "+node.getData());
			display(node.getRight());
			}
	}
	
	public void checkIndex(int index){ //check if index is within the range of the list size
		String message="Current Size of the TreeList is: " +treeSize;
		if(index>treeSize-1){
			System.out.println("Index must be between 0 and " +(treeSize-1));
			throw new IndexOutOfBoundsException(message);
		}
	
	}//close checkIndex
}
