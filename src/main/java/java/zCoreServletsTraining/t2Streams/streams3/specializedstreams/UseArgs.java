package java.zCoreServletsTraining.t2Streams.streams3.specializedstreams;

public class UseArgs {
  public static int firstNumber(int... nums) {
    return(nums[0]);
  }
  
  public static Object firstObject(Object... objects) {
    return(objects[0]);
  }
  
  private UseArgs() {}
}
