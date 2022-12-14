/*
Name:Kenil Shah
Student Number: V00903842
Project: Lab 3 exercise
Date: 29th May 2018
*/

public class IntegerSLL implements IntegerList
{
	private INode head;
	private int count;
	
	public IntegerSLL(){
		
		head=null;
		count=0;
	}
	
	/*
	 * PURPOSE:
	 *	Add the element x to the front of the list.
	 *
	 * PRECONDITIONS:
	 *	None.
	 * 
	 * Examples:
	 * 
	 * If l is {1,2,3} and l.addFront(9) returns, then l is {9,1,2,3}.
	 * If l is {} and l.addFront(3) returns, then l is {3}.
	 */
	public void addFront (int x){
		
		head=new INode(x,head);
		count++;
		
		//alternate method
		
		//INode newNode = new INode (x);
		//newNode.setNext(head);
		//head=newNode;
		//count++;
	}

	/*
	 * PURPOSE:
	 *	Add the element x to the back of the list.
	 *
	 * PRECONDITIONS:
	 *	None.
	 * 
	 * Examples:
	 * 
	 * If l is {1,2,3} and l.addBack(9) returns, then l is {1,2,3,9}.
	 * If l is {} and l.addBack(9) returns, then l is {9}.
	 */	
	public void addBack (int x){
		
		INode newNode = new INode(x);
		count++;
		if(head==null){
			head = newNode;
			return;
		}
		INode temp=head;
		while(temp.next != null){
			temp=temp.next;
		}
		temp.next=newNode;
	}

	/*
	 * PURPOSE:
	 *	Return the number of elements in the list
	 *
	 * PRECONDITIONS:
	 *	None.
	 *
	 * Examples:
	 *	If l is {7,13,22} l.size() returns 3
	 *	If l is {} l.size() returns 0
	 */
	public int size()
	{
		return count;
	}
	
	/* 
	 * PURPOSE:
	 *	Return the element at position pos in the list.
	 * 
	 * PRECONDITIONS:
	 *	pos >= 0 and pos < l.size()
	 * 
	 * Examples:
	 *	If l is {67,12,13} then l.get(0) returns 67
	 *	If l is	{67,12,13} then l.get(2) returns 13
	 *	If l is {92} then the result of l.get(2) is undefined.
	 *
	 */
	public int  get (int pos){
		
		
		INode temp = head;
		
		for(int i=0;i<pos;i++) temp=temp.next;
		return temp.item;
	}
	
	/* 
	 * PURPOSE:
	 *	Remove all elements from the list.  After calling this
	 *	method on a list l, l.size() will return 0
	 * 
	 * PRECONDITIONS:
	 *	None.
	 * 
	 * Examples:
	 *	If l is {67,12,13} then after l.clear(), l is {}
	 *	If l is {} then after l.clear(), l is {}
	 *
	 */
	public void clear(){
		head=null;
		count=0;
	}

	/* 
	 * PURPOSE:
	 *	Remove the first item from the list. 
	 * 
	 * PRECONDITIONS:
	 *	The list is not empty.
	 * 
	 * Examples:
	 *	If l is {67,12,13,12} then after removeFront(), l is {12,13,12}
	 *  67 is returned.
	 */
	public int removeFront (){
		
		int n=head.item;
		head=head.next;
		count--;
		return n;
	}

	/* 
	 * PURPOSE:
	 *	Remove all instances of value from the list. 
	 * 
	 * PRECONDITIONS:
	 *	None.
	 * 
	 * Examples:
	 *	If l is {67,12,13,12} then after l.remove(12), l is {67,13}
	 *	If l is {1,2,3} then after l.remove(2), l is {1,3}
	 *	If l is {1,2,3} then after l.remove(99), l is {1,2,3}
	 */
	public void remove (int value)
	{
	//not going to be implemented in the lab
	}

	/*
	 * PURPOSE:
	 *	Return a string representation of the list
	 * 
	 * PRECONDITIONS:
	 *	None.
	 *
	 * Examples:
	 *	If l is {1,2,3,4} then l.toString() returns "{1,2,3,4}"
	 *	If l is {} then l.toString() returns "{}"
	 *
	 */
	public String toString()
	{	
		StringBuilder output = new StringBuilder("{");
		INode temp=head;
		while(temp!=null){
			output.append(temp.item);
			if(temp.next!=null) output.append(",");
			temp=temp.next;
		}
		output.append("}");
		return output.toString();
	}
	
	public static void main(String[] args){
		
		IntegerList list = new IntegerSLL();
		System.out.println("Empty List:");
		System.out.println(list);
		
		list.addFront(1);
		list.addFront(2);
		list.addFront(3);
		System.out.println("After adding 3, size = " + list.size() );
		System.out.println(list);
		
		list.clear();
		System.out.println("After clear, size = " + list.size() );
		
		list.addBack(4);
		list.addBack(5);
		list.addBack(6);
		System.out.println("After addback, size = " + list.size() );
		System.out.println(list);
		
		System.out.println("Test get: ");
		System.out.println("pos = 0 , get = " + list.get(0));
		System.out.println("pos = 1 , get = " + list.get(1));
		System.out.println("pos = 2 , get = " + list.get(2));
		
		IntegerSLL s_list = (IntegerSLL)list;
		
		int j=s_list.removeFront();
		System.out.println(list	);
	}
}