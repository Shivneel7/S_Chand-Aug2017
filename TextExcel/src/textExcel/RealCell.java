//Shivneel Chand 
//3-9-18
package textExcel;

public abstract class RealCell implements Cell, Comparable<RealCell> {
	
	protected String value;
	
	public RealCell(String value) {
		this.value = value;
	}
	
	public abstract double getDoubleValue();
	
	public int compareTo(RealCell o) {
		if(this.getDoubleValue() > o.getDoubleValue()) {
			return 1;
		}else if(this.getDoubleValue() == o.getDoubleValue()) {
			return 0;
		}else {
			return -1;
		}
	}
}
