//Shivneel Chand
//10-28-17
import java.util.Arrays;

public class Split {

	public static void main(String[] args) {
		// Your task Part 0
//		System.out.println(Arrays.toString(("I like apples!".split(" "))));
//		System.out.println(Arrays.toString("I reallyreally likeapples".split("really")));
//		System.out.println(Arrays.toString("I reallyreally likeapples".split("really")));
//		System.out.println(Arrays.toString("I reallyreally likeapples".split("really")));
//		System.out.println(Arrays.toString("bread fish bread a bread".split("bread")));
		
		
		//Your task Part 1:
		/*Write a method that take in a string like "applespineapplesbreadlettustomatobaconmayohambreadcheese" describing a sandwich
		* use String.split to split up the sandwich by the word "bread" and return what's in the middle of the sandwich and ignores what's on the outside
		* What if it's a fancy sandwich with multiple pieces of bread?
		*/
		System.out.println(getFilling("cheese toothpuck bread lettus tomato bacon mayo ham bread cheese bread kajsdf bread"));
		System.out.println(getFilling("teeth bread lettus tomato bacon mayo ham bread cheese bread kajsdf"));
		System.out.println(getFilling("crab bread lettus tomato bbreadacon mayo ham bread cheese bread kajsdf bread"));
		System.out.println(getFilling("crabbreadlettustomatobbreadaconmayohambreadcheesebreadkajsdfbread"));
		System.out.println(getFilling("breadlettusomatobbreadaconmayohambreadsausagebreadcheese"));
		System.out.println(getFilling("applespineapplesbreadlettustomatobaconmayohambreadcheese"));
		System.out.println(getFilling("bread"));
		System.out.println(getFilling("bread bread"));
		System.out.println(getFilling("breadbread"));
		//Your task Part 2:
		/*Write a method that take in a string like "apples pineapples bread lettus tomato bacon mayo ham bread cheese" describing a sandwich
		* use String.split to split up the sandwich at the spaces, " ", and return what's in the middle of the sandwich and ignores what's on the outside
		* Again, what if it's a fancy sandwich with multiple pieces of bread?
		*/
		System.out.println("Part 2");
		System.out.println(getFillingPart2("cheese toothpuck bread lettus tomato bacon mayo ham bread cheese bread kajsdf bread"));
		System.out.println(getFillingPart2("teeth bread lettus tomato bacon mayo ham bread cheese bread kajsd bunch of stuff outside"));
		System.out.println(getFillingPart2("crab bread lettus tomato bbreadacon mayo ham bread cheese bread still inside the sandwich bread"));
	}
	//part 1
	public static String getFilling(String sandwich) {
		if(sandwich.indexOf("bread")<0||sandwich.equals("bread")) {
			return "not a sandwich";
		}
		int endsWithBread = 1;
		String[] sandwichArray = sandwich.split("bread");
		String filling = "";
		if(sandwich.substring(sandwich.length()-5).equals("bread")){
			endsWithBread = 0;
		}
		for(int i = 1; i < sandwichArray.length-endsWithBread;i++) {
			filling += sandwichArray[i];
		}
		if(filling.equals("")||filling.equals(" ")) {
			return "not a sandwich";
		}
		return filling;
	}
	//part 2
	public static String getFillingPart2(String sandwich) {
		String[] sandwichArray = sandwich.split(" ");
		String spacelessSandwich = "";
		for(int i = 0; i < sandwichArray.length;i++){
			spacelessSandwich += sandwichArray[i];
		}
		return getFilling(spacelessSandwich);
	}
	

}
