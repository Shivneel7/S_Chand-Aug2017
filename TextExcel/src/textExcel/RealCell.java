//Shivneel Chand 
//3-9-18
package textExcel;

public abstract class RealCell implements Cell {
	
	protected String value;
	
	public RealCell(String value) {
		this.value = value;
	}
	
	public abstract double getDoubleValue();
}
