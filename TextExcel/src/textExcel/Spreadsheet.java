//Shivneel Chand 
//3-9-18

package textExcel;

public class Spreadsheet implements Grid {

	private Cell[][] cells;

	public Spreadsheet() {
		cells = new Cell[getRows()][getCols()];
		for (int i = 0; i < getRows(); i++) {
			for (int j = 0; j < getCols(); j++) {
				cells[i][j] = new EmptyCell();
			}
		}
	}

	public String processCommand(String command) {

		if (command.indexOf('=') > 0) {
			String[] arr = command.split(" = ", 2);
			SpreadsheetLocation l = new SpreadsheetLocation(arr[0]);
			cells[l.getRow()][l.getCol()] = new TextCell(arr[1].replace("\"", ""));
			return getGridText();

		} else if (command.length() == 2 || command.length() == 3) {
			return getCell(new SpreadsheetLocation(command)).fullCellText();
		}

		command = command.toUpperCase();
		if (command.equals("CLEAR")) {
			for (int i = 0; i < getRows(); i++) {
				for (int j = 0; j < getCols(); j++) {
					cells[i][j] = new EmptyCell();
				}
			}
			return getGridText();
		} else if (command.startsWith("CLEAR ")) {
			SpreadsheetLocation l = new SpreadsheetLocation(command.substring(6));
			cells[l.getRow()][l.getCol()] = new EmptyCell();
			return getGridText();
		}
		return "";
	}

	public int getRows() {
		return 20;
	}

	public int getCols() {
		return 12;
	}

	public Cell getCell(Location loc) {
		return cells[loc.getRow()][loc.getCol()];
	}

	public String getGridText() {
		String fullSheet = "   ";
		for (int i = 0; i < getCols(); i++) {
			fullSheet += ("|" + (char) (i + 'A') + "         ");
		}
		fullSheet += "|\n";

		for (int i = 1; i <= getRows(); i++) {
			if (i < 10) {
				fullSheet += i + "  ";// for two digit numbers
			} else {
				fullSheet += i + " ";// for one digit numbers
			}

			for (int j = 0; j < getCols(); j++) {
				fullSheet += "|" + cells[i - 1][j].abbreviatedCellText();
			}
			fullSheet += "|\n";
		}
		return fullSheet;
	}

}
