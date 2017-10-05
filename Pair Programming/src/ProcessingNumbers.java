//Programmer 1 Shivneel Chand and Programmer 2 James Lee partner code.
import java.util.*;
public class ProcessingNumbers {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		System.out.println("How many terms are you going to list?");
		double numberOfTerms = userInput.nextDouble();
		double maxEven = -1;//Later, I test if maxEven == -1 and print "No even numbers" if true.
		double max = 0;
		double min = 0;
		double evenSum = 0;
		boolean isFirstNumber = true;
		boolean isFirstEvenNumber = true;
		for(int i = 1; i <= numberOfTerms; i++) {
			System.out.println("Enter number " + i + ": ");
			double num = userInput.nextDouble();
			if(isFirstNumber) {
				min = num;
				max= num;
				isFirstNumber = false;
			}
			if(num > max) {
				max = num;
			}
			if(num < min) {
				min = num;
			}
			if(num %2 == 0) {
				if(isFirstEvenNumber) {//only executes for the first even number
					maxEven = num;
					isFirstEvenNumber= false;
				}else if(num > maxEven) {
					maxEven = num;
				}
			evenSum += num;
			}
		}
		System.out.println("The lowest number is: " + min + " The greatest number is: " + max);
		if(maxEven == -1) {
			System.out.println("Your list contained no even numbers.");
		}else {
			System.out.println("The sum of the even numbers is: " + evenSum);
			System.out.println("The largest even number is: " + maxEven);
		}
	}
}