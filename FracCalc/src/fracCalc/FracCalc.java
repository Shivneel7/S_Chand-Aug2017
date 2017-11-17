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
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //        
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    public static String produceAnswer(String input){
        String[] parsedInput = input.split(" ");
        int[] operand1 = splitOperand(parsedInput[0]);
        int[] operand2 = splitOperand(parsedInput[2]);
        
        String result = "";     
        String operator = parsedInput[1];
        
        if(operator.equals("+") || operator.equals("-")) {
        	result = addSubtract(operand1, operand2, operator);
        	
        }else if(operator.equals("*") || operator.equals("/")) {
        	result = multiplyDivide(operand1, operand2, operator);
        }

        result = simplify(splitOperand(result));

        return result;
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
        numerator = wholeNumber * denominator + numerator;
        int[] operandParts = {numerator, denominator};
        return operandParts;
    }
//This method returns the sum or the difference of the two operands depending on the operator passed to the method
    public static String addSubtract(int[] operand1, int[] operand2, String operator) {
    	int newDenominator = operand1[1] * operand2[1];
    	int numerator1 = operand1[0] * operand2[1];
    	int numerator2 = operand2[0] * operand1[1];
    	int newNumerator = numerator1 + numerator2;

    	if(operator.equals("-")) {
    		newNumerator = numerator1 - numerator2;
    	}

    	return newNumerator + "/" + newDenominator;
    }
//this method returns the product or quotient of the two operands depending on the operator passed to the method
    public static String multiplyDivide(int[] operand1, int[] operand2, String operator) {
	    if(operator.equals("/")) {
    		if(operand2[0] < 0) {//this is too make sure any negative signs stay with the numerator
    			operand2[1] *= -1;
    			operand2[0] *= -1;
    		}
	    	int temp = operand2[0]; //reciprocates the second operand
	    	operand2[0] = operand2[1];
	    	operand2[1] = temp;
	    }
    	int newNumerator = operand1[0] * operand2[0];
    	if(operand2[1] == 0) {
    		return newNumerator + "/" + operand2[0];
    	}
    	int newDenominator = operand1[1] * operand2[1];
    	return newNumerator + "/" + newDenominator;
    }
    
//Simplifies the result.
    public static String simplify(int[] frac) {
    	int wholeNumber = frac[0]/frac[1];
    	int numerator = frac[0] % frac[1];
    	int denominator = frac[1];
    	if(wholeNumber != 0) { // if the number is a fraction with no whole number, then make the numerator...
    		numerator = Math.abs(numerator);//positive since the whole number contains the negative sign.
    	}
		//find the gcf then divide numerator and denominator by it to reduce the fraction to its simplest form.
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
			return ""+wholeNumber;
		}
		return wholeNumber + "_" + numerator + "/" + denominator;
    }
//takes two integers and returns the greatest commong factor of the integers.
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
