import java.util.*;
import java.io.*;

public class HangMan {
	
	static char[] WORD = "ae".toCharArray();
	static String incorrectGuesses = "";
	static int numberOfErrors = 0;
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Console con = System.console();
		
		char[] word = new char[WORD.length];
		for(int i = 0; i<WORD.length; i++) {
			word[i] = '_';
		}
		
		if(con != null) {
			WORD = con.readPassword("Enter the word");
		}
		
		do {
			System.out.println(getMan());
			System.out.println(incorrectGuesses);
			System.out.println("Player one, guess a letter");
			
			char guess = input.next().toCharArray()[0];
			
			if(checkGuess(guess, word)) {
				numberOfErrors++;
			}
			if(checkEquality(word)) {
				System.out.println("GOOD JOB!\nYOU WON!\nEZ GAME.\nPLAYER ONE GET REKT.");
				break;
			}

			System.out.println(Arrays.toString(word));
		}while(numberOfErrors < 6);
		if(numberOfErrors == 6) {
			System.out.println(getMan());
		}
		
	}
	
	public static boolean checkGuess(char guess, char[] word) {
		boolean error = true;
		for(int i=0; i < WORD.length; i++) {
			if(WORD[i] == guess) {
				word[i] = guess;
				error = false;
			}
			
		}
		if(error) {
			incorrectGuesses += " " + guess;
		}
		return error;
	}
	
	public static boolean checkEquality(char[] word){
		boolean isEqual = true;
		for(int i=0; i < WORD.length; i++) {
			if(WORD[i] != word[i]) {
				isEqual = false;
			}
		}
		return isEqual;
	}
	static String getMan() {
		String noose = "    ___\n   |   |\n   |   \n   |\n   |\n___|___"; 
		if(numberOfErrors == 1) {
			noose = "    ___\n   |   |\n   |   O\n   |\n   |\n___|___";
		}else if(numberOfErrors == 2) {
			noose = "    ___\n   |   |\n   |   O\n   |   |\n   |\n___|___";
		}else if(numberOfErrors == 3) {
			noose = "    ___\n   |   |\n   |   O\n   |  /|\n   |\n___|___";
		}else if(numberOfErrors == 4) {
			noose = "    ___\n   |   |\n   |   O\n   |  /|\\\n   |\n___|___";
		}else if(numberOfErrors == 5) {
			noose = "    ___\n   |   |\n   |   O\n   |  /|\\\n      /\n___|___";
		}else if(numberOfErrors == 6) {
			noose = "    ___\n   |   |\n   |   O\n   |  /|\\\n   |  / \\\n___|___\n You Lost :(\n The word was: " + Arrays.toString(WORD);
		}
		return noose;
		//the variants of the man.
//		String noError = "    ___\n   |   |\n   |   \n   |\n   |\n___|___"; 
//		String oneError = "    ___\n   |   |\n   |   O\n   |\n   |\n___|___";
//		String twoError = "    ___\n   |   |\n   |   O\n   |   |\n   |\n___|___";
//		String threeError = "    ___\n   |   |\n   |   O\n   |  /|\n   |\n___|___";
//		String fourError = "    ___\n   |   |\n   |   O\n   |  /|\\\n   |\n___|___";
//		String fiveError = "    ___\n   |   |\n   |   O\n   |  /|\\\n      /\n___|___";
//		String sixError = "    ___\n   |   |\n   |   O\n   |  /|\\\n   |  / \\\n___|___";
	}
	
	
}
