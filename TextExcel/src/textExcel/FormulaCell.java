//Shivneel Chand 
//3-9-18
package textExcel;

public class FormulaCell extends RealCell {

	private Spreadsheet ss;

	public FormulaCell(String value, Spreadsheet ss) {
		super(value);
		this.ss = ss;
	}

	public String abbreviatedCellText() {
		String temp = "" + getDoubleValue();
		for (int i = temp.length(); i < 10; i++) {
			temp += " ";
		}
		return temp.substring(0, 10);
	}

	public String fullCellText() {
		return value;
	}

	public double getDoubleValue() {
		String temp = value.replace("( ", "").toUpperCase();
		String[] parsedValues = temp.split(" ");

		double answer = 0;

		if (parsedValues[0].equals("AVG")) {// Average
			answer = avg(parsedValues[1]);

		} else if (parsedValues[0].equals("SUM")) {// Addition
			answer = sum(parsedValues[1]);

		} else {
			// Normal Formula Cell with doubles and cells
			answer = stringToDouble(parsedValues[0]);

			for (int i = 2; i < parsedValues.length; i += 2) {
				String operator = parsedValues[i - 1];
				double operand = 0;

				operand = stringToDouble(parsedValues[i]);

				if (operator.equals("+")) {
					answer += operand;
				} else if (operator.equals("-")) {
					answer -= operand;
				} else if (operator.equals("*")) {
					answer *= operand;
				} else if (operator.equals("/")) {
					answer /= operand;
				}
			}
		}
		return answer;
	}

	/**
	 * 
	 * @param s
	 *            - String that will turn into a double
	 * @return The double value either from a Cell, or from parsing the String
	 */
	public double stringToDouble(String s) {
		double result;
		if (Character.isDigit(s.charAt(0)) || s.charAt(0) == '-') {
			result = Double.parseDouble(s);
		} else {
			result = ((RealCell) ss.getCell(new SpreadsheetLocation(s))).getDoubleValue();
		}
		return result;
	}

	public double sum(String cellRange) {
		int index = cellRange.indexOf('-');

		SpreadsheetLocation firstCell = new SpreadsheetLocation(cellRange.substring(0, index));
		SpreadsheetLocation secondCell = new SpreadsheetLocation(cellRange.substring(index + 1, cellRange.length()));

		double sum = 0;

		for (int row = firstCell.getRow(); row <= secondCell.getRow(); row++) {
			for (int col = firstCell.getCol(); col <= secondCell.getCol(); col++) {
				sum += ((RealCell) ss.getCell(row, col)).getDoubleValue();
			}
		}

		return sum;
	}

	public double avg(String cellRange) {
		double sum = sum(cellRange);
		
		int index = cellRange.indexOf('-');
		SpreadsheetLocation firstCell = new SpreadsheetLocation(cellRange.substring(0, index));
		SpreadsheetLocation secondCell = new SpreadsheetLocation(cellRange.substring(index + 1, cellRange.length()));
		
		int numCells = 0;
		for (int row = firstCell.getRow(); row <= secondCell.getRow(); row++) {
			for (int col = firstCell.getCol(); col <= secondCell.getCol(); col++) {
				numCells++;
			}
		}

		return sum/numCells;
	}
}
