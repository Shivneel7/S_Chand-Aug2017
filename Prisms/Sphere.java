//Shivneel Chand
//2-21-18
public class Sphere extends ThreeDShape {
	
	private double radius;
	
	public Sphere(double rad) {
		super();
		this.radius = rad;
	}
	
	public double calcVolume() {
		return (Math.PI * radius * radius * radius * 4) / 3;
	}

	public double calcSA() {
		return Math.PI * radius * radius * 4;
	}

}
