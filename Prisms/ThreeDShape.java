//Shivneel Chand
//2-21-18

public abstract class ThreeDShape {
	private double volume;
	private double surfaceArea;

	public ThreeDShape(){
		this.volume = calcVolume();
		this.surfaceArea = calcSA();
	}

	public abstract double calcVolume();
	public abstract double calcSA();

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	public double getSurfaceArea() {
		return surfaceArea;
	}

	public void setSurfaceArea(double surfaceArea) {
		this.surfaceArea = surfaceArea;
	}
	
}