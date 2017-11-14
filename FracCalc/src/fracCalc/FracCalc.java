//Shivneel Chand
//11-8-17
//This class takes continuous user input from the console of a fractional equation 
//and prints the simplified fractional form of the equation

package fracCalc;
import java.util.*;

public class FracCalc {

    public static void main(String[] args) {
    	Scanner userInput = new Scanner(System.in);
    	do {
    		String input = userInput.nextLine();
    		System.out.println(produceAnswer(input));
    	}while(!(userInput.nextLine().equals("quit")));
    	
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
        //Fraction I could use to test: 7_3/4 + 6_2/9
        String wholeNumber1 = (parsedInput[0].split("_")[0]);
        String wholeNumber2 = (parsedInput[2].split("_")[0]);
        String numerator1 = (parsedInput[0].split("_")[1].split("/")[0]);
        String numerator2 = (parsedInput[2].split("_")[1].split("/")[0]);
        String denominator1 = (parsedInput[0].split("/")[1]);
        String denominator2 = (parsedInput[2].split("/")[1]);
        return "whole:" + wholeNumber2 + " numerator:" + numerator2 + " denominator:" + denominator2;
    }
}
