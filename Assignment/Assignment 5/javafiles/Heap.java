import java.util.NoSuchElementException;
import java.util.Vector;

/*
 * The shell of the class, to be completed as part
 * of CSC115 Assignment 5: Emergency Room.
 */
 
/*
* Name: Kenil C. Shah
* ID: V00903842
* Date: 29 July 2018
* Filename: Heap.java
* Details: CSc 115 Assignment 5
*/

public class Heap<E extends Comparable<E>> {

	private Vector<E> heapArray;;
	
	/**
	 *Constructor of the class,creates an empty heap.
	*/
	public Heap(){
		
		heapArray = new Vector<E>();
	}
	
	/**
	 *Checks if the heap is empty.
	 *@return true if the heap is empty, false if it is not.
	*/
	public boolean isEmpty(){
		return heapArray.size() == 0;
	}
	
	/**
	 *Used to check the number of elements in teh heap.
	 *@return The number of items in the heap.
	*/
	public int size(){
		return heapArray.size();
	}
	
	/**
	 *Inserts an item into the heap.
	 *@param item - The newly added item
	*/
	public void insert(E item){
		
		heapArray.add(item);
		//System.out.println(heapArray);
		//System.out.println(heapArray.capacity());
		bubbleUp(heapArray.size()-1);
		
	}
	
	/*
	 * Private helper method bubbleUp used to re-establish
	 * minHeap's property by use of recursion.
	 * @param int n - the index of the element to be bubbled up
	*/
	private void bubbleUp(int n){
		
		//base case- if root returns
		if(n<=0) return;
		
		//determine parent of the element
		int parent;
		if(n%2 == 0){
			parent = (n-2)/2;
		}
		else{
			parent = (n-1)/2;
		}
		
		//base case - if parent already smaller than child returns
		if(heapArray.elementAt(parent).compareTo(heapArray.elementAt(n)) < 0) return;
		
		//swap
		E temp = heapArray.elementAt(n);
		heapArray.set(n,heapArray.elementAt(parent));
		heapArray.set(parent,temp);
		
		//recursive call using parent
		bubbleUp(parent);
	}
	
	/**
	 * Removes the item at the root node of the heap.
	 * @return The item at the root of the heap.
	 * @throw java.util.NoSuchElementException - if the heap is empty.
	*/
	public E removeRootItem(){
		
		if(heapArray.isEmpty()) throw new NoSuchElementException("The heap is empty");
		
		E temp = heapArray.elementAt(0);
		heapArray.set(0,heapArray.elementAt(heapArray.size()-1));
		heapArray.remove(heapArray.size()-1);
		bubbleDown(0);
		
		return temp;
		
	}
	
	/*
	 * Private helper method bubbleUp used to re-establish
	 * minHeap's property by use of recursion.
	 * @param int rroot- the index of the root of two children
	*/
	private void bubbleDown(int root){
		
		//determine left and right child index 
		int leftIndex = 2*root + 1;
		int rightIndex = 2*root + 2;
		int minIndex;
		
		//case - no right child
		if(rightIndex >= heapArray.size()){
			
			//case - no right and left child
			if(leftIndex >= heapArray.size()) return;
			
			//case - only left child 
			else minIndex = leftIndex;
		}
		
		//case - right child exists - left child exist as heap is always a complete binary tree
		else{
			
			//left child element < right child element
			if(heapArray.elementAt(leftIndex).compareTo(heapArray.elementAt(rightIndex)) < 0){
				minIndex = leftIndex;
			}
			
			//right child element < left child element
			else{
				minIndex = rightIndex;
			}
		}
		
		//swap if element at minIndex smaller than root element
		if(heapArray.elementAt(minIndex).compareTo(heapArray.elementAt(root)) < 0){
			
			E temp = heapArray.elementAt(root);
			heapArray.set(root,heapArray.elementAt(minIndex));
			heapArray.set(minIndex,temp);
			
			//recursive call
			bubbleDown(minIndex);
		}
	}
	
	/**
	 * Retrieves, without removing the item in the root.
	 * @return The top item in the tree.
	 * @throw java.util.NoSuchElementException - if the heap is empty.
	*/
	public E getRootItem(){
		
		if(heapArray.isEmpty()) throw new NoSuchElementException("The heap is empty");
		return heapArray.elementAt(0);
	}
	
	/*
	 *toString method to print the entire heap.
	*/
	public String toString() {
		
		if(heapArray.size() == 0) return "";
		
	 	StringBuilder stringRep = new StringBuilder("{");
		for(int i=0;i<heapArray.size();i++){
			stringRep.append(heapArray.elementAt(i));
			if(i != heapArray.size()-1)stringRep.append(", ");
		}
		stringRep.append("}");
		
		return stringRep.toString();
 	}
	
	/**
	 * The unit tester for this class.
	 * @param args Not used.
	 */
	public static void main(String[] args){
		
		Heap<String> testHeap1 = new Heap<String>();
		
		System.out.println(testHeap1.isEmpty());
		testHeap1.insert("Walk In");
		System.out.println(testHeap1.getRootItem());
		
		System.out.println(testHeap1.isEmpty());
		System.out.println(testHeap1);
		
		Heap<String> testHeap2 = new Heap<String>();
		
		testHeap2.insert("a");
		testHeap2.insert("b");
		testHeap2.insert("c");
		testHeap2.insert("d");
		testHeap2.insert("e");
		testHeap2.insert("f");
		testHeap2.insert("g");
		testHeap2.insert("h");
		testHeap2.insert("i");
		testHeap2.insert("j");
		testHeap2.insert("k");
		testHeap2.insert("l");
		testHeap2.insert("m");
		testHeap2.insert("n");
		
		System.out.println("\n" + testHeap2.isEmpty());
		System.out.println(testHeap2);
		System.out.println(testHeap2.getRootItem());
		
		System.out.println("\n" + testHeap2.removeRootItem());
		System.out.println(testHeap2.isEmpty());
		System.out.println(testHeap2);
		System.out.println(testHeap2.getRootItem());
		
		Heap<Integer> testHeap3 = new Heap<Integer>();
		
		testHeap3.insert(1);
		System.out.println("\n" + testHeap3.isEmpty());
		System.out.println(testHeap3);
		
		testHeap3.insert(57);
		testHeap3.insert(293);
		testHeap3.insert(23);
		testHeap3.insert(982);
		testHeap3.insert(82);
		testHeap3.insert(92);
		testHeap3.insert(-23);
		testHeap3.insert(234);
		testHeap3.insert(9023);
		testHeap3.insert(666);
		System.out.println("\n" + testHeap3.isEmpty());
		System.out.println(testHeap3);
		System.out.println(testHeap3.getRootItem());
		
		System.out.println("\n" + testHeap3.removeRootItem());
		System.out.println(testHeap3.isEmpty());
		System.out.println(testHeap3);
		
		System.out.println("\n" + testHeap3.removeRootItem());
		System.out.println(testHeap3.isEmpty());
		System.out.println(testHeap3);
		
		System.out.println("\n" + testHeap3.removeRootItem());
		System.out.println(testHeap3.isEmpty());
		System.out.println(testHeap3);
		System.out.println(testHeap3.getRootItem());
		
		System.out.println("\n" + testHeap3.removeRootItem());
		System.out.println(testHeap3.isEmpty());
		System.out.println(testHeap3);
		
		System.out.println("\n" + testHeap3.removeRootItem());
		System.out.println(testHeap3.isEmpty());
		System.out.println(testHeap3);
		
	}
}
