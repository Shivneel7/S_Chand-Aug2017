import java.util.*;
import java.io.*;

public class HangMan {
static char[] WORD = "zebra".toCharArray();
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Console con = System.console();
		if(con != null) {
			WORD = con.readPassword("Enter the word");
		}
		int numberOfErrors = 0;
		System.out.println(getMan(numberOfErrors));
	}
	
	static String getMan(int numberOfErrors) {
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
			noose = "    ___\n   |   |\n   |   O\n   |  /|\\\n   |  / \\\n___|___";
		}
		return noose;
		
//		String noError = "    ___\n   |   |\n   |   \n   |\n   |\n___|___"; 
//		String oneError = "    ___\n   |   |\n   |   O\n   |\n   |\n___|___";
//		String twoError = "    ___\n   |   |\n   |   O\n   |   |\n   |\n___|___";
//		String threeError = "    ___\n   |   |\n   |   O\n   |  /|\n   |\n___|___";
//		String fourError = "    ___\n   |   |\n   |   O\n   |  /|\\\n   |\n___|___";
//		String fiveError = "    ___\n   |   |\n   |   O\n   |  /|\\\n      /\n___|___";
//		String sixError = "    ___\n   |   |\n   |   O\n   |  /|\\\n   |  / \\\n___|___";
	}
}
