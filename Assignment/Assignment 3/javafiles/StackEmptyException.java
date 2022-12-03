/*
* Name: Kenil C. Shah
* ID: V00903842
* Date: 23 June 2018
* Filename: StackEmptyException.java
* Details: CSc 115 Assignment 3
*/

/**
 An exception is thrown when stack is deemed to be empty 
 and no method can be applied
*/
public class StackEmptyException extends RuntimeException{
	
	/**
	 Creates an exception with message
	 @param msg the message to be shown when exception is thrown
	*/
	public StackEmptyException(String msg){
		super(msg);
	}
	
	/**
	 Creates an exception without an exception
	*/
	public StackEmptyException(){
		super();
	}
	
}