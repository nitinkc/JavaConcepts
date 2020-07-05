package com.nitin.a10collections;

public class EqualsTest2 {

	public static void main(String[] args) {
		Friend leena = new Friend("Leena","Delhi",24);
		Friend leenaJacob = new Friend("Leena","Delhi",24); //Another object of type Friend. 
		Friend leejac = leena; //same reference to the Object leena
		
		if (leenaJacob.equals(leena)) //these 2 objects are same in the eyes of equals() method, but not in the eyes of ==
			System.out.println("Both are equal in the eyes of equals() method");
		else
			System.out.println("Both are Unequal n the eyes of equals() method");
		
		if (leenaJacob == leena) //these 2 objects are different in the eyes of ==
			System.out.println("Both are equal n the eyes of == method");
		else
			System.out.println("Both are Unequal n the eyes of == method");
		
		if (leejac.equals(leena)) //leejac refers to leena so there is only one object
			System.out.println("Both are equal");
		else
			System.out.println("Both are UNequal");
		
		if (leejac == leena) //leejac refers to leena so there is only one object
			System.out.println("Both are equal");
		else
			System.out.println("Both are UNequal");
		
		
}
}
	
	class Friend{
		private final String name;
		private final String place;
		private final int age;
		
	public Friend(String name1,String place1,int age1){
			/* Without using this.name type assignment
			 * Class FriendInfo(String name,String city,int age){
		name = this.name; //this could also be name = name1 where name1 could be the parameter to the constructor
		city = this.city; //when constructor is invoked this.city will have the info whic is copied to city
		age = this.age;*/
			name = name1;
			place = place1;
			age = age1;
		}
		
		public String getName(){
			return name;
			}
		public String getPlace(){
			return place;
		}
		public int getAge(){
			return age;
		}
		
		public boolean equals(Object l){//leena Object is copied to l
            //check the difference between this.name and name
            return (l instanceof Friend) &&
                    (((Friend) l).getName() == this.name) &&
                    (((Friend) l).getPlace() == place) &&
                    (((Friend) l).getAge() == age);
		}
	}
