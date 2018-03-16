package textExcel;

public class FormulaCell extends RealCell{

	public FormulaCell(String value) {
		super(value);
	}
	
	public String abbreviatedCellText() {
		return "TODO";
	}

	public String fullCellText() {
		return null;
	}

	public double getDoubleValue() {
		return 0;
	}

}
