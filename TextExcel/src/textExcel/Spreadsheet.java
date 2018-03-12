//Shivneel Chand 
//3-9-18

package textExcel;

public class Spreadsheet implements Grid {
	
	Cell[][] cells;
	
	public Spreadsheet() {
		cells = new Cell[getRows()][getCols()];
	}
	
	public String processCommand(String command) {
		return "";
	}

	public int getRows() {
		return 20;
	}

	public int getCols(){
		return 12;
	}

	public Cell getCell(Location loc){
		return null;
	}

	public String getGridText() {
		return null;
	}

}
