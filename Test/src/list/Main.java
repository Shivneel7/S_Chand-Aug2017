package list;

import java.util.ArrayList;
import java.util.Iterator;

import polymorphism.Animal;
import polymorphism.B;
import polymorphism.C;
import polymorphism.Pig;

public class Main {
	
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(null);
		list.get(0);
		
		Iterator<Integer> i = list.iterator();
		System.out.println(i.next());
		System.out.println(i.next());
		
		Pig p = new Pig();
		((Animal) p).method1();
		
		C c = new C(); 
		c.firstMethod(); 
		c.secondMethod(); 
		c.thirdMethod();
		
		B b = new C();
		b.thirdMethod();
		
	}
}
