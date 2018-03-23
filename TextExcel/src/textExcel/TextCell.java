//Shivneel Chand 
//3-9-18
package textExcel;

public class TextCell implements Cell, Comparable<TextCell> {
	
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

	public int compareTo(TextCell tc) {
		if(fullCellText().charAt(1) > tc.fullCellText().charAt(1)) {
			return 1;
		}else if(tc.fullCellText().charAt(1) == fullCellText().charAt(1)) {
			return 0;
		}else {
			return -1;
		}
	}
}
