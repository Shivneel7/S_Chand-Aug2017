package fracCalc;

public class Fraction {
	
	private int numerator = 0;
	private int wholeNumber = 0;
	private int denominator = 1;
	
	public Fraction(String frac) {
		if(frac.contains("/") && frac.contains("_")) {
        	numerator = Integer.parseInt(frac.split("_")[1].split("/")[0]);
        	denominator = Integer.parseInt(frac.split("/")[1]);
        	wholeNumber = Integer.parseInt(frac.split("_")[0]);
        }else if(frac.contains("/") && !(frac.contains("_"))){
        	numerator = Integer.parseInt(frac.split("/")[0]);
        	denominator = Integer.parseInt(frac.split("/")[1]);
        }else{
        	wholeNumber = Integer.parseInt(frac);
        }
	}

	public String toString() {
		return "whole:"+ wholeNumber + " numerator:" + numerator + " denominator:" + denominator;
	}
}