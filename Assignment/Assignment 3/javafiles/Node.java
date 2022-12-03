/*
* Name: Kenil C. Shah
* ID: V00903842
* Date: 23 June 2018
* Filename: Node.java
* Details: CSc 115 Assignment 3
*/

/**
Node class is a String singly linked list.
It stores an String and a node object 
which points to the next node object
*/
public class Node{
	
	
	String item;
	Node next;
	
	/**
	 Default constructor. Sets the item to 0, next to null.
	*/
	public Node(){
		item="";
		next=null;
	}
	
	/**
	 Creates node with String value n.
	 @param n a String value assigned to node
	*/
	public Node(String n){
		item=n;
		next=null;
	}

	/**
	 Creates a node with value n and nextNode as next
	 @param n		 a String value asigned to the node
	 @param nextNode a node object to which next points to
	*/
	public Node(String n,Node nextNode){
		item=n;
		next=nextNode;
	}
	
	/**
	 Gets the value of n.
	 @return the value of item
	*/
	public String getItem(){
		return item;
	}

	/**
	Gets the value of next
	@return the node object next
	*/
	public Node getNext(){
		return next;
	}	
	
	/**
	 Sets newItem to item String
	 @param newItem a String assigned to item
	*/
	public void setItem(String newItem){
		item=newItem;
	}
	
	/**
	 Sets newNext to next Node
	 @param newNext a Node object assigned to next
	*/
	public void setNext(Node newNext){
		next=newNext;
	}
	
}