//Shivneel Chand
//11-8-17
//This class takes continuous user input from the console of a fractional equation 
//and prints the simplified fractional form of the equation

package fracCalc;
import java.util.*;

public class FracCalc {

    public static void main(String[] args) {
    	Scanner userInput = new Scanner(System.in);
    	while(true) {//Accepts strings from the user until the user types "quit"
    		System.out.println("Type a fractional expression to evaluate it or type \"quit\" to terminate the program.");
    		String input = userInput.nextLine();
    		if(input.equals("quit")) {
    			break;
    		}
    		System.out.println(produceAnswer(input));
    		
    		//The line underneath tests my findGCF method
    		//System.out.println(findGCF(Integer.parseInt(input.split(" ")[0]), Integer.parseInt(input.split(" ")[1])));
    	}
    }
    
    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //        
    // The method returns the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    public static String produceAnswer(String input){
    	String[] parsedInput = input.split(" ");
    	//if the input has an even number of parts, then the input was not in the proper format.
    	if(parsedInput.length % 2 == 0 || parsedInput.length == 1) {
    		return "ERROR: Please check you expression and try again.";
    	}
    	String resultString = "";
    	
    	for(int i = 2; i < parsedInput.length; i += 2) { 		
    		int[] operand1 = splitOperand(parsedInput[0]);
	        int[] operand2 = splitOperand(parsedInput[i]);

	        String operator = parsedInput[i-1];
	        
	        int[] unsimplifiedResultArray = new int[2];
	        if(operand1[1] == 0) {//checks if denominator of any operands is 0, so we don't try and divide by 0.
	        	return "ERROR: Please stop trying to divide by 0.";
	        }
	        if(operator.equals("+") || operator.equals("-")) {
	        	unsimplifiedResultArray = addSubtract(operand1, operand2, operator);
	        
	        }else if(operator.equals("*")) {
	        	unsimplifiedResultArray = multiplyDivide(operand1, operand2, operator);
	        
	        }else if(operator.equals("/")){
	        	if(operand2[1] == 0 || operand2[0] == 0) {//Makes sure we do not divide by 0.
	        		return "ERROR: Please stop trying to divide by 0.";
	        	}
	        	unsimplifiedResultArray = multiplyDivide(operand1, operand2, operator);
	        }else {
	        	return "ERROR: Please try a different operator.";
	        }

	        resultString = simplify(unsimplifiedResultArray);
	        parsedInput[0] = resultString;	//by saving this in the 0th index of the original array,
	        								//we can always make parsedInput[0] the first operand 
	        								//and easily handle multiple operands
    	}
        return resultString;
    }

    //Takes an operand and returns the whole number, numerator, and denominator of the operand in an array of length 3.
    public static int[] splitOperand(String operand) {
    	int numerator = 0;
        int denominator = 1;
        int wholeNumber = 0;
   	 	
        if(operand.contains("/") && operand.contains("_")) {
        	numerator = Integer.parseInt(operand.split("_")[1].split("/")[0]);
        	denominator = Integer.parseInt(operand.split("/")[1]);
        	wholeNumber = Integer.parseInt(operand.split("_")[0]);
        }else if(operand.contains("/") && !(operand.contains("_"))){
        	numerator = Integer.parseInt(operand.split("/")[0]);
        	denominator = Integer.parseInt(operand.split("/")[1]);
        }else{
        	wholeNumber = Integer.parseInt(operand);
        }
        if(wholeNumber<0) {
        	numerator *= -1;
        }
        numerator = wholeNumber * denominator + numerator; //This turns all mixed fractions into improper fractions.
        int[] operandParts = {numerator, denominator};
        return operandParts;
    }
    
//This method returns the sum or the difference of the two operands depending on the operator passed to the method
    public static int[] addSubtract(int[] operand1, int[] operand2, String operator) {
    	int newDenominator = operand1[1] * operand2[1];
    	int numerator1 = operand1[0] * operand2[1];
    	int numerator2 = operand2[0] * operand1[1];
    	//Addition
    	int newNumerator = numerator1 + numerator2;
    	//Subtraction
    	if(operator.equals("-")) {
    		newNumerator = numerator1 - numerator2;
    	}
    	int[] result = {newNumerator, newDenominator};
    	return result;
    }
    
//returns the product or quotient of the two operands depending on the operator passed to the method
    public static int[] multiplyDivide(int[] operand1, int[] operand2, String operator) {
    	if(operator.equals("/")) {//Division part
	    	if(operand2[0] < 0) {	//<--- this is to make sure any negative signs stay with
    			operand2[1] *= -1;	//the numerator which helps the simplification process
    			operand2[0] *= -1;
    		}
	    	int temp = operand2[0]; //Reciprocates the second operand
	    	operand2[0] = operand2[1];
	    	operand2[1] = temp;
	    }
	    //Multiplication
    	int newNumerator = operand1[0] * operand2[0];
    	int newDenominator = operand1[1] * operand2[1];
    	int[] result = {newNumerator, newDenominator};
    	return result;
    }
    
//Simplifies the result. Takes an array with the numerator and denominator at index 0 and 1 respectively.
    public static String simplify(int[] frac) {
    	int wholeNumber = frac[0]/frac[1];
    	int numerator = frac[0] % frac[1];
    	int denominator = frac[1];
    	if(wholeNumber != 0) { // if the number is a fraction with no whole number, then make the numerator...
    		numerator = Math.abs(numerator);//positive since the whole number contains the negative sign.
    	}
		//finds the gcf then divide numerator and denominator by it to reduce the fraction to its simplest form.
    	int gcf = findGCF(numerator, denominator);
    	numerator /= gcf;
		denominator /= gcf;
		if(wholeNumber == 0) {
			if(numerator == 0) {
				return "0";
			}
			return numerator + "/" + denominator;
		}
		if(numerator == 0) {
			return "" + wholeNumber;
		}
		return wholeNumber + "_" + numerator + "/" + denominator;
    }
    
//takes two integers and returns the greatest common factor of the integers.
    public static int findGCF(int num1, int num2) {
    	num1 = Math.abs(num1);
    	num2 = Math.abs(num2);
    	for(int i = num1; i > 1; i--) {
    		if(num1 % i == 0 && num2 % i == 0) {
    			return i;
    		}
    	}
    	return 1;
    }
}

