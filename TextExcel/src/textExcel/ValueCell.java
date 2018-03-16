package textExcel;

public class ValueCell extends RealCell {
	
	public ValueCell(String value) {
		super(value);
	}
	
	public String fullCellText() {
		return ""+getDoubleValue();
	}

	public double getDoubleValue() {
		return Double.parseDouble(value);
	}

}
