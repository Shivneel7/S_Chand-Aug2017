package polymorphism;

public abstract class B extends A {
	public void firstMethod() { 
		System.out.println("FIRST"); 
		thirdMethod();
	} 
	public abstract void thirdMethod(); 

}
