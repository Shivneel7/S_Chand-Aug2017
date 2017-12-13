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
	
	public Fraction() {
		this(0,0,1);
	}
	
	public Fraction(int numerator, int denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}
	
	public Fraction(int numerator,  int denominator, int wholeNumber) {
		this.numerator = numerator;
		this.wholeNumber = wholeNumber;
		this.denominator = denominator;
	}
	
	public Fraction add(Fraction operand2) {//also subtracts by changing sign in client code
		Fraction result = new Fraction();
		
		return result;
	}
	
	public Fraction multiply(Fraction operand2) {//also divides by reciprocating in the client code
		this.toImproper();
		operand2.toImproper();
		Fraction result = new Fraction(this.numerator * operand2.getNumerator(), this.denominator * operand2.getDenominator());
		return result;
	}
	
	public void toImproper() {
		numerator = wholeNumber * denominator + numerator;
		wholeNumber = 0; 
	}
	
	public void toMixedNumber() {
		wholeNumber = numerator/denominator;
    	numerator = numerator % denominator;
	}
		
	public void reciprocate() {//Used for division
    	if(numerator < 0) {	//<--- this is to make sure any negative signs stay with
			denominator *= -1;	//the numerator which helps the simplification process
			numerator *= -1;
		}
		int temp = numerator;
		numerator = denominator;
		denominator = temp;
	}
	
	public boolean isDivideByZero() {
		if(denominator == 0) 
			return true;
		else 
			return false;
	}
	
	public int getNumerator() {
		return numerator;
	}

	public void setNumerator(int numerator) {
		this.numerator = numerator;
	}

	public int getWholeNumber() {
		return wholeNumber;
	}

	public void setWholeNumber(int wholeNumber) {
		this.wholeNumber = wholeNumber;
	}

	public int getDenominator() {
		return denominator;
	}

	public void setDenominator(int denominator) {
		this.denominator = denominator;
	}
	
	public String toString() {
		toMixedNumber();
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
}