/*
* Name: Kenil C. Shah
* ID: V00903842
* Date: 27 May 2018
* Filename: BingoCalls.java
* Details: CSc 115 Assignment 1
*/


/*
* Class below creates and holds bingo balls 
* called by the user in a particular game
*/
public class BingoCalls{
	
	//container for bingo balls
	private BingoBall[] balls;
	//keeps track of the position of the array
	private int count;
	//initial capacity of the array
	private static final int capacity = 5; 
	
	/*
	* Constructor BingoCalls creates a container to hold bingo balls
	* parameter: none
	*/
	public BingoCalls(){
		balls = new BingoBall[capacity];
		count = 0;
	}
	
	/*
	*public instance method insert to add balls in the container
	*parameter: BingoBall object to be inserted
	*returns : none
	*/
	public void insert(BingoBall insertBall){
		
		//if statement to check if the array is full
		if(count==balls.length){
			//calls the method expand if the array is full
			expand();
		}
		
		//if statement to check if the ball was called before
		if(!wasCalled(insertBall)){
			
			//inserts ball in the first available space in the array
			balls[count] = insertBall;
			//incrementing count to point to the next available index of the array
			count++;
		}
	}
	
	/*
	*public instance method to check the number of bingo balls
	*already called in the game.
	*parameter: none
	*return: int count, which represents the number of bingo balls
	*/
	public int numBallsCalled(){
		return count;
	}
	
	/*
	*public instance method wasCalled used to check if
	*a bingo ball was previously called in the game
	*parameter : a BingoBall object calledBall 
	*returns: True, if the ball is found in the array;
	*	      False, if the ball was not found in the array
	*/
	public boolean wasCalled(BingoBall calledBall){
		
		//for loop to iterate over the array balls
		for(int i=0;i<count;i++){
			
			//if statement which calls equals method to compare balls
			if(balls[i].equals(calledBall)) return true;
			
		}//end of for loop
		
		return false;
	}
	
	/*
	*public instance method remove used to remove certain bingo ball from the array
	*parameter: the BingoBall object to be removed
	*returns: none
	*/
	public void remove(BingoBall ball){
		
		//calling method find to obtain the index value of array
		int index = find(ball);
		
		//if statement to check if the ball is present in the array
		if(index != -1){
			
			//for loop iterates over the array shifting values to preceding position
			for(int i=index;i<count-1;i++){
				
				balls[i] = balls[i+1];
				
			}//end of for loop
			
			//setting the last position to null to allow other balls to be inserted
			balls[count-1] = null;
			count--;
		}
	}
	
	/*
	*public instance method makeEmpty used to empty the array of all the balls
	*parameter: none
	*returns: none
	*/
	public void makeEmpty(){
		
		//for loop to iterate over the array setting all indexes to null
		for(int i=0;i<count;i++){
			
			balls[i]=null;
			
		}//end of for loop
		
		// resetting the counter
		count=0;
		
	}
	
	/*
	*public instance method expand used to double the size of the array id full
	*parameters: none
	*returns: none
	*/
	private void expand(){
		
		//creating a new expanded array with twice the capacity of previous array
		BingoBall[] arrayExpand = new BingoBall[balls.length*2];
		
		//for loop to copy all elements of array ball to the new array
		for(int i=0;i<count;i++){
			
			arrayExpand[i] = balls[i];
		}
		
		//setting arrayExpand as pivate array
		balls = arrayExpand;

	}
	
	/*
	*private instance method used to find the array index of a bingo ball
	*parameter: the BingoBall object whose index is to be found
	*returns: the index position if ball is present in the array; or -1 if not in the array
	*/
	private int find(BingoBall ball){
		
		//for loop to iterate over the loop and find ball
		for(int i=0;i<count;i++){
			
			//if statement ehich uses equals method and returns index position of a bingo ball
			if(balls[i].equals(ball)) return i;
			
		}//end of for loop
		
		return -1;
	}
	
	/*
	*the toString method for the class
	*parameters: none
	*returns: a string representation of the bingo ball
	*/
	public String toString(){
		
		String str = "";
		if(count == 0) return "{}";
		else{
			
			str += "{";
			for(int i=0;i<count-1;i++){
				str += balls[i].toString();
				str += ",";
			}
			str += balls[count-1].toString();
			str += "}";
		}
		
		return str;
	}
	
	/*
	* main method for the class BingoBall
	* used as a tester method for the class
	*/
	public static void main(String[] args){
		
		//creating a new container for bingo balls
		BingoCalls test = new BingoCalls();
		
		//creating 11 BingoBall objects
		BingoBall b1 = new BingoBall(1);
		BingoBall b2 = new BingoBall(16);
		BingoBall b3 = new BingoBall(31);
		BingoBall b4 = new BingoBall(46);
		BingoBall b5 = new BingoBall(61);
		BingoBall b6 = new BingoBall(2);
		BingoBall b7 = new BingoBall(17);
		BingoBall b8 = new BingoBall(32);
		BingoBall b9 = new BingoBall(47);
		BingoBall b10 = new BingoBall(62);
		BingoBall b11 = new BingoBall(62);
		
		//inserting 5 balls in the container using the insert method
		test.insert(b1);
		test.insert(b2);
		test.insert(b3);
		test.insert(b4);
		test.insert(b5);
		
		//testing numBallsCalled method
		System.out.println(test.numBallsCalled());
		
		//testing the toString method 
		System.out.println(test.toString());
		
		//inserting 5 more balls in the container to test expand method
		test.insert(b6);
		test.insert(b7);
		test.insert(b8);
		test.insert(b9);
		test.insert(b10);
		test.insert(b11);
		
		//using numBallsCalled to check if array has expanded
		System.out.println(test.numBallsCalled());
		
		System.out.println(test.toString());
		
		//removing first ball in the array using the remove method
		test.remove(b1);
		System.out.println(test.numBallsCalled());
		System.out.println(test.toString());
		
		//removing one of the middle index balls using the remove method
		test.remove(b5);
		System.out.println(test.numBallsCalled());
		System.out.println(test.toString());
		
		//removing the third index ball for further testing
		test.remove(b3);
		System.out.println(test.numBallsCalled());
		System.out.println(test.toString());
		
		//removing one of the end index balls for testing
		test.remove(b9);
		System.out.println(test.numBallsCalled());
		System.out.println(test.toString());
		
		//removing the last index ball using the remove method
		test.remove(b11);
		System.out.println(test.numBallsCalled());
		System.out.println(test.toString());
		
		//testing the makeEmpty method
		test.makeEmpty();
		
		//calling the numBallsCalled method to check if the container is empty
		System.out.println(test.numBallsCalled());
		
		//testing toString method for empty container
		System.out.println(test.toString());
	}
}