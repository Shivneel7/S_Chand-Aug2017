//Shivneel Chand 
//3-9-18
package textExcel;

public class FormulaCell extends RealCell{

	private Spreadsheet ss;
	
	public FormulaCell(String value, Spreadsheet ss) {
		super(value);
		this.ss = ss;
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
		double answer = 0;
		if(parsedValues[0].equals("AVG")) {
			
		}else if(parsedValues[0].equals("SUM")) {
			
		}else {
		if(Character.isDigit(parsedValues[0].charAt(0)) || parsedValues[0].charAt(0) == '-') {
			answer = Double.parseDouble(parsedValues[0]);
		}else {
			answer = ((RealCell)ss.getCell(new SpreadsheetLocation(parsedValues[0]))).getDoubleValue();
		}
		
		for(int i = 2; i < parsedValues.length; i +=2) {
			String operator = parsedValues[i-1];
			double operand = 0;
			
			if(Character.isDigit(parsedValues[i].charAt(0)) || parsedValues[i].charAt(0) == '-') {
				operand = Double.parseDouble(parsedValues[i]);
			}else {
				operand = ((RealCell)ss.getCell(new SpreadsheetLocation(parsedValues[i]))).getDoubleValue();
			}
			
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
		}
		return answer;
	}
}
