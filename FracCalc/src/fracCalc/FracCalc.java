//Shivneel Chand
//11-8-17
//This class takes continuous user input from the console of a fractional equation 
//and prints the simplified fractional form of the equation

package fracCalc;
import java.util.*;

public class FracCalc {

    public static void main(String[] args) {
    	Scanner userInput = new Scanner(System.in);
    	while(true) {
    		String input = userInput.nextLine();
    		if(input.equals("quit")) {
    			break;
    		}
    		System.out.println(produceAnswer(input));
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
        
        String operator = parsedInput[1];
        String result = "";
        if(operator.equals("+") || operator.equals("-")) {
        	result = addSubtract(operand1, operand2, operator);
        }else if(operator.equals("*") || operator.equals("/")) {
        	result = multiplyDivide(operand1, operand2, operator);
        }else {
        	//MOVE THIS TO THE MULTIPLYDIVIDE METHOD

        }
        return result;
    }
    
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
        int[] operandParts = {wholeNumber, numerator, denominator};
        return operandParts;
    }
    
    public static String addSubtract(int[] operand1, int[] operand2, String operator) {
    	int newDenominator = operand1[2] * operand2[2];
    	int numerator1 = operand1[1] * operand2[2];
    	int numerator2 = operand2[1] * operand1[2];
    	int newNumerator = numerator1 + numerator2;
    	int newWholeNumber = operand1[0] + operand2[0];
    	if(operator.equals("-")) {
    		newNumerator = numerator1 - numerator2;
    		newWholeNumber = operand1[0] - operand2[0];
    	}
    	return newWholeNumber + "_" + newNumerator + "/" + newDenominator;
    }
    
    public static String multiplyDivide(int[] operand1, int[] operand2, String operator) {
    	int numerator1 = operand1[0] * operand1[2] + operand1[1];
    	int numerator2 = operand2[0] * operand2[2] + operand2[1];
	    if(operator.equals("/")){
    		int temp = operand2[1];
	    	operand2[1] = operand2[2];
	    	operand2[2] = temp;
	    }
    	int newNumerator = numerator1 * numerator2;
    	if(operand2[2] == 0) {
    		return newNumerator + "/" + operand2[0];
    	}
    	int newDenominator = operand1[2] * operand2[2];
    	return newNumerator + "/" + newDenominator;
    }
}
