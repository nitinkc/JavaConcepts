package java.zCoreServletsTraining.t2Streams.t2Streams.streams2.streams;

public class PersonUtils {
  private static final String[] possibleFirstNames =
    { "Andrea", "Brad", "Cathy", "David", "Erin", "Frank" };
  private static final String[] possibleLastNames = 
    { "Anderson", "Bradley", "Carson", "Donaldson", "Evans", "Fisher" };
  
  public static String randomFirstName() {
    return(RandomUtils.randomElement(possibleFirstNames));
  }
  
  public static String randomLastName() {
    return(RandomUtils.randomElement(possibleLastNames));
  }
  
  private PersonUtils() {}; // Uninstantiatable class
}
