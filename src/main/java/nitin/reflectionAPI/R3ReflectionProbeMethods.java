package nitin.reflectionAPI;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class R3ReflectionProbeMethods {
  public static void main(String[] args) throws ClassNotFoundException {
    Class c = Class.forName("nitin.reflectionAPI.ReflectionTestClass");
    printClassMetadata(c);
  }

  private static void printClassMetadata(Class c) {

    // Discovering the methods of a class:
    Method[] m = c.getDeclaredMethods();
    System.out.println(
        "METHODS IN CLASS ARE (getDeclaredMethods - declared in this class, any access):");
    if (m.length == 0) {
      System.out.println("  (none declared directly in this class)");
    }
    for (Method method : m) {
      System.out.println("  " + method + " | declared in: " + method.getDeclaringClass().getName());
    }
    System.out.println("---------------------------");

    Method[] methods = c.getMethods();
    System.out.println("METHODS IN CLASS ARE (getMethods - public only, includes superclasses):");
    if (methods.length == 0) {
      System.out.println("  (no public methods found in class hierarchy)");
    }
    for (Method mtd : methods) {
      System.out.println("  " + mtd + " | declared in: " + mtd.getDeclaringClass().getName());
    }
    System.out.println("---------------------------");

    // Discovering the fields of a class:
    System.out.println(
        "FIELDS IN CLASS ARE (getDeclaredFields - all declared in this class, any access):");
    Field[] f = c.getDeclaredFields();
    if (f.length == 0) {
      System.out.println("  (none declared directly in this class)");
    }
    for (Field field : f) {
      System.out.println("  " + field + " | declared in: " + field.getDeclaringClass().getName());
    }
    System.out.println("---------------------------");

    // Methods for public fields in this class and its superclasses
    System.out.println("FIELDS IN CLASS ARE (getFields - public only, includes superclasses):");
    Field[] fields = c.getFields();
    if (fields.length == 0) {
      System.out.println("  (no public fields found in class hierarchy)");
    }
    for (Field fld : fields) {
      System.out.println("  " + fld + " | declared in: " + fld.getDeclaringClass().getName());
    }
    System.out.println("---------------------------");

    // Constructor in the Class are
    Constructor[] cons = c.getDeclaredConstructors();
    System.out.println("CONSTRUCTORS IN THE CLASS ARE :- ");
    for (Constructor constructor : cons) {
      System.out.println(constructor);
    }
    System.out.println("---------------------------");

    // Discovering the interfaces implemented by a class:
    Class[] interfaces = c.getInterfaces();
    System.out.println("INTERFACES IN THE CLASS ARE :- ");
    for (Class i : interfaces) {
      System.out.println(i);
    }
    System.out.println("---------------------------");

    System.out.println("Getting the superclass");
    // Getting the superclass :
    Class s = c.getSuperclass();
    System.out.println(s);

    // Getting the class name:
    String str = c.getName();
    System.out.println(str);
    System.out.println("---------------------------");

    System.out.println(c.getClassLoader());
    System.out.println(c.getFields().toString());
    System.out.println("---------------------------");
  }
}
