package nitin.reflectionAPI;

public class R2ReflectionEquality {

  static void main() {
    // Case Study for the equality of the Objects
    try {
      caseStudy();
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }

  private static void caseStudy() throws ClassNotFoundException {
    Class c1 = ReflectionTestClass.class;
    Class c2 = Class.forName("nitin.reflectionAPI.ReflectionTestClass");
    Class c3 = new ReflectionTestClass().getClass();

    // All the three references points to the same object.
    if (c1 == c2) {
      System.out.println(" c1 and c2 are equal");
    }

    if (c1 == c3) {
      System.out.println(" c1 and c3 are equal");
    }

    System.out.println("----------------------");

    System.out.println("c1 hashcode :: " + System.identityHashCode(c1));
    System.out.println("c2 hashcode :: " + System.identityHashCode(c2));
    System.out.println("c3 hashcode :: " + System.identityHashCode(c3));
  }
}
