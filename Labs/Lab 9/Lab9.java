import java.util.NoSuchElementException;
import java.util.Vector;

/*
 * Learn to use the Vector class in support of 
 * CSC115 Assignment 5: Emergency Room.
 */

/*
Name:Kenil Shah
Student Number: V00903842
Project: Lab 9 exercise
Date: 17th July 2018
*/

public class Lab9<E extends Comparable<E>> {

	private Vector<E> container;

	public Lab9() {
		
		container = new Vector<E>();
	}

	//add data at the end of the container
 	public void add(E data){
		
		container.add(data);
	}
	//return the number of objects in the container
	public int size(){
		
		return container.size();
	}
	//Swap the two object at index i and j
	public void swap(int i, int j){
		if(i>=0 && j>=0 && i<container.size() && j<container.size()){
			E temp = container.elementAt(i);
			container.set(i,container.elementAt(j));
			container.set(j,temp);
		}

	}
	//delete the object at index i
	public E delete(int i){
		if(i>=0 && i<container.size()) return container.remove(i);
		else return null;
	}
	//string representation of the containter
 	public String toString() {
		
		if(container.size() == 0) return "";
		
	 	StringBuilder stringRep = new StringBuilder("{");
		for(int i=0;i<container.size();i++){
			stringRep.append(container.elementAt(i));
			if(i != container.size()-1)stringRep.append(", ");
		}
		stringRep.append("}");
		
		return stringRep.toString();
 	}

	public static void main(String[] args) {
		Lab9<String> test = new Lab9<String>();
		System.out.println(test.size());
		test.add("f");
		test.add("d");
		test.add("i");
		test.add("s");
		test.add("m");
		test.add("d");
		System.out.println(test);
		System.out.println(test.delete(0));
		System.out.println(test);
		System.out.println(test.delete(test.size()-1));
		System.out.println(test);
		System.out.println(test.delete(1));
		System.out.println(test);
		
		//test 1
		Lab9<String> testLab9 = new Lab9<String>();
		testLab9.add("e");
		
		//test 2 - uncomment the following code after previous code works
		
		testLab9.add("k");
	
		
		//test 3 - uncomment the following code after previous code works
		
		testLab9.add("l");
		
		
		//test 4 - uncomment the following code after previous code works
		
		testLab9.add("w");
		testLab9.add("r");
		testLab9.add("s");
		testLab9.add("q");
		
		System.out.println(testLab9);
		
		testLab9.swap(1,4);
		System.out.println(testLab9);
		
		testLab9.swap(0,testLab9.size()-1);
		System.out.println(testLab9);
		
	}
}