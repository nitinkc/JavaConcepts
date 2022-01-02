package java.streams.t2Streams.streams3.streams;

import java.util.Arrays;
import java.util.List;

public class EmpSamples {
  private static Emp[] sampleEmps = {
    new Emp("Larry", "Page", "Mountain View"),
    new Emp("Sergey", "Brin", "Mountain View"),
    new Emp("Lindsay", "Hall", "New York"),
    new Emp("Hesky", "Fisher", "New York"),
    new Emp("Reto", "Strobl", "Zurich"),
    new Emp("Fork", "Guy", "Zurich"),
  };
  
  public static List<Emp> getSampleEmps() {
    return(Arrays.asList(sampleEmps));
  }
  
  private EmpSamples() {} // Uninstantiatable class
}
