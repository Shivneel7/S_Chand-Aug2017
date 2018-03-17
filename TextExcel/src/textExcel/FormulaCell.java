//Shivneel Chand 
//3-9-18
package textExcel;

public class FormulaCell extends RealCell{

	public FormulaCell(String value) {
		super(value);
	}
	
	public String abbreviatedCellText() {
		String temp = "" + getDoubleValue();
		for(int i = temp.length(); i < 10; i++) {
			temp += " ";
		}
		return temp.substring(0, 10);
	}

	public String fullCellText() {
		return value;
	}

	public double getDoubleValue() {
		String temp = value.replace("( ", "");
		String[] parsedValues = temp.split(" ");
		double answer = Double.parseDouble(parsedValues[0]);
		
		for(int i = 2; i < parsedValues.length; i +=2) {
			String operator = parsedValues[i-1];
			double operand = Double.parseDouble(parsedValues[i]);
			if(operator.equals("+")) {
				answer += operand;
			}else if(operator.equals("-")) {
				answer -= operand;
			}else if(operator.equals("*")) {
				answer *= operand;
			}else if(operator.equals("/")) {
				answer /= operand;
			}
		}
		return answer;
	}
}
