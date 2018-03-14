package textExcel;

public class TextCell implements Cell {
	
	private String text;
	
	public TextCell(String text) {
		this.text = text;
	}
	
	public String abbreviatedCellText() {
		if(text.length() > 10) {
			return text.substring(0, 10);
		}
		String temp = text;
		for(int i = text.length(); i < 10; i++) {
			temp += " ";
		}
		return temp;
	}

	public String fullCellText() {
		return "\"" + text + "\"";
	}
	
	public void setText(String text) {
		this.text = text;
	}
}
