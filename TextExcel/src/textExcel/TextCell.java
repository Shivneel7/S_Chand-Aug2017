//Shivneel Chand 
//3-9-18
package textExcel;

public class TextCell implements Cell {
	
	private String text;
	
	public TextCell(String text) {
		this.text = text;
	}
	
	public String abbreviatedCellText() {
		String temp = text;
		for(int i = text.length(); i < 10; i++) {
			temp += " ";
		}
		return temp.substring(0,10);
	}

	public String fullCellText() {
		return "\"" + text + "\"";
	}
}
