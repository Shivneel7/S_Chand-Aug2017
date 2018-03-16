package textExcel;

public abstract class RealCell implements Cell {
	
	protected String value;
	
	public RealCell(String value) {
		this.value = value;
	}
	
	public String abbreviatedCellText() {
		if(value.length() > 10) {
			return value.substring(0, 10);
		}
		String temp = value;
		for(int i = value.length(); i < 10; i++) {
			temp += " ";
		}
		return temp;
	}

	public abstract String fullCellText();
	
	public abstract double getDoubleValue();

}
