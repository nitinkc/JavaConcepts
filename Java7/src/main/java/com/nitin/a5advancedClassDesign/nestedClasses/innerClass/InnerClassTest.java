package com.nitin.a5advancedClassDesign.nestedClasses.innerClass;

public class InnerClassTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyOuter mo = new MyOuter();
		MyOuter.MyInner inner = mo.new MyInner();
		inner.seeOuter();

	}

}

class MyOuter{
	private final int x = 56;
	
	class MyInner{
		public void seeOuter(){
			System.out.println("Outer x is " + x);
		}
	}
}


