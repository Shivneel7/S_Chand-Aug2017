package polymorphism;

public abstract class A {
	public abstract void firstMethod(); 
	
	public void secondMethod() { 
		System.out.println("SECOND"); 
		firstMethod(); 
	}

}
