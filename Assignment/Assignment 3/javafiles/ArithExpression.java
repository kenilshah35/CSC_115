/*
* Name: Kenil C. Shah
* ID: V00903842
* Date: 23 June 2018
* Filename: ArithExpression.java
* Details: CSc 115 Assignment 3
*/

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 ArithExpression class used to convert infix expressions to
 postfix expressions and then evaluate the postfix expression.
 The infix expression is converted using String stacks and
 TokenList object list.
*/
public class ArithExpression {

	private TokenList postfixTokens;
	private TokenList infixTokens;

	/**
	 * Sets up a legal standard Arithmetic expression.
	 * The only parentheses accepted are "(" and ")".
	 * @param word An arithmetic expression in standard infix order.
	 * 	An invalid expression is not expressly checked for, but will not be
	 * 	successfully evaluated, when the <b>evaluate</b> method is called.
	 * @throws InvalidExpressionException if the expression cannot be properly parsed,
	 *  	or converted to a postfix expression.
	 */
	public ArithExpression(String word) {
		if (Tools.isBalancedBy("()",word)) {
			tokenizeInfix(word);
			infixToPostfix();
		} else {
			throw new InvalidExpressionException("Parentheses unbalanced");
		}
	}

	/*
	 * A private helper method that tokenizes a string by separating out
	 * any arithmetic operators or parens from the rest of the string.
	 * It does no error checking.
	 * The method makes use of Java Pattern matching and Regular expressions to
	 * isolate the operators and parentheses.
	 * The operands are assumed to be the substrings delimited by the operators and parentheses.
	 * The result is captured in the infixToken list, where each token is 
	 * an operator, a paren or a operand.
	 * @param express The string that is assumed to be an arithmetic expression.
	 */
	private void tokenizeInfix(String express) {
		infixTokens  = new TokenList(express.length());

		// regular expression that looks for any operators or parentheses.
		Pattern opParenPattern = Pattern.compile("[-+*/^()]");
		Matcher opMatcher = opParenPattern.matcher(express);

		String matchedBit, nonMatchedBit;
		int lastNonMatchIndex = 0;
		String lastMatch = "";

		// find all occurrences of a matched substring
		while (opMatcher.find()) {
			matchedBit = opMatcher.group();
			// get the substring between matches
			nonMatchedBit = express.substring(lastNonMatchIndex, opMatcher.start());
			nonMatchedBit = nonMatchedBit.trim(); //removes outside whitespace
			// The very first '-' or a '-' that follows another operator is considered a negative sign
			if (matchedBit.charAt(0) == '-') {
				if (opMatcher.start() == 0 || 	
					!lastMatch.equals(")") && nonMatchedBit.equals("")) {
					continue;  // ignore this match
				}
			}
			// nonMatchedBit can be empty when an operator follows a ')'
			if (nonMatchedBit.length() != 0) {
				infixTokens.append(nonMatchedBit);
			}
			lastNonMatchIndex = opMatcher.end();
			infixTokens.append(matchedBit);
			lastMatch = matchedBit;
		}
		// parse the final substring after the last operator or paren:
		if (lastNonMatchIndex < express.length()) {
			nonMatchedBit = express.substring(lastNonMatchIndex,express.length());
			nonMatchedBit = nonMatchedBit.trim();
			infixTokens.append(nonMatchedBit);
		}
	}

	/**
	 * Determines whether a single character string is an operator.
	 * The allowable operators are {+,-,*,/,^}.
	 * @param op The string in question.
	 * @return True if it is recognized as a an operator.
	 */
	public static boolean isOperator(String op) {
		switch(op) {
			case "+":
			case "-":
			case "/":
			case "*":
			case "^":
				return true;
			default:
				return false;
		}
	}
		

	 /**
	 * A private method that initializes the postfixTokens data field.
	 * It takes the information from the infixTokens data field.
	 * If, during the process, it is determined that the expression is invalid,
	 * an InvalidExpressionException is thrown.
 	 * Note that since the only method that calls this method is the constructor,
	 * the Exception is propogated through the constructor.
	 */
	private void infixToPostfix() {
		
		StringStack arithmeticStack = new StringStack();
		postfixTokens = new TokenList(infixTokens.size());
		
		for(int i=0;i<infixTokens.size();i++){
			
			String currToken = infixTokens.get(i);
			
			
			//System.out.println(currToken);
			
			//for operands
			if(isOperator(currToken) == false && !currToken.equals("(") && !currToken.equals(")")) {
				postfixTokens.append(currToken);
				//System.out.println(postfixTokens.toString());
			}
			//for "("
			else if(currToken.equals("(") ) {
				//System.out.println("Hello I am here too DONT IGNORE ME");
				
				arithmeticStack.push(currToken);
				
				//System.out.println(arithmeticStack.peek());
				//System.out.println("Hello I am here too DONT IGNORE ME");
			}
			
			//for operators
			else if(isOperator(currToken) == true){
				
				//System.out.println("Am I getting executed? before while");
				
				if(!arithmeticStack.isEmpty()){
					
					//System.out.println(currToken);
					//System.out.println(arithmeticStack.peek());
					//System.out.println(getPrecedence(currToken,arithmeticStack.peek())+"\n");
					
				}
				
				while(!arithmeticStack.isEmpty() && !arithmeticStack.peek().equals("(") && getPrecedence(currToken,arithmeticStack.peek()).equals("low_equal")){
					
					//System.out.println("Am I getting executed? after while");
				
					String pop = arithmeticStack.pop();
					postfixTokens.append(pop);
					
				}
				arithmeticStack.push(currToken);
				
				//System.out.println(arithmeticStack.peek());
				//System.out.println(postfixTokens.toString());
			}
			
			//for ")"
			else if(currToken.equals(")")){
				
				//System.out.println(arithmeticStack.peek());
				while(!arithmeticStack.peek().equals("(")){
					String pop = arithmeticStack.pop();
					postfixTokens.append(pop);
				}
				String pop = arithmeticStack.pop();
				
			}

		}
		
		//System.out.println(getPostfixExpression());
		
		//appends the remaining tokens to the list
		while(arithmeticStack.isEmpty() != true){
			
			String pop = arithmeticStack.pop();
			postfixTokens.append(pop);
		}
		
		/*
		//Testing the private method getPrecedence
		System.out.println(getPrecedence("+","-"));
		System.out.println(getPrecedence("-","+"));
		System.out.println(getPrecedence("+","+"));
		System.out.println(getPrecedence("-","-"));
		System.out.println(getPrecedence("*","^"));
		System.out.println(getPrecedence("*","/"));
		System.out.println(getPrecedence("*","*"));
		System.out.println("2" + getPrecedence("/","*"));
		System.out.println(getPrecedence("/","/"));
		System.out.println(getPrecedence("/","^"));
		System.out.println(getPrecedence("^","+"));
		System.out.println(getPrecedence("^","-"));
		System.out.println(getPrecedence("^","*"));
		System.out.println(getPrecedence("^","/"));
		System.out.println(getPrecedence("^","^"));
		System.out.println(getPrecedence("*","-"));
		System.out.println(getPrecedence("*","+"));
		*/	
	}
	
	/**
	 a private instance method used to compare two operator tokens
	 and returns the precedence	
	 @return low_equal if precedence is low or equal
	 @return hign if precedence is high 
	*/
	private String getPrecedence(String tokenOperator, String stackOperator){
		
		if(tokenOperator.equals("+") && ( stackOperator.equals("-") || stackOperator.equals("+") || stackOperator.equals("^") || stackOperator.equals("/") || stackOperator.equals("*")  ) ) return "low_equal";
		
		else if(tokenOperator.equals("-") && ( stackOperator.equals("-") || stackOperator.equals("+") || stackOperator.equals("^") || stackOperator.equals("/") || stackOperator.equals("*")  ) ) return "low_equal";
		
		else if(tokenOperator.equals("*") && (stackOperator.equals("^") || stackOperator.equals("/") || stackOperator.equals("*"))) return "low_equal";
		
		else if(tokenOperator.equals("/") && (stackOperator.equals("^") || stackOperator.equals("*") || stackOperator.equals("/"))) return "low_equal";
		
		else if(tokenOperator.equals("^") && stackOperator.equals("^")) return "low_equal";
		
		else return "high";
	}
	
	/**
	 Gets the infix expression 
	 @return infixTokens
	*/
	public String getInfixExpression() {
		return infixTokens.toString();
	}

	/**
	 Gets the postfix expression 
	 @return postfixTokens
	*/
	public String getPostfixExpression() {
		return postfixTokens.toString();
	}
	
	/**
	 A public instance method used to evaluate the 
	 postfix expression using stacks	
	 @throws IllegalArgumentException if the postfixTokens is empty
	 @throws InvalidExpressionException if there is division by zero
	 @throws IllegalArgumentException if the stack is not empty after the last pop
	*/
	public double evaluate() {
		
		if(postfixTokens.isEmpty() == true) throw new IllegalArgumentException("There is no postfix to evaluate!");
		StringStack evaluateStack = new StringStack();

		for(int i=0;i<postfixTokens.size();i++){
			
			String currToken = postfixTokens.get(i);
			double answer;
			
			//if the token is an operand it is pushed on the stack
			if(!isOperator(currToken)) evaluateStack.push(currToken);
			
			//if the token is an operator, the first two operands on the stack are evaluated
			else if(isOperator(currToken)){
				
				double value1 = Double.parseDouble(evaluateStack.pop());
				double value2 = Double.parseDouble(evaluateStack.pop());
				
				if(currToken.equals("+")){
					answer = value2 + value1;
					evaluateStack.push(Double.toString(answer));
				}
				
				else if(currToken.equals("-")){
					answer = value2 - value1;
					evaluateStack.push(Double.toString(answer));
				}
				
				else if(currToken.equals("*")){
					answer = value2 * value1;
					evaluateStack.push(Double.toString(answer));
				}
				
				else if(currToken.equals("/")){
					
					if(value1 == 0) throw new InvalidExpressionException("Can not divide by zero!!!");
					answer = value2 / value1;
					evaluateStack.push(Double.toString(answer));
				}
				
				else if(currToken.equals("^")){
					
					answer = Math.pow(value2,value1);
					evaluateStack.push(Double.toString(answer));
				}
			}
			
		}
		
		//final answer is the last token of the stack
		String finalAnswer = evaluateStack.pop();
		
		//if the stack is not empty after the last pop, an exception is thrown
		if(!evaluateStack.isEmpty()) {
			throw new IllegalArgumentException("The stack is not empty at the end , error in the postfix expression");
		}
		
		return Double.parseDouble(finalAnswer);
	}
	
	public static void main(String[] args) {
		
		
		ArithExpression express = new ArithExpression("B*D+(E*C)");
		
		System.out.println("Infix Expression: "+express.getInfixExpression());
		System.out.println("Postfix Expression: "+express.getPostfixExpression());
		System.out.println();
		
		ArithExpression express2 = new ArithExpression("(55-13)/6");
		
		System.out.println("Infix Expression: "+express2.getInfixExpression());
		System.out.println("Postfix Expression: "+express2.getPostfixExpression());
		System.out.println(express2.evaluate());
		System.out.println();
		
		ArithExpression express3 = new ArithExpression("-6+8*(9/9)");
		
		System.out.println("Infix Expression: "+express3.getInfixExpression());
		System.out.println("Postfix Expression: "+express3.getPostfixExpression());
		System.out.println(express3.evaluate());
		System.out.println();
		
		/*
		ArithExpression express4 = new ArithExpression("(5+3)/0");
		
		System.out.println("Infix Expression: "+express4.getInfixExpression());
		System.out.println("Postfix Expression: "+express4.getPostfixExpression());
		System.out.println(express4.evaluate());
		System.out.println();
		*/
		
		ArithExpression express5 = new ArithExpression("3^2+9*(16/8)");
		
		System.out.println("Infix Expression: "+express5.getInfixExpression());
		System.out.println("Postfix Expression: "+express5.getPostfixExpression());
		System.out.println(express5.evaluate());
		System.out.println();
	}	
}
