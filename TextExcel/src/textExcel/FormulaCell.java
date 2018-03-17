//Shivneel Chand 
//3-9-18
package textExcel;

public class FormulaCell extends RealCell{

	public FormulaCell(String value) {
		super(value);
	}
	
	public String abbreviatedCellText() {
		return "TODO      ";
	}

	public String fullCellText() {
		return "TODO";
	}

	public double getDoubleValue() {
		return 0;
	}

}
