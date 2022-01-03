package nitin.collections.a_list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Family{
	String name;
	Family(String name1){
		name = name1;
	}
}
public class ListTest {
	public static void main(String[] args) {
		List<Family> myFamily = new ArrayList<Family>();
		myFamily.add(new Family("papa"));
		myFamily.add(new Family("mummy"));
		
		Family amma = new Family("Amma");
		myFamily.add(amma);
		
		myFamily.add(new Family("nidhi"));
		myFamily.add(new Family("nishu"));
		myFamily.add(new Family("varun"));
		
		//make an iterator to traverse through the a_list
		
		Iterator<Family> i = myFamily.iterator();
		while(i.hasNext()){
			Family f = i.next();
			System.out.print(f.name+" ");
		}
		System.out.println("\nIndex of Amma is = "+myFamily.indexOf(amma));
		System.out.println("Number of members = "+myFamily.size());
		System.out.println("Member at index 5 HashCode = "+myFamily.get(5));
		System.out.println("Member at index 5 = "+myFamily.get(5).name);//SEE THE DIFFERENCE IN THE TWO LINES
		
		myFamily.remove(2);
		
		Object [] fmly = myFamily.toArray(); //created an Object of type Family
		System.out.print("Members from fmly Array\n");
		for(Object o : fmly){
			Family f = (Family)o; //but has to cast to compare 
			System.out.print(f.name + " ");
		}

	}

}
