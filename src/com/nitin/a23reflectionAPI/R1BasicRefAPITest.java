package com.nitin.a23reflectionAPI;//package com.nitin.reflectionAPI;
/*
Package Name has to be deleted because the Class.forName method is not recognizing the Class
From Default package it is recognizing.

//ERROR: For classes in the Package, it is not recognizing

 */
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by com.nitin.a23reflectionAPI.Nitin Chaurasia on 12/3/15 at 11:54 PM.
 *
 * There are 3 ways to get the instance of Class class. They are as follows:
 *    forName() method of Class class
 *    getClass() method of Object class
 *    the .class syntax
 */
public class R1BasicRefAPITest {
    public static void main(String[] args) throws
            IllegalAccessException,
            InstantiationException,
            ClassNotFoundException {

        //Instance to access non-static methods
        R1BasicRefAPITest t = new R1BasicRefAPITest();

        /*
        For every loaded class, the JVM maintains an associated Class object
         */
        Class c = null;

        // Type 1: Class.forName() mathod
        // should be used if you know the fully qualified name
        c = Class.forName("com.nitin.a23reflectionAPI.Nitin");

        System.out.println(c.getClass());
        t.printMetadata(c);

        //Type 2: Creating the Instance when the Class name and object name both are known!!
        Nitin n = (Nitin) c.newInstance();
        // Can use n just like an created with new keyword

        // Type 3: When only the Object Name is known.
        Nitin nObj = new Nitin();
        /*
         It should be used if you know the type.
         Moreover, .getClass can be used with primitives.
         */
        Class c1 = nObj.getClass();

        //Case Study for the equality of the Objects
        t.caseStudy();
    }

    private void caseStudy() throws ClassNotFoundException {
        Nitin n = new Nitin();

        Class c1 = Nitin.class;
        Class c2 = Class.forName("com.nitin.a23reflectionAPI.Nitin");
        Class c3 = n.getClass();

        //All the three references points to the same object.
        if (c1 == c2) {
            System.out.println(" equal");
        }

        System.out.println("c1" + "  " + c1);
        System.out.println("c2" + " " + c2);
        System.out.println("c3" + " " + c3);

    }

    //When Class name is Known, Class.forName() method is preferred
    private void printMetadata(Class c) {

        //Discovering the methods of a class:
        Method m[] = c.getDeclaredMethods();
        System.out.println("METHODS IN CLASS ARE :- ");
        for (Method method : m) {
            System.out.println(method);
        }
        System.out.println("---------------------------");

        //Discovering the fields of a class:
        Field f[] = c.getDeclaredFields();
        System.out.println("FIELDS IN CLASS ARE :- ");
        for (Field field : f) {
            System.out.println(field);
        }
        System.out.println("---------------------------");

        //Constructor in the Class are
        Constructor cons[] = c.getDeclaredConstructors();
        System.out.println("CONSTRUCTORS IN THE CLASS ARE :- ");
        for (Constructor constructor : cons) {
            System.out.println(constructor);
        }
        System.out.println("---------------------------");

        Field[] fields = c.getFields();
        //Methods for super class as well
        System.out.println("Fields IN THE CLASS ARE (getFields method):- ");
        for ( Field fld : fields) {
            System.out.println(fld);
        }
        System.out.println("---------------------------");


        Method[] methods = c.getMethods();
        System.out.println("methods IN THE CLASS ARE :- ");
        for ( Method mtd : methods) {
            System.out.println(mtd);
        }
        System.out.println("---------------------------");

        //Discovering the interfaces implemented by a class:
        Class[] interfaces = c.getInterfaces();
        System.out.println("INTERFACES IN THE CLASS ARE :- ");
        for ( Class i : interfaces) {
            System.out.println(i);
        }
        System.out.println("---------------------------");


        //Getting the superclass :
        Class s = c.getSuperclass();
        System.out.println(s);

        //Getting the class name:
        String str = c.getName();
        System.out.println(str);
        System.out.println("---------------------------");

        System.out.println(c.getClassLoader());
        System.out.println(c.getFields().toString());
        System.out.println("---------------------------");

    }
}

    /**
     * Class Written for the Reflection API Testing
     */

class Nitin{
    int x;
    Sindhu s;

    Nitin(){
    }
    Nitin(int a, String b, boolean c){
        //A Constructor
    }

    public void m1(){
        //Any method
        return;
    }

    public int m2(){
        //Any other method

        return 0;
    }
}
 
/**
 * Data Class Containing only data.
 */
class Sindhu{
    private int kiddo;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKiddo() {
        return kiddo;
    }

    public void setKiddo(int kiddo) {
        this.kiddo = kiddo;
    }
}