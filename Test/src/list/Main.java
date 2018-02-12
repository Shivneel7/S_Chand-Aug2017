package list;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {
	
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("one");
		list.add("two");
		list.get(0);
		
		Iterator<String> i = list.iterator();
		System.out.println(i.next());
		System.out.println(i.next());
	}
}
