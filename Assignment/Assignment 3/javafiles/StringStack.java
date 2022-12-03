/*
* Name: Kenil C. Shah
* ID: V00903842
* Date: 23 June 2018
* Filename: StringStack.java
* Details: CSc 115 Assignment 3
*/

/**
 Creates a Stack using a reference based linked list
 which stores string nodes as stacks initialised by
 head node.
*/
public class StringStack {

	private Node head;
	
	/**
	 Checks if the stack is empty by checking
	 if the head is null
	 @return boolean value of head==null
	*/
	public boolean isEmpty() {
		return (head==null);
	}

	/**
	 Deletes the first node of the stack and 
	 returns the item of the deleted node 
	 @return the item of the node deleted of list
	 @throws StackEmptyException if stack is empty during deletion
	*/
	public String pop() {
		
		if(this.isEmpty() == true) throw new StackEmptyException("The Stack is empty");
		
		//temp node to hold the soon to be deleted node
		Node curr = head;
		
		//assigning the reference of the head to the 2nd item of stack
		head = head.next;
		
		return curr.item;
	}

	/**
	 Gets the first item of the stack
	 @return the value stored in the first node of the stack
	 @throws StackEmptyException if stack is empty during retrieval
	*/
	public String peek() {
		
		if(this.isEmpty() == true) throw new StackEmptyException("The Stack is empty");
		
		return head.item;
	}
	
	/**
	 Creates a new Node with value of item String
	 and inserts it to the top of the stack
	 @param item String with the value to be assigned to the new Node
	*/
	public void push(String item) {
		
		Node curr = new Node();
		Node newNode = new Node(item);
		
		if(head != null){
			
			//temporary placeholder
			curr = head;
			//assigning the new node to the top of the stack
			head = newNode;
			//assigning the new Node's next reference to the former top node of the stack
			newNode.next = curr;
		}
		else{
			//if the stack is empty the new Node is assigned to the head
			head = newNode;
		}
	}

	/**
	 Empties the stack by setting head reference to null.
	*/
	public void popAll() {
		head=null;
	}
	
	public static void main(String[] args){
		
		StringStack test = new StringStack();
		System.out.println("After Creating stack");
		System.out.println("Testing isEmpty: " + test.isEmpty());
		System.out.println();
		
		test.push("A");
		System.out.println("After 1st Push");
		System.out.println("Testing peek: " + test.peek());
		
		System.out.println("Testing isEmpty: " + test.isEmpty());
		System.out.println();
		
		test.push("B");
		System.out.println("After 2nd Push");
		System.out.println("Testing peek: " + test.peek());
		
		System.out.println("Testing isEmpty: " + test.isEmpty());
		System.out.println();
		
		test.push("C");
		System.out.println("After 3rd Push");
		System.out.println("Testing peek: " + test.peek());
		
		System.out.println("Testing isEmpty: " + test.isEmpty());
		System.out.println();
		
		test.push("D");
		System.out.println("After 4st Push");
		System.out.println("Testing peek: " + test.peek());
		
		System.out.println("Testing isEmpty: " + test.isEmpty());
		System.out.println();
		
		test.pop();
		System.out.println("After 1st pop");
		System.out.println("Testing peek: " + test.peek());
		
		System.out.println("Testing isEmpty: " + test.isEmpty());
		System.out.println();
		
		test.pop();
		System.out.println("After 2nd pop");
		System.out.println("Testing peek: " + test.peek());
		
		System.out.println("Testing isEmpty: " + test.isEmpty());
		System.out.println();
		
		test.pop();
		System.out.println("After 3rd pop");
		System.out.println("Testing peek: " + test.peek());
		
		System.out.println("Testing isEmpty: " + test.isEmpty());
		System.out.println();
		
		
		
		test.pop();
		System.out.println("After 4st pop");
		
		//Testing exception inside method peek
		/*
		System.out.println("Testing peek: " + test.peek());
		*/
		
		System.out.println("Testing isEmpty: " + test.isEmpty());
		System.out.println();
		
		//Testing exception inside method peek
		/*
		test.pop();
		*/
		
		test.popAll();
		System.out.println("After pop all");
		System.out.println("Testing isEmpty: " + test.isEmpty());
	}
}
