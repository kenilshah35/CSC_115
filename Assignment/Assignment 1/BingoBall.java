/*
* Name: Kenil C. Shah
* ID: V00903842
* Date: 27 May 2018
* Filename: BingoBall.java
* Details: CSc 115 Assignment 1
*/


/*
*The class below creates and holds a single ball
*in the game of bingo.
*It has value between 1-75
*/
public class BingoBall {

	private static char[] bingo = {'B','I','N','G','O'};
	private int value = 0;
	private char letter;
	
	/*
	*Constructor BingoBall creates a bingo ball with given ball and assigns letter
	*parameters: integer value
	*throws IllegalArgumentException when given a value more than 75 or less than 1
	*/
	public BingoBall(int value) {
		if (value > 0 && value < 76) {
			
			//assigns the value passed to the private variable
			this.value = value;
			//calls the setLetter method to assign a letter
			setLetter();
		} else {
			//throws exception if the value is not between 1 and 75
			throw new IllegalArgumentException("number must be between 1 and 75; it was "+value);
		}
	}
	
	/*
	*private method used to assign a letter corresponding to the value of ball
	*/
	private void setLetter() {
		
		//if-else block to set a letter value to corresponding number value
		if(value>=1 && value<=15){
			letter = bingo[0];
		}
		else if(value>=16 && value<=30){
			letter = bingo[1];
		}
		else if(value>=31 && value<=45){
			letter = bingo[2];
		}
		else if(value>=46 && value<=60){
			letter = bingo[3];
		}
		else if(value>=61 && value<=75){
			letter = bingo[4];
		}
	}
	
	/*
	*public instance method used to get value of the bingo ball
	*parameters: none
	*returns: int value of the ball
	*/
	public int getValue() {
		return value;
	}
	
	/*
	*public instance method used to get the letter
	*corresponding to the bingo ball
	*parameters: none
	*returns: char letter of the ball
	*/
	public char getLetter() {
		return letter; 
	}
	
	/*
	*public instance method used to set value of a bingo ball.
	*calls the setLetter method to set the corresponding letter value
	*parameters: int value (new value)
	*returns: nothing
	*/
	public void setValue(int value) {
		this.value = value;
		setLetter();
	}
	
	/*
	*public instance method used to compare two bingo balls
	*parameter: a BingoBall object for comparison
	*returns: True, if the two balls are equal;
	*or False, if the two balls are not equal
	*/
	public boolean equals(BingoBall other) {
		
		//if statement to check and compare the values of  the two balls 
		if(this.getValue() == other.getValue()){
			return true;
		}
		else return false;
	}
	
	/*
	*the toString method for the class
	*parameters: none
	*returns: a string representation of the bingo ball
	*/
	public String toString() {
		String str="";
		str += letter;
		str += value;
		return str;
	}

	/*
	* main method for the class BingoBall
	* Used as a tester method for the class
	*/
	public static void main(String[] args) {
		
		BingoBall b = new BingoBall(42);
		System.out.println("Created a BingoBall: "+b);
		System.out.println("The number is "+b.getValue());
		System.out.println("The letter is "+b.getLetter());
		BingoBall c = null;
		
		try {
			c = new BingoBall(76);
		} catch (Exception e) {
			System.out.println("Correctly caught the exception");
		}
		
		System.out.println("Created a second BingoBall: "+c);
		c = new BingoBall(14);
		
		if (!b.equals(c)) {
			System.out.println("The two balls are not equivalent");
		}
		
		c.setValue(42);
		System.out.println("The second ball has been changed to "+c);
		
		if (b.equals(c)) {

			System.out.println("They are now equivalent");
		}
		
		c.setValue(74);
		System.out.println("The second bingo ball has been changed to "+c);
	}
}
