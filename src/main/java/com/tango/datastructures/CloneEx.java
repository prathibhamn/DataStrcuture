package com.tango.datastructures;

//A Java program to demonstrate shallow copy
//using clone()
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CloneEx {

	public static void main(String args[]) throws CloneNotSupportedException {
		
		 Integer ar[] = {4, 6, 1, 8, 3, 9, 7, 4, 2};
		 
	        // Creates a wrapper list over ar[]
	        List<Integer> l1 = Arrays.asList(ar);
	        l1.set(1, 2);
	        //l1.repl
	        System.out.println(ar.toString());
	        List<Integer>  l2= new ArrayList<>() ;
	        l2.add(1);
	        l2.add(2);
	        l2.add(3);
	        l2.add(4);
	        l2.add(2,5);
		Test2 t1 = new Test2();
		t1.a = 10;
		t1.b = 20;
		t1.c.x = 30;
		t1.c.y = 40;

		Test2 t2 = (Test2) t1.clone();

		// Creating a copy of object t1 and passing
		// it to t2
		t2.a = 100;

		// Change in primitive type of t2 will not
		// be reflected in t1 field
		t2.c.x = 300;

		// Change in object type field will be
		// reflected in both t2 and t1(shallow copy)
		System.out.println(t1.a + " " + t1.b + " " + t1.c.x + " " + t1.c.y);
		System.out.println(t2.a + " " + t2.b + " " + t2.c.x + " " + t2.c.y);
	}

}

// An object reference of this class is
// contained by Test2
class Test {
	int x, y;
}

// Contains a reference of Test and implements
// clone with shallow copy.
class Test2 implements Cloneable {
	int a;
	int b;
	Test c = new Test();

	public Object clone() throws CloneNotSupportedException {
		
		return super.clone();
	}
}
