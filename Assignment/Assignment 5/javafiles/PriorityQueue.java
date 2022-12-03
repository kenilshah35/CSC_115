import java.util.NoSuchElementException;

/*
 * The shell of the class, to be completed as part of the
 * CSC115 Assignment 5 : Emergency Room
 */

/*
* Name: Kenil C. Shah
* ID: V00903842
* Date: 29 July 2018
* Filename: PriorityQueue.java
* Details: CSc 115 Assignment 5
*/
 
public class PriorityQueue<E extends Comparable<E>> {
	
	private Heap<E> heap;
	
	/**
	 * Creates an empty priority queue.
	*/
	public PriorityQueue() {
		heap = new Heap<E>();
	}
	
	/**
	 * Checks if the heap is empty.
	 * @return True if the queue is empty, false if it is not.
	*/
	public boolean isEmpty(){
		return heap.size() == 0;
	}
	
	/**
	 * Retrieves, but does not remove the next item out of the queue.
	 * @return The item with the highest priority in the queue.
	 * @throw java.util.NoSuchElementException - if the queue is empty.
	*/
	public E peek(){
		
		if(heap.isEmpty()) throw new NoSuchElementException("The heap is empty");
		
		return heap.getRootItem();
	}
	
	/**
	 * Inserts an item into the queue.
	 * @param item - The item to insert.
	*/
	public void enqueue(E item){
		heap.insert(item);
	}
	
	/**
	 * Removes the highest priority item from the queue.
	 * @return The item. 
	 * @throw java.util.NoSuchElementException - if the queue is empty.
	*/
	public E dequeue(){
		
		if(heap.isEmpty()) throw new NoSuchElementException("The heap is empty");
		E item = heap.removeRootItem();
		return item;
	}
	
	/**
	 * The unit tester for this class.
	 * @param args Not used.
	 */
	public static void main(String[] args){
		
		PriorityQueue<ER_Patient> testQueue1 = new PriorityQueue<ER_Patient>();
		
		System.out.println("\n"+"Testing isEmpty on empty queue: " + testQueue1.isEmpty() + "\n");
		//System.out.println("Testing peek on empty queue: " + testQueue1.peek());
		
		ER_Patient patient1 = new ER_Patient("Walk-in");
		ER_Patient patient2 = new ER_Patient("Major fracture");
		ER_Patient patient3 = new ER_Patient("Chronic");
		ER_Patient patient4 = new ER_Patient("Life-threatening");
		ER_Patient patient5 = new ER_Patient("Walk-in");
		ER_Patient patient6 = new ER_Patient("Life-threatening");
		
		testQueue1.enqueue(patient1);
		testQueue1.enqueue(patient2);
		testQueue1.enqueue(patient3);
		testQueue1.enqueue(patient4);
		testQueue1.enqueue(patient5);
		testQueue1.enqueue(patient6);
		
		System.out.println("Testing peek after 6 enqueues: " + testQueue1.peek() +"\n");
		
		System.out.println("Testing isEmpty after 6 enqueues: " + testQueue1.isEmpty()+"\n");
		
		System.out.println("Dequeued item: " + testQueue1.dequeue());
		System.out.println("Testing peek after 1 dequeue: " + testQueue1.peek() +"\n");
		
		System.out.println("Dequeued item: " + testQueue1.dequeue());
		System.out.println("Testing peek after 2 dequeue: " + testQueue1.peek() +"\n");
		
		System.out.println("Dequeued item: " + testQueue1.dequeue());
		System.out.println("Testing peek after 3 dequeue: " + testQueue1.peek() +"\n");
		
		System.out.println("Dequeued item: " + testQueue1.dequeue());
		System.out.println("Testing peek after 4 dequeue: " + testQueue1.peek() +"\n");
		
		System.out.println("Dequeued item: " + testQueue1.dequeue());
		System.out.println("Testing peek after 5 dequeue: " + testQueue1.peek() +"\n");
		
		System.out.println("Dequeued item: " + testQueue1.dequeue());
		System.out.println("Testing isEmpty after 6 dequeues: " + testQueue1.isEmpty()+"\n");
	}
}
	
